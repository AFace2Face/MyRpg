package james.peck.myrpg;

import java.util.ArrayList;

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

    public int getMHP() {
        return MHP;
    }

    public void setMHP(int MHP) {
        this.MHP = MHP;
    }

    public int getMEP() {
        return MEP;
    }

    public void setMEP(int MEP) {
        this.MEP = MEP;
    }

    public boolean getIsPlayer()
    {
        return isPlayer;
    }

    private String Name;
    private int Health;
    private int Energy;
    private int Strength;
    private int Agility;
    private int Intuition;
    private int MHP;
    private int MEP;
    public ArrayList<String> knownAttacks = new ArrayList<>();
   // public ArrayList<Defense> knownDefenses;
    private boolean isPlayer = false;
    static public Creature Player;

    public Creature(String name, int health, int energy, int strength, int agility, int intuition) {
        Name = name;
        Health = health;
        Energy = energy;
        Strength = strength;
        Agility = agility;
        Intuition = intuition;
        MHP = health;
        MEP = energy;
    }

    public Creature(String name, int health, int energy, int strength, int agility, int intuition, boolean player) {
        Name = name;
        Health = health;
        Energy = energy;
        Strength = strength;
        Agility = agility;
        Intuition = intuition;
        MHP = health;
        MEP = energy;
        isPlayer = player;
    }

    public Creature(String name, int health, int energy, int strength, int agility, int intuition, Attack firstAttack) {
        Name = name;
        Health = health;
        Energy = energy;
        Strength = strength;
        Agility = agility;
        Intuition = intuition;
        MHP = health;
        MEP = energy;
    }



    private int TurnProgress;



}
