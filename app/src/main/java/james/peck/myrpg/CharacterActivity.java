package james.peck.myrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
}
