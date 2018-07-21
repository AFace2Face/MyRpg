package james.peck.myrpg;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static james.peck.myrpg.Attack.AttackList;
import static james.peck.myrpg.Creature.Player;

/**
 * Created by James on 4/14/2018.
 */

public class BattleManager {

    private View ScreenView;
    private Context CurrentContext;
    private ArrayList<Button> Skillbuttons = new ArrayList<>();
    private TextView battlelog;
    private Creature Monster;
    final ArrayList<Creature> Fighters = new ArrayList<>();
    private GridLayout moveList;


    public BattleManager(View screenView, Context currentContext)
    {
        ScreenView = screenView;
        CurrentContext = currentContext;
    }

    /**
     *
     * @param
     * @
     * looks at the list of current fighters and returns the next fighter to reach the turn progress goal (100) Then has the fighter takes its turn
     */
    private void NextTurn()
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

       if(p.getIsPlayer())
       {
           PlayerTurn();
       }
       else
       {
           MonsterTurn();
       }
    }

    public void BattleStart()
    {
        battlelog = ScreenView.findViewById(R.id.battleLog);
        moveList = ScreenView.findViewById(R.id.moveList);
        Player = new Creature("James", 100, 100, 10, 8, 10, true);
        Creature monster = new Creature("Ratman", 200, 50, 15, 5, 2);
        Player.knownAttacks.add("maceStrike");
        monster.knownAttacks.add("blowDart");
        Monster = monster;

        Fighters.add(Player);
        Fighters.add(Monster);


        NextTurn();
    }

    private void PlayerTurn()
    {
        makeButtons(Player.knownAttacks);
    }

    private void MonsterTurn()
    {
        enemyAttack();
        NextTurn();
    }
    private void enemyAttack()
    {
        Player.setHealth(Player.getHealth() - getAttack(Monster.knownAttacks.get(0)).getDamage());
        battlelog.setText(battlelog.getText()+ "\n" + Player.getName() + " health is now " + Player.getHealth());
    }

    private void playerAttack(Attack attack)
    {
        Monster.setHealth(Monster.getHealth()-attack.getDamage());
        battlelog.setText(battlelog.getText()+ "\n" + Monster.getName() + " health is now " + Monster.getHealth());
        unmakeButtons();
        NextTurn();

    }


    private Attack getAttack(String attack)
    {
        return AttackList.get(attack);
    }

    private void unmakeButtons()
    {
        moveList.removeAllViews();
        Skillbuttons.clear();
    }

    private void makeButtons(ArrayList currentList)
    {

     //moveList.addView(button);
     //button.getLayoutParams().width =(int) (0);

     for(int i = 0; i <  currentList.size(); i++)
        {


                final Button button = new Button(CurrentContext);
                button.setText((String) currentList.get(i));
                Skillbuttons.add(button);
                //optional: add your buttons to any layout if you want to see them in your screen
                moveList.addView(button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playerAttack(getAttack(button.getText().toString()));
                    }
                });



        }


    }



}
