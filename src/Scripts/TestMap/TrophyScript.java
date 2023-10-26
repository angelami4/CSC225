package Scripts.TestMap;

import Level.*;

public class TrophyScript extends Script<Item>
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
