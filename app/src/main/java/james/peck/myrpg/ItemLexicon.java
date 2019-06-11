package james.peck.myrpg;

import james.peck.myrpg.Items.Body;
import james.peck.myrpg.Items.Helmet;
import james.peck.myrpg.Items.Weapon;

import static james.peck.myrpg.Items.Equipment.gearList;

public class ItemLexicon {

    public void fillLexicon()
    {
        Weapon masterStaff = new Weapon("Master's Staff", 1000, 5, 2, 45);
        gearList.put("masterStaff", masterStaff);

        Body runicArmor = new Body("Runic Armor", 2500, 30, 70);
        gearList.put("runicArmor", runicArmor);

        Helmet avariceCrown = new Helmet("Crown of Avarice", 50000, 0, 100);
        gearList.put("avariceCrown", avariceCrown);
    }
}
