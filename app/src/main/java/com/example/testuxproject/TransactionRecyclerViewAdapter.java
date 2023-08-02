package com.example.testuxproject;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testuxproject.homepage.HomeInterface;

import java.util.ArrayList;

public class TransactionRecyclerViewAdapter extends RecyclerView.Adapter<TransactionRecyclerViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<TransactionModel> transactions;
    HomeInterface homeInterface;

    public TransactionRecyclerViewAdapter(Context context, ArrayList<TransactionModel> transactions, HomeInterface hi) {
        this.context = context;
        this.transactions = transactions;
        this.homeInterface = hi;
    }

    @NonNull
    @Override
    public TransactionRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.profile_item_transaction, parent, false);
        return new TransactionRecyclerViewAdapter.MyViewHolder(view, homeInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionRecyclerViewAdapter.MyViewHolder holder, int position) {
//        holder.itemName.setText(transactions.get(position).getItemName());
        holder.gameName.setText(transactions.get(position).getGameName());
        holder.itemQty.setText(transactions.get(position).getItemName().toString() + " - " + transactions.get(position).getQuantity().toString());
        holder.cost.setText(transactions.get(position).getItemPrice().toString());
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView itemName;
        TextView gameName;
        TextView itemQty;
        TextView cost;

        public MyViewHolder(@NonNull View itemView, HomeInterface homeInterface) {
            super(itemView);

//            itemName = itemView.findViewById(R.id.R_itemName);
            gameName = itemView.findViewById(R.id.R_game);
            itemQty = itemView.findViewById(R.id.R_itemQty);
            cost = itemView.findViewById(R.id.R_Cost);

            itemView.setOnClickListener(view -> {
                if (homeInterface != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        homeInterface.onItemClick(pos);
                    }
                }
            });
        }
    }


}

