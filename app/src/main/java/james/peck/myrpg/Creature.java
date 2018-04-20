package james.peck.myrpg;

/**
 * Created by James on 4/15/2018.
 */

public class Creature {
    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getEnergy() {
        return Energy;
    }

    public void setEnergy(int energy) {
        Energy = energy;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public int getAgility() {
        return Agility;
    }

    public void setAgility(int agility) {
        Agility = agility;
    }

    public int getIntuition() {
        return Intuition;
    }

    public void setIntuition(int intuition) {
        Intuition = intuition;
    }

    public int getTurnProgress() {
        return TurnProgress;
    }

    public void setTurnProgress(int turnProgress) {
        TurnProgress = turnProgress;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getCHP() {
        return CHP;
    }

    public void setCHP(int CHP) {
        this.CHP = CHP;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    private String Name;
    private int Health;
    private int Energy;
    private int Strength;
    private int Agility;
    private int Intuition;
    private int CHP;
    private int CEP;

    public Creature(String name, int health, int energy, int strength, int agility, int intuition) {
        Name = name;
        Health = health;
        Energy = energy;
        Strength = strength;
        Agility = agility;
        Intuition = intuition;
        CHP = health;
        CEP = energy;
    }

    private int TurnProgress;



}
