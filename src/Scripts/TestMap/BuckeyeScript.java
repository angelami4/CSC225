package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

// script for talking to walrus npc
public class BuckeyeScript extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (isFlagSet("hasTalkedToWarrior")) {
            addTextToTextboxQueue( "Buckeye: YOU THINK THIS GON BE EASY?");
            addTextToTextboxQueue( "Bobcat: Let's just calm down n skate");
            addTextToTextboxQueue( "Buckeye: NA ");
            addTextToTextboxQueue( "Buckeye: You're BOUTTA GET CRACKED ");

          //  addTextToTextboxQueue( "Hmmm...my walrus brain remembers seeing Dino with\nit last. Maybe you can check with him?");
        }
        else {
            addTextToTextboxQueue( "You Must Battle with the Merrimack Warrior Before ME!");
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();

        // set flag so that if walrus is talked to again after the first time, what he says changes
      //  setFlag("hasTalkedToBuckeye");
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