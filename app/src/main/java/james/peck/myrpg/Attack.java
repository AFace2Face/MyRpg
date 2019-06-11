package james.peck.myrpg;

import java.util.HashMap;

/**
 * Created by James on 4/19/2018.
 */

public class Attack extends Skill {

    public String getName() {
        return name;
    }

    public int getDrain() {
        return drain;
    }

    public int getDamage() {
        return damage;
    }

    public int getType() {
        return type;
    }

    public boolean isHeal() {
        return isHeal;
    }

    public int getBonusType() {
        return bonusType;
    }

    public String name;
    private int drain;
    private int damage;
    private int type;
    private boolean isHeal = false;
    private int bonusType = 0;

    static public HashMap<String, Attack> AttackList = new HashMap<>();

    public Attack(String name, int drain, int damage, int stat, int type) {
        this.name = name;
        this.drain = drain;
        this.damage = damage;
        this.stat = stat;
        this.type = type;
    }

    public Attack(String name, int drain, int damage, String stat, String type) {
        this.name = name;
        this.drain = drain;
        this.damage = damage;
        if(stat.equals("str"))
        {
            this.stat = 0;
        }
        else if(stat.equals("agi"))
        {
            this.stat = 1;
        }
        else if(stat.equals("int"))
        {
            this.stat = 2;
        }

        if(type.equals("bash"))
        {
            this.type = 1;
        }
        else if (type.equals("pierce"))
        {
            this.type = 2;
        }
        else if (type.equals("fire"))
        {
            this.type = 3;
        }
        else if (type.equals("slash"))
        {
            this.type = 4;
        }
    }
    public Attack(String name, int drain, int damage, int stat, int type, int bonusType) {
        this.name = name;
        this.drain = drain;
        this.damage = damage;
        this.stat = stat;
        this.type = type;
        this.bonusType = bonusType;
    }

    public Attack(String name, int drain, int damage, String stat, String type, int bonusType) {
        this.name = name;
        this.drain = drain;
        this.damage = damage;
        this.bonusType = bonusType;
        if(stat.equals("str"))
        {
            this.stat = 0;
        }
        else if(stat.equals("agi"))
        {
            this.stat = 1;
        }
        else if(stat.equals("int"))
        {
            this.stat = 2;
        }

        if(type.equals("bash"))
        {
            this.type = 1;
        }
        else if (type.equals("pierce"))
        {
            this.type = 2;
        }
        else if (type.equals("fire"))
        {
            this.type = 3;
        }
        else if (type.equals("slash"))
        {
            this.type = 4;
        }
    }

}
