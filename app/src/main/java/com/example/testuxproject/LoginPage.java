package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;

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
                    layoutEmail.setError("Email must be filled!");
                }else if(!email.contains("@")){
                    isValid = false;
                    layoutEmail.setError("Email must contain '@'");
                }else if(!email.endsWith(".com")){
                    isValid = false;
                    layoutEmail.setError("Email must end with .com");
                }
                else {
                    layoutEmail.setError(null);
                }

                if (password.isEmpty()) {
                    isValid = false;
                    layoutPassword.setError("Password must be filled!");
                }else if(password.length() < 8){
                    isValid = false;
                    layoutPassword.setError("Password must contain at least 8 characters");
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