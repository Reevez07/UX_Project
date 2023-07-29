package com.example.testuxproject.homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.window.SplashScreenView;

import com.example.testuxproject.GlobalData;
import com.example.testuxproject.MainActivity;
import com.example.testuxproject.ProfilePage;
import com.example.testuxproject.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
//    image carousel
    ViewPager2 viewPager2;

//    repeater
    TabLayout tabLayout;
    ViewPager2 viewPager;
    Home_tab_adapter tabAdapters;
    ViewGroup viewGroup;

    //auto slide
    private Handler slideHandler = new Handler();

//    hamburger button
    ImageButton menuIcon;
    AnimatorSet slideDownAnimatorSet;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // init
        GlobalData.init();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home_page);

//        username
        String userEmail = GlobalData.userEmail;
        TextView nameUser = findViewById(R.id.emailUser1);
        int index = userEmail.indexOf('@');
        String userName = userEmail.substring(0,index);
        GlobalData.userName = userName;
        nameUser.setText(userName);

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

//        image carousel
        viewPager2 = findViewById(R.id.viewPagerCarousel);

        List<Slideitem> slideItems = new ArrayList<>();
        slideItems.add(new Slideitem(R.drawable.img1));
        slideItems.add(new Slideitem(R.drawable.img2));
        slideItems.add(new Slideitem(R.drawable.img3));

        viewPager2.setAdapter(new Slide_adapter(slideItems, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositionTransform = new CompositePageTransformer();
        compositionTransform.addTransformer(new MarginPageTransformer(5));
        compositionTransform.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1- Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });

        viewPager2.setPageTransformer(compositionTransform);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                slideHandler.removeCallbacks(slideRunnable);
                slideHandler.postDelayed(slideRunnable,2000);
            }
        });

//        tab layout
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpagerRepeater);
        viewPager.setUserInputEnabled(false);
        tabAdapters = new Home_tab_adapter(getSupportFragmentManager(), getLifecycle());

        viewPager.setAdapter(tabAdapters);

        tabLayout.addTab(tabLayout.newTab().setText("Recommend"));
        tabLayout.addTab(tabLayout.newTab().setText("Mobile"));
        tabLayout.addTab(tabLayout.newTab().setText("PC"));
        tabLayout.addTab(tabLayout.newTab().setText("Console"));

        // tab layout: set space between tabs
        ViewGroup slidingTabStrip = (ViewGroup) tabLayout.getChildAt(0);

        for (int i=0; i<slidingTabStrip.getChildCount()-1; i++) {
            View v = slidingTabStrip.getChildAt(i);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.rightMargin = 45;
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }

//    dropdown
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

//    image carousel
    private Runnable slideRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause(){
        super.onPause();
        slideHandler.removeCallbacks(slideRunnable);
    }

    @Override
    protected void onResume(){
        super.onResume();
        slideHandler.postDelayed(slideRunnable, 3000);
    }
}