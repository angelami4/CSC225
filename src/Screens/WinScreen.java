package Screens;

import Engine.*;
import GameObject.Rectangle;
import SpriteFont.SpriteFont;
import Utils.Sound;
import Maps.TestMap;

import java.awt.*;

// This class is for the win level screen
public class WinScreen extends Screen {
    protected SpriteFont loseMessage;
    protected SpriteFont loseMessage2;
    //protected SpriteFont poopMessage;
    protected SpriteFont playerHP;
    protected SpriteFont enemyHP;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected Rectangle rectangle;
    protected GraphicsHandler graphicsHandler;

    public WinScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public void initialize() {
       
       loseMessage = new SpriteFont("YOU WIN! WE ARE CHAMPS! ", 50, 200, "Verdana", 30, new Color(255, 255, 255));
       loseMessage.setOutlineColor(Color.black);
       loseMessage.setOutlineThickness(3);
  
       loseMessage2 = new SpriteFont("YOU WIN! WE ARE CHAMPS! ", 50, 204, "Verdana", 30, new Color(255, 255, 255));
       loseMessage2.setOutlineColor(Color.black);
       loseMessage2.setOutlineThickness(3);
        
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