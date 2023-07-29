package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemPage extends AppCompatActivity {

    ArrayList<ItemGameModel> Items;
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
        Items = this.getIntent().getExtras().getParcelableArrayList("Items");
        gameName = this.getIntent().getExtras().getString("gameName");
        gameIcon = this.getIntent().getExtras().getInt("gameIcon");

        // set gameName and gameIcon
        TextView gameNameView = findViewById(R.id.gameName);
        gameNameView.setText(gameName);

        ImageView gameIconView = findViewById(R.id.gameIcon);
        gameIconView.setImageResource(gameIcon);
        
        // repeater
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        IG_RecyclerViewAdapter adapter = new IG_RecyclerViewAdapter(this, Items);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

        private void navigateToLogout() {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        private void navigateToProfile() {
            Intent intent = new Intent(this, ProfilePage.class);
            startActivity(intent);
        }

        private void navigateToHome() {
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }


        private void showPopupMenu(View view) {
            PopupMenu popupMenu = new PopupMenu(this, view, Gravity.END);
            popupMenu.getMenuInflater().inflate(R.menu.dropdown_menu_home, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.menu_home:
                            navigateToHome();
                            return true;
                        case R.id.menu_profile:
                            navigateToProfile();
                            return true;
                        case R.id.menu_logout:
                            navigateToLogout();
                            return true;
                        default:
                            return false;
                    }
                }
            });
            slideDownAnimatorSet.start();
            popupMenu.show();

            // Change background color when the dropdown is shown
            //        mainLayout.setBackgroundColor(Color.parseColor("#800080")); // Purple color with 50% opacity
        }
}