package james.peck.myrpg.Items;

public class Armor extends Equipment {

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getWarding() {
        return warding;
    }

    public void setWarding(int warding) {
        this.warding = warding;
    }

    protected int defense = -1;
    protected int warding = -1;
}
