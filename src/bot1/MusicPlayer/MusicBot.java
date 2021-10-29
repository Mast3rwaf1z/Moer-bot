package bot1.MusicPlayer;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.managers.Manager;

public class MusicBot {
    static private AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
    static private  Map<Long, GuildMusicManager> musicManagers = new HashMap<>();
    public MusicBot() {
        AudioSourceManagers.registerRemoteSources(playerManager);
        AudioSourceManagers.registerLocalSource(playerManager);
    }

    private synchronized GuildMusicManager getGuildAudioPlayer(Guild guild) {
        long guildId = Long.parseLong(guild.getId());
        GuildMusicManager musicManager = musicManagers.get(guildId);

        if (musicManager == null) {
            musicManager = new GuildMusicManager(playerManager);
            musicManagers.put(guildId, musicManager);
        }

        guild.getAudioManager().setSendingHandler(musicManager.getSendHandler());

        return musicManager;
    }

    public void loadAndPlay(TextChannel channel, VoiceChannel voiceChannel, String string) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());

        playerManager.loadItemOrdered(musicManager, string, new AudioLoadResultHandler() {

            @Override
            public void trackLoaded(AudioTrack track) {
            	EmbedBuilder builder = new EmbedBuilder();
            	builder.setColor(Color.yellow);
            	builder.setTitle("Successfully added track!");
            	builder.addField("", "["+track.getInfo().title+"]"+"("+string+") "+"Track duration: "+getTime(track.getDuration()), false);
            	channel.sendMessageEmbeds(builder.build()).queue();
                play(channel.getGuild(), voiceChannel, musicManager, track);
                
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {
                AudioTrack firstTrack = playlist.getSelectedTrack();
                if (firstTrack == null) {
                    firstTrack = playlist.getTracks().get(0);
                }
                EmbedBuilder builder = new EmbedBuilder();
            	builder.setColor(Color.yellow);
                builder.setTitle("Successfully added playlist!");
                builder.addField("","["+playlist.getName()+"]"+"("+string+") "+"Number of tracks: " + playlist.getTracks().size(), false);
                channel.sendMessageEmbeds(builder.build()).queue();
                for (int i = 1; i < playlist.getTracks().size(); i++) {
                    musicManager.scheduler.queue(playlist.getTracks().get(i));
                }
                play(channel.getGuild(), voiceChannel, musicManager, firstTrack);
            }

            @Override
            public void noMatches() {
                channel.sendMessage("Mørbot didn't find anything at " + string).queue();
            }

            @Override
            public void loadFailed(FriendlyException exception) {
                channel.sendMessage("Mørbot couldn't play: " + exception.getMessage()).queue();
            }
        });
    }

    private void play(Guild guild, VoiceChannel channel, GuildMusicManager musicManager, AudioTrack track) {
        connectToFirstVoiceChannel(guild.getAudioManager(), channel);
        musicManager.scheduler.queue(track);
    }

    public void skipTrack(TextChannel channel) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        AudioTrack track = musicManager.scheduler.nextTrack();
        EmbedBuilder builder = new EmbedBuilder();
    	builder.setColor(Color.yellow);
        builder.setTitle("Skipping to next track");
    	builder.addField("","["+track.getInfo().title+"]"+"("+track.getInfo().uri+") "+"Track duration: "+getTime(track.getDuration()), false);
    	channel.sendMessageEmbeds(builder.build()).queue();
    }

    private void connectToFirstVoiceChannel(AudioManager audioManager, VoiceChannel channel) {
        if (!audioManager.isConnected()) {
            audioManager.openAudioConnection(channel);
        }
    }

    public EmbedBuilder getQueue(TextChannel channel, int offset) {
        EmbedBuilder embed = new EmbedBuilder();
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        for(int i = (15*offset); i < musicManager.scheduler.queueList.size(); i++) {
        	AudioTrack track = musicManager.scheduler.queueList.get(i);
        	embed.addField("",String.valueOf(i+1)+". ["+track.getInfo().title+"]("+track.getInfo().uri+")\n"+"Duration: "+getTime(track.getDuration()), false);
        	if(i>(15*(offset+1))) {
        		break;
        	}
        }
    	embed.setColor(Color.yellow);
    	embed.setThumbnail("https://cdn.discordapp.com/attachments/692410386657574955/888922522417004574/BotImage.jpg");
        embed.setTitle("Track queue", "https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        embed.setDescription("Queue page: " +offset+" of "+musicManager.scheduler.queueList.size()/16);
        embed.setFooter("total number of tracks in queue: " + musicManager.scheduler.queueList.size());
        return embed;
    }

    public void disconnect(Guild guild) {
        if (guild.getAudioManager().isConnected()) {
        	guild.getAudioManager().closeAudioConnection();
        }
    }
    public void nowPlaying(TextChannel channel) {
    	EmbedBuilder builder = new EmbedBuilder();
    	GuildMusicManager manager = getGuildAudioPlayer(channel.getGuild());
    	AudioTrack track = manager.player.getPlayingTrack();
    	builder.setColor(Color.yellow);
    	builder.setTitle("Current track");
    	builder.addField("", "["+track.getInfo().title+"]("+track.getInfo().uri+") "+"Duration: "+getTime(track.getPosition())+"/"+getTime(track.getDuration()), false);
    	builder.setFooter("Total number of tracks left in queue: "+manager.scheduler.queueList.size());
    	channel.sendMessageEmbeds(builder.build()).queue();
    }

	public void clear(TextChannel channel) {
		// TODO Auto-generated method stub
		GuildMusicManager manager = getGuildAudioPlayer(channel.getGuild());
		while(manager.scheduler.queueList.size() != 0) {
			manager.scheduler.nextTrack();
		}
		manager.scheduler.nextTrack();
	}
	public void repeat(TextChannel channel) {
		GuildMusicManager manager = getGuildAudioPlayer(channel.getGuild());
		if(manager.scheduler.repeat) {
			manager.scheduler.repeat = false;
			channel.sendMessage("repeat has been turned off").queue();
		}
		else{
			manager.scheduler.repeat = true;
			channel.sendMessage("repeat has been turned on").queue();
		}
	}
	public String getTime(Long duration) {
		String minutes = String.valueOf((duration/1000)/60);
		if(Integer.parseInt(minutes)<10) {
			minutes = "0"+minutes;
		}
		String seconds = String.valueOf((duration/1000)%60);
		if(Integer.parseInt(seconds)<10) {
			seconds = "0"+seconds;
		}
		return minutes+":"+seconds;
	}

}