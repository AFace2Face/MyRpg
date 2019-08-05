package james.peck.myrpg;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static james.peck.myrpg.Attack.AttackList;
import static james.peck.myrpg.Creature.CreatureList;
import static james.peck.myrpg.Creature.Player;
import static james.peck.myrpg.Defense.DefenseList;

/**
 * Created by James on 4/14/2018.
 */

public class BattleActivity extends AppCompatActivity {

    private View ScreenView;
    private ArrayList<Button> SkillButtons = new ArrayList<>();
    private TextView battleLog;
    private Creature Monster;
    final ArrayList<Creature> Fighters = new ArrayList<>();
    private GridLayout moveList;
    private Attack CurrentAttack;
    private Defense CurrentDefense;
    private TextView playerHealth;
    private TextView playerEnergy;
    private TextView monsterHealth;
    private TextView monsterEnergy;
    private ArrayList<String> presentCreatures = new ArrayList<>();



    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        ScreenView = findViewById(android.R.id.content);

        battleLog = ScreenView.findViewById(R.id.battleLog);
        moveList = ScreenView.findViewById(R.id.moveList);
        playerHealth = ScreenView.findViewById(R.id.hp);
        playerEnergy = ScreenView.findViewById(R.id.ep);
        monsterHealth = ScreenView.findViewById(R.id.mhp);
        monsterEnergy = ScreenView.findViewById(R.id.mep);

        Button Character = (ScreenView.findViewById(R.id.Character_Button));
        Character.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v)
            {
                Intent intent = new Intent(getBaseContext(), CharacterActivity.class);
                SaveLoadPlayer save = new SaveLoadPlayer(Player, getBaseContext());  save.playerSave();
                getBaseContext().startActivity(intent);

            }
        });

        Button inventory = (ScreenView.findViewById(R.id.Return_Button));
        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), InventoryActivity.class);
                SaveLoadPlayer save = new SaveLoadPlayer(Player, getBaseContext()); save.playerSave();
                getBaseContext().startActivity(intent);
            }
        });

        Button retreat = (ScreenView.findViewById(R.id.retreat_button));
        retreat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        BattleStart();
    }

    @Override
    public void onBackPressed() {
        // Disable back button in the battle screen adding retreat confirm later
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
        CreatureDic myCreatureDic = new CreatureDic();
        presentCreatures = myCreatureDic.PopulateArea(1);

        SaveLoadPlayer save = new SaveLoadPlayer(Player, getBaseContext());  save.playerSave();
        Monster = CreatureList.get(presentCreatures.get(0)).spawnNewCopy();

        Fighters.add(Player);
        Fighters.add(Monster);
        nextBattle();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * lets the player rest after a victory and then spawns a new creature for them to fight
     */
    private void nextBattle()
    {
        takeRest();
        Monster = CreatureList.get(presentCreatures.get((int) (Math.random()* presentCreatures.size()))).spawnNewCopy();
        battleLog.setText(Monster.getEncounter());
        Creature p = Fighters.get(0);

        for(int i = 0; i < Fighters.size(); i++)
        {
            p = Fighters.get(i);
            p.setTurnProgress(0);
            updateLifeForce();
        }
         NextTurn();
    }

    /**
     * Heals the player between fights based on their strength
     */
    private void takeRest()
    {
        Player.setHealth(Player.getHealth() + (Player.getStrength()/2));
        Player.setEnergy(Player.getEnergy() + (Player.getStrength()));
        if(Player.getHealth() > Player.getMHP())
        {
            Player.setHealth(Player.getMHP());
        }
        if(Player.getEnergy() > Player.getMEP())
        {
            Player.setEnergy(Player.getMEP());
        }
    }

    /**
     * prompts player to choose an attack skill
     */
    private void PlayerTurn()
    {
        if(stillFighting() == 0)
        {
            makeButtons(Player.knownAttacks, true);
        }
        else if(stillFighting() == 1)
        {
            nextBattle();
        }
    }

    /**
     * Decides on the enemies attack, and prompts player to defend
     */
    private void MonsterTurn()
    {
        if(stillFighting() == 0)
        {
            CurrentAttack = getAttack(Monster.chooseAttack());
            makeButtons(Player.knownDefenses, false);
        }
        else if(stillFighting() == 1)
        {
            nextBattle();
        }
    }

    /**
     * decides what defense the enemy will use
     */
    private void pickEnemyDefense()
    {
        CurrentDefense =  getDefense(Monster.knownDefenses.get(0));
    }

    /**
     * resolves damage the player takes and updates displayed values
     * @param defense  Defense player has selected
     */
    private void playerDefense(Defense defense)
    {
        if (defense.getBonusType() == 0)
        {
        int health = Player.getHealth();
        float Bonus = findTypeBonus(CurrentAttack, defense);
        if(CurrentAttack.getDrain()-(Monster.getIntuition()) > CurrentAttack.getDrain()/4)
        {
            Monster.setEnergy(Monster.getEnergy() - ((CurrentAttack.getDrain())-Monster.getIntuition()));
        }
        else
        {
            Monster.setEnergy(Monster.getEnergy() - (CurrentAttack.getDrain())/4);
        }
        Player.setHealth(Player.getHealth() - findDamage(CurrentAttack.getDamage(), findStatBonus(Monster, CurrentAttack), findStatBonus(Player, defense), defense.getImpairment(), Bonus, Player.getArmor()));
        Player.setEnergy(Player.getEnergy() - (findDamage(CurrentAttack.getDamage(), findStatBonus(Monster, CurrentAttack), findStatBonus(Player, defense), defense.getDrain(), Bonus, Player.getWarding()))); // maybe divide warding by 1/3
        battleLog.setText //(battlelog.getText()+ "\n" +
                (Player.getName() + " Took " + (health - Player.getHealth()));
        updateLifeForce();
        unmakeButtons();
        NextTurn();}
        else if (defense.getBonusType() == 1)
        {
           int i = Player.getEnergy();
            if (Player.getAgility() - Monster.getAgility() >= 0)
            {
                Player.setEnergy(i-10);
            }
            else
            {
                Player.setEnergy(i-(5 * (Monster.getAgility() - Player.getAgility())));
            }
            if(CurrentAttack.getDrain()-(Monster.getIntuition()) > CurrentAttack.getDrain()/4)
            {
                Monster.setEnergy(Monster.getEnergy() - ((CurrentAttack.getDrain())-Monster.getIntuition()));
            }
            else
            {
                Monster.setEnergy(Monster.getEnergy() - (CurrentAttack.getDrain())/4);
            }
            updateLifeForce();
            unmakeButtons();
            NextTurn();
        }
    }

    /**
     * Resolves the damage player deals, and updates values
     * @param attack attack player has selected
     */
    private void playerAttack(Attack attack)
    {
        pickEnemyDefense();
        int health = Monster.getHealth();
        float Bonus = findTypeBonus(attack, CurrentDefense);
        if(attack.getDrain()-(Player.getIntuition()) > attack.getDrain()/5)
        {
            Player.setEnergy(Player.getEnergy() - ((attack.getDrain())-Player.getIntuition()));
        }
        else
        {
            Player.setEnergy(Player.getEnergy() - (attack.getDrain())/5);
        }
        Monster.setHealth(Monster.getHealth() - findDamage(attack.getDamage(), findStatBonus(Player, attack), findStatBonus(Monster, CurrentDefense), CurrentDefense.getImpairment(), Bonus, Monster.getArmor()));
        Monster.setEnergy(Monster.getEnergy() - (findDamage(attack.getDamage(), findStatBonus(Player, attack), findStatBonus(Monster, CurrentDefense), CurrentDefense.getDrain(), Bonus, Monster.getWarding())));  //  maybe divide warding by 1/3
        battleLog.setText //(battlelog.getText()+ "\n" +
                (Monster.getName() + " Took " + (health - Monster.getHealth()));
        updateLifeForce();
        unmakeButtons();
        NextTurn();

    }

    /**
     *  Updates the displayed values for Health and Energy for both combatants
     */
    private void updateLifeForce()
    {
        playerHealth.setText(Player.getHealth() + "/" + Player.getMHP() + " HP");
        playerEnergy.setText("EP " + Player.getEnergy() + "/" + Player.getMEP());
        monsterHealth.setText(Monster.getHealth() + "/" + Monster.getMHP() + " HP");
        monsterEnergy.setText("EP " + Monster.getEnergy() + "/" + Monster.getMEP());
    }

    /**
     * Checks the health of every thing fighting to see if the fight should continue
     * @return returns a value based on if someone dies or they are all still alive
     */
    private int stillFighting()
    {
        if(Player.getHealth() <= 0)
        {
            battleLog.setText("You are dead");
            return 2;
        }
        if(Player.getEnergy() <= 0)
        {
            if (Player.getEnergy() < Monster.getEnergy()){
            battleLog.setText("You blackout and are killed");
            return 2; }
        }
        if(Monster.getHealth() <= 0)
        {
            battleLog.setText("You kill your target");
            return 1;
        }
        if(Monster.getEnergy() <= 0)
        {
            battleLog.setText("Your target falls unconscious");
            return 1;
        }
        return 0;
    }

    /**
     * Takes a string and finds the attack with the same name
     * @param attack name of attack
     * @return attack object
     */
    private Attack getAttack(String attack)
    {
        return AttackList.get(attack);
    }

    /**
     * Takes a string and finds the defense with the same name
     * @param defense  Name of defense
     * @return  defense object
     */
    private Defense getDefense(String defense)
    {
        return DefenseList.get(defense);
    }

    /**
     * takes the attack and defense type, and decides if their is a damage bonus
     * @param attack attacking skill
     * @param defense defending skill
     * @return The multiplier found
     */
    private float findTypeBonus(Attack attack, Defense defense)
    {
        float bonus = 1;
        if(attack.getType() == 0 || defense.getType() == 0)
        {
            bonus = 2;
        }
        else if(attack.getType() == defense.getType())
        {
            bonus = 4;
        }
        return bonus;
    }

    /**
     * finds the value for the skills associated stat
     * @param creature creature using the skill
     * @param skill skill being used
     * @return value to be used with the skill
     */
    private int findStatBonus(Creature creature, Skill skill)
    {
        if(skill.getStat() == 0)
        {
            return creature.getStrength();
        }
        else if(skill.getStat() == 1)
        {
            return  creature.getAgility();
        }
        else if(skill.getStat() == 2)
        {
            return  creature.getIntuition();
        }
        else
        {
            return 0;
        }
    }

    /**
     * finds the damage done based on all variables involved
     * @param attack skills base damage
     * @param attackStat  value of attackers stat that the attack skill uses
     * @param defenseStat value of defenders stat that the defense skill uses
     * @param splitPercent amount of damage taken based on defense skill split for health/energy
     * @param bonus attack/defense type bonus
     * @return final damage dealt
     */
    private int findDamage(int attack, int attackStat, int defenseStat, float splitPercent, float bonus, int flatReduction)
    {
        int damage = (int) ((((attack + ((attack/4) * attackStat)) - ((attack/5) * defenseStat)) * bonus * (splitPercent/100))) - flatReduction;
        if (damage > 0)
        {
            return damage;
        }
        else
        {
            return  0;
        }
    }

    /**
     * removes all buttons from onscreen
     */
    private void unmakeButtons()
    {
        moveList.removeAllViews();
        SkillButtons.clear();
    }

    /**
     * given a list of skills draws button and call a method depending on weather it's an attack or defense
     * @param currentList list of skills
     * @param isAttack whether given skills are an attack or defense
     */
    private void makeButtons(ArrayList currentList, Boolean isAttack)
    {
        if(isAttack) {
            for (int i = 0; i < currentList.size(); i++) {


                final Button button = new Button(getBaseContext());
                button.setText((String) currentList.get(i));
                button.setTextColor(Color.parseColor("#FFFFFF"));
                button.setTextSize(11);
                if((getAttack((button.getText().toString()))).getStat() == 0)
                { button.setBackground(button.getContext().getResources().getDrawable(R.drawable.strength_border));}
                else if((getAttack((button.getText().toString()))).getStat() == 1)
                {button.setBackground((button.getContext().getResources().getDrawable((R.drawable.agility_border))));}
                else if ((getAttack((button.getText().toString()))).getStat() == 2)
                { button.setBackground((button.getContext().getResources().getDrawable(R.drawable.intution_border)));}
                SkillButtons.add(button);
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
        else
        {
            for (int i = 0; i < currentList.size(); i++) {

                final Button button = new Button(getBaseContext());
                button.setWidth((ScreenView.getWidth()/4));
                button.setText((String) currentList.get(i));
                button.setTextColor(Color.parseColor("#FFFFFF"));
                button.setTextSize(11);
                if((getDefense((button.getText().toString()))).getStat() == 0)
                { button.setBackground(button.getContext().getResources().getDrawable(R.drawable.strength_border));}
                else if((getDefense((button.getText().toString()))).getStat() == 1)
                {button.setBackground((button.getContext().getResources().getDrawable((R.drawable.agility_border))));}
                else if ((getDefense((button.getText().toString()))).getStat() == 2)
                { button.setBackground((button.getContext().getResources().getDrawable(R.drawable.intution_border)));}
                SkillButtons.add(button);
                moveList.addView(button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playerDefense(getDefense(button.getText().toString()));
                    }
                });


            }
        }


    }



}
