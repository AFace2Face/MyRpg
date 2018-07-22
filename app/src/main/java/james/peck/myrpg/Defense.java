package james.peck.myrpg;

import java.util.HashMap;

/**
 * Created by James on 7/22/2018.
 */

public class Defense {

    public int getDrain() {
        return drain;
    }

    public void setDrain(int drain) {
        this.drain = drain;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String name;
    private int drain;
    private int power;
    private int type;
    static public HashMap<String, Defense> DefenseList = new HashMap<>();

    public Defense(String name, int drain, int power, int type)
    {
        this.name = name;
        this.drain = drain;
        this.power = power;
        this.type = type;

    }

    public Defense(String name, int drain, int power, String type)
    {
        this.name = name;
        this.drain = drain;
        this.power = power;
        if(type.equals("deflect"))
        {
            this.type = 1;
        }
        else if(type.equals("guard"))
        {
            this.type = 2;
        }

    }
}
