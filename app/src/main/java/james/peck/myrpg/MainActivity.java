package james.peck.myrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          View ScreenView = this.findViewById(android.R.id.content);
          Button Character = (findViewById(R.id.Character_Button));
          Character.setOnClickListener(new View.OnClickListener() {
              public void onClick (View v)
              {
                  Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
                  startActivity(intent);
              }
          });

        BattleManager Combat = new BattleManager(ScreenView, getBaseContext());
        AttackBuilder Attacks = new AttackBuilder();   Attacks.BuildList();
        CreatureDic Creatures = new CreatureDic(); Creatures.BuildDic();
        Combat.BattleStart();
    }
}
