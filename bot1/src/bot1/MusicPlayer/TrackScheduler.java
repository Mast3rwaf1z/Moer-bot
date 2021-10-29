package bot1.MusicPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;

import bot1.Commands;
import bot1.Main;

public class TrackScheduler extends AudioEventAdapter {
    private final AudioPlayer player;
    private final BlockingQueue<AudioTrack> queue;
    private AudioTrack[] temp = {};
    public List<AudioTrack> queueList = new ArrayList<AudioTrack>(Arrays.asList(temp));
    public boolean repeat = false;

    public TrackScheduler(AudioPlayer player) {
        this.player = player;
        this.queue = new LinkedBlockingQueue<>();
    }

    public void queue(AudioTrack track) {
        if (!player.startTrack(track, true)) {
            queue.offer(track);
            queueList.add(track);
        }
        else if(player.isPaused()) {
        	player.setPaused(false);
        }
    }
    
    public AudioTrack nextTrack() {
    	AudioTrack track = queue.poll();
    	queueList.remove(0);
        if(player.startTrack(track, false)) {
        	Commands.trackTracker = true;
        	Main.currentTrack = track.getInfo().title;
        	if(player.isPaused()) {
        		player.setPaused(false);
        	}
        }
        return track;
    }

    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
    	if (queue.isEmpty()) {
    		player.setPaused(true);
    	}
    	else if (endReason.mayStartNext) {
    		if(repeat) {
    			player.playTrack(track);
    		}
    		else {
    			nextTrack();
    		}
        }
    }
}
