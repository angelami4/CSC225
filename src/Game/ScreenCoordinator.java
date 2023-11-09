package Game;

import Engine.DefaultScreen;
import Engine.GraphicsHandler;
import Engine.Screen;
import Screens.CreditsScreen;
import Screens.InstructionScreen;
import Screens.InventoryScreen;
import Screens.MenuScreen;
import Screens.BattleScreen;
import Screens.PlayLevelScreen;
import Game.ScreenCoordinator;
/*
 * Based on the current game state, this class determines which Screen should be shown
 * There can only be one "currentScreen", although screens can have "nested" screens
 */
public class ScreenCoordinator extends Screen {
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();

	
	protected GameState gameState;
	protected GameState previousGameState;

	public GameState getGameState() {
		return gameState;
	}

	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public void initialize() {
	
		gameState = GameState.MENU;
	}

	@Override
	public void update() {
		do {
		
			if (previousGameState != gameState) {
				switch(gameState) {
					case MENU:
						currentScreen = new MenuScreen(this);
						break;
					case LEVEL:
						currentScreen = new PlayLevelScreen(this);
						break;
					case CREDITS:
						currentScreen = new CreditsScreen(this);
						break;
					case INSTRUCTIONS:
						currentScreen = new InstructionScreen(this);
						break;
					case BATTLE:
						currentScreen = new BattleScreen(this);
						break;
				}
				currentScreen.initialize();
			}
			previousGameState = gameState;


			currentScreen.update();
		} while (previousGameState != gameState);
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {

		currentScreen.draw(graphicsHandler);
	}
}
