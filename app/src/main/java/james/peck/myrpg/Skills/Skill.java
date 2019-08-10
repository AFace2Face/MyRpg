package james.peck.myrpg.Skills;

import java.util.ArrayList;

/**
 * Created by James on 12/4/2018.
 */

public class Skill {

    public String getName() {
        return name;
    }

    public boolean isNeedMelee() {
        return needMelee;
    }

    public boolean isNeedRanged() {
        return needRanged;
    }

    public boolean isNeedMagic() {
        return needMagic;
    }

    public boolean isNeedSlash() {
        return needSlash;
    }

    public boolean isNeedThrust() {
        return needThrust;
    }

    public boolean isNeedChop() {
        return needChop;
    }

    public boolean isNeedBash() {
        return needBash;
    }

    public boolean isNeedPolearm() {
        return needPolearm;
    }

    public boolean isNeedShort() {
        return needShort;
    }

    public boolean isNeedBow() {
        return needBow;
    }

    public boolean isNeedCrossbow() {
        return needCrossbow;
    }

    protected String name;
    protected int stat;


    protected boolean needMelee;
    protected boolean needRanged;
    protected boolean needMagic;
    protected boolean needSlash;
    protected boolean needThrust;
    protected boolean needChop;
    protected boolean needBash;
    protected boolean needPolearm;
    protected boolean needShort;
    protected boolean needBow;
    protected boolean needCrossbow;

    public ArrayList<String> required = new ArrayList<>(3);

    public int getStat() {
        return stat;
    }


}
