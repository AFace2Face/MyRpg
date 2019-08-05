package james.peck.myrpg;

public class Boss extends Creature {


    public Boss(String name, String encounter, int health, int energy, int strength, int agility, int intuition, int armor, int warding) {
        super(name, encounter, health, energy, strength, agility, intuition, armor, warding);

    }



    public String chooseDefense() {
        int i = (int) (Math.random() * knownDefenses.size());
        return knownDefenses.get(i);
    }
}
