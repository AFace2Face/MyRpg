package james.peck.myrpg.Items;

import java.util.PriorityQueue;

public class Weapon extends Equipment {


    public int getBonusStrength() {
        return bonusStrength;
    }

    public void setBonusStrength(int bonusStrength) {
        this.bonusStrength = bonusStrength;
    }

    public int getBonusAgility() {
        return bonusAgility;
    }

    public void setBonusAgility(int bonusAgility) {
        this.bonusAgility = bonusAgility;
    }

    public int getBonusIntuition() {
        return bonusIntuition;
    }

    public void setBonusIntuition(int bonusIntuition) {
        this.bonusIntuition = bonusIntuition;
    }

    public boolean isMelee() {
        return isMelee;
    }

    public boolean isRanged() {
        return isRanged;
    }

    public boolean isMagic() {
        return isMagic;
    }

    public boolean isSlash() {
        return isSlash;
    }

    public boolean isThrust() {
        return isThrust;
    }

    public boolean isChop() {
        return isChop;
    }

    public boolean isBash() {
        return isBash;
    }

    public boolean isPolearm() {
        return isPolearm;
    }

    public boolean isShort() {
        return isShort;
    }

    public boolean isBow() {
        return isBow;
    }

    public boolean isCrossbow() {
        return isCrossbow;
    }

    private int bonusStrength;
    private int bonusAgility;
    private int bonusIntuition;

    private boolean isMelee;
    private boolean isRanged;
    private boolean isMagic;
    private boolean isSlash;
    private boolean isThrust;
    private boolean isChop;
    private boolean isBash;
    private boolean isPolearm;
    private boolean isShort;
    private boolean isBow;
    private boolean isCrossbow;


    public Weapon(String name, int value, int strength, int agility, int intutition) {
        this.name = name;
        this.value = value;
        bonusStrength = strength;
        bonusAgility = agility;
        bonusIntuition = intutition;
    }

    public Weapon(String name, String description, int value, int strength, int agility, int intuition, boolean isMelee, boolean isSlash, boolean isThrust, boolean isChop, boolean isBash) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.bonusStrength = strength;
        this.bonusAgility = agility;
        this.bonusIntuition = intuition;
        this.isMelee = isMelee;
        this.isSlash = isSlash;
        this.isThrust = isThrust;
        this.isChop = isChop;
        this.isBash = isBash;
        
    }
    

    public Weapon(String name, String description, int value, int strength, int agility, int intuition, boolean isRanged, boolean isBow, boolean isCrossbow) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.bonusStrength = strength;
        this.bonusAgility = agility;
        this.bonusIntuition = intuition;
        this.isRanged = isRanged;
        this.isBow = isBow;
        this.isCrossbow = isCrossbow;
    }

    public Weapon(String name, String description, int value, int strength, int agility, int intuition, boolean isMagic, boolean isPolearm, boolean isMelee, boolean isBash) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.bonusStrength = strength;
        this.bonusAgility = agility;
        this.bonusIntuition = intuition;
        this.isMagic = isMagic;
        this.isPolearm = isPolearm;
        this.isMelee = isMelee;
        this.isBash = isBash;
    }

    public Weapon(String name, String description, int value, int strength, int agility, int intuition, boolean isMelee, boolean isMagic, boolean isSlash, boolean isThrust, boolean isChop, boolean isBash, boolean isPolearm, boolean isShort) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.bonusStrength = strength;
        this.bonusAgility = agility;
        this.bonusIntuition = intuition;
        this.isMelee = isMelee;
        this.isMagic = isMagic;
        this.isSlash = isSlash;
        this.isThrust = isThrust;
        this.isChop = isChop;
        this.isBash = isBash;
        this.isPolearm = isPolearm;
        this.isShort = isShort;

    }
    
    
    
    


 /*   Melee,Ranged,
    Cut,Trust,Cop,
    Bash
            Polearm, Short,
            Bow, Crossbow

    magic?
    */

}
