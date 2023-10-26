package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

import Game.ScreenCoordinator;

// script for talking to walrus npc
public class Enemy1Script extends Script<NPC> {
    protected ScreenCoordinator screenCoordinator;

    
    // Constructor for Enemy1Script that takes a ScreenCoordinator instance

   
    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToWalrus")) {
            addTextToTextboxQueue( "Hi Cat!");
            addTextToTextboxQueue( "...oh, you lost your ball?");
            addTextToTextboxQueue( "Hmmm...my walrus brain remembers seeing Dino with\nit last. Maybe you can check with him?");
        }
        else {
            addTextToTextboxQueue( "I sure love doing walrus things!");
                    
        if(map.getFlagManager().isFlagSet("HasTalkedToWalrus"));
            
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();

        // set flag so that if walrus is talked to again after the first time, what he says changes
        setFlag("hasTalkedToWalrus");
    }

    @Override
    public ScriptState execute() {
        start();
        if (!isTextboxQueueEmpty()) {
            return ScriptState.RUNNING;
        }
        end();
        return ScriptState.COMPLETED;
    }
}
