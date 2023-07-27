package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        ImageView back = findViewById(R.id.arrow_left);
        ImageView hamburger_btn = findViewById(R.id.hamburger_btn);
        TextView header_title = findViewById(R.id.header_title);


        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                Toast.makeText(MainActivity.this, "click left button", Toast.LENGTH_SHORT).show();
            }
        });
        hamburger_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                Toast.makeText(MainActivity.this, "click hamburger button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}