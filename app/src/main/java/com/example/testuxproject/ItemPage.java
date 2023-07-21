package com.example.testuxproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemPage extends AppCompatActivity {

    ArrayList<ItemGameModel> itemGameModel = new ArrayList<>();

    int[] itemGameImage = {R.drawable.valorant_reaver_collection_vandal_hd, R.drawable.valorant_ion_collection_operator_hd
    ,R.drawable.valorant_prime_knife_hd,R.drawable.valorant_oni_collection_phantom_hd, R.drawable.valorant_glitchpop_collection_vandal_hd};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_item_page);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpItemGameModel();

        IG_RecyclerViewAdapter adapter = new IG_RecyclerViewAdapter(this, itemGameModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
    }

    private void setUpItemGameModel(){
        String[] itemGameName = getResources().getStringArray(R.array.item_name_txt);
        String[] itemGameShop = getResources().getStringArray(R.array.item_shop_txt);
        String[] itemGamePrice = getResources().getStringArray(R.array.item_price_txt);

        for(int i = 0; i < itemGameName.length; i++){
            itemGameModel.add(new ItemGameModel(itemGameName[i], itemGameShop[i], itemGamePrice[i], itemGameImage[i]));
        }
    }
}