package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemPage extends AppCompatActivity {

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

        IG_RecyclerViewAdapter adapter = new IG_RecyclerViewAdapter(this, items);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
    }
}