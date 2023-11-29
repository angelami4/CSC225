package Screens;

import Engine.GamePanel;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.Game;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.TestMap;
import Players.Cat;
import Utils.Direction;
import Utils.Point;
import Utils.Sound;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    private final Key pauseKey = Key.ESC;
    private KeyLocker keyLocker = new KeyLocker();
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected LoseScreen loseScreen;
    protected BattleScreen battleScreen;
    protected BattleScreen2 battleScreen2;
    protected BattleScreen3 battleScreen3;
    protected BattleScreen4 battleScreen4;
    protected InventoryScreen inventoryScreen;
    protected FlagManager flagManager;
    protected int health = GamePanel.health;
    protected int bobcatHealth;
    private boolean isGamePaused;
    public static boolean hasBeatenWarrior;
    public static boolean hasBeatenBuckeye;
    public static boolean hasBeatenWolverine;
    public static boolean hasBeatenGopher;
    protected int enemyHealth;
    Sound background = new Sound("ruins.wav", true);
    Sound fightStart = new Sound("fight!.wav", false);
    Sound warriorMusic = new Sound("dummy!.wav", false);
    Sound gameOver = new Sound("game-over.wav", false);
    Sound fightWin = new Sound("fight-win.wav", false);
    Sound warriorTaunt = new Sound("ganon-chuckle.wav", true);

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("hasLostBall", false);
        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
        flagManager.addFlag("hasFoundBall", false);
        flagManager.addFlag("hasTouchedTrophy", false);
        flagManager.addFlag("hasTalkedToWarrior", false);
         flagManager.addFlag("hasTalkedToBuckeye", false);
         flagManager.addFlag("hasTalkedToGoofer", false);
         flagManager.addFlag("hasTalkedToWolverine", false);
         background.play();
        battleScreen = new BattleScreen(this.screenCoordinator);
        battleScreen2 = new BattleScreen2(this.screenCoordinator);
        battleScreen3 = new BattleScreen3(this.screenCoordinator);
        battleScreen4 = new BattleScreen4(this.screenCoordinator);
        bobcatHealth = health;
        // define/setup map
        this.map = new TestMap();
        map.setFlagManager(flagManager);

        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        this.player.setFacingDirection(Direction.LEFT);
        
        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        // setup map scripts to have references to the map and player
        for (MapTile mapTile : map.getMapTiles()) {
            if (mapTile.getInteractScript() != null) {
                mapTile.getInteractScript().setMap(map);
                mapTile.getInteractScript().setPlayer(player);
            }
        }
        for (NPC npc : map.getNPCs()) {
            if (npc.getInteractScript() != null) {
                npc.getInteractScript().setMap(map);
                npc.getInteractScript().setPlayer(player);
            }
        }
        for (Item item : map.getItems())
        {
            if (item.getInteractScript() != null)
            {
                item.getInteractScript().setMap(map);
                item.getInteractScript().setPlayer(player);
            }
        }
        for (EnhancedMapTile enhancedMapTile : map.getEnhancedMapTiles()) {
            if (enhancedMapTile.getInteractScript() != null) {
                enhancedMapTile.getInteractScript().setMap(map);
                enhancedMapTile.getInteractScript().setPlayer(player);
            }
        }
        for (Trigger trigger : map.getTriggers()) {
            if (trigger.getTriggerScript() != null) {
                trigger.getTriggerScript().setMap(map);
                trigger.getTriggerScript().setPlayer(player);
            }
        }
        winScreen = new WinScreen(this);
        inventoryScreen = new InventoryScreen(this);

        loseScreen = new LoseScreen(this);
    }

    public void update() {
        updatePauseState();
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                background.play();
                warriorMusic.pause();
                warriorTaunt.pause();
                map.update(player);
                if(isGamePaused){
                    playLevelScreenState = PlayLevelScreenState.INVENTORY;
                    keyLocker.lockKey(pauseKey);
                }
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_LOSE:
                loseScreen.update();
                background.pause();
                warriorMusic.pause();
                warriorTaunt.pause();
                gameOver.play();
                break;
            case LEVEL_WIN:
                winScreen.update();
                background.pause();
                warriorMusic.pause();
                warriorTaunt.pause();
                fightWin.play();
                break;
            case BATTLE_ACTIVATE:
                battleScreen.update();
                background.pause();
                fightStart.play();
                warriorMusic.play();
                warriorTaunt.play();
                break;
            case BATTLE2_ACTIVATE:
                battleScreen2.update();
                background.pause();
                //fightStart.play();
                break;
            case BATTLE3_ACTIVATE:
                battleScreen3.update();
                background.pause();
                break;
            case BATTLE4_ACTIVATE:
                battleScreen4.update();
                background.pause();
                break;
            case INVENTORY:
                inventoryScreen.update();
                break;
        }
        
        // if flag is set at any point during gameplay, game is "won"
       // if (map.getFlagManager().isFlagSet("hasFoundBall")) {
         //   playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        //}
        if (hasBeatenWolverine == true && map.getFlagManager().isFlagSet("hasTalkedToWolverine"))
        {
            playLevelScreenState = PlayLevelScreenState.BATTLE4_ACTIVATE;
            if(GamePanel.health <= 0) {
                playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE;
            }
            if(GamePanel.bossHealth4 <= 0)
            {
                playLevelScreenState = PlayLevelScreenState.RUNNING;
                //hasBeatenGopher = true;
            }
        }
        else if (hasBeatenBuckeye == true && map.getFlagManager().isFlagSet("hasTalkedToBuckeye"))
        {
            playLevelScreenState = PlayLevelScreenState.BATTLE3_ACTIVATE;
            if(GamePanel.health <= 0) {
                playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE;
            }
            if(GamePanel.bossHealth3 <= 0)
            {
                playLevelScreenState = PlayLevelScreenState.RUNNING;
                //hasBeatenWolverine = true;
                //map.getFlagManager().setFlag("hasTalkedToGoofer");
            }
        }
        else if (hasBeatenWarrior == true && map.getFlagManager().isFlagSet("hasTalkedToWarrior"))
        {
            playLevelScreenState = PlayLevelScreenState.BATTLE2_ACTIVATE;
            if(GamePanel.health <= 0) {
                playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE;
            }
            if(GamePanel.bossHealth2 <= 0)
            {
                playLevelScreenState = PlayLevelScreenState.RUNNING;
                //hasBeatenBuckeye = true;
                //map.getFlagManager().setFlag("hasTalkedToWolverine");
            }
        }
        else if (map.getFlagManager().isFlagSet("hasTalkedToWalrus")) {
            playLevelScreenState = PlayLevelScreenState.BATTLE_ACTIVATE;
              if (GamePanel.health <= 0 ) {
              playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE;
              //gameOver.play();
            } 
            if(GamePanel.bossHealth <= 0){
                playLevelScreenState = PlayLevelScreenState.RUNNING;
                //map.getFlagManager().setFlag("hasTalkedToBuckeye");
            }
        }

        if (GamePanel.bossHealth <= 0)
        {
            hasBeatenWarrior = true;
        }
        else if(GamePanel.bossHealth2 <= 0)
        {
            hasBeatenBuckeye = true;
        }
        else if(GamePanel.bossHealth3 <= 0)
        {
            hasBeatenWolverine = true;
        }
        else if(GamePanel.bossHealth4 <= 0)
        {
            hasBeatenGopher = true;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:    
            map.draw(player, graphicsHandler);
                break;
            case LEVEL_LOSE:
                loseScreen.draw(graphicsHandler);
                break;
            case LEVEL_WIN:
                winScreen.draw(graphicsHandler);
                break;
            case BATTLE_ACTIVATE:
                battleScreen.draw(graphicsHandler);
                break;
            case BATTLE2_ACTIVATE:
                battleScreen2.draw(graphicsHandler);
                break;
            case BATTLE3_ACTIVATE:
                battleScreen3.draw(graphicsHandler);
                break;
            case BATTLE4_ACTIVATE:
                battleScreen4.draw(graphicsHandler);
                break;
            case INVENTORY:
                inventoryScreen.draw(graphicsHandler);
                break;
        }
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }

    public void setPlayLevelScreenState(PlayLevelScreenState state){
        this.playLevelScreenState = state;
    }

    public void resetLevel() {
        initialize();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
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

    // This enum represents the different states this screen can be in
    public enum PlayLevelScreenState {
        RUNNING, LEVEL_LOSE, BATTLE_ACTIVATE, BATTLE2_ACTIVATE, BATTLE3_ACTIVATE, BATTLE4_ACTIVATE, INVENTORY, LEVEL_WIN
    }
}
