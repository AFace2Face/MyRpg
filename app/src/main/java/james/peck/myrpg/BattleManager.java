package james.peck.myrpg;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by James on 4/14/2018.
 */

public class BattleManager {

    private View ScreenView;

    public BattleManager(View screenView)
    {
        ScreenView = screenView;
    }

    /**
     *
     * @param Fighters
     * @return
     * Takes a list of the current fighters and returns the next fighter to reach the turn progress goal (100)
     */
    public Creature NextTurn(ArrayList<Creature> Fighters)
    {
       Creature  p = Fighters.get(0);
       for (int i = 0; i < Fighters.size(); i++)
       {
           if (p.getTurnProgress() < Fighters.get(i).getTurnProgress())
           {
               p = Fighters.get(i);

           }
       }
       while (p.getTurnProgress() < 100) {
           for (int i = 0; i < Fighters.size(); i++)
           {
               Fighters.get(i).setTurnProgress(Fighters.get(i).getAgility()+Fighters.get(i).getTurnProgress());
               if (p.getTurnProgress() < Fighters.get(i).getTurnProgress())
               {
                   p = Fighters.get(i);
               }
           }
       }
       p.setTurnProgress(p.getTurnProgress()-100);
       return p;
    }

    public void MockFight()
    {
        Creature Player = new Creature("James", 100, 100, 10, 8, 10);
        Creature Monster = new Creature("Ratman" ,200, 50, 15, 5, 2);
        final ArrayList<Creature> Fighters = new ArrayList<>();
        Fighters.add(Player);
        Fighters.add(Monster);
        final TextView battlelog =  ScreenView.findViewById(R.id.battleLog);

        Button nextClick = ScreenView.findViewById(R.id.nextPerson);
        nextClick.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Creature nextFighter = NextTurn(Fighters);
                battlelog.setText("next turn is " + nextFighter.getName());
            }
        });



    }
}
