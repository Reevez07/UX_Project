package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class ProfilePage extends AppCompatActivity {
    Button submitBtn;

//    declare variable
    Integer account_balance = GlobalData.userBalance;

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

    }
}