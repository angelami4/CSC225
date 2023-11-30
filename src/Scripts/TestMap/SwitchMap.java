package Scripts.TestMap;

import Level.*;

public class SwitchMap extends Script<Item>
{
    @Override
    protected void setup() {

    }

    @Override
    protected void cleanup() {

    }
 
    @Override
    protected ScriptState execute() 

    {
        start();
        map.mapTransition = 1;

        end();
        return ScriptState.COMPLETED;
    }
    

}