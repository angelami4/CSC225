package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

// trigger script at beginning of game to set that heavy emotional plot
public class LostBallScript extends Script {
    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("HELP ME!!!!");
        addTextToTextboxQueue("SCARY MERRIMACK MAN!");
       // addTextToTextboxQueue("Maybe Walrus has seen it.");
    }

    @Override
    protected void cleanup() {
        setFlag("hasLostBall");
        hideTextbox();
        unlockPlayer();
    }

    @Override
    public ScriptState execute() {
        if (!isFlagSet("hasLostBall")) {
            start();
            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }
            end();
        }
        return ScriptState.COMPLETED;
    }
}
