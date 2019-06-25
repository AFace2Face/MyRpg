package james.peck.myrpg;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class InventoryRecyclerViewAdapter extends RecyclerView.Adapter<InventoryRecyclerViewAdapter.ViewHolder>{



    private Context context;
    private ArrayList<String> itemNameList;
    private ArrayList<String> itemTextList;
    private int expandedPosition = -1;
    private int previousExpandedPosition = -1;

    public InventoryRecyclerViewAdapter(Context context, ArrayList<String> itemNameList, ArrayList<String> itemTextList) {
        this.context = context;
        this.itemNameList = itemNameList;
        this.itemTextList = itemTextList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutinventoryitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemName.setText(itemNameList.get(position));
        holder.itemText.setText(itemTextList.get(position));

        final boolean isExpanded = position== expandedPosition;
        holder.details.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);

        if (isExpanded)
            previousExpandedPosition = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandedPosition = isExpanded ? -1:holder.getAdapterPosition();
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemNameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemText;
        TextView textBox;
        TextView itemValue;
        LinearLayout details;
        RelativeLayout listItemLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemText = itemView.findViewById(R.id.itemText);
            textBox = itemView.findViewById(R.id.textbox);
            itemValue = itemView.findViewById(R.id.itemvalue);
            listItemLayout = itemView.findViewById(R.id.listitemlayout);
            details = itemView.findViewById(R.id.details);
        }
    }
}
