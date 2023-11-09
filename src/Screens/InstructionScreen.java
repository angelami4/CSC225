package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class InstructionScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont introLabel;
    protected SpriteFont gameControlsLabel;
    protected SpriteFont movementDesc;
    protected SpriteFont interactionDesc;
    protected SpriteFont invetoryDesc;
    protected SpriteFont inventoryInteractioDesc;
    protected SpriteFont battleControlsLabel;
    protected SpriteFont arrowKeyDesc;
    protected SpriteFont battleInteractionDesc;
    protected SpriteFont battleRulesLabel;
    protected SpriteFont battleRulesDesc1;
    protected SpriteFont battleRulesDesc2;
    protected SpriteFont attackDesc;


    public InstructionScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        introLabel = new SpriteFont("Welcome to the Championship Experience", 150, 25, "Times New Roman", 30, Color.blue);
        introLabel.setOutlineColor(Color.black);
        gameControlsLabel = new SpriteFont("GAME CONTROLS:", 61, 125, "Times New Roman", 30, Color.RED);
        gameControlsLabel.setOutlineColor(Color.black);
        movementDesc = new SpriteFont("- WASD For Movement", 40, 175, "Times New Roman", 25, Color.BLACK);
        movementDesc.setOutlineColor(Color.black);
        interactionDesc = new SpriteFont("- SPACE for NPC Interaction", 40, 210, "Times New Roman", 25, Color.BLACK);
        interactionDesc.setOutlineColor(Color.black);
        invetoryDesc = new SpriteFont("- ESC for Inventory", 40, 245, "Times New Roman", 25, Color.BLACK);
        invetoryDesc.setOutlineColor(Color.black);
        inventoryInteractioDesc = new SpriteFont("- ENTER for Inventory Interaction", 40, 280, "Times New Roman", 25, Color.BLACK);
        inventoryInteractioDesc.setOutlineColor(Color.black);
        battleControlsLabel = new SpriteFont("BATTLE CONTROLS:", 475, 125, "Times New Roman", 30, Color.RED);
        battleControlsLabel.setOutlineColor(Color.black);
        arrowKeyDesc = new SpriteFont("- ↓ for Attack Choice", 475, 175, "Times New Roman", 25, Color.BLACK);
        arrowKeyDesc.setOutlineColor(Color.black);
        battleInteractionDesc = new SpriteFont("- ENTER for Attack Selection", 475, 211, "Times New Roman", 25, Color.BLACK);
        battleInteractionDesc.setOutlineColor(Color.black);
        battleRulesLabel = new SpriteFont("BATTLE RULES", 300, 331, "Times New Roman", 30, Color.RED);
        battleRulesLabel.setOutlineColor(Color.BLACK);
        battleRulesDesc1 = new SpriteFont("In this game, the battle has 3 types of attacks: HEAVY, LIGHT, and DEFEND", 70, 365, "Times New Roman", 20, Color.BLACK);
        battleRulesDesc1.setOutlineColor(Color.BLACK);
        battleRulesDesc2 = new SpriteFont("For battles, the attack bounds are as follows:", 200, 394, "Times New Roman", 20, Color.BLACK);
        battleRulesDesc2.setOutlineColor(Color.BLACK);
        attackDesc = new SpriteFont("HEAVY beats DEFEND. DEFEND beats LIGHT. LIGHT beats HEAVY.", 45, 425, "Times New Roman", 25, Color.BLACK);
        attackDesc.setOutlineColor(Color.BLACK);
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
        introLabel.draw(graphicsHandler);
        gameControlsLabel.draw(graphicsHandler);
        movementDesc.draw(graphicsHandler);
        interactionDesc.draw(graphicsHandler);
        invetoryDesc.draw(graphicsHandler);
        inventoryInteractioDesc.draw(graphicsHandler);
        battleControlsLabel.draw(graphicsHandler);
        arrowKeyDesc.draw(graphicsHandler);
        battleInteractionDesc.draw(graphicsHandler);
        battleRulesLabel.draw(graphicsHandler);
        battleRulesDesc1.draw(graphicsHandler);
        battleRulesDesc2.draw(graphicsHandler);
        attackDesc.draw(graphicsHandler);
    }
}
