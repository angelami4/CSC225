package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

// script for talking to walrus npc
public class WarriorScript extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToWarrior")) {
            addTextToTextboxQueue( "Bobcat: What are you doing on my rink!?!!? ");
            addTextToTextboxQueue( "Merrimack: IT SHALL BE MINE MWUHAHAHA ");
            addTextToTextboxQueue( "Bobcat: GRRRRRR ");

        }
        else {
            addTextToTextboxQueue( "You've already defeated me !\n next is buckeye. ");
        }
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();

        // set flag so that if walrus is talked to again after the first time, what he says changes
        //setFlag("hasTalkedToWalrus");
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
