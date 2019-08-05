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

    private int bonusStrength;
    private int bonusAgility;
    private int bonusIntuition;

    private Boolean isMelee = false;
    private Boolean isRanged = false;
    private Boolean isMagic = false;
    private Boolean isSlash = false;
    private Boolean isThrust = false;
    private Boolean isChop = false;
    private Boolean isBash = false;
    private Boolean isPolearm = false;
    private Boolean isShort = false;
    private Boolean isBow = false;
    private Boolean isCrossbow = false;


    public Weapon(String name, int value, int strength, int agility, int intutition) {
        this.name = name;
        this.value = value;
        bonusStrength = strength;
        bonusAgility = agility;
        bonusIntuition = intutition;
    }

    public Weapon(String name, String description, int value, int strength, int agility, int intuition, Boolean isMelee, Boolean isSlash, Boolean isThrust, Boolean isChop, Boolean isBash) {
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
    

    public Weapon(String name, String description, int value, int strength, int agility, int intuition, Boolean isRanged, Boolean isBow, Boolean isCrossbow) {
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

    public Weapon(String name, String description, int value, int strength, int agility, int intuition, Boolean isMagic, Boolean isPolearm) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.bonusStrength = strength;
        this.bonusAgility = agility;
        this.bonusIntuition = intuition;
        this.isMagic = isMagic;
        this.isPolearm = isPolearm;
    }

    public Weapon(String name, String description, int value, int strength, int agility, int intuition, Boolean isMelee, Boolean isMagic, Boolean isSlash, Boolean isThrust, Boolean isChop, Boolean isBash, Boolean isPolearm, Boolean isShort) {
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
