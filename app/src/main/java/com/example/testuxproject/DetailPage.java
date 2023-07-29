package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

public class DetailPage extends AppCompatActivity {

    TextView EmailField;
    TextView usernameField;
    TextView stepperinput;
    TextView totalBalance;
    Button BuyButton;
    String gameName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail_page);

        ItemGameModel item = this.getIntent().getExtras().getParcelable("item");
        gameName = this.getIntent().getExtras().getString("gameName");
        int gameWalpaper = this.getIntent().getExtras().getInt("gameWallpaper");

        ImageView walpaper = findViewById(R.id.detailwallpaper);
        int size = 10;

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


    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

//        LinearLayout
        TextView name =  dialog.findViewById(R.id.GameNameText);
        name.setText(gameName);
    }


}