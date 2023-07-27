package com.example.testuxproject;

import android.os.Bundle;

import com.example.testuxproject.homepage.GameItems;

import java.util.ArrayList;

public class GlobalData {
    public static String userEmail = "rere@gmail.com";
    public static String userPassword = "12345678";
    public static String userName;
    public static ArrayList<GameItems> games = new ArrayList<>();

//    filter
    public static ArrayList<GameItems> filterGameByType (String type) {
        ArrayList<GameItems> filtered = new ArrayList<>();
        for (GameItems game: games) {
            if (game.getGameType().equalsIgnoreCase(type)) {
                filtered.add(game);
            }
        }
        return filtered;
    }


    public static void init(){
//        mobile legend
        GameItems mobilelegend = new GameItems(R.drawable.wallpaper_mobilelegend, R.drawable.wallpaper_mobilelegend, "Mobile Legend", 4.4, "Action", "mobile");
        mobilelegend.getItems().add(new ItemGameModel("Blade of Despair", "DonShop", "1500", R.drawable.wallpaper_mobilelegend));

        games.add(mobilelegend);
//        coc
//        pubg
//        pokemon
//        genshin impact

//        valorant
//        rocket league
//        dota 2
//        fortnite
//        apex legend

//        uncharted
//        the last of us
//        resident evil
//        god of war
//        tekken 8

//        mobile legend
//        the last of us
//        pubg
//        fortnite
//        genshin impact


    }


}
