package Scripts.TestMap;

import Level.*;
import Utils.Sound;

public class TrophyScript extends Script<Item>
{
    Sound pickup = new Sound("pickup-item.wav", false);
    @Override
    protected void setup() {
        if (!isFlagSet("hasTouchedTrophy")) {
            setFlag("hasTouchedTrophy");
        }
    }

    @Override
    protected void cleanup() {
       if (isFlagSet("hasTouchedTrophy"))
       {
        entity.setIsHidden(true);
        pickup.play();
       }
       System.out.println("test print");
    }

    @Override
    protected ScriptState execute() 
    {
        start();
        if (!isFlagSet("hasTouchedTrophy")) {
            return ScriptState.RUNNING;
        }
        end();
        return ScriptState.COMPLETED;
    }
    

}
