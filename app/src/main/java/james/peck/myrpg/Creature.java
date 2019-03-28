package james.peck.myrpg;

import java.util.ArrayList;
import java.util.HashMap;

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

    public int getArmor() {
        return Armor;
    }

    public void setArmor(int armor) {
        Armor = armor;
    }

    public int getWarding() {
        return Warding;
    }

    public void setWarding(int warding) {
        Warding = warding;
    }

    private int TurnProgress;
    private String Name;
    private int Health;
    private int Energy;
    private int Strength;
    private int Agility;
    private int Intuition;
    private int MHP;
    private int MEP;
    private int Armor = 0;
    private int Warding = 0;
    public ArrayList<String> knownAttacks = new ArrayList<>();
    public ArrayList<String> knownDefenses = new ArrayList<>();
    public ArrayList<String> equipedItems = new ArrayList<>();
    public ArrayList<String> inventory = new ArrayList<>();
    private boolean isPlayer = false;
    static public Creature Player;

    static public HashMap<String, Creature> CreatureList = new HashMap<>();

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

    public Creature(String name, int health, int energy, int strength, int agility, int intuition, String firstAttack) {
        Name = name;
        Health = health;
        Energy = energy;
        Strength = strength;
        Agility = agility;
        Intuition = intuition;
        MHP = health;
        MEP = energy;
        knownAttacks.add(firstAttack);
    }

    public Creature(String name, int health, int energy, int strength, int agility, int intuition, String firstAttack, String firstDefense) {
        Name = name;
        Health = health;
        Energy = energy;
        Strength = strength;
        Agility = agility;
        Intuition = intuition;
        MHP = health;
        MEP = energy;
        knownAttacks.add(firstAttack);
        knownDefenses.add(firstDefense);
    }

    public Creature(String name, int health, int energy, int strength, int agility, int intuition, int armor, int warding, String firstAttack, String firstDefense) {
        Name = name;
        Health = health;
        Energy = energy;
        Strength = strength;
        Agility = agility;
        Intuition = intuition;
        MHP = health;
        MEP = energy;
        Armor = armor;
        Warding = warding;
        knownAttacks.add(firstAttack);
        knownDefenses.add(firstDefense);
    }

    public Creature(final Creature copy){
        Name = copy.getName();
        Health = copy.getHealth();
        Energy = copy.getEnergy();
        Strength = copy.getStrength();
        Agility = copy.getAgility();
        Intuition = copy.getAgility();
        Armor = copy.getArmor();
        Warding = copy.getWarding();
        MHP = Health;
        MEP = Energy;
        knownAttacks.add(copy.knownAttacks.get(0));
        knownDefenses.add(copy.knownDefenses.get(0));
    }

    public Creature spawnNewCopy()
    {
        return new Creature(this);
    }



}
