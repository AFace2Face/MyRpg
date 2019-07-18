package james.peck.myrpg;


import java.util.ArrayList;

import static james.peck.myrpg.Creature.CreatureList;
/**
 * Created by James on 1/31/2019.
 */

public class CreatureDic {

    public void BuildDic()

    {
        Creature ratMan = new Creature("Ratman", 100, 65, 4, 12, 2, 15, 25, "blowDart", "counterSwing");
        CreatureList.put("ratMan", ratMan);
        Creature giantRat = new Creature("Giant Rat", 250, 120, 8, 4, 1,3, 0, "claw", "tooth&Paw");
        CreatureList.put("giantRat", giantRat);
        Creature largeFrog = new Creature( "Large Frog", 75, 150, 3, 25, 7, 0, 4, "fireBall", "simpleWard");
        CreatureList.put("largeFrog", largeFrog);
    }


    public ArrayList<String> PopulateArea(int zone)
    {
        ArrayList<String> presentCreatures = new ArrayList<>();
        if(zone == 1)
        {
            presentCreatures.add("ratMan");
            presentCreatures.add("giantRat");
            presentCreatures.add("largeFrog");
        }
        return presentCreatures;
    }


}
