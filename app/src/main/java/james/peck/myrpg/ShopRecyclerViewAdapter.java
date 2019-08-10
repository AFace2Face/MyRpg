package james.peck.myrpg;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import james.peck.myrpg.Items.Body;
import james.peck.myrpg.Items.Helmet;
import james.peck.myrpg.Items.Item;
import james.peck.myrpg.Items.Weapon;
import james.peck.myrpg.Skills.Attack;
import james.peck.myrpg.Skills.Defense;
import james.peck.myrpg.Skills.Skill;

import static james.peck.myrpg.Skills.Attack.AttackList;
import static james.peck.myrpg.Creature.Player;
import static james.peck.myrpg.Skills.Defense.DefenseList;
import static james.peck.myrpg.Items.Equipment.gearList;

public class ShopRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<String> displayList;
    private final int HELMET = 0, BODY = 1, WEAPON = 2, ITEM = 3, SKILL =4;
    private EquipmentChanger changer;
    private int expandedPosition = -1;
    private int previousExpandedPosition = -1;


    public ShopRecyclerViewAdapter(Context context, ArrayList<String> displayList) {
        this.context = context;
        changer = new EquipmentChanger(context);
        this.displayList = displayList;
    }

    public Item findItem(String itemName) {
        return gearList.get(itemName);
    }

    public Skill findSkill(String skillName) {
        Skill skill;
        if(AttackList.get(skillName) != null)
            skill = AttackList.get(skillName);
        else
            skill = DefenseList.get(skillName);
        return skill;
    }

    @Override
    public int getItemViewType(int position) {
        //change skill to tree and remove
        if (ShopActivity.shopNumber == 3)
            return SKILL;
        Item item = findItem(displayList.get(position));
        if (item instanceof Helmet) {
            return HELMET;
        } else if (item instanceof Body) {
            return BODY;
        } else if (item instanceof Weapon) {
            return WEAPON;
        } else if (item instanceof Item) {
            return ITEM;
        }
        return -1;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view;
        switch (viewType) {
            //remove after skill tree
            case SKILL:
                view = inflater.inflate(R.layout.layouttownskill, parent, false);
                viewHolder = new TownSkillViewHolder(view);
                break;
            case HELMET:
                view = inflater.inflate(R.layout.layouttownhelmet, parent, false);
                viewHolder = new TownHelmetViewHolder(view);
                break;
            case BODY:
                view = inflater.inflate(R.layout.layouttownbody, parent, false);
                viewHolder = new TownBodyViewHolder(view);
                break;
            case WEAPON:
                view = inflater.inflate(R.layout.layouttownweapon, parent, false);
                viewHolder = new TownWeaponViewHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.layoutinventoryitem, parent, false);
                viewHolder = new TownHelmetViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {

            case SKILL:
                TownSkillViewHolder holder0 = (TownSkillViewHolder) holder;
                configureTownSkillViewHolder(holder0, position);
                break;
            case HELMET:
                TownHelmetViewHolder holder1 = (TownHelmetViewHolder) holder;
                configureTownHelmetViewHolder(holder1, position);
                break;
            case BODY:
                TownBodyViewHolder holder2 = (TownBodyViewHolder) holder;
                configureTownBodyViewHolder(holder2, position);
                break;
            case WEAPON:
                TownWeaponViewHolder holder3 = (TownWeaponViewHolder) holder;
                configureTownWeaponViewHolder(holder3, position);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }

    public void configureTownHelmetViewHolder(final TownHelmetViewHolder holder, final int position) {
        final Helmet head = (Helmet)findItem(displayList.get(position));

        holder.headShopName.setText(head.getName());
        holder.headShopText.setText(head.getDescription());
        holder.headShopValue.setText(head.getValue() + " Gold");
        holder.headShopArmor.setText(head.getDefense() + " Armor");
        holder.headShopWarding.setText(head.getWarding() + " Warding");


        final boolean isExpanded = position == expandedPosition;
        holder.headShopDetails.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.itemView.setActivated(isExpanded);
        if (isExpanded)
            previousExpandedPosition = position;


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });

        /*
         * purchases the item, adding it to the player inventory and removing the cost of the item
         * then collapsed the view and replaces the name with 'purchased' to give some feedback
         */
        holder.headShopBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Player.getGold()>= head.getValue()) {
                    Player.setGold(Player.getGold() - head.getValue());
                    Player.inventory.add(displayList.get(position));
                    expandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
                    holder.headShopDetails.setVisibility(View.GONE);
                    holder.headShopName.setText("Purchased");

                }
            }
        });

    }

    public void configureTownBodyViewHolder(final  TownBodyViewHolder holder, final int position) {
        final Body armor = (Body)findItem(displayList.get(position));

        holder.bodyShopName.setText(armor.getName());
        holder.bodyShopValue.setText(armor.getValue() + " Gold");
        holder.bodyShopText.setText(armor.getDescription());
        holder.bodyShopArmor.setText(armor.getDefense() + " Armor");
        holder.bodyShopWarding.setText(armor.getWarding() + " Warding");


        final boolean isExpanded = position == expandedPosition;
        holder.bodyShopDetails.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.itemView.setActivated(isExpanded);
        if(isExpanded)
            previousExpandedPosition = position;


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });

        /*
         * purchases the item, adding it to the player inventory and removing the cost of the item
         * then collapsed the view and replaces the name with 'purchased' to give some feedback
         */
        holder.bodyShopBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Player.getGold()>= armor.getValue()) {
                    Player.setGold(Player.getGold() - armor.getValue());
                    Player.inventory.add(displayList.get(position));
                    expandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
                    holder.bodyShopDetails.setVisibility(View.GONE);
                    holder.bodyShopName.setText("Purchased");

                }
            }
        });
    }

    public void configureTownWeaponViewHolder(final TownWeaponViewHolder holder, final int position) {
        final Weapon weapon = (Weapon)findItem(displayList.get(position));

        holder.weaponShopName.setText(weapon.getName());
        if (weapon.getValue() > 0)
            holder.weaponShopValue.setText(weapon.getValue() + " Gold");
        else
            holder.weaponShopValue.setText(" ");
        holder.weaponShopText.setText(weapon.getDescription());
        holder.weaponShopStrength.setText(weapon.getBonusStrength() + " Strength");
        holder.weaponShopAgility.setText(weapon.getBonusAgility() + " Agility");
        holder.weaponShopIntuition.setText(weapon.getBonusIntuition() + " Intuition");


        final boolean isExpanded = position == expandedPosition;
        holder.weaponShopDetails.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.itemView.setActivated(isExpanded);
        if(isExpanded)
            previousExpandedPosition = position;


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });

        /*
         * purchases the item, adding it to the player inventory and removing the cost of the item
         * then collapsed the view and replaces the name with 'purchased' to give some feedback
         */
        holder.weaponShopBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Player.getGold()>= weapon.getValue()) {
                    Player.setGold(Player.getGold() - weapon.getValue());
                    Player.inventory.add(displayList.get(position));
                    expandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
                    holder.weaponShopDetails.setVisibility(View.GONE);
                    holder.weaponShopName.setText("Purchased");
                }
            }
        });
    }

    public void configureTownSkillViewHolder(final TownSkillViewHolder holder, final int position) {
        Skill skill = findSkill(displayList.get(position));
  /*      if(skill instanceof Attack)
        for(int i = 0; i < Player.knownAttacks.size(); i++) {
            if (displayList.get(position).equals(Player.knownAttacks.get(i))) {
                holder.skillShopBody.setVisibility(View.GONE);
                break;
            }
        } */
        final boolean isAttack;
        if (skill instanceof Attack)
            isAttack = true;
        else
            isAttack = false;

        holder.skillShopName.setText(skill.getName());
        if (skill.getStat() == 0)
            holder.skillShopStat.setText("Strength");
        else if (skill.getStat() == 1)
            holder.skillShopStat.setText("Agility");
        else if (skill.getStat() == 2)
            holder.skillShopStat.setText("Intuition");
        if (isAttack) {
            holder.skillShopDmg.setText(((Attack) skill).getDamage() + " ");
            holder.skillShopDrain.setText(((Attack) skill).getDrain() + " ");
        } else if (!isAttack)
        {
            holder.skillShopDmg.setText(((Defense) skill).getImpairment() + " ");
            holder.skillShopDrain.setText(((Defense) skill).getDrain() + " ");
        }
        holder.skillShopReq1.setText(skill.required.get(0));
        if(skill.required.size() > 1)
            holder.skillShopReq2.setText(skill.required.get(1));
        else
            holder.skillShopReq2.setText(" ");
        if(skill.required.size() > 2)
            holder.skillShopReq3.setText(skill.required.get(2));
        else
            holder.skillShopReq3.setText(" ");





        final boolean isExpanded = position == expandedPosition;
        holder.skillShopDetails.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.itemView.setActivated(isExpanded);
        if(isExpanded)
            previousExpandedPosition = position;


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });

        holder.skillShopBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAttack) {
                    Player.knownAttacks.add(displayList.get(position));
                    notifyItemChanged(holder.getAdapterPosition());
                }
                else if (!isAttack) {
                    Player.knownDefenses.add(displayList.get(position));
                    notifyItemChanged(holder.getAdapterPosition());
                }

            }
        });
    }


    public class TownHelmetViewHolder extends RecyclerView.ViewHolder {

        TextView headShopName;
        TextView headShopValue;
        TextView headShopText;
        TextView headShopArmor;
        TextView headShopWarding;
        Button headShopCompare;
        Button headShopBuy;
        ConstraintLayout headShopDetails;

        public TownHelmetViewHolder(View itemView) {
            super(itemView);
            headShopName = itemView.findViewById(R.id.headShopName);
            headShopValue = itemView.findViewById(R.id.headShopValue);
            headShopText = itemView.findViewById(R.id.headShopText);
            headShopArmor = itemView.findViewById(R.id.headShopArmor);
            headShopWarding = itemView.findViewById(R.id.headShopWarding);
            headShopCompare = itemView.findViewById(R.id.headShopCompare);
            headShopBuy = itemView.findViewById(R.id.headShopBuy);
            headShopDetails = itemView.findViewById(R.id.headShopDetails);

        }
    }

    public class TownBodyViewHolder extends  RecyclerView.ViewHolder {
        TextView bodyShopName;
        TextView bodyShopValue;
        TextView bodyShopText;
        TextView bodyShopArmor;
        TextView bodyShopWarding;
        Button bodyShopCompare;
        Button bodyShopBuy;
        ConstraintLayout bodyShopDetails;

        public TownBodyViewHolder(View itemView) {
            super(itemView);
            bodyShopName = itemView.findViewById(R.id.bodyShopName);
            bodyShopValue = itemView.findViewById(R.id.bodyShopValue);
            bodyShopText = itemView.findViewById(R.id.bodyShopText);
            bodyShopArmor = itemView.findViewById(R.id.bodyShopArmor);
            bodyShopWarding = itemView.findViewById(R.id.bodyShopWarding);
            bodyShopCompare = itemView.findViewById(R.id.bodyShopCompare);
            bodyShopBuy = itemView.findViewById(R.id.bodyShopBuy);
            bodyShopDetails = itemView.findViewById(R.id.bodyShopDetails);
        }
    }

    public class TownWeaponViewHolder extends RecyclerView.ViewHolder {
        TextView weaponShopName;
        TextView weaponShopValue;
        TextView weaponShopText;
        TextView weaponShopStrength;
        TextView weaponShopAgility;
        TextView weaponShopIntuition;
        Button weaponShopCompare;
        Button weaponShopBuy;
        ConstraintLayout weaponShopDetails;

        public  TownWeaponViewHolder(View itemView) {
            super(itemView);
            weaponShopName = itemView.findViewById(R.id.weaponShopName);
            weaponShopValue = itemView.findViewById(R.id.weaponShopValue);
            weaponShopText = itemView.findViewById(R.id.weaponShopText);
            weaponShopStrength = itemView.findViewById(R.id.weaponShopStrength);
            weaponShopAgility = itemView.findViewById(R.id.weaponShopAgility);
            weaponShopIntuition = itemView.findViewById(R.id.weaponShopIntuition);
            weaponShopCompare = itemView.findViewById(R.id.weaponShopCompare);
            weaponShopBuy = itemView.findViewById(R.id.weaponShopBuy);
            weaponShopDetails = itemView.findViewById(R.id.weaponShopDetails);
        }
    }

    public class TownSkillViewHolder extends RecyclerView.ViewHolder {
        TextView skillShopName;
        TextView skillShopValue;
        TextView skillShopText;
        TextView skillShopStat;
        TextView skillShopDmg;
        TextView skillShopDrain;
        TextView skillShopReq1;
        TextView skillShopReq2;
        TextView skillShopReq3;
        Button skillShopBuy;
        ConstraintLayout skillShopDetails;
        ConstraintLayout skillShopBody;

        public TownSkillViewHolder(View itemView) {
            super(itemView);
            skillShopName = itemView.findViewById(R.id.SkillShopName);
            skillShopValue = itemView.findViewById(R.id.SkillShopValue);
            skillShopText = itemView.findViewById(R.id.SkillShopText);
            skillShopStat = itemView.findViewById(R.id.SkillShopStat);
            skillShopDmg = itemView.findViewById(R.id.SkillShopDmg);
            skillShopDrain = itemView.findViewById(R.id.SkillShopDrain);
            skillShopReq1 = itemView.findViewById(R.id.SkillShopNeed1);
            skillShopReq2 = itemView.findViewById(R.id.SkillShopNeed2);
            skillShopReq3 = itemView.findViewById(R.id.SkillShopNeed3);
            skillShopBuy = itemView.findViewById(R.id.SkillShopBuy);
            skillShopDetails = itemView.findViewById(R.id.SkillShopDetails);
            skillShopBody = itemView.findViewById(R.id.SkillShopBody);
        }
    }

}