package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

public class DetailPage extends AppCompatActivity {

    TextView EmailField;
    TextView usernameField;
    TextView stepperinput;
    TextView totalBalance;
    Button BuyButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail_page);

//        EmailField = findViewById(R.id./*cekulang*/);
//        usernameField = findViewById(R.id./*cekulang*/);
//        stepperinput = findViewById(R.id./*cekulang*/);
//        totalBalance = findViewById(R.id./*cekulang*/);
//        BuyButton = findViewById(R.id.BuyButton);
//
//        BuyButton.setOnClickListener();


    }
}