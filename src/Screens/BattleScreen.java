package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import GameObject.Rectangle;
import SpriteFont.SpriteFont;
import Utils.Sound;
import Maps.TestMap;
import Game.GameState;
import Combat.Battle;
import Combat.NextMove;
import Combat.WarriorMoves;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BattleScreen extends Screen {
    protected SpriteFont playerHP;
    protected SpriteFont enemyHP;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected Rectangle rectangle;
    protected GraphicsHandler graphicsHandler;
    protected ScreenCoordinator screenCoordinator;

    public static int enemyHealth = 90;
    public static int bobcatHealth = 100;

    protected List<SpriteFont> attackOptions;
    protected int selectedAttack;
    protected SpriteFont attackMessage;
    protected long attackMessageTimer;
    protected long attackMessageDuration = 2000;
    protected boolean fightMessageDisplayed = false;  
    protected boolean fightMessageTimer;

    public BattleScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        initialize();
    }

    @Override
    public void initialize() {
        playerHP = new SpriteFont("BOBCAT | " + bobcatHealth + " HP", 15, 15, "Trebuchet MS", 22, Color.black);
        enemyHP = new SpriteFont("ENEMY | " + enemyHealth + " HP", 600, 15, "Trebuchet MS", 22, Color.black);
        rectangle = new Rectangle();
        bobcatHealth = 100;
        keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.Y);

        int initialY = 430; 
        int ySpacing = 50;
        
    // Initialize attack options
        attackOptions = new ArrayList<>();
        attackOptions.add(new SpriteFont("HEAVY", 50, initialY, "Trebuchet MS", 22, Color.black));
        attackOptions.add(new SpriteFont("LIGHT", 50, initialY + ySpacing, "Trebuchet MS", 22, Color.black));
        attackOptions.add(new SpriteFont("DEFEND", 50, initialY + 2 * ySpacing, "Trebuchet MS", 22, Color.black));
        selectedAttack = 0;
        attackMessage = new SpriteFont("", 300, 250, "Trebuchet MS", 30, Color.black);
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
            attackMessageTimer = System.currentTimeMillis();
        } else {
            if (Keyboard.isKeyDown(Key.ENTER) && !keyLocker.isKeyLocked(Key.ENTER)) {
                String attackName = attackOptions.get(selectedAttack).getText();
                

                // Determine damage based on the selected attack
                if (selectedAttack == 0) {
                    attackMessage.setText("Bobcat used HEAVY Attack!!!");
                    Battle.CatMove = NextMove.HEAVY;
                    Battle.Fight(WarriorMoves.WarriorHP, WarriorMoves.WarriorDamage);
                    if (Battle.CatTakesDamage == true)
                    {
                        bobcatHealth = bobcatHealth - 10;
                    }
                    else if (Battle.BossTakesDamage == true)
                    {
                        enemyHealth -= 10;
                    }
                    WarriorMoves.WarriorAI(NextMove.HEAVY); 
                } else if (selectedAttack == 1) {
                    attackMessage.setText("Bobcat used LIGHT Attack!!!");
                    Battle.CatMove = NextMove.LIGHT;
                    Battle.Fight(WarriorMoves.WarriorHP, WarriorMoves.WarriorDamage);
                    if (Battle.CatTakesDamage == true)
                    {
                        bobcatHealth = bobcatHealth - 10;
                    }
                    else if (Battle.BossTakesDamage == true)
                    {
                        enemyHealth -= 10;
                    }
                    WarriorMoves.WarriorAI(NextMove.LIGHT);
                } else if (selectedAttack == 2) {
                    attackMessage.setText("Bobcat used DEFEND!!!");
                    Battle.CatMove = NextMove.DEFEND;
                    Battle.Fight(WarriorMoves.WarriorHP, WarriorMoves.WarriorDamage);
                    if (Battle.CatTakesDamage == true)
                    {
                        bobcatHealth = bobcatHealth - 10;
                    }
                    if (Battle.BossTakesDamage == true)
                    {
                        enemyHealth -= 10;
                    }
                    WarriorMoves.WarriorAI(NextMove.DEFEND);
                }

               
                
                
                enemyHP.setText("ENEMY | " + enemyHealth + " HP");

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
        graphicsHandler.drawFilledRectangle(0, 420, 450, 160, Color.white);
        graphicsHandler.drawFilledRectangle(500, 420, 400, 160, Color.white);
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
