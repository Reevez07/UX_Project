package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.testuxproject.homepage.GameItems;
import com.example.testuxproject.homepage.HomePage;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class ProfilePage extends AppCompatActivity {
    Button submitBtn;

    //    declare variable
    Integer account_balance = GlobalData.userBalance;

    ImageButton menuIcon;
    AnimatorSet slideDownAnimatorSet;

    //    ViewPager transactionContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        EditText TopUpVal = (EditText) findViewById(R.id.TopUpVal);
        submitBtn = (MaterialButton) findViewById(R.id.TopUpbtn);
        TextView ErrorMessage = (TextView) findViewById(R.id.errormessage);

        TextView balance = findViewById(R.id.balance_value);
        balance.setText(account_balance.toString());

//        username
        TextView username = findViewById(R.id.username);
        username.setText(GlobalData.userName);

        TextView email = findViewById(R.id.userEmail);
        email.setText(GlobalData.userEmail);

        // countpurchased
        TextView countpurchased = findViewById(R.id.countpurchased);
        Integer totalTransaction = GlobalData.transactions.size();
        countpurchased.setText(totalTransaction.toString());

        // set fragment
        ViewPager2 container = findViewById(R.id.viewPagerTransaction);
        TransactionFragmentAdapter adapter = new TransactionFragmentAdapter(getSupportFragmentManager(), getLifecycle());
        container.setAdapter(adapter);

        submitBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                String topup = TopUpVal.getText().toString();
                boolean isValid = true;
                if(topup.isEmpty()){
                    isValid = false;
                    ErrorMessage.setVisibility(View.VISIBLE);
                    ErrorMessage.setText("Top-up cannot be empty!");
                } else if (Integer.parseInt(topup)<=0) {
                    isValid = false;
                    ErrorMessage.setVisibility(View.VISIBLE);
                    ErrorMessage.setText("Top-up cannot be less than or equal to 0!");
                } else{
                    isValid = true;
                    GlobalData.userBalance += Integer.parseInt(topup);
                }
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

    }
}