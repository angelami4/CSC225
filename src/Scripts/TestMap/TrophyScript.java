package Scripts.TestMap;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.*;
import Utils.Direction;
import Utils.Point;

public class TrophyScript extends Script<NPC>
{

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
