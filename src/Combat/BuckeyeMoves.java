package Combat;

public class BuckeyeMoves 
{
    public static int increment = 0; 

    public static void BuckeyeAI()
    {
        increment++;

        if(increment % 5 == 1)
        {
            Battle.BossMove = NextMove.DEFEND;
        }
        else if(increment % 5 == 2)
        {
            Battle.BossMove = NextMove.LIGHT;
        } 
        else if(increment % 5 == 3)
        {
            Battle.BossMove = NextMove.DEFEND;
        }
        else if(increment % 5 == 4)
        {
            Battle.BossMove = NextMove.DEFEND;
        }
        else if(increment % 5 == 0)
        {
            Battle.BossMove = NextMove.HEAVY;
        }
    }
}
