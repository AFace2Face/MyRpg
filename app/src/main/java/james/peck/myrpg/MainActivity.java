package james.peck.myrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AttackBuilder Attacks = new AttackBuilder();   Attacks.BuildList();
        CreatureDic Creatures = new CreatureDic(); Creatures.BuildDic(); Creatures.makePlayer(getBaseContext());
        ItemLexicon items = new ItemLexicon(); items.fillLexicon();



        Intent intent = new Intent(getBaseContext(), BattleActivity.class);
        getBaseContext().startActivity(intent);

    }


}
