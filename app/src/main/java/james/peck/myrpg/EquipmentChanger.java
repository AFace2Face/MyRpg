package james.peck.myrpg;

import android.content.Context;

import james.peck.myrpg.Items.Body;
import james.peck.myrpg.Items.Helmet;

import static james.peck.myrpg.Items.Equipment.gearList;

public class EquipmentChanger {

    Creature Player;
    SaveLoadPlayer saveLoadPlayer;

    public EquipmentChanger(Context context) {
        saveLoadPlayer = new SaveLoadPlayer(context);
        Player = saveLoadPlayer.playerLoad();
    }

    public void changeWeapon(int position) {
        String oldWeapon = Player.equipment[2];
        Player.equipment[2] = Player.inventory.get(position);
        Player.inventory.set(position, oldWeapon);
        saveLoadPlayer.playerSave(Player);
    }

    public void changeArmor(int position) {
        if (gearList.get(Player.inventory.get(position)) instanceof Body)
        {
            String oldBody = Player.equipment[1];
            Player.equipment[1] = Player.inventory.get(position);
            Player.inventory.set(position, oldBody);
            saveLoadPlayer.playerSave(Player);
        }
        else if(gearList.get(Player.inventory.get(position)) instanceof Helmet)
        {
            String oldHelmet = Player.equipment[0];
            Player.equipment[0] = Player.inventory.get(position);
            Player.inventory.set(position, oldHelmet);
            saveLoadPlayer.playerSave();
        }
    }
}
