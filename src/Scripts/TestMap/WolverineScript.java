package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

// script for talking to walrus npc
public class WolverineScript extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (isFlagSet("hasTalkedToBuckeye")) {
            addTextToTextboxQueue( "Wolverine: Stupid Bobcat, Your about to get CLAWED! ");
            addTextToTextboxQueue( "Bobcat: I'd like to see you try we're far to fast for you ");
            addTextToTextboxQueue( "Wolverine: ENOUGH TALKING LET'S HIT THE ICE. ");

          //  addTextToTextboxQueue( "Hmmm...my walrus brain remembers seeing Dino with\nit last. Maybe you can check with him?");
        }
        else {
            addTextToTextboxQueue( "You Must Battle with the Ohio Buckeye Before ME!");
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();

        // set flag so that if walrus is talked to again after the first time, what he says changes
        setFlag("hasTalkedToWolverine");
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
