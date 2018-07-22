package james.peck.myrpg;

import static james.peck.myrpg.Attack.AttackList;
import static james.peck.myrpg.Defense.DefenseList;

/**
 * Created by James on 7/21/2018.
 */

public class AttackBuilder {

    public void BuildList()

    {

        Attack blowDart = new Attack("BlowDart", 20, 30, "pierce");
        AttackList.put("blowDart", blowDart);
        Attack maceStrike = new Attack("MaceStrike", 20, 30, "bash");
        AttackList.put("maceStrike", maceStrike);

        Defense soildBlock = new Defense("solidBlock", 20, 30, 1);
        DefenseList.put("solidBlock", soildBlock);
    }
}
