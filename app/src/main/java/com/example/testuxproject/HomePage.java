package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home_page);

        String userEmail = GlobalData.userEmail;
        TextView nameUser = findViewById(R.id.emailUser1);
        int index = userEmail.indexOf('@');
        String userName = userEmail.substring(0,index);
        GlobalData.userName = userName;
        nameUser.setText(userName);
    }
}