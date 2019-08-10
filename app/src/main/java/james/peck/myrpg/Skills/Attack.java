package james.peck.myrpg.Skills;

import java.util.HashMap;

/**
 * Created by James on 4/19/2018.
 */

public class Attack extends Skill {




    public String getName() {
        return name;
    }

    public int getDrain() {
        return drain;
    }

    public int getDamage() {
        return damage;
    }

    public int getType() {
        return type;
    }

    public boolean isHeal() {
        return isHeal;
    }

    public int getBonusType() {
        return bonusType;
    }

    public String name;
    private int drain;
    private int damage;
    private int type;
    private boolean isHeal = false;
    private int bonusType = 0;

    private final int STR = 0, AGI = 1, INT = 1;
    private final int BLUNT = 2, PIERCE = 1, FIRE = 3, CUT = 3;

    // MELEE = 0, RANGED = 1, MAGIC = 2, SLASH = 3, THRUST = 4, CHOP = 5, BASH = 6 , POLEARM = 7, SHORT = 8, BOW= 9 , CROSSBOW = 10;

    static public HashMap<String, Attack> AttackList = new HashMap<>();

    public Attack(String name, int drain, int damage, int stat, int type) {
        this.name = name;
        this.drain = drain;
        this.damage = damage;
        this.stat = stat;
        this.type = type;
    }

    public Attack(String name, int drain, int damage, int stat, int type, int requirement) {
        this.name = name;
        this.drain = drain;
        this.damage = damage;
        this.stat = stat;
        this.type = type;
        assignRequirement(requirement);
    }

    public Attack(String name, int drain, int damage, int stat, int type, int requirement1, int requirement2) {
        this.name = name;
        this.drain = drain;
        this.damage = damage;
        this.stat = stat;
        this.type = type;
        assignRequirement(requirement1);
        assignRequirement(requirement2);
    }

    public Attack(String name, int drain, int damage, int stat, int type, int requirement1, int requirement2, int requirement3) {
        this.name = name;
        this.drain = drain;
        this.damage = damage;
        this.stat = stat;
        this.type = type;
        assignRequirement(requirement1);
        assignRequirement(requirement2);
        assignRequirement(requirement3);
    }


 /*   public Attack(String name, int drain, int damage, int stat, int type, int bonusType) {
        this.name = name;
        this.drain = drain;
        this.damage = damage;
        this.stat = stat;
        this.type = type;
        this.bonusType = bonusType;
    }
*/


    private void assignRequirement(int requirement) {
        switch (requirement) {
            case 0:
                needMelee = true;
                required.add("Melee");
                break;
            case 1:
                needRanged = true;
                required.add("Ranged");
                break;
            case 2:
                needMagic = true;
                required.add("Magic");
                break;
            case 3:
                needSlash = true;
                required.add("Slash");
                break;
            case 4:
                needThrust = true;
                required.add("Thrust");
                break;
            case 5:
                needChop = true;
                required.add("Chop");
                break;
            case 6:
                needBash = true;
                required.add("Bash");
                break;
            case 7:
                needPolearm = true;
                required.add("Polearm");
                break;
            case 8:
                needShort = true;
                required.add("Short");
                break;
            case 9:
                needBow = true;
                required.add("Bow");
                break;
            case 10:
                needCrossbow = true;
                required.add("Crossbow");
                break;
        }
    }





}
