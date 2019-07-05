package james.peck.myrpg.Items;

public class Body extends Armor {



    public Body(String name, int value, int defense, int warding)
    {
        this.name = name;
        this.value = value;
        this.defense = defense;
        this.warding = warding;
    }

    public Body(String name, String description, int value, int defense, int warding)
    {
        this.name = name;
        this.description = description;
        this.value = value;
        this.defense = defense;
        this.warding = warding;
    }

}
