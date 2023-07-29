package com.example.testuxproject.homepage;

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

import com.example.testuxproject.R;

import java.util.ArrayList;
import java.util.List;

public class Home_game_adapter extends RecyclerView.Adapter<Home_game_adapter.MyViewHolder> {
    Context context;
    ArrayList<GameItems> games;

    private final HomeInterface homeInterface;

    public Home_game_adapter(Context context, ArrayList<GameItems> games, HomeInterface homeInterface) {
        this.context = context;
        this.games = games;
        this.homeInterface = homeInterface;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.home_game_rep, parent, false);
        return new MyViewHolder(v, homeInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int size = 10;

        Bitmap originalBitmap = BitmapFactory.decodeResource(context.getResources(), games.get(position).getGameImage1());
        Bitmap resized = Bitmap.createScaledBitmap(originalBitmap, originalBitmap.getWidth() / size, originalBitmap.getHeight() / size, true);
        originalBitmap.recycle();

        Bitmap image2 = BitmapFactory.decodeResource(context.getResources(), games.get(position).getGameImage2());
        Bitmap resized2 = Bitmap.createScaledBitmap(image2, image2.getWidth() / size, image2.getHeight() / size, true);
        image2.recycle();

        holder.gameImage1.setImageBitmap(resized);
        holder.gameImage2.setImageBitmap(resized2);
        holder.gameName.setText(games.get(position).getGameName());
        holder.gameGenre.setText(games.get(position).getGameGenre());
        holder.gameRating.setText(games.get(position).getGameRating().toString());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView gameImage1, gameImage2;
        TextView gameName, gameGenre, gameRating;

        public MyViewHolder(@NonNull View itemView, HomeInterface homeInterface) {
            super(itemView);

            gameImage1 = itemView.findViewById(R.id.imageRep1);
            gameImage2 = itemView.findViewById(R.id.imageRep2);
            gameName = itemView.findViewById(R.id.gamename);
            gameGenre = itemView.findViewById(R.id.gamegenre);
            gameRating = itemView.findViewById(R.id.rating);

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
