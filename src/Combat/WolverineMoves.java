package Combat;

public class WolverineMoves 
{
    public static int increment = 0;

    public static void WolverineAI()
    {
        increment++;

        if(increment % 6 == 1)
        {
            Battle.BossMove = NextMove.HEAVY;
        }
        else if(increment % 6 == 2)
        {
            Battle.BossMove = NextMove.HEAVY;
        }
        else if(increment % 6 == 3)
        {
            Battle.BossMove = NextMove.LIGHT;
        }
        else if(increment % 6 == 4)
        {
            Battle.BossMove = NextMove.LIGHT;
        }
        else if(increment % 6 == 5)
        {
            Battle.BossMove = NextMove.DEFEND;
        }
        else if(increment % 6 == 0)
        {
            Battle.BossMove = NextMove.DEFEND;
        }
    }
}
