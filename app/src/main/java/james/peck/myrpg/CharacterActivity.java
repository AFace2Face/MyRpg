package james.peck.myrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



import james.peck.myrpg.Items.Armor;
import james.peck.myrpg.Items.Weapon;

import static james.peck.myrpg.Items.Equipment.gearList;


public class CharacterActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        Button Character = (findViewById(R.id.Return_Button));
        Character.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v)
            {
                finish();
            }
        });
        SaveLoadPlayer load = new SaveLoadPlayer(getBaseContext());
        Creature Player = load.playerLoad();
        View screenView = this.findViewById(android.R.id.content);
        TextView nameDisplay = screenView.findViewById(R.id.name_display);
        TextView goldDisplay = findViewById(R.id.gold_display);
        TextView levelDisplay = findViewById(R.id.level_display);
        TextView hpDisplay = findViewById(R.id.hp_display);
        TextView energyDisplay = findViewById(R.id.energy_display);
        TextView strengthDisplay = findViewById(R.id.strength_display);
        TextView agilityDisplay = findViewById(R.id.agility_display);
        TextView intuitionDisplay = findViewById(R.id.intuition_display);
        TextView armorDisplay = findViewById(R.id.armor_display);
        TextView wardingDisplay = findViewById(R.id.warding_display);
        TextView headName = findViewById(R.id.head_armor_name);
        TextView headStats = findViewById(R.id.head_armor_stats);
        TextView bodyName = findViewById(R.id.body_armor_name);
        TextView bodyStats = findViewById(R.id.body_armor_stats);
        TextView weaponName = findViewById(R.id.weapon_name);
        TextView weaponStats = findViewById(R.id.weapon_stats);

        Player.findNewStats();

        nameDisplay.setText(Player.getName());
        goldDisplay.setText(Player.getGold() + " Gold");
        levelDisplay.setText("Level " +Player.getLevel());
        hpDisplay.setText(Player.getHealth() + "/" + Player.getMHP() + " HP" );
        energyDisplay.setText(Player.getEnergy() + "/" + Player.getMEP() + " Energy");
        strengthDisplay.setText(Player.getBaseStrength() + " + " + Player.getExtraStrength() + " Strength");
        agilityDisplay.setText(Player.getAgility() + " Agility");
        intuitionDisplay.setText(Player.getIntuition() + " Intuition");
        armorDisplay.setText(Player.getArmor() + " Armor");
        wardingDisplay.setText(Player.getWarding() + " Warding");
        headName.setText(findArmor(Player.equipment[0]).getName());
        headStats.setText(findArmor(Player.equipment[0]).getDefense() + " Armor " + findArmor(Player.equipment[0]).getWarding() + " Warding");
        bodyName.setText(findArmor(Player.equipment[1]).getName());
        bodyStats.setText(findArmor(Player.equipment[1]).getDefense() + " Armor " + findArmor(Player.equipment[1]).getWarding() + " Warding");
        weaponName.setText(findWeapon(Player.equipment[2]).getName());
        weaponStats.setText(findWeapon(Player.equipment[2]).getBonusStrength() + " Str " + findWeapon(Player.equipment[2]).getBonusAgility() + " Agi " + findWeapon(Player.equipment[2]).getBonusIntuition() + " int");



    }

    /**
     * takes a String and find the Armor that has the same internal name
     * @param target pass the internal name of what you want to find
     * @return  the Armor object that has the same internal name
     */
    public Armor findArmor(String target)
    {
        return (Armor)gearList.get(target);
    }

    /**
     * takes a String and find the Weapon that has the same internal name
     * @param target pass the internal name of what you want to find
     * @return  the Weapon object that has the same internal name
     */
    public Weapon findWeapon(String target)
    {
        return (Weapon)gearList.get(target);
    }

}
