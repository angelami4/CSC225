package Combat;

public class WarriorMoves 
{
    public static void WarriorAI(NextMove nextmove)
    {
        if (nextmove == NextMove.DEFEND)
        {
            Battle.BossMove = NextMove.DEFEND;
        }
        else if (nextmove == NextMove.HEAVY)
        {
            Battle.BossMove = NextMove.HEAVY;
        }
        else if (nextmove == NextMove.LIGHT)
        {
            Battle.BossMove = NextMove.LIGHT;
        }
    }
}
