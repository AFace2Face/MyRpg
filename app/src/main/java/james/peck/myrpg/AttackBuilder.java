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
        Attack fireBall = new Attack("FireBall", 25, 50,"int", "fire");
        AttackList.put("fireBall", fireBall);
        Attack thrust = new Attack("Thrust", 5, 15,"str", "pierce");
        AttackList.put("Thrust", thrust);

        Defense solidBlock = new Defense("solidBlock", 30, 70, 0, 1);
        DefenseList.put("solidBlock", solidBlock);

        Defense counterSwing = new Defense("counterSwing", 40, 60, 0 , 2);
        DefenseList.put("counterSwing", counterSwing);

        Defense simpleWard = new Defense("SimpleWard", 100,0, 2, 0, 0);
        DefenseList.put("simpleWard", simpleWard);
    }
}
