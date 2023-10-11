/**
 * This class is in charge of all of the audio files for the game.
 * 
 * Introduced: September 27th (Sprint 1)
 * Last updated: October 1st (Sprint 2)
 * @author bjaxqq
 */

package Level;

import Utils.Sound;
import java.util.HashMap;
import java.util.Map;

public class Audio {
    protected static Player player1;

    // Creating a hash map to store sound object
    protected static Map<Integer, Sound> sounds = new HashMap<>();

    static {
        // Door opening sounds
        sounds.put(12, new Sound("door1.wav", true));
        sounds.put(13, new Sound("door2.wav", true));

        sounds.put(14, new Sound("ruins.wav", true));
    }

    // Set default sound to grass
    //private static Sound walkSound = sounds.get(0);

    // Setting the player object
    public static void setPlayer(Player player) {
        player1 = player;
    }

    // Changing the audio based on what tile index the player is on
    

    // Function for playing background music (september 29th)
    // Will change this based on what map/area the player is in later once we have
    // that set up
    public static void playBackgroundMusic() {
        Sound backgroundMusic = sounds.get(14);
        if (backgroundMusic != null) {
            backgroundMusic.play();
        }
    }
}