package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
//import Screens.*;

// script for talking to walrus npc
public class BuckeyeScript extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (isFlagSet("hasTalkedToWarrior")) {
            addTextToTextboxQueue( "Buckeye: YOU THINK THIS GON BE EASY? ");
            addTextToTextboxQueue( "Buckeye: Just Cause im from Ohio? ");
            addTextToTextboxQueue( "Buckeye: Well you thought wrong! ");
            addTextToTextboxQueue( "Bobcat: Let's just calm down n skate ");
            addTextToTextboxQueue( "Buckeye: NA ");
            addTextToTextboxQueue( "Buckeye: You're BOUTTA GET CRACKED ");
            //PlayLevelScreen.hasBeatenWarrior = true;
          //  addTextToTextboxQueue( "Hmmm...my walrus brain remembers seeing Dino with\nit last. Maybe you can check with him?");
        }
        else {
            addTextToTextboxQueue( "You Must Battle with the Merrimack Warrior Before ME!");
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        //map.getFlagManager().setFlag("hasTalkedToWarrior");
        unlockPlayer();
        hideTextbox();
        setFlag("hasTalkedToBuckeye");
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
