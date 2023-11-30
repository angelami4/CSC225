package Combat;

public class GopherMoves 
{
    public static int increment = 0;

    public static void GopherAI()
    {
        increment++;

        if(increment % 8 == 1)
        {
            Battle.BossMove = NextMove.HEAVY;
        }
        else if(increment % 8 == 2)
        {
            Battle.BossMove = NextMove.LIGHT;
        }
        else if(increment % 8 == 3)
        {
            Battle.BossMove = NextMove.HEAVY;
        }
        else if(increment % 8 == 4)
        {
            Battle.BossMove = NextMove.DEFEND;
        }
        else if(increment % 8 == 5)
        {
            Battle.BossMove = NextMove.HEAVY;
        }
        else if(increment % 8 == 6)
        {
            Battle.BossMove = NextMove.DEFEND;
        }
        else if(increment % 8 == 7)
        {
            Battle.BossMove = NextMove.DEFEND;
        }
        else if(increment % 8 == 0)
        {
            Battle.BossMove = NextMove.DEFEND;
        }
    }    
}
