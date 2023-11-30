package Screens;

import Engine.*;
import GameObject.Rectangle;
import SpriteFont.SpriteFont;
import Utils.Sound;
import Maps.TestMap;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

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
    protected BufferedImage victoryImage; 

    public WinScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
        try {
            victoryImage = ImageIO.read(new File("Resources/victoryroyale.jpg")); 
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    @Override
    public void initialize() {
       
       loseMessage = new SpriteFont("PRESS ESC FOR MENU ", 200, 500, "Verdana", 30, new Color(255, 0, 0));
       loseMessage.setOutlineColor(Color.black);
       loseMessage.setOutlineThickness(3);
  
       
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
        if (victoryImage != null) {
            graphicsHandler.drawImage(victoryImage, 0, 0);
        }
        loseMessage.draw(graphicsHandler);
       // poopMessage.draw(graphicsHandler);
 
    }
}