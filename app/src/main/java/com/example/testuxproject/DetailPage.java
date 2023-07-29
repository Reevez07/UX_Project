package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.app.AlertDialog;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

import com.example.testuxproject.homepage.GameItems;
import com.example.testuxproject.homepage.HomePage;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class DetailPage extends AppCompatActivity {

    TextView EmailField;
    TextView usernameField;
    TextView stepperinput;
    TextView totalBalance;
    Button BuyButton;
    String gameName;
    ItemGameModel item;
    Integer accbalance = GlobalData.userBalance;
    TextView totalPrice;
    TextView quantity;
    Integer qty;
    AppCompatButton minus;
    AppCompatButton plus;


    public void showError (String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error").setMessage(msg);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail_page);

        item = this.getIntent().getExtras().getParcelable("item");
        gameName = this.getIntent().getExtras().getString("gameName");
        int gameWalpaper = this.getIntent().getExtras().getInt("gameWallpaper");

        ImageView walpaper = findViewById(R.id.detailwallpaper);
        int size = 5;

        Bitmap originalBitmap = BitmapFactory.decodeResource(this.getResources(), gameWalpaper);
        Bitmap resized = Bitmap.createScaledBitmap(originalBitmap, originalBitmap.getWidth() / size, originalBitmap.getHeight() / size, true);
        originalBitmap.recycle();

        walpaper.setImageBitmap(resized);

        ImageView itemImage = findViewById(R.id.imageItem);
        itemImage.setImageResource(item.getItemGameImage());

        TextView itemName = findViewById(R.id.PageItemName);
        itemName.setText(item.getItemGameName());

        TextView itemCoin = findViewById(R.id.PageItemCoin);
        itemCoin.setText(item.getItemGamePrice() + " Coins");

        TextView gameDesc = findViewById(R.id.Description);
        gameDesc.setText(item.getItemGameDesc());

//        BottomSheet Dialog
        BuyButton = findViewById(R.id.Buybutton);
        BuyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showDialog();
            }
        });



//        EmailField = findViewById(R.id./*cekulang*/);
//        usernameField = findViewById(R.id./*cekulang*/);
//        stepperinput = findViewById(R.id./*cekulang*/);
//        totalBalance = findViewById(R.id./*cekulang*/);
//        BuyButton = findViewById(R.id.BuyButton);
//
//        BuyButton.setOnClickListener();

        ImageView backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailPage.this, ItemPage.class);
                Bundle bundle = new Bundle();

                GameItems game = GlobalData.filterGameByName(gameName);

                bundle.putParcelableArrayList("Items", game.getItems());
                bundle.putString("gameName", game.getGameName());
                bundle.putInt("gameIcon", game.getGameImage2());

                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });

    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

//        LinearLayout
        TextView GameName = dialog.findViewById(R.id.GameNameValue);
        GameName.setText(gameName);


//        GameName and accBalance
        TextView name =  dialog.findViewById(R.id.GameNameText);
        name.setText(gameName);

        TextView balance =  dialog.findViewById(R.id.AccBalanceValue);
        balance.setText(accbalance.toString());


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        // stepper
        quantity = dialog.findViewById(R.id.StepperText);
        totalPrice = dialog.findViewById(R.id.TotalPaymentValue);
        qty = Integer.parseInt(quantity.getText().toString());

        totalPrice.setText(item.getItemGamePrice());

        minus = dialog.findViewById(R.id.StepperMinus);
        plus = dialog.findViewById(R.id.StepperPlus);

        minus.setOnClickListener(v -> {
            if (qty > 0) qty--;
            quantity.setText(qty.toString());
            Integer temp = qty * Integer.parseInt(item.getItemGamePrice());
            totalPrice.setText(temp.toString());
        });

        plus.setOnClickListener(v -> {
            qty++;
            quantity.setText(qty.toString());
            Integer temp = qty * Integer.parseInt(item.getItemGamePrice());
            totalPrice.setText(temp.toString());
        });

        // pay button

        EditText emailPay = dialog.findViewById(R.id.editTextEmail);
        EditText usernamePay = dialog.findViewById(R.id.editTextUsername);
        MaterialButton buttonPayment = dialog.findViewById(R.id.PayButton);

        buttonPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailPay.getText().toString();
                String username = usernamePay.getText().toString();

                // Perform email and password validations
                boolean isValid = true;

                if (email.isEmpty()) {
                    isValid = false;
                    showError("Email must be filled!");
                } else if (username.isEmpty()) {
                    isValid = false;
                    showError("Username must be filled!");
                } else if (qty <= 0) {
                    showError("Quantity must be more than 0!");
                } else if (GlobalData.userBalance < qty * Integer.parseInt(item.getItemGamePrice())){
                    showError("Account Balance is no sufficient");
                } else {
                    GlobalData.userBalance = GlobalData.userBalance - qty * Integer.parseInt(item.getItemGamePrice());
                    GlobalData.transactions.add(new TransactionModel(item.getItemGameName(), gameName, Integer.parseInt(item.getItemGamePrice()), qty));
                    Intent intent = new Intent(DetailPage.this, ProfilePage.class);
                    startActivity(intent);
                }
            }
        });

    }


}