package james.peck.myrpg.Items;

import static james.peck.myrpg.Items.Equipment.gearList;

public class ItemLexicon {

    public void fillLexicon()
    {
        Weapon masterStaff = new Weapon("Master's Staff", 1000, 5, 2, 45);
        gearList.put("masterStaff", masterStaff);

        Body runicArmor = new Body("Runic Armor", 2500, 30, 70);
        gearList.put("runicArmor", runicArmor);

        Helment avariceCrown = new Helment("Crown of Avarice", 50000, 0, 100);
        gearList.put("avariceCrown", avariceCrown);
    }
}
