package Maps;

//import EnhancedMapTiles.PushableRock;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Item;
import Level.Trigger;
//import NPCs.Dinosaur;
import NPCs.Buckeye;
import NPCs.Warrior;
import NPCs.Buckeye;
import NPCs.Walrus;
import NPCs.Transition;
//import NPCs.TrophyNPC;
import Items.*;
import Scripts.TestMap.TrophyScript;
import Scripts.TestMap.BuckeyeScript;
import Scripts.SimpleTextScript;
//import Scripts.TestMap.DinoScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.SwitchMap;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.WarriorScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;
import Utils.Sound;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap() {
        super("test_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

   /*/ @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        //PushableRock pushableRock = new PushableRock(getMapTile(2, 7).getLocation());
        //enhancedMapTiles.add(pushableRock);

        return enhancedMapTiles;
    }*/

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Warrior warrior = new Warrior(1, getMapTile(10, 20).getLocation().subtractY(40));
        warrior.setInteractScript(new WarriorScript());
        npcs.add(warrior);


        Buckeye buckeye = new Buckeye(1, getMapTile(4, 20).getLocation().subtractY(40));
        buckeye.setInteractScript(new BuckeyeScript());
        npcs.add(buckeye);

        //Dinosaur dinosaur = new Dinosaur(2, getMapTile(13, 4).getLocation());
        //dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        //dinosaur.setInteractScript(new DinoScript());
        //npcs.add(dinosaur);
        
        
        Transition transition = new Transition(2, getMapTile(14, 5).getLocation());
        transition.setExistenceFlag("transitionToFinalMap");
        transition.setInteractScript(new SwitchMap());
        npcs.add(transition); 

        //TrophyNPC trophynpc = new TrophyNPC(1, getMapTile(13, 17).getLocation());
        //trophynpc.setExistenceFlag("hasTouchedTrophy");
        //trophynpc.setInteractScript(new TrophyScript());
        //npcs.add(trophynpc);

        return npcs;
    }

   @Override
    public ArrayList<Item> loadItems() 
    {
        ArrayList<Item> items = new ArrayList<>();

        Trophy trophy = new Trophy(1, getMapTile(16, 2).getLocation());
        trophy.setInteractScript(new TrophyScript());
        items.add(trophy);

        CTice ctice = new CTice(1, getMapTile(10,2).getLocation());
        ctice.setInteractScript(new TrophyScript());
        items.add(ctice);

        FriendBell friendbell = new FriendBell(1, getMapTile(13, 2).getLocation());
        friendbell.setInteractScript(new TrophyScript());
        items.add(friendbell);
        
        return items;
    }
    

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

