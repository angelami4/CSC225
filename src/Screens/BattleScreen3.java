package Screens;

import Engine.*;
import Game.Game;
import Game.ScreenCoordinator;
import GameObject.Rectangle;
import SpriteFont.SpriteFont;
import Utils.Sound;
//import Maps.TestMap;
//import Game.GameState;
import Combat.Battle;
import Combat.BuckeyeMoves;
import Combat.GopherMoves;
import Combat.NextMove;
import Combat.WarriorMoves;
import Combat.WolverineMoves;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class BattleScreen3 extends Screen
{
    protected SpriteFont playerHP;
    protected SpriteFont enemyHP;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected Rectangle rectangle;
    protected GraphicsHandler graphicsHandler;
    protected ScreenCoordinator screenCoordinator;
    //public int health = GamePanel.health;
    //public int enemyHealth = 90;
    //public int bobcatHealth = GamePanel.health;

    protected List<SpriteFont> attackOptions;
    protected int selectedAttack;
    protected SpriteFont attackMessage;
    protected long attackMessageTimer;
    protected long attackMessageDuration = 2000;
    protected boolean fightMessageDisplayed = false;  
    protected boolean fightMessageTimer;

    protected BufferedImage backgroundImage; 
    protected BufferedImage playerImage;
    protected BufferedImage enemyImage;
    protected int playerX = 20;
    protected int playerY = 150;
    protected int enemyX = 530;
    protected int enemyY = 150;

    public BattleScreen3(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        initialize();
        try {
            backgroundImage = ImageIO.read(new File("Resources/rink.png")); 
            playerImage = ImageIO.read(new File("Resources/bb1.png")); 
            enemyImage = ImageIO.read(new File("Resources/bb4.png")); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize() {
        playerHP = new SpriteFont("BOBCAT | " + GamePanel.health + " HP", 15, 15, "Trebuchet MS", 22, Color.white);
        enemyHP = new SpriteFont("ENEMY | " + GamePanel.bossHealth3 + " HP", 600, 15, "Trebuchet MS", 22, Color.white);
        rectangle = new Rectangle();
        keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.Y);
        int initialY = 430; 
        int ySpacing = 50;
        //Sound warriorMusic = new Sound("spear-of-justice.wav", false);
        //warriorMusic.play();
        
    // Initialize attack options
        attackOptions = new ArrayList<>();
        attackOptions.add(new SpriteFont("HEAVY", 50, initialY, "Trebuchet MS", 22, Color.black));
        attackOptions.add(new SpriteFont("LIGHT", 50, initialY + ySpacing, "Trebuchet MS", 22, Color.black));
        attackOptions.add(new SpriteFont("DEFEND", 50, initialY + 2 * ySpacing, "Trebuchet MS", 22, Color.black));
        selectedAttack = 0;
        attackMessage = new SpriteFont("", 250, 151, "Trebuchet MS", 30, Color.white);
    }

    //add action listener so buttons can be pressed

    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        if (Keyboard.isKeyUp(Key.ENTER)) {
            keyLocker.unlockKey(Key.ENTER);
        }
        
        if (Keyboard.isKeyUp(Key.UP)) {
            keyLocker.unlockKey(Key.UP);
        }

        if (Keyboard.isKeyUp(Key.DOWN)) {
            keyLocker.unlockKey(Key.DOWN);
        }

        if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
            playLevelScreen.goBackToMenu();
        } else if (!fightMessageDisplayed) {  
            fightMessageDisplayed = true;
            attackMessage.setText("FIGHT!");
            attackMessage.setX(350);
            attackMessageTimer = System.currentTimeMillis();
        } else {
            if (Keyboard.isKeyDown(Key.ENTER) && !keyLocker.isKeyLocked(Key.ENTER)) {
                String attackName = attackOptions.get(selectedAttack).getText();
                

                // Determine damage based on the selected attack
                if (selectedAttack == 0) {
                    attackMessage.setText("Bobcat used HEAVY Attack!!!");
                    attackMessage.setX(200);
                    Battle.CatMove = NextMove.HEAVY;
                    WolverineMoves.WolverineAI();
                    Battle.Fight();
                    if (Battle.CatTakesDamage == true)
                    {
                        GamePanel.health -= 10;
                        playerHP.setText("BOBCAT | " + GamePanel.health + " HP");
                    }
                    else if (Battle.BossTakesDamage == true)
                    {
                        GamePanel.bossHealth3 -= 10;
                        enemyHP.setText("ENEMY | " + GamePanel.bossHealth3 + " HP");
                    } 
                } else if (selectedAttack == 1) {
                    attackMessage.setText("Bobcat used LIGHT Attack!!!");
                    attackMessage.setX(200);
                    Battle.CatMove = NextMove.LIGHT;
                    WolverineMoves.WolverineAI();
                    Battle.Fight();
                    if (Battle.CatTakesDamage == true)
                    {
                        GamePanel.health -= 10;
                        playerHP.setText("BOBCAT | " + GamePanel.health + " HP");
                    }
                    else if (Battle.BossTakesDamage == true)
                    {
                        GamePanel.bossHealth3 -= 10;
                        enemyHP.setText("ENEMY | " + GamePanel.bossHealth3 + " HP");
                    }
                } else if (selectedAttack == 2) {
                    attackMessage.setText("Bobcat used DEFEND!!!");
                    attackMessage.setX(200);
                    Battle.CatMove = NextMove.DEFEND;
                    WolverineMoves.WolverineAI();
                    Battle.Fight();
                    if (Battle.CatTakesDamage == true)
                    {
                        GamePanel.health -= 10;
                        playerHP.setText("BOBCAT | " + GamePanel.health + " HP");
                    }
                    if (Battle.BossTakesDamage == true)
                    {
                        GamePanel.bossHealth3 -= 10;
                        enemyHP.setText("ENEMY | " + GamePanel.bossHealth3 + " HP");
                    }
                }
                //playerHP.setText("BOBCAT | " + bobcatHealth + " HP");
                //enemyHP.setText("ENEMY | " + enemyHealth + " HP");

                attackMessageTimer = System.currentTimeMillis();
                keyLocker.lockKey(Key.ENTER);
            }

            if (Keyboard.isKeyDown(Key.UP) && !keyLocker.isKeyLocked(Key.UP)) {
                if (selectedAttack > 0) {
                    selectedAttack--;
                }
                keyLocker.lockKey(Key.UP);
            }

            if (Keyboard.isKeyDown(Key.DOWN) && !keyLocker.isKeyLocked(Key.DOWN)) {
                if (selectedAttack < attackOptions.size() - 1) {
                    selectedAttack++;
                }
                keyLocker.lockKey(Key.DOWN);
            }
        }

        if (attackMessageTimer > 0 && System.currentTimeMillis() - attackMessageTimer >= attackMessageDuration) {
            attackMessage.setText("");
            attackMessageTimer = 0;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        if (backgroundImage != null) {
            graphicsHandler.drawImage(backgroundImage, 0, 0);
        }
        if (playerImage != null) {
            graphicsHandler.drawImage(playerImage, playerX, playerY); 
        }
        if (enemyImage != null) {
            graphicsHandler.drawImage(enemyImage, enemyX, enemyY);
        }

        graphicsHandler.drawFilledRectangle(0, 420, 450, 160, Color.white);
        
        playerHP.draw(graphicsHandler);
        enemyHP.draw(graphicsHandler);

        for (SpriteFont attackOption : attackOptions) {
            int currentIndex = attackOptions.indexOf(attackOption);
            if (currentIndex == selectedAttack) {
                attackOption.setColor(Color.red);
            } else {
                attackOption.setColor(Color.black);
            }
            attackOption.draw(graphicsHandler);
        }

        attackMessage.draw(graphicsHandler);
    }
}
