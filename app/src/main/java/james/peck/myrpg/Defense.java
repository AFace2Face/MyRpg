package james.peck.myrpg;

import java.util.HashMap;

/**
 * Created by James on 7/22/2018.
 */

public class Defense extends Skill {

    public int getDrain() {
        return drain;
    }


    public int getImpairment() {
        return impairment;
    }


    public int getType() {
        return type;
    }


    public int getStat() {
        return stat;
    }

    public int getBonusType() {
        return bonusType;
    }


    public String name;
    private int drain;
    private int impairment;
    private int type;
    private int stat;
    private int bonusType = 1;

    static public HashMap<String, Defense> DefenseList = new HashMap<>();

    public Defense(String name, int drain, int impairment, int stat, int type)
    {
        this.name = name;
        this.drain = drain;
        this.impairment = impairment;
        this.stat = stat;
        this.type = type;

    }

    public Defense(String name, int drain, int impairment,int stat, int type, int bonusType)
    {
        this.name = name;
        this.drain = drain;
        this.impairment = impairment;
        this.stat = stat;
        this.type = type;
        this.bonusType = type;

    }

    public Defense(String name, int drain, int impairment, String stat, String type)
    {
        this.name = name;
        this.drain = drain;
        this.impairment = impairment;
        if(stat.equals("str"))
        {
            this.stat = 0;
        }
        else if (stat.equals("agi"))
        {
            this.stat = 1;
        }
        else if(stat.equals("int"))
        {
            this.stat = 2;
        }

        if(type.equals("base"))
        {
            this.type = 0;
        }
        else if(type.equals("deflect"))
        {
            this.type = 1;
        }
        else if(type.equals("guard"))
        {
            this.type = 2;
        }

    }

    public Defense(String name, int drain, int impairment, String stat, String type, String bonusType)
    {
        this.name = name;
        this.drain = drain;
        this.impairment = impairment;
        if(stat.equals("str"))
        {
            this.stat = 0;
        }
        else if (stat.equals("agi"))
        {
            this.stat = 1;
        }
        else if(stat.equals("int"))
        {
            this.stat = 2;
        }


        if(bonusType.equals("health"))
        {
            this.bonusType = 0;
        }
        else if(bonusType.equals("energy"))
        {
            this.bonusType = 2;
        }

        else if(type.equals("base"))
        {
            this.type = 0;
        }
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
