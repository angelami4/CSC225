package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

// trigger script at beginning of game to set that heavy emotional plot
public class LostBallScript extends Script {
    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("Welcome, I'm Coach if you need help \n with how to play go back to instructions. ");
        addTextToTextboxQueue("You are going to defeat the final four schools !\nand get us that trophy. ");
        addTextToTextboxQueue( "We are yet to get a championship !\n and this is our year. ");
        addTextToTextboxQueue( "It's all up to you, first gather some  supplies !\nthen head into the rink with our first opponent. ");
        addTextToTextboxQueue( "Merimack aka The Warrior. ");
        addTextToTextboxQueue( "Goodluck, Do me proud. ");
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
