package james.peck.myrpg;

import java.util.ArrayList;

import james.peck.myrpg.Items.Body;
import james.peck.myrpg.Items.Helmet;
import james.peck.myrpg.Items.Weapon;

import static james.peck.myrpg.Items.Equipment.gearList;

public class ItemLexicon {

    public static ArrayList<ArrayList<String>> armorShopCatalog = new ArrayList<>(2);

    public void fillLexicon()
    {

        // Tier 0 (starter) armor below
        Helmet hardHat = new Helmet("Hard hat", "A solid hat that you found laying in the street", 2, 2, 1);
        gearList.put("hardhat", hardHat);

        Body tatteredShirt = new Body("Tattered clothes", " tattered clothes you were wearing when you started your adventures", 3, 1, 3);
        gearList.put("tatteredshirt", tatteredShirt);

        Weapon longStick = new Weapon("Longstick", "a sturdy stick as just longer then your arm", 1, 1, 1, 1);
        gearList.put("longstick", longStick);


        // Tier 1 armor below light/medium/heavy
        Helmet clothHat = new Helmet("Cloth hat", "A hat made out of cloth, doesn't offer much protection but won't get in your way defend yourself", 20, 1, 5);
        gearList.put("clothhat", clothHat);

        Body clothOutfit = new Body("Cloth outfit", "Simple cloth clothing not great at protecting you, but it is very easy to move in, making defending yourself less tiresome", 50, 2, 6);
        gearList.put("clothoutfit", clothOutfit);

        Helmet leatherCap = new Helmet("Leather cap", "A durable cap able to protect against the occasional hit without weighing you down much", 20, 2, 4);
        gearList.put("leathercap", leatherCap);

        Body paddedArmor = new Body("Padded armor", "A light gambeson made to both protect against strikes and allow you enough movement to try and defend against them youself", 50, 5,3);
        gearList.put("paddedarmor", paddedArmor);

        Helmet ironHelmet = new Helmet("Iron helmet", "A basic iron helmet to guard your head against many strikes, the weight will slow you down", 20, 4, 2);
        gearList.put("ironhelmet", ironHelmet);

        Body oldLamellar = new Body("Old lamellar", "Used but still intact heavy Lamellar armor, can stop alot of damage but makes defending yourself rather exhausting", 50, 7, 1);
        gearList.put("oldlamellar", oldLamellar);




        Weapon masterStaff = new Weapon("Master's Staff", 1000, 5, 2, 45);
        gearList.put("masterStaff", masterStaff);

        Weapon copperBlade = new Weapon("Copper Blade", 20, 10, 1, 3);
        gearList.put("CopperBlade", copperBlade);

        Body runicArmor = new Body("Runic Armor", 2500, 30, 70);
        gearList.put("runicArmor", runicArmor);

      //  Helmet avariceCrown = new Helmet("Crown of Avarice", 50000, 10, 100);
      //  gearList.put("avariceCrown", avariceCrown);


        makeShopCatalogs();
    }


    private void makeShopCatalogs() {
        ArrayList<String> armorShopZero = new ArrayList<>();
        armorShopZero.add("hardhat");
        armorShopZero.add("tatteredshirt");
        armorShopCatalog.add(0, armorShopZero);


        ArrayList<String> armorShopOne = new ArrayList<>();
        armorShopOne.add("clothhat");
        armorShopOne.add("clothoutfit");
        armorShopOne.add("leathercap");
        armorShopOne.add("paddedarmor");
        armorShopOne.add("ironhelmet");
        armorShopOne.add("oldlamellar");
        armorShopCatalog.add(armorShopOne);
    }
}

