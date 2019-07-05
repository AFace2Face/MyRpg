package james.peck.myrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static james.peck.myrpg.Creature.Player;

public class InventoryActivity extends AppCompatActivity {


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


        InitRecyclerView();
        TextView gold = (findViewById(R.id.inventorygold));
        gold.setText("Gold: " + Player.getGold());

        Button character = findViewById(R.id.Character_Button);
        character.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), CharacterActivity.class);
                getBaseContext().startActivity(intent);
                finish();
            }
        });

    }

    private void InitRecyclerView() {
        RecyclerView inventoryList = findViewById(R.id.itemView);
        InventoryRecyclerViewAdapter adapter = new InventoryRecyclerViewAdapter(this);
        inventoryList.setAdapter(adapter);
        inventoryList.setLayoutManager(new LinearLayoutManager(this));

    }

}
