package Engine;

import GameObject.Rectangle;
import SpriteFont.SpriteFont;
import Utils.Colors;
import Utils.Sound;

import javax.swing.*;

//import Game.GameState;

import java.awt.*;

/*
 * This is where the game loop process and render back buffer is setup
 */
public class GamePanel extends JPanel {
	// loads Screens on to the JPanel
	// each screen has its own update and draw methods defined to handle a "section" of the game.
	private ScreenManager screenManager;

	// used to draw graphics to the panel
	private GraphicsHandler graphicsHandler;

	private boolean isGamePaused = false;
	private SpriteFont pauseLabel;
	private KeyLocker keyLocker = new KeyLocker();
	private final Key pauseKey = Key.ESC;
	private Thread gameLoopProcess;

	private Key showFPSKey = Key.G;
	private SpriteFont fpsDisplayLabel;
	private boolean showFPS = false;
	private int currentFPS;
	public static int health;
	public static int bossHealth;
	
	protected int menuItemHovered = 0; // current menu item being "hovered" over
	protected boolean isItemHovered;
    protected int menuItemSelected = -1;
	protected int keyPressTimer;

	// The JPanel and various important class instances are setup here
	public GamePanel(){
		super();
		health = 50;
		bossHealth = 60;
		this.setDoubleBuffered(true);
		// attaches Keyboard class's keyListener to this JPanel
		this.addKeyListener(Keyboard.getKeyListener());

		graphicsHandler = new GraphicsHandler();

		screenManager = new ScreenManager();
		pauseLabel = new SpriteFont("MENU", 10, 10, "Trebuchet MS", 24, Color.white);
		pauseLabel.setOutlineColor(Color.black);
		pauseLabel.setOutlineThickness(2.0f);
		// this game loop code will run in a separate thread from the rest of the program
		// will continually update the game's logic and repaint the game's graphics
		GameLoop gameLoop = new GameLoop(this);
		gameLoopProcess = new Thread(gameLoop.getGameLoopProcess());
	}

	// this is called later after instantiation, and will initialize screenManager
	// this had to be done outside of the constructor because it needed to know the JPanel's width and height, which aren't available in the constructor
	public void setupGame() {
		setBackground(Colors.CORNFLOWER_BLUE);
		screenManager.initialize(new Rectangle(getX(), getY(), getWidth(), getHeight()));
	}

	// this starts the timer (the game loop is started here
	public void startGame() {
		gameLoopProcess.start();
	}

	public ScreenManager getScreenManager() {
		return screenManager;
	}

	public void setCurrentFPS(int currentFPS) {
		this.currentFPS = currentFPS;
	}

	public void update() {
		//updatePauseState();
		//updateShowFPSState();
		// if (Keyboard.isKeyDown(Key.DOWN) && keyPressTimer == 0) {
        //     keyPressTimer = 14;
		// 	menuItemHovered++;
        // } 
		// else if (Keyboard.isKeyDown(Key.UP) && keyPressTimer == 0) {
		// 	keyPressTimer = 14;
		// 	menuItemHovered--;
		// } 
		// if (menuItemHovered > 3) {
		// 	menuItemHovered = 1;
		// } 
		// else if (menuItemHovered < 1) {
        //     menuItemHovered = 1;
        // }
		// else {
        //     if (keyPressTimer > 0) {
        //         keyPressTimer--;
        //     }
        // }
		// if (menuItemHovered == 1) {
        //     item1.setColor(Color.red);
        //     item2.setColor(Color.white);
		// 	item3.setColor(Color.white);
        // } else if (menuItemHovered == 2) {
        //     item1.setColor(Color.white);
        //     item2.setColor(Color.red);
		// 	item3.setColor(Color.white);
        // } else if (menuItemHovered == 3) {
        //     item1.setColor(Color.white);
        //     item2.setColor(Color.white);
		// 	item3.setColor(Color.red);
        // }
		// if (Keyboard.isKeyDown(Key.ENTER)) {
        //     keyLocker.unlockKey(Key.ENTER);
        // }
		// if (!keyLocker.isKeyLocked(Key.ENTER) && Keyboard.isKeyDown(Key.ENTER)) {
        //     menuItemSelected = menuItemHovered;
        //     if (menuItemSelected == 0) {
		// 		item0.remove();
        //     }
		// 	if (menuItemSelected == 1) {
		// 		keyPressTimer = 100;
		// 		item1.remove();
		// 		item2.setY(95);
		// 		item3.setY(125);
		// 		infoLabel.setText("Pepsi drank! Gained 5 HP");
        //     } 
		// 	else if (menuItemSelected == 2) {
		// 		keyPressTimer = 100;
		// 		item2.remove();
		// 		item3.setY(125);
		// 		infoLabel.setText("Hot Dog eaten! Gained 10 HP");
        //     } 
		// 	else if (menuItemSelected == 3){
		// 		keyPressTimer = 100;
		// 		item3.remove();
		// 		infoLabel.setText("Nachos eaten! Gained 20 HP");
		// 	}
        // }
		// if (!isGamePaused) {
		screenManager.update();
		// }
	}

	private void updatePauseState() {
		if (Keyboard.isKeyDown(pauseKey) && !keyLocker.isKeyLocked(pauseKey)) {
			isGamePaused = !isGamePaused;
			keyLocker.lockKey(pauseKey);
			Sound pause = new Sound("pause.wav", false);
			pause.playOnce();
		}

		if (Keyboard.isKeyUp(pauseKey)) {
			keyLocker.unlockKey(pauseKey);
		}
	}

	private void updateShowFPSState() {
		if (Keyboard.isKeyDown(showFPSKey) && !keyLocker.isKeyLocked(showFPSKey)) {
			showFPS = !showFPS;
			keyLocker.lockKey(showFPSKey);
		}

		if (Keyboard.isKeyUp(showFPSKey)) {
			keyLocker.unlockKey(showFPSKey);
		}

		fpsDisplayLabel.setText("FPS: " + currentFPS);
	}	

	public void draw() {
		screenManager.draw(graphicsHandler);

		// if game is paused, draw pause gfx over Screen gfx
		if (isGamePaused) {
			// graphicsHandler.drawFilledRectangleWithBorder(20, 50, 180, 210, Color.black, Color.white, 3);
			// graphicsHandler.drawFilledRectangleWithBorder(20, 270, 180, 250, Color.black, Color.white, 3);
			// graphicsHandler.drawFilledRectangleWithBorder(210, 50,400, 300, Color.black, Color.white, 3);
			// graphicsHandler.drawFilledRectangleWithBorder(210, 360, 400, 160, Color.black, Color.white, 3);
			// graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 100));
			// pauseLabel.draw(graphicsHandler);
			// healthLabel.draw(graphicsHandler);
			// attackTitle.draw(graphicsHandler);
			// itemTitle.draw(graphicsHandler);
			// dmgBoost1.draw(graphicsHandler);
			// dmgBoost2.draw(graphicsHandler);
			// dmgBoost3.draw(graphicsHandler);
			// item0.draw(graphicsHandler);
			// item1.draw(graphicsHandler);
			// item2.draw(graphicsHandler);
			// item3.draw(graphicsHandler);
			// bobcatLabel.draw(graphicsHandler);
			// levelNumber.draw(graphicsHandler);
			// trophyLabel.draw(graphicsHandler);
			// itemLabel.draw(graphicsHandler);
			// attackListLabel.draw(graphicsHandler);
			// infoLabel.draw(graphicsHandler);
		}

		if (showFPS) {
			fpsDisplayLabel.draw(graphicsHandler);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// every repaint call will schedule this method to be called
		// when called, it will setup the graphics handler and then call this class's draw method
		graphicsHandler.setGraphics((Graphics2D) g);
		draw();
	}

}
