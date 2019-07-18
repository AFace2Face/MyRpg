package james.peck.myrpg;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import  static james.peck.myrpg.Creature.Player;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SaveLoadPlayer load = new SaveLoadPlayer(getBaseContext());
        Player = load.playerLoad();

        AttackBuilder Attacks = new AttackBuilder();   Attacks.BuildList();
        CreatureDic Creatures = new CreatureDic(); Creatures.BuildDic();
        ItemLexicon items = new ItemLexicon(); items.fillLexicon();

        Button loadGame = findViewById(R.id.load_game);

        if (Player != null) loadGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), TownActivity.class);
                getBaseContext().startActivity(intent);
            }
        });
        else {
            loadGame.setClickable(false);
        }

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

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Name");

// Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);


// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {



                Player = new Creature(input.getText().toString(), 100, 100, 10, 10, 10, true);
                Player.equipment[0] ="hardhat";
                Player.equipment[1] ="tatteredshirt";
                Player.equipment[2] ="longstick";
                Player.knownAttacks.add("smack");
                Player.knownDefenses.add("recoil");
                Player.findNewStats();
                Player.setLevel(1);
                Intent intent = new Intent(getBaseContext(), TownActivity.class);
                getBaseContext().startActivity(intent);



                Player.setGold(1000);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }


}
