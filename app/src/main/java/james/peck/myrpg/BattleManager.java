package james.peck.myrpg;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static james.peck.myrpg.Attack.AttackList;
import static james.peck.myrpg.Creature.CreatureList;
import static james.peck.myrpg.Defense.DefenseList;

/**
 * Created by James on 4/14/2018.
 */

public class BattleManager {

    private View ScreenView;
    private Context CurrentContext;
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
    public Creature Player;


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
        battleLog = ScreenView.findViewById(R.id.battleLog);
        moveList = ScreenView.findViewById(R.id.moveList);
        playerHealth = ScreenView.findViewById(R.id.hp);
        playerEnergy = ScreenView.findViewById(R.id.ep);
        monsterHealth = ScreenView.findViewById(R.id.mhp);
        monsterEnergy = ScreenView.findViewById(R.id.mep);
        Player = new Creature("James", 100, 100, 10, 8, 10, true);
        Player.setArmor(5);
        Player.setWarding(10);
        Creature monster = CreatureList.get("largeFrog").spawnNewCopy();
        Player.knownAttacks.add("maceStrike");
        Player.knownAttacks.add("fireBall");
        Player.knownAttacks.add("Thrust");
        Player.knownAttacks.add("shoot");

        Player.knownDefenses.add("counterSwing");
        Player.knownDefenses.add("simpleWard");
        Player.knownDefenses.add("solidBlock");
        Player.knownDefenses.add("dodgeAttack");

        Player.equipment[0] = "avariceCrown";
        Player.equipment[1] = "runicArmor";
        Player.equipment[2] = "masterStaff";
        Player.findNewStats();

        Player.inventory.add("avariceCrown");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");
        Player.inventory.add("runicArmor");
        Player.inventory.add("runicArmor");
        Player.inventory.add("avariceCrown");


        Monster = monster;

        Fighters.add(Player);
        Fighters.add(Monster);
        CreatureDic myCreatureDic = new CreatureDic();
        presentCreatures = myCreatureDic.PopulateArea(1);

        Button Character = (ScreenView.findViewById(R.id.Character_Button));
        Character.setOnClickListener(new View.OnClickListener() {
        public void onClick (View v)
        {
            Intent intent = new Intent(CurrentContext, CharacterActivity.class);
            SaveLoadPlayer save = new SaveLoadPlayer(Player, CurrentContext);  save.playerSave();
            CurrentContext.startActivity(intent);

        }
    });

        Button inventory = (ScreenView.findViewById(R.id.Return_Button));
        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CurrentContext, InventoryActivity.class);
                SaveLoadPlayer save = new SaveLoadPlayer(Player, CurrentContext); save.playerSave();
                CurrentContext.startActivity(intent);
            }
        });



        NextTurn();
    }

    /**
     * lets the player rest after a victory and then spawns a new creature for them to fight
     */
    private void nextBattle()
    {
        takeRest();
        Monster = CreatureList.get(presentCreatures.get((int) (Math.random()* presentCreatures.size()))).spawnNewCopy();
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
            CurrentAttack = getAttack(Monster.knownAttacks.get(0));
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
        Player.setEnergy(Player.getEnergy() - (findDamage(CurrentAttack.getDamage(), findStatBonus(Monster, CurrentAttack), findStatBonus(Player, defense), defense.getDrain(), Bonus, Player.getWarding()))/3);
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
        Monster.setEnergy(Monster.getEnergy() - (findDamage(attack.getDamage(), findStatBonus(Player, attack), findStatBonus(Monster, CurrentDefense), CurrentDefense.getDrain(), Bonus, Monster.getWarding()))/3);
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


                final Button button = new Button(CurrentContext);
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

                final Button button = new Button(CurrentContext);
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
