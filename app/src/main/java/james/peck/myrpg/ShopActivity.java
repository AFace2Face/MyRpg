package james.peck.myrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static james.peck.myrpg.Creature.Player;
import static james.peck.myrpg.ItemLexicon.armorShopCatalog;

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
        }
    }

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

    private void initRecyclerView(ArrayList displayList) {
        RecyclerView shopList = findViewById(R.id.ShopView);
        ShopRecyclerViewAdapter adapter = new ShopRecyclerViewAdapter(this, displayList);
        shopList.setAdapter(adapter);
        shopList.setLayoutManager(new LinearLayoutManager(this));
    }
}
