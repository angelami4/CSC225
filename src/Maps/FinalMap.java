package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.NPC;
import NPCs.Buckeye;
import NPCs.Dinosaur;
import NPCs.Transition;
import NPCs.Wolverine;
import NPCs.Gopher;
import NPCs.Warrior;
import Scripts.TestMap.BuckeyeScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.SwitchMap;
import Scripts.TestMap.GooferScript;
import Scripts.TestMap.WolverineScript;
import Scripts.TestMap.WarriorScript;
import Tilesets.CommonTileset;
import Utils.Point;

public class FinalMap extends Map {
    public FinalMap() {
        super("my_map.txt", new CommonTileset());
        this.playerStartPosition = new Point(1, 11);
    }
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Gopher gopher = new Gopher(1, getMapTile(11, 29).getLocation().subtractY(40));
        gopher.setInteractScript(new GooferScript());
        npcs.add(gopher);


       Wolverine wolverine = new Wolverine(1, getMapTile(15, 8).getLocation().subtractY(40));
        wolverine.setInteractScript(new WolverineScript());
        npcs.add(wolverine);

      
        return npcs;
    }
}