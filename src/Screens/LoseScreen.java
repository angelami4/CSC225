package Screens;

import Engine.*;
import GameObject.Rectangle;
import SpriteFont.SpriteFont;
import Utils.Sound;
import Maps.TestMap;

import java.awt.*;

// This class is for the win level screen
public class LoseScreen extends Screen {
    protected SpriteFont loseMessage;
    //protected SpriteFont poopMessage;
    protected SpriteFont playerHP;
    protected SpriteFont enemyHP;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected Rectangle rectangle;
    protected GraphicsHandler graphicsHandler;

    public LoseScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public void initialize() {
        loseMessage = new SpriteFont("You Died, Press Escape.", 70, 200, "Trebuchet MS", 60, Color.black);
       // poopMessage = new SpriteFont("Press Escape To go To main Menu, Press space to reset ", 300, 200, "Trebuchet MS", 60, Color.black);
        
  
     
        keyLocker.lockKey(Key.SPACE);

        
        keyLocker.lockKey(Key.SPACE);
    }

    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, reset level. if escape is pressed, go back to main menu
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
            playLevelScreen.resetLevel();
        } else if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.SPACE)) {
            playLevelScreen.goBackToMenu();
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
    
        loseMessage.draw(graphicsHandler);
       // poopMessage.draw(graphicsHandler);
 
    }
}
