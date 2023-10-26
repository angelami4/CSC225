package Utils;

import java.io.File;
import javax.sound.sampled.*;
import Engine.Config;

public class Sound implements LineListener {

    //shows if playback is finished or not
    private boolean isPlaybackComplete;
    //shows if audio should loop or not
    private boolean isLooping;
    //imports clip 
    private Clip audioClip;


     //Constructor that takes file name and if it loops
    public Sound(String audioFileName, boolean loop) {
        this.isLooping = loop;
        try {
            // Object for audio file in Sounds folder
            File audioFile = new File(Config.SOUNDS_PATH + audioFileName);
            // Gets input stream from audio file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            // Gets format from AudioInputStream
            AudioFormat audioFormat = audioStream.getFormat();
            // Specifies we are working with "Clip"
            DataLine.Info audioInfo = new DataLine.Info(Clip.class, audioFormat);
            // Gets clip instance from AudioSystem based on data info
            audioClip = (Clip) AudioSystem.getLine(audioInfo);
            // Adds class as LineListener to get line events
            audioClip.addLineListener(this);
            // Opens audio stream and associates with Clip
            audioClip.open(audioStream);
        } catch (Exception e) {
            // Print exception to audio setup
            e.printStackTrace();
        }
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        if (type == LineEvent.Type.STOP && !isLooping) {
            // If playback stops marked as complete
            isPlaybackComplete = true;
        }
    }

    public void play() {
        if (audioClip != null) {
            if (isLooping) {
                //if looping is labeled true, loop it
                audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            // Plays the audio
            audioClip.start();
        }
    }

    public void playOnce()
    {
        if(audioClip != null)
        {
            audioClip.start();
        }
    }

    public void pause() {
        if (audioClip != null) {
            // Stops the audio
            audioClip.stop();
        }
    }

    /**
     * Starts the audio from the beginning
     */
    public void back() {
        if (audioClip != null) {
            // Brings the audio position to the very beginning
            audioClip.setMicrosecondPosition(0);
        }
    }

    /**
     * Closes the stream
     */
    public void close() {
        if (audioClip != null) {
            // Stops the audio
            audioClip.stop();
            // Closes the audio
            audioClip.close();
        }
    }

    /**
     * Stops the audio and sets to the beginning
     */
    public void stop() {
        if(audioClip != null) {
            audioClip.stop();
            audioClip.setMicrosecondPosition(0);
        }
    }

    /**
     * Checks if the audio is finished
     * @return
     */
    public boolean isPlaybackComplete() {
        return isPlaybackComplete;
    }
}
