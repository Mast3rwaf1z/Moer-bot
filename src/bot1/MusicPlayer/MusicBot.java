package bot1.MusicPlayer;

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

public class MusicBot {
    private final AudioPlayerManager playerManager;
    private final Map<Long, GuildMusicManager> musicManagers;

    public MusicBot() {
        this.musicManagers = new HashMap<>();

        this.playerManager = new DefaultAudioPlayerManager();
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
                channel.sendMessage("Tilføjer " + track.getInfo().title + " til køen").queue();
                musicManager.scheduler.queue(track);
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {
                AudioTrack firstTrack = playlist.getSelectedTrack();
                if (firstTrack == null) {
                    firstTrack = playlist.getTracks().get(0);
                }

                channel.sendMessage("Tilføjer " + firstTrack.getInfo().title + " til køen, første på playlisten: "
                        + playlist.getName()).queue();

                for (int i = 1; i < playlist.getTracks().size(); i++) {
                    musicManager.scheduler.queue(playlist.getTracks().get(i));
                }
                play(channel.getGuild(), voiceChannel, musicManager, firstTrack);
            }

            @Override
            public void noMatches() {
                channel.sendMessage("Mørbot fandt ikke noget ved " + string).queue();
            }

            @Override
            public void loadFailed(FriendlyException exception) {
                channel.sendMessage("Mørbot kunne ikke afspille: " + exception.getMessage()).queue();
            }
        });
    }

    private void play(Guild guild, VoiceChannel channel, GuildMusicManager musicManager, AudioTrack track) {
        connectToFirstVoiceChannel(guild.getAudioManager(), channel);
        musicManager.scheduler.queue(track);
    }

    public void skipTrack(TextChannel channel) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        musicManager.scheduler.nextTrack();

        channel.sendMessage("skipper til næste sang.").queue();
    }

    private void connectToFirstVoiceChannel(AudioManager audioManager, VoiceChannel channel) {
        System.out.println("is bot connected?");
        if (!audioManager.isConnected() && !audioManager.isAttemptingToConnect()) {
            System.out.println("attempting to connect");
            audioManager.openAudioConnection(channel);
        }
    }

    public EmbedBuilder getQueue() {
        EmbedBuilder embed = new EmbedBuilder();

        return embed;
    }

    public void disconnect(Guild guild) {
        if (guild.getAudioManager().isConnected()) {

        }
    }

}