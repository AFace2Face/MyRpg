package james.peck.myrpg.Items;

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

    public Weapon(String name, int value, int strength, int agility, int intutition)
    {
        this.name = name;
        this.value = value;
        bonusStrength = strength;
        bonusAgility = agility;
        bonusIntuition = intutition;
    }
}
