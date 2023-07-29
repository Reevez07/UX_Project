package com.example.testuxproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testuxproject.homepage.HomeInterface;

import java.util.ArrayList;

public class IG_RecyclerViewAdapter extends RecyclerView.Adapter<IG_RecyclerViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<ItemGameModel> itemGameModel;
    private final HomeInterface homeInterface;

    public IG_RecyclerViewAdapter(Context context, ArrayList<ItemGameModel> itemGameModel, HomeInterface hi) {
        this.context = context;
        this.itemGameModel = itemGameModel;
        this.homeInterface = hi;
    }

    @NonNull
    @Override
    public IG_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_item, parent, false);

        return new IG_RecyclerViewAdapter.MyViewHolder(view, homeInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull IG_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textViewName.setText(itemGameModel.get(position).getItemGameName());
        holder.textViewShop.setText(itemGameModel.get(position).getItemGameShop());
        holder.textViewPrice.setText(itemGameModel.get(position).getItemGamePrice() + " Coins");
        holder.imageView.setImageBitmap(GlobalData.decodeSampledBitmapFromResource(context.getResources(), itemGameModel.get(position).getItemGameImage(), 100, 100));
    }

    @Override
    public int getItemCount() {
        return itemGameModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewName, textViewShop, textViewPrice;

        public MyViewHolder(@NonNull View itemView, HomeInterface homeInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageItem);
            textViewName = itemView.findViewById(R.id.itemName);
            textViewShop = itemView.findViewById(R.id.itemShop);
            textViewPrice = itemView.findViewById(R.id.itemPrice);

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
