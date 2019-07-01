package james.peck.myrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

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

    }

    private void InitRecyclerView() {
        RecyclerView inventoryList = findViewById(R.id.itemView);
        InventoryRecyclerViewAdapter adapter = new InventoryRecyclerViewAdapter(this);
        inventoryList.setAdapter(adapter);
        inventoryList.setLayoutManager(new LinearLayoutManager(this));

    }

}
