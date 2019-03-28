package james.peck.myrpg;

import static james.peck.myrpg.Creature.CreatureList;
/**
 * Created by James on 1/31/2019.
 */

public class CreatureDic {

    public void BuildDic()

    {
        Creature ratMan = new Creature("Ratman", 100, 65, 4, 12, 2, 15, 25, "blowDart", "counterSwing");
        CreatureList.put("ratMan", ratMan);
        Creature giantRat = new Creature("Giant Rat", 200, 120, 8, 4, 1,4, 0, "claw", "tooth&Paw");
        CreatureList.put("giantRat", giantRat);
    }
}
