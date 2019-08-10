package james.peck.myrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        Button weaponShop = findViewById(R.id.weaponShop);
        weaponShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopActivity.shopNumber = WEAPON;
                Intent intent = new Intent(getBaseContext(), ShopActivity.class);
                getBaseContext().startActivity(intent);
            }
        });

        Button skillShop = findViewById(R.id.Skill_Button);
        skillShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopActivity.shopNumber = SKILLS;
                Intent intent = new Intent(getBaseContext(), ShopActivity.class);
                getBaseContext().startActivity(intent);
            }
        });




        Button dungeonEntrance = findViewById(R.id.dungeonEntrance);
        dungeonEntrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), BattleActivity.class);
                getBaseContext().startActivity(intent);
            }
        });

        Button characterButton = findViewById(R.id.Character_Button);
        characterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), CharacterActivity.class);
                getBaseContext().startActivity(intent);
            }
        });

        Button inventoryButton = findViewById(R.id.Inventory_Button);
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), InventoryActivity.class);
                getBaseContext().startActivity(intent);
            }
        });
    }




}