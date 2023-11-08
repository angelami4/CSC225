package Combat;


import Screens.BattleScreen;

public class Battle 
{
    public static NextMove CatMove = NextMove.NO_MOVE;
    public static NextMove BossMove = NextMove.NO_MOVE;
    public static int CatHealth = 100;
    public static int damage = 10;
    public static boolean CatTakesDamage;
    public static boolean BossTakesDamage;
    
    public static void Fight(int bosshealth, int bossDamage)
    {
        BattleScreen.enemyHealth = bosshealth;

        CatTakesDamage = false;
        BossTakesDamage = false;

        if (CatMove == NextMove.HEAVY)
        {
            if(BossMove == NextMove.DEFEND)
            {
                WarriorMoves.WarriorHP -= damage;
                BossTakesDamage = true;
                System.out.println("Cat wins");
            }
            else if(BossMove == NextMove.LIGHT)
            {
                CatHealth -= damage;
                CatTakesDamage = true;
                System.out.println("Boss wins");
            }
            else if(BossMove == NextMove.HEAVY)
            {
                System.out.println("Tie");
            }
        }
        else if (CatMove == NextMove.LIGHT)
        {
            if(BossMove == NextMove.DEFEND)
            {
                System.out.println("No Damage Delt");
            }
            else if(BossMove == NextMove.LIGHT)
            {
                System.out.println("Tie");
            } 
            else if(BossMove == NextMove.HEAVY)
            {
                WarriorMoves.WarriorHP -= damage;
                BossTakesDamage = true;
                System.out.println("Cat wins");
            }
        }
        else if (CatMove == NextMove.DEFEND)
        {
            if(BossMove == NextMove.DEFEND)
            {
                System.out.println("Tie");
            }
            else if(BossMove == NextMove.LIGHT)
            {
                System.out.println("No Damage Delt");
            }
            else if(BossMove == NextMove.HEAVY)
            {
                CatHealth -= damage;
                CatTakesDamage = true;
                System.out.println("Boss wins");
            }
        }
    }

}
