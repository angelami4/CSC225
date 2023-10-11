package Screens;

import Engine.*;
import GameObject.Rectangle;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the win level screen
public class WinScreen extends Screen {
    protected SpriteFont winMessage;
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
        winMessage = new SpriteFont("FIGHT!", 300, 200, "Trebuchet MS", 60, Color.black);
        playerHP = new SpriteFont("BOBCAT|100HP", 15,15, "Trebuchet MS", 22, Color.black);
        enemyHP = new SpriteFont("ENEMY|150HP", 625,15, "Trebuchet MS", 22, Color.black);
        rectangle = new Rectangle();
        keyLocker.lockKey(Key.SPACE);

        
        keyLocker.lockKey(Key.ESC);
    }

    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }

        // if space is pressed, reset level. if escape is pressed, go back to main menu
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
            playLevelScreen.resetLevel();
        } else if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
            playLevelScreen.goBackToMenu();
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
       graphicsHandler.drawFilledRectangle(0, 420, 450, 160, Color.black);
        graphicsHandler.drawFilledRectangle(500, 420, 400, 160, Color.black);
        winMessage.draw(graphicsHandler);
        playerHP.draw(graphicsHandler);
        enemyHP.draw(graphicsHandler);
    }
}
