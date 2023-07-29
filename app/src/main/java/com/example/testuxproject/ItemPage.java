package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testuxproject.homepage.GameItems;
import com.example.testuxproject.homepage.HomeInterface;

import java.util.ArrayList;

public class ItemPage extends AppCompatActivity implements HomeInterface {

    ArrayList<ItemGameModel> items;
    String gameName;
    int gameIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_item_page);

        // ngisi item ama game name ama game icon nya
        items = this.getIntent().getExtras().getParcelableArrayList("Items");
        gameName = this.getIntent().getExtras().getString("gameName");
        gameIcon = this.getIntent().getExtras().getInt("gameIcon");

        // set gameName and gameIcon
        TextView gameNameView = findViewById(R.id.gameName);
        gameNameView.setText(gameName);

        ImageView gameIconView = findViewById(R.id.gameIcon);
        gameIconView.setImageResource(gameIcon);
        
        // repeater
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        IG_RecyclerViewAdapter adapter = new IG_RecyclerViewAdapter(this, items, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {
        ItemGameModel selectedItem = items.get(position);
        GameItems game = GlobalData.filterGameByName(gameName);

        Intent intent = new Intent(this, DetailPage.class);

        Bundle bundle = new Bundle();
        bundle.putParcelable("item", selectedItem);
        bundle.putInt("gameWallpaper", game.getGameImage1());
        bundle.putString("gameName", gameName);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}