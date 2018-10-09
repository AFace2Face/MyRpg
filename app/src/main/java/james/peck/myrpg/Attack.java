package james.peck.myrpg;

import java.util.HashMap;

/**
 * Created by James on 4/19/2018.
 */

public class Attack {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrain() {
        return drain;
    }

    public void setDrain(int drain) {
        this.drain = drain;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static HashMap<String, Attack> getAttackList() {
        return AttackList;
    }

    public static void setAttackList(HashMap<String, Attack> attackList) {
        AttackList = attackList;
    }

    public String name;
    private int drain;
    private int damage;
    private int type;
    static public HashMap<String, Attack> AttackList = new HashMap<>();

    public Attack(String name, int drain, int damage, int type) {
        this.name = name;
        this.drain = drain;
        this.damage = damage;
        this.type = type;
    }

    public Attack(String name, int drain, int damage, String type) {
        this.name = name;
        this.drain = drain;
        this.damage = damage;
        if(type.equals("Bash"))
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
    }


}
