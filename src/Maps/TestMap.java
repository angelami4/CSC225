package Maps;

import EnhancedMapTiles.PushableRock;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Item;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.Enemy1;
import NPCs.Enemy2;
import NPCs.Walrus;
import Scripts.TestMap.TrophyScript;
import Scripts.TestMap.Enemy1Script;
import Scripts.SimpleTextScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;
import Utils.Sound;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap() {
        super("test_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
        Sound background = new Sound("ruins.wav", true);
        background.play();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        PushableRock pushableRock = new PushableRock(getMapTile(2, 7).getLocation());
        enhancedMapTiles.add(pushableRock);

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(1, getMapTile(4, 20).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);

        Enemy1 enemy1 = new Enemy1(1, getMapTile(10, 18).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(enemy1);

        Enemy2 enemy2 = new Enemy2(1, getMapTile(10, 20).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(enemy2);

        Dinosaur dinosaur = new Dinosaur(2, getMapTile(13, 4).getLocation());
        dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        dinosaur.setInteractScript(new DinoScript());
        npcs.add(dinosaur);

        TrophyNPC trophynpc = new TrophyNPC(1, getMapTile(13, 17).getLocation());
        trophynpc.setExistenceFlag("hasTouchedTrophy");
        trophynpc.setInteractScript(new TrophyScript());
        npcs.add(trophynpc);

        return npcs;
    }

   /* @Override
    public ArrayList<Item> loadItems() 
    {
        ArrayList<Item> items = new ArrayList<>();

        Trophy trophy = new Trophy(1, getMapTile(13, 17).getLocation());
        trophy.setExistenceFlag("hasTouchedTrophy");
        trophy.setInteractScript(new TrophyScript());
        items.add(trophy);
        
        return items;
    }
    */

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        return triggers;
    }

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }
}

