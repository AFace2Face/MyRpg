package james.peck.myrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import james.peck.myrpg.Items.Body;

public class TownActivity extends AppCompatActivity {

    private final int ARMOR = 0, WEAPON = 1, ITEMS = 2, SKILLS = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_town);



        Button armorShop = findViewById(R.id.armorShop);
        armorShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopActivity.shopNumber = ARMOR;
                Intent intent = new Intent(getBaseContext(), ShopActivity.class);
                getBaseContext().startActivity(intent);
            }
        });
    }




}