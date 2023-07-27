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

                if (email.isEmpty() || !email.contains("@") || !email.endsWith(".com")) {
                    isValid = false;
                    layoutEmail.setError("Invalid email");
                } else {
                    layoutEmail.setError(null);
                }

                if (password.isEmpty() || password.length() < 8) {
                    isValid = false;
                    layoutPassword.setError("Invalid password");
                } else {
                    layoutPassword.setError(null);
                }

                if (isValid) {
                    // Validations successful, proceed to the next activity
                    Intent intent = new Intent(LoginPage.this, HomePage.class);
                    startActivity(intent);
                }
            }
        });

        email_txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String email = charSequence.toString();
                if(email.isEmpty()){
                    layoutEmail.setBoxStrokeColorStateList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    layoutEmail.setEndIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    layoutEmail.setEndIconDrawable(R.drawable.ic_error);
                    layoutEmail.setHelperText("Email Must be Filled!");
                    layoutEmail.setError("");
                }else if (!email.contains("@")) {
                    layoutEmail.setBoxStrokeColorStateList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    layoutEmail.setEndIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    layoutEmail.setEndIconDrawable(R.drawable.ic_error);
                    layoutEmail.setHelperText("Email must contains @");
                    layoutEmail.setError("");
                }else if(!email.endsWith(".com")){
                    layoutEmail.setBoxStrokeColorStateList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    layoutEmail.setEndIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    layoutEmail.setEndIconDrawable(R.drawable.ic_error);;
                    layoutEmail.setHelperText("Email must ends with .com");
                    layoutEmail.setError("");
                }else{
                    layoutEmail.setHelperText("");
                    layoutEmail.setBoxStrokeColorStateList(ColorStateList.valueOf(getResources().getColor(R.color.baseblue))); // Set to null to revert to the default stroke color
                    Drawable clearIcon = getResources().getDrawable(R.drawable.ic_clear);
                    layoutEmail.setEndIconDrawable(clearIcon);
//                    layoutEmail.setEndIconTintList(null); // Set to null to revert to the default end icon tint
//                    layoutEmail.setEndIconDrawable(null); // Set to null to revert to the default end icon
                    layoutEmail.setError(null); // Set to null to clear any previous error
                    layoutEmail.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password_txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String password = charSequence.toString();
                if (password.isEmpty()){
                    layoutPassword.setBoxStrokeColorStateList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
//                    layoutPassword.setEndIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
//                    layoutPassword.setEndIconDrawable(R.drawable.ic_error);
                    layoutPassword.setHelperText("Password Must be Filled!");
                    layoutPassword.setError("");
                }else if(password.length() < 8){
                    layoutPassword.setBoxStrokeColorStateList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
//                    layoutPassword.setEndIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
//                    layoutPassword.setEndIconDrawable(R.drawable.ic_error);
                    layoutPassword.setHelperText("Enter Minimum 8 Char");
                    layoutPassword.setError("");
                }else{
                    layoutPassword.setHelperText("");
//                    layoutPassword.setEndIconDrawable(null);
                    layoutPassword.setBoxStrokeColorStateList(ColorStateList.valueOf(getResources().getColor(R.color.baseblue))); // Set to null to revert to the default stroke color
//                    layoutPassword.setEndIconTintList(null);
//                    layoutPassword.setEndIconMode(TextInputLayout.END_ICON_PASSWORD_TOGGLE);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}