package Game;

import Engine.GameWindow;
import Engine.ScreenManager;
import Utils.Sound;

/*
 * The game starts here
 * This class just starts up a GameWindow and attaches the ScreenCoordinator to the ScreenManager instance in the GameWindow
 * From this point on the ScreenCoordinator class will dictate what the game does
 */
public class Game { 

// //<<<<<<< HEAD
//     public static void main(String[] args) {
//         new Game();
//     }
//=======
    public static void main(String[] args) { 
        new Game();
    } 
//>>>>>>> 67c173535dc89f766778e4bd62c3298b38fee1e2

    public Game() {
        GameWindow gameWindow = new GameWindow(); 
        ScreenManager screenManager = gameWindow.getScreenManager(); 
        screenManager.setCurrentScreen(new ScreenCoordinator()); 
        gameWindow.startGame();
    } 
}