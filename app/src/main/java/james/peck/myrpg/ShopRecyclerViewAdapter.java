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

import static james.peck.myrpg.Items.Equipment.gearList;

public class ShopRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<String> displayList;
    private final int HELMET = 0, BODY = 1, WEAPON = 2, ITEM = 3;
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

    @Override
    public int getItemViewType(int position) {
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
        //      switch (viewType) {
        //          case HELMET:
        view = inflater.inflate(R.layout.layouttownhelmet, parent, false);
        viewHolder = new TownHelmetViewHolder(view);
        //              break;
 /*           case BODY:
                view = inflater.inflate(R.layout.layoutinventoryequipment, parent, false);
                viewHolder = new EquipViewHolder(view);
                break;
            case WEAPON:
                view = inflater.inflate(R.layout.layoutinventoryweapon, parent, false);
                viewHolder = new WeaponViewHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.layoutinventoryitem, parent, false);
                viewHolder = new ItemViewHolder(view);
                break;
        } */
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {

            case HELMET:
                TownHelmetViewHolder holder1 = (TownHelmetViewHolder) holder;
                configureTownHelmetViewHolder(holder1, position);
                break;
 /*           case EQUIP:
                EquipViewHolder holder2 = (EquipViewHolder) holder;
                configureEquipViewHolder(holder2, position);
                break;
            case WEAPON:
                WeaponViewHolder holder3 = (WeaponViewHolder) holder;
                configureWeaponViewHolder(holder3, position);
                break; */
        }

    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }

    public void configureTownHelmetViewHolder(final TownHelmetViewHolder holder, int position) {
        Helmet head = (Helmet)findItem(displayList.get(position));

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

}