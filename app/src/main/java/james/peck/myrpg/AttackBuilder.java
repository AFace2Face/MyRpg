package james.peck.myrpg;

import java.util.ArrayList;

import james.peck.myrpg.Skills.Attack;
import james.peck.myrpg.Skills.Defense;

import static james.peck.myrpg.Skills.Attack.AttackList;
import static james.peck.myrpg.Skills.Defense.DefenseList;

/**
 * Created by James on 7/21/2018.
 */

public class AttackBuilder {

    private final int STR = 0, AGI = 1, INT = 2;
    private final int BLUNT = 2, PIERCE = 1, FIRE = 3, CUT = 3;
    private final int MELEE = 0, RANGED = 1, MAGIC = 2, SLASH = 3, THRUST = 4, CHOP = 5, BASH = 6 , POLEARM = 7, SHORT = 8, BOW= 9 , CROSSBOW = 10;

    public static ArrayList<ArrayList<String>> skillCatalog = new ArrayList<>(4);

    public void BuildList()

    {
        // Tier 0 (starting) attack
        Attack smack = new Attack("Smack", 15, 9, STR, BLUNT, MELEE);
        AttackList.put("smack", smack);

        // Tier 0.5 (basic) attacks
        Attack cut = new Attack("Cut", 10, 10, STR, CUT, SLASH);
        AttackList.put("cut", cut);

        Attack stab = new Attack("Stab", 12, 12, AGI, PIERCE, THRUST);
        AttackList.put("stab", stab);

        Attack bludgeon = new Attack("Bludgeon", 15, 14, STR, BLUNT, BASH);
        AttackList.put("bludgeon", bludgeon);

        //Tier 1 attacks                                                       //change off fire type
        Attack magicBlast = new Attack("Magic blast", 20, 17, INT, FIRE, MAGIC);
        AttackList.put("magicblast", magicBlast);








        // Tier 0 (starting) defense
        Defense recoil = new Defense("Recoil", 10, 100, "agi", "guard");
        DefenseList.put("recoil", recoil);










        Attack wolfBite = new Attack("Wolf bite", 5, 9, STR, PIERCE);
        AttackList.put("wolfBite", wolfBite);

        Defense duck = new Defense("Duck", 60, 40, AGI, 0);
        DefenseList.put("duck", duck);


        Attack stagCharge = new Attack("Stag charge", 8, 7, STR, BASH);
        AttackList.put("stagcharge", stagCharge);

        Defense antlerGuard = new Defense("Antler guard", 50, 60, STR, 0);
        DefenseList.put("antlerguard", antlerGuard);










/*
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
        */

        makeSkillCatalog();
    }

    private void makeSkillCatalog() {
        ArrayList<String> skillShopZero = new ArrayList<>(0);
        skillShopZero.add("smack");
        skillCatalog.add(0, skillShopZero);

        ArrayList<String> skillShopOne = new ArrayList<>(4);
        skillShopOne.add("cut");
        skillShopOne.add("stab");
        skillShopOne.add("bludgeon");
        skillShopOne.add("magicblast");
        skillCatalog.add(1,skillShopOne);
    }
}
