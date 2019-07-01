package james.peck.myrpg;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import james.peck.myrpg.Items.Armor;
import james.peck.myrpg.Items.Item;
import james.peck.myrpg.Items.SimpleItem;
import james.peck.myrpg.Items.Weapon;

import static james.peck.myrpg.Items.Equipment.gearList;

public class InventoryRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private ArrayList<String> inventory;
    private int expandedPosition = -1;
    private int previousExpandedPosition = -1;
    private final int ITEM = 0, EQUIP = 1, WEAPON = 2;
    private EquipmentChanger changer;
    private SaveLoadPlayer loader;

    public InventoryRecyclerViewAdapter(Context context) {
        this.context = context;
        changer = new EquipmentChanger(context);
        loader = new SaveLoadPlayer(context);
        inventory = loader.playerLoad().inventory;


    }

    public void updateInventoryList() {
        inventory = loader.playerLoad().inventory;
    }

    public Item findItem(String item) {
        return gearList.get(item);
    }

    @Override
    public int getItemViewType(int position) {
        if (findItem(inventory.get(position)) instanceof SimpleItem) {
            return ITEM;
        } else if (findItem(inventory.get(position)) instanceof Armor) {
            return EQUIP;
        } else if (findItem(inventory.get(position)) instanceof Weapon) {
            return  WEAPON;
        }
        return -1;
    }


  /*  public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutinventoryitem, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;
    } */

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view;
        switch (viewType) {
            case ITEM:
                view = inflater.inflate(R.layout.layoutinventoryitem, viewGroup, false);
                viewHolder = new ItemViewHolder(view);
                break;
            case EQUIP:
                view = inflater.inflate(R.layout.layoutinventoryequipment, viewGroup, false);
                viewHolder = new EquipViewHolder(view);
                break;
            case WEAPON:
                view = inflater.inflate(R.layout.layoutinventoryweapon, viewGroup, false);
                viewHolder = new WeaponViewHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.layoutinventoryitem, viewGroup, false);
                viewHolder = new ItemViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {

            case ITEM:
                ItemViewHolder holder1 = (ItemViewHolder) holder;
                configureItemViewHolder(holder1, position);
                break;
            case EQUIP:
                EquipViewHolder holder2 = (EquipViewHolder) holder;
                configureEquipViewHolder(holder2, position);
                break;
            case WEAPON:
                WeaponViewHolder holder3 = (WeaponViewHolder) holder;
                configureWeaponViewHolder(holder3, position);
                break;
        }
    }

    public void configureItemViewHolder(final ItemViewHolder holder, int position){
        holder.itemName.setText(findItem(inventory.get(position)).getName());
        holder.itemText.setText(findItem(inventory.get(position)).getDescription());

        final boolean isExpanded = position == expandedPosition;
        holder.details.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
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
    }

    public void configureEquipViewHolder(final EquipViewHolder holder, final int position) {
        holder.equipName.setText(findItem(inventory.get(position)).getName());
        holder.equipText.setText(findItem(inventory.get(position)).getDescription());
        holder.equipArmor.setText(((Armor)findItem(inventory.get(position))).getDefense() + " Armor");
        holder.equipWarding.setText(((Armor)findItem(inventory.get(position))).getWarding() + " Warding");

        final boolean isExpanded = position == expandedPosition;
        holder.equipDetails.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
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

        holder.equipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changer.changeArmor(position);
                updateInventoryList();
                notifyItemChanged(holder.getAdapterPosition());
            }
        });


    }

    public void configureWeaponViewHolder(final WeaponViewHolder holder, final int position)
    {
        holder.weaponName.setText(findItem(inventory.get(position)).getName());
        holder.weaponText.setText(findItem(inventory.get(position)).getDescription());
        holder.weaponStr.setText(((Weapon)findItem(inventory.get(position))).getBonusStrength() + " Str");
        holder.weaponAgi.setText(((Weapon)findItem(inventory.get(position))).getBonusAgility() + " Agi");
        holder.weaponInt.setText(((Weapon)findItem(inventory.get(position))).getBonusIntuition() + " Int");
        holder.weaponValue.setText("Value: " + findItem(inventory.get(position)).getValue());

        final boolean isExpanded = position == expandedPosition;
        holder.weaponDetails.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
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

        holder.weaponEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changer.changeWeapon(position);
                updateInventoryList();
                notifyItemChanged(holder.getAdapterPosition());

            }
        });
    }

    @Override
    public int getItemCount() {
        return inventory.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemText;
        TextView textBox;
        TextView itemValue;
        LinearLayout details;
        RelativeLayout listItemLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemname);
            itemText = itemView.findViewById(R.id.itemtext);
            textBox = itemView.findViewById(R.id.equipvalue);
            itemValue = itemView.findViewById(R.id.itemvalue);
            listItemLayout = itemView.findViewById(R.id.listitemlayout);
            details = itemView.findViewById(R.id.details);
        }
    }

    public class EquipViewHolder extends RecyclerView.ViewHolder {

        TextView equipName;
        TextView equipText;
        TextView equipArmor;
        TextView equipWarding;
        TextView equipValue;
        Button equipCompare;
        Button equipButton;
        ConstraintLayout equipDetails;
        RelativeLayout listEquipLayout;

        public EquipViewHolder(View itemView) {
            super(itemView);
            equipName = itemView.findViewById(R.id.equipname);
            equipText = itemView.findViewById(R.id.equipText);
            equipArmor = itemView.findViewById(R.id.equiparmor);
            equipWarding = itemView.findViewById(R.id.equipwarding);
            equipValue = itemView.findViewById(R.id.equipvalue);
            equipCompare = itemView.findViewById(R.id.comparebutton);
            equipButton = itemView.findViewById(R.id.equipbutton);
            listEquipLayout = itemView.findViewById(R.id.listequiplayout);
            equipDetails = itemView.findViewById(R.id.detailsequipment);
        }
    }

    public class WeaponViewHolder extends RecyclerView.ViewHolder {
        TextView weaponName;
        TextView weaponText;
        TextView weaponStr;
        TextView weaponAgi;
        TextView weaponInt;
        TextView weaponValue;
        Button weaponCompare;
        Button weaponEquip;
        ConstraintLayout listWeaponLayout;
        ConstraintLayout weaponDetails;

        public  WeaponViewHolder(View itemView) {
            super(itemView);
            weaponName = itemView.findViewById(R.id.weaponname);
            weaponText = itemView.findViewById(R.id.weapontext);
            weaponStr = itemView.findViewById(R.id.strview);
            weaponAgi = itemView.findViewById(R.id.agiview);
            weaponInt = itemView.findViewById(R.id.intview);
            weaponValue = itemView.findViewById(R.id.weaponvalue);
            weaponCompare = itemView.findViewById(R.id.weaponcompare);
            weaponEquip = itemView.findViewById(R.id.weaponequip);
            listWeaponLayout = itemView.findViewById(R.id.listweaponlayout);
            weaponDetails = itemView.findViewById(R.id.weapondetails);
        }

    }
}


