package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.testuxproject.homepage.GameItems;
import com.example.testuxproject.homepage.HomeInterface;
import com.example.testuxproject.homepage.HomePage;

import java.util.ArrayList;

public class ItemPage extends AppCompatActivity implements HomeInterface {

    ArrayList<ItemGameModel> items;
    String gameName;
    int gameIcon;
    ImageButton menuIcon;
    AnimatorSet slideDownAnimatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

        ImageView backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemPage.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });

        //        hamburger button

        menuIcon = findViewById(R.id.button_menu);

        slideDownAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.slide_down);
        slideDownAnimatorSet.setTarget(R.menu.dropdown_menu_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuIcon.setImageResource(R.drawable.ic_baseline_close_24);
                showPopupMenu(view);
            }
        });
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