package james.peck.myrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import james.peck.myrpg.Items.Item;

import static james.peck.myrpg.Items.Equipment.gearList;

public class InventoryActivity extends AppCompatActivity {

    private ArrayList<String> itemNameList = new ArrayList<>();
    private ArrayList<String> itemTextList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        Button inventory = (findViewById(R.id.Return_Button));
        inventory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        SaveLoadPlayer load = new SaveLoadPlayer(getBaseContext());
        Creature Player = load.playerLoad();


        for (int i = 0; i < Player.inventory.size(); i++) {
            String Item = gearList.get(Player.inventory.get(i)).getName();
            itemNameList.add(Item);
            String description = gearList.get(Player.inventory.get(i)).getDescription() + " ";
            itemTextList.add(description);
        }

        InitRecyclerView();

    }
        private void InitRecyclerView()
        {
            RecyclerView inventoryList = findViewById(R.id.itemView);
            InventoryRecyclerViewAdapter adapter = new InventoryRecyclerViewAdapter(this, itemNameList, itemTextList);
            inventoryList.setAdapter(adapter);
            inventoryList.setLayoutManager(new LinearLayoutManager(this));
        }

}
