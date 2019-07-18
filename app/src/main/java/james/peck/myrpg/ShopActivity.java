package james.peck.myrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static james.peck.myrpg.Creature.Player;
import static james.peck.myrpg.ItemLexicon.armorShopCatalog;
import static james.peck.myrpg.ItemLexicon.weaponShopCatalog;

public class ShopActivity extends AppCompatActivity {

    private final int ARMOR = 0, WEAPON = 1, ITEMS = 2, SKILLS = 3;
    public static int shopNumber;
    private ArrayList<String> displayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        switch (shopNumber) {
            case ARMOR:
                fillArmorShop();
                break;
            case WEAPON:
                fillWeaponShop();
                break;
        }
    }

    /**
     * inflates the list of items to buy from the armor shop, as you level up you are able to buy better armor
     */
    private void fillArmorShop() {
        int i = 0;
        ArrayList<String> armorList;
        while (i <= Player.getLevel()) {
            armorList = armorShopCatalog.get(i);
            displayList.addAll(armorList);
            i++;
        }
        initRecyclerView(displayList);
    }

    /**
     * inflates the list of items to buy from the weapon shop, as you level up you are able to buy better weapons
     */
    private void fillWeaponShop() {
        int i = 0;
        ArrayList<String> weaponList;
        while ( i <= Player.getLevel()) {
            weaponList = weaponShopCatalog.get(i);
            displayList.addAll(weaponList);
            i++;
        }
        initRecyclerView(displayList);
    }

    /**
     * creates the list of items that are available to purchase based on the list has been passed
     * @param displayList list of items that are being sold
     */
    private void initRecyclerView(ArrayList displayList) {
        RecyclerView shopList = findViewById(R.id.ShopView);
        ShopRecyclerViewAdapter adapter = new ShopRecyclerViewAdapter(this, displayList);
        shopList.setAdapter(adapter);
        shopList.setLayoutManager(new LinearLayoutManager(this));
    }
}
