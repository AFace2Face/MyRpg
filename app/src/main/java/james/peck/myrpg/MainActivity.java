package james.peck.myrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import  static james.peck.myrpg.Creature.Player;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SaveLoadPlayer load = new SaveLoadPlayer(getBaseContext());
        Player = load.playerLoad();

        AttackBuilder Attacks = new AttackBuilder();   Attacks.BuildList();
        CreatureDic Creatures = new CreatureDic(); Creatures.BuildDic(); Creatures.makePlayer(getBaseContext());
        ItemLexicon items = new ItemLexicon(); items.fillLexicon();

        Button loadGame = findViewById(R.id.load_game);
        loadGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), BattleActivity.class);
                getBaseContext().startActivity(intent);
            }
        });

        Button newGame = findViewById(R.id.new_game);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewCharacter();
            }
        });




    }

    public void createNewCharacter()
    {
        Player = new Creature("Name", 100, 100, 10, 10, 10, true);
        Player.equipment[0] ="hardhat";
        Player.equipment[1] ="clothshirt";
        Player.equipment[2] ="longstick";
        Player.knownAttacks.add("smack");
        Player.knownDefenses.add("recoil");
        Intent intent = new Intent(getBaseContext(), BattleActivity.class);
        getBaseContext().startActivity(intent);
    }


}
