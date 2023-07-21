package com.example.testuxproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IG_RecyclerViewAdapter extends RecyclerView.Adapter<IG_RecyclerViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<ItemGameModel> itemGameModel;

    public IG_RecyclerViewAdapter(Context context, ArrayList<ItemGameModel> itemGameModel) {
        this.context = context;
        this.itemGameModel = itemGameModel;
    }

    @NonNull
    @Override
    public IG_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_item, parent, false);

        return new IG_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IG_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textViewName.setText(itemGameModel.get(position).getItemGameName());
        holder.textViewShop.setText(itemGameModel.get(position).getItemGameShop());
        holder.textViewPrice.setText(itemGameModel.get(position).getItemGamePrice());
        holder.imageView.setImageResource(itemGameModel.get(position).getItemGameImage());
    }

    @Override
    public int getItemCount() {
        return itemGameModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewName, textViewShop, textViewPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageItem);
            textViewName = itemView.findViewById(R.id.itemName);
            textViewShop = itemView.findViewById(R.id.itemShop);
            textViewPrice = itemView.findViewById(R.id.itemPrice);
        }
    }
}
