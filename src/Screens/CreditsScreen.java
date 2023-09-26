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
        creditsLabel = new SpriteFont("Credits", 15, 7, "Times New Roman", 30, Color.white);
        creditsLabel.setOutlineColor(Color.black);
        creditsLabel.setOutlineThickness(3);
        createdByLabel = new SpriteFont("CREATORS:", 150, 121, "Segoe UI", 20, Color.white);
        createdByLabel.setOutlineColor(Color.black);
        createdByLabel.setOutlineThickness(3);
        coleLabel =  new SpriteFont("Cole Davignon", 150, 151, "Segoe UI", 20, Color.white);
        coleLabel.setOutlineColor(Color.black);
        coleLabel.setOutlineThickness(3);
        angelaLabel =  new SpriteFont("Angela Bruno", 150, 181, "Segoe UI", 20, Color.white);
        angelaLabel.setOutlineColor(Color.black);
        angelaLabel.setOutlineThickness(3);
        aidanLabel =  new SpriteFont("Aidan Armellino", 150, 211, "Segoe UI", 20, Color.white);
        aidanLabel.setOutlineColor(Color.black);
        aidanLabel.setOutlineThickness(3);
        javiLabel =  new SpriteFont("Javi Flores", 150, 241, "Segoe UI", 20, Color.white);
        javiLabel.setOutlineColor(Color.black);
        javiLabel.setOutlineThickness(3);
        returnInstructionsLabel = new SpriteFont("Press Left Arrow to return to the menu", 20, 532, "Times New Roman", 30, Color.white);
        returnInstructionsLabel.setOutlineColor(Color.black);
        returnInstructionsLabel.setOutlineThickness(3);
        keyLocker.lockKey(Key.LEFT);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.LEFT)) {
            keyLocker.unlockKey(Key.LEFT);
        }

        // if LEFT is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.LEFT) && Keyboard.isKeyDown(Key.LEFT)) {
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
