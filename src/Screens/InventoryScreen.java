package Screens;
import Level.Map;
import Screens.PlayLevelScreen.PlayLevelScreenState;
import SpriteFont.SpriteFont;
import Engine.GamePanel;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.ScreenCoordinator;
import java.awt.*;
import Utils.Sound;

public class InventoryScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
	protected PlayLevelScreen playLevelScreen;
	private SpriteFont pauseLabel;
	
	private SpriteFont healthLabel;
	private SpriteFont attackTitle;
	private SpriteFont itemTitle; 
	private SpriteFont dmgBoost1;
	private SpriteFont dmgBoost2;
	private SpriteFont dmgBoost3;
	private SpriteFont item0;
	private SpriteFont item1;
	private SpriteFont item2;
	private SpriteFont item3;
	private SpriteFont bobcatLabel;
	private SpriteFont levelNumber;
	private SpriteFont trophyLabel;
	private SpriteFont itemLabel;
	private SpriteFont attackListLabel;
	private SpriteFont infoLabel;
	public static int health;
	protected int menuItemHovered = 0; // current menu item being "hovered" over
	protected boolean isItemHovered;
    protected int menuItemSelected = -1;
	protected int keyPressTimer;

    public InventoryScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }
	@Override
	public void initialize() {
		health = GamePanel.health;
		pauseLabel = new SpriteFont("MENU", 10, 10, "Verdana", 24, Color.white);
		pauseLabel.setOutlineColor(Color.black);
		pauseLabel.setOutlineThickness(2.0f);

		attackTitle = new SpriteFont("ATTACK BOOST", 30, 280, "Verdana", 20, Color.white);
		dmgBoost1 = new SpriteFont("- Boxing Gloves", 30, 320, "Trebuchet MS", 20, Color.white);
		dmgBoost2 = new SpriteFont("- Hockey Stick", 30, 350, "Trebuchet MS", 20, Color.white);
		dmgBoost3 = new SpriteFont("- Scratching Post", 30, 380, "Trebuchet MS", 20, Color.white);

		itemTitle = new SpriteFont("ITEMS", 220, 65, "Verdana", 24, Color.white);
		item0 = new SpriteFont("", 220, 95, "Trebuchet MS", 24, Color.black);
		item1 = new SpriteFont(" - Pepsi (5 HP)", 220, 95, "Trebuchet MS", 24, Color.white);
		item2 = new SpriteFont(" - Hot Dog (10 HP)", 220, 125, "Trebuchet MS", 24, Color.white);
		item3 = new SpriteFont(" - Nachos (20 HP)", 220, 155, "Trebuchet MS", 24, Color.white);

		bobcatLabel = new SpriteFont("Boomer", 28, 60, "Impact", 30, Color.white);
		levelNumber = new SpriteFont("LV 1", 30, 105, "Trebuchet MS", 16, Color.white);
		healthLabel = new SpriteFont(health + "/100 HP", 30, 125, "Trebuchet MS", 16, Color.white);
		trophyLabel = new SpriteFont("TROPHIES: 0", 30, 145, "Trebuchet MS", 16, Color.white);
		itemLabel = new SpriteFont("    ITEMS", 30, 185, "Verdana", 16, Color.white);
		attackListLabel = new SpriteFont("    ATTACK LIST", 30, 205, "Verdana", 16, Color.white);
		infoLabel = new SpriteFont("Use Enter Key to pick Item!", 220, 370, "Verdana", 21, Color.white);
		//pointer = new SpriteFont(">", 220, 85, "Trebuchet MS", 24, Color.red);
    }
    
    public void update() {
		if (Keyboard.isKeyDown(Key.ESC)) {
			playLevelScreen.setPlayLevelScreenState(PlayLevelScreenState.RUNNING);
		}
		
		if (Keyboard.isKeyDown(Key.DOWN) && keyPressTimer == 0) {
            keyPressTimer = 14;
			menuItemHovered++;
        } 
		else if (Keyboard.isKeyDown(Key.UP) && keyPressTimer == 0) {
			keyPressTimer = 14;
			menuItemHovered--;
		} 
		if (menuItemHovered > 3) {
			menuItemHovered = 1;
		} 
		else if (menuItemHovered < 1) {
            menuItemHovered = 1;
        }
		else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }
		if (menuItemHovered == 1) {
            item1.setColor(Color.red);
            item2.setColor(Color.white);
			item3.setColor(Color.white);
			//pointer.setY(95);
        } else if (menuItemHovered == 2) {
            item1.setColor(Color.white);
            item2.setColor(Color.red);
			item3.setColor(Color.white);
			//pointer.setY(125);
        } else if (menuItemHovered == 3) {
            item1.setColor(Color.white);
            item2.setColor(Color.white);
			item3.setColor(Color.red);
			//pointer.setY(155);
        }
		if (Keyboard.isKeyDown(Key.ENTER)) {
            keyLocker.unlockKey(Key.ENTER);
        }
		if (!keyLocker.isKeyLocked(Key.ENTER) && Keyboard.isKeyDown(Key.ENTER)) {
            menuItemSelected = menuItemHovered;
			Sound interact = new Sound("interact.wav", false);
			interact.playOnce();
            if (menuItemSelected == 0) {
				item0.remove();
            }
			if (menuItemSelected == 1) {
				item1.remove();
				item2.setY(95);
				item3.setY(125);
				infoLabel.setText("Pepsi drank! Gained 5 HP");
            } 
			else if (menuItemSelected == 2) {
				item2.remove();
				item3.setY(125);
				infoLabel.setText("Hot Dog eaten! Gained 10 HP");
            } 
			else if (menuItemSelected == 3){
				item3.remove();
				infoLabel.setText("Nachos eaten! Gained 20 HP");
			}
        }
	}
    
    @Override
    public void draw(GraphicsHandler graphicsHandler){
		graphicsHandler.drawFilledRectangleWithBorder(20, 50, 180, 210, Color.black, Color.white, 3);
		graphicsHandler.drawFilledRectangleWithBorder(20, 270, 180, 250, Color.black, Color.white, 3);
		graphicsHandler.drawFilledRectangleWithBorder(210, 50,400, 300, Color.black, Color.white, 3);
		graphicsHandler.drawFilledRectangleWithBorder(210, 360, 400, 160, Color.black, Color.white, 3);
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 100));			pauseLabel.draw(graphicsHandler);
		healthLabel.draw(graphicsHandler);
		attackTitle.draw(graphicsHandler);
		itemTitle.draw(graphicsHandler);
		dmgBoost1.draw(graphicsHandler);
		dmgBoost2.draw(graphicsHandler);
		dmgBoost3.draw(graphicsHandler);
		item0.draw(graphicsHandler);
		item1.draw(graphicsHandler);
		item2.draw(graphicsHandler);
		item3.draw(graphicsHandler);
		bobcatLabel.draw(graphicsHandler);
		levelNumber.draw(graphicsHandler);
		trophyLabel.draw(graphicsHandler);
		itemLabel.draw(graphicsHandler);
		attackListLabel.draw(graphicsHandler);
		infoLabel.draw(graphicsHandler);
		//pointer.draw(graphicsHandler);
	}
}