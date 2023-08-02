package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.text.Editable;
import android.widget.Button;
import android.widget.TextView;

import com.example.testuxproject.homepage.HomePage;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login_page);

        TextInputLayout layoutPassword = findViewById(R.id.passwordInputLayout);
        TextInputLayout layoutEmail = findViewById(R.id.emailInputLayout);
        TextInputEditText password_txt = findViewById(R.id.password_txt);
        TextInputEditText email_txt = findViewById(R.id.email_txt);
        Button buttonToLogin = findViewById(R.id.buttonToLogin);
        TextView error_email = findViewById(R.id.errorEmail);
        TextView error_password = findViewById(R.id.errorPassword_txt);

        buttonToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_txt.getText().toString();
                String password = password_txt.getText().toString();

                // Perform email and password validations
                boolean isValid = true;
                GlobalData.userEmail = email;
                GlobalData.userPassword = password;

                if (email.isEmpty()) {
                    isValid = false;
                    error_email.setText("Email must be filled!");
                    error_email.setVisibility(View.VISIBLE);
                }else if(!email.contains("@")){
                    isValid = false;
                    error_email.setText("Email must contain @");
                    error_email.setVisibility(View.VISIBLE);
                }else if(!email.endsWith(".com")){
                    isValid = false;
                    error_email.setText("Email must ends with .com");
                    error_email.setVisibility(View.VISIBLE);
                }else if (password.isEmpty()) {
                    isValid = false;
                    error_email.setVisibility(View.INVISIBLE);
                    error_password.setText("Password must be filled!");
                    error_password.setVisibility(View.VISIBLE);
                }else if(password.length() < 8){
                    isValid = false;
                    error_email.setVisibility(View.INVISIBLE);
                    error_password.setText("Password must contain at least 8 characters");
                    error_password.setVisibility(View.VISIBLE);
                }
                else {
                    layoutPassword.setError(null);
                }

                if (isValid) {
                    // Validations successful, proceed to the next activity
                    Intent intent = new Intent(LoginPage.this, HomePage.class);
                    startActivity(intent);
                }
            }
        });

    }
}