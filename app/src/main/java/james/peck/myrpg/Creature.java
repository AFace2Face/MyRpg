package james.peck.myrpg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import james.peck.myrpg.Items.Armor;
import james.peck.myrpg.Items.Weapon;

import static james.peck.myrpg.Items.Equipment.gearList;

/**
 * Created by James on 4/15/2018.
 */

public class Creature implements Serializable {
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public void setBaseStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    }

    public int getExtraStrength() {
        return extraStrength;
    }

    public void setExtraStrength(int extraStrength) {
        this.extraStrength = extraStrength;
    }

    public int getBaseAgility() {
        return baseAgility;
    }

    public void setBaseAgility(int baseAgility) {
        this.baseAgility = baseAgility;
    }

    public int getExtraAgility() {
        return extraAgility;
    }

    public void setExtraAgility(int extraAgility) {
        this.extraAgility = extraAgility;
    }

    public int getBaseIntuition() {
        return baseIntuition;
    }

    public void setBaseIntuition(int baseIntuition) {
        this.baseIntuition = baseIntuition;
    }

    public int getExtraIntuition() {
        return extraIntuition;
    }

    public void setExtraIntuition(int extraIntuition) {
        this.extraIntuition = extraIntuition;
    }

    private int TurnProgress;
    private String Name;
    private int Health;
    private int Energy;
    private int Strength;
    private int baseStrength = 0;
    private int extraStrength = 0;
    private int Agility;
    private int baseAgility = 0;
    private int extraAgility = 0;
    private int Intuition;
    private int baseIntuition = 0;
    private int extraIntuition = 0;
    private int MHP;
    private int MEP;
    private int Armor = 0;
    private int Warding = 0;
    private int gold = 0;
    private int level = 0;
    public ArrayList<String> knownAttacks = new ArrayList<>();
    public ArrayList<String> knownDefenses = new ArrayList<>();
    public String equipment[] = {"head", "body", "weapon"};
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
        baseStrength = strength;
        baseAgility = agility;
        baseIntuition = intuition;
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
        Intuition = copy.getIntuition();
        Armor = copy.getArmor();
        Warding = copy.getWarding();
        MHP = Health;
        MEP = Energy;
        knownAttacks.add(copy.knownAttacks.get(0));
        knownDefenses.add(copy.knownDefenses.get(0));
    }

    /**
     *
     * @return
     */
    public Creature spawnNewCopy()
    {
        return new Creature(this);
    }

    /**
     * finds and stats all stats based on the current items equipped
     */
    public void findNewStats()
    {
        extraStrength = ((Weapon)gearList.get(equipment[2])).getBonusStrength();
        extraAgility = ((Weapon)gearList.get(equipment[2])).getBonusAgility();
        extraIntuition = ((Weapon)gearList.get(equipment[2])).getBonusIntuition();
        Strength = (baseStrength + extraStrength);
        Agility = (baseAgility + extraAgility);
        Intuition = (baseIntuition + extraIntuition);
        Armor = (((Armor)gearList.get(equipment[0])).getDefense() + ((Armor)gearList.get(equipment[1])).getDefense());
        Warding = (((Armor)gearList.get(equipment[0])).getWarding() + ((Armor)gearList.get(equipment[1])).getWarding());
    }



}
