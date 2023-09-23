package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class CreditsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont coleLabel;
    protected SpriteFont angelaLabel;
    protected SpriteFont javiLabel;
    protected SpriteFont aidanLabel;
    protected SpriteFont returnInstructionsLabel;

    public CreditsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("CREDITS", 15, 7, "Impact", 30, Color.white);
        createdByLabel = new SpriteFont("CREATORS:", 150, 121, "Segoe UI", 20, Color.white);
        coleLabel =  new SpriteFont("Cole Davignon", 150, 151, "Segoe UI", 20, Color.white);
        angelaLabel =  new SpriteFont("Angela Bruno", 150, 181, "Segoe UI", 20, Color.white);
        aidanLabel =  new SpriteFont("Aidan Armellino", 150, 211, "Segoe UI", 20, Color.white);
        javiLabel =  new SpriteFont("Javi Reyes", 150, 241, "Segoe UI", 20, Color.white);
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 532, "Times New Roman", 30, Color.white);
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        creditsLabel.draw(graphicsHandler);
        createdByLabel.draw(graphicsHandler);
        coleLabel.draw(graphicsHandler);
        angelaLabel.draw(graphicsHandler);
        aidanLabel.draw(graphicsHandler);
        javiLabel.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
