package james.peck.myrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          View ScreenView = this.findViewById(android.R.id.content);

        BattleManager Combat = new BattleManager(ScreenView);
        Combat.MockFight();
    }
}
