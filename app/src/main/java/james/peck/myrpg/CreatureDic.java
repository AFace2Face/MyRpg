package james.peck.myrpg;


import java.util.ArrayList;

import static james.peck.myrpg.Creature.CreatureList;
/**
 * Created by James on 1/31/2019.
 */

public class CreatureDic {

    public void BuildDic()

    {
        //Zone 1 Creatures
        Creature strayWolf = new Creature("Stray wolf", "You stumble across a lone hungry wolf", 50, 120, 8, 15, 1 , 1, 2, "wolfBite", "duck");
        CreatureList.put("straywolf", strayWolf);
        Creature angryStag = new Creature("Angry stag", "You see a stag in front of you \n The stag raises it's head and looks at you threateningly", 70, 100, 10, 8, 1, 2, 1, "stagcharge", "antlerguard");
        CreatureList.put("angrystag", angryStag);


        //Zone 1 Boss/Mini Boss
        Boss alphaWolf = new Boss("Alpha wolf", "A howl echos through the forest followed by a large wolf bursting threw the undergrowth", 200, 300, 10, 18, 3, 3, 5);
        alphaWolf.knownAttacks.add("wolfBite");

        alphaWolf.knownDefenses.add("duck");

        CreatureList.put("alphawolf", alphaWolf);





     /*   Creature ratMan = new Creature("Ratman", 100, 65, 4, 12, 2, 15, 25, "blowDart", "counterSwing");
        CreatureList.put("ratMan", ratMan);
        Creature giantRat = new Creature("Giant Rat", 250, 120, 8, 4, 1,3, 0, "claw", "tooth&Paw");
        CreatureList.put("giantRat", giantRat);
        Creature largeFrog = new Creature( "Large Frog", 75, 150, 3, 25, 7, 0, 4, "fireBall", "simpleWard");
        CreatureList.put("largeFrog", largeFrog);
     */
    }


    public ArrayList<String> PopulateArea(int zone)
    {
        ArrayList<String> presentCreatures = new ArrayList<>();
        if(zone == 1)
        {
            presentCreatures.add(0,"alphawolf");
            presentCreatures.add("straywolf");
            presentCreatures.add("angrystag");

        }
        return presentCreatures;
    }


}
