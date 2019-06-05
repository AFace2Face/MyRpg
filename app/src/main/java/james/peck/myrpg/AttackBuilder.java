package james.peck.myrpg;

import static james.peck.myrpg.Attack.AttackList;
import static james.peck.myrpg.Defense.DefenseList;

/**
 * Created by James on 7/21/2018.
 */

public class AttackBuilder {

    public void BuildList()

    {

        Attack blowDart = new Attack("BlowDart", 10, 25, "agi", "pierce");
        AttackList.put("blowDart", blowDart);
        Attack maceStrike = new Attack("MaceStrike", 10, 25,"str", "bash");
        AttackList.put("maceStrike", maceStrike);
        Attack fireBall = new Attack("FireBall", 25, 50,2, 3);
        AttackList.put("fireBall", fireBall);
        Attack thrust = new Attack("Thrust", 5, 15,"str", "pierce");
        AttackList.put("Thrust", thrust);
        Attack claw = new Attack("claw", 3, 20, "str", "slash");
        AttackList.put("claw", claw);
        Attack idle = new Attack("Idle", 0, 0, "str", "slash", 1);
        AttackList.put("idle", idle);
        Attack shoot = new Attack("Shot", 13, 30, "agi", "pierce");
        AttackList.put("shoot", shoot);



        Defense solidBlock = new Defense("solidBlock", 30, 70, 0, 1);
        DefenseList.put("solidBlock", solidBlock);
        Defense counterSwing = new Defense("counterSwing", 40, 60, 0 , 2);
        DefenseList.put("counterSwing", counterSwing);
        Defense simpleWard = new Defense("SimpleWard", 100,0, 2, 0);
        DefenseList.put("simpleWard", simpleWard);
        Defense toothAndPaw = new Defense("tooth&Paw", 0, 100, 0, 0);
        DefenseList.put("tooth&Paw", toothAndPaw);
        Defense dodgeAttack = new Defense("dodgeAttack", 100,2000,1,0, 1);
        DefenseList.put("dodgeAttack", dodgeAttack);
    }
}
