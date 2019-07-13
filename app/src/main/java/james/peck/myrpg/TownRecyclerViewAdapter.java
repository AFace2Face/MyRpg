package james.peck.myrpg;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import java.util.ArrayList;

import james.peck.myrpg.Items.Body;
import james.peck.myrpg.Items.Helmet;
import james.peck.myrpg.Items.Item;
import james.peck.myrpg.Items.Weapon;

import static james.peck.myrpg.Items.Equipment.gearList;

public class TownRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<String> displayList;
    private final int HELMET = 0, BODY = 1, WEAPON = 2, ITEM = 3;
    private EquipmentChanger changer;
    private int expandedPosition = -1;
    private int previousExpandedPosition = -1;


    public TownRecyclerViewAdapter(Context context, ArrayList<String> displayList) {
        this.context = context;
        changer = new EquipmentChanger(context);
        this.displayList = displayList;
    }

    public Item findItem(String itemName) {
        return gearList.get(itemName);
    }

    @Override
    public int getItemViewType(int position)
    {
        Item item = findItem(displayList.get(position));
        if(item instanceof Helmet) {
            return HELMET;
        }
        else if (item instanceof Body) {
            return BODY;
        }
        else if (item instanceof Weapon) {
            return WEAPON;
        }
        else if (item instanceof Item) {
            return ITEM;
        }
        return -1;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view;
 /*       switch (viewType) {
            case HELMET:
                view = inflater.inflate(R.layout.layoutinventoryitem, viewGroup, false);
                viewHolder = new HelmetViewHolder(view);
                break;
            case BODY:
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
        return viewHolder; */
            return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
