package com.example.testuxproject.homepage;

import com.example.testuxproject.ItemGameModel;

import java.util.ArrayList;

public class GameItems {
    private int gameImage1;
    private int gameImage2;
    private String gameName;
    private Double gameRating;
    private String gameGenre;
    String gameType;

    ArrayList<ItemGameModel> items = new ArrayList<>();

    public GameItems(int gameImage1, int gameImage2, String gameName, Double gameRating, String gameGenre, String gameType) {
        this.gameImage1 = gameImage1;
        this.gameImage2 = gameImage2;
        this.gameName = gameName;
        this.gameRating = gameRating;
        this.gameGenre = gameGenre;
        this.gameType = gameType;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public GameItems(){
        //constructor kosong
    }

    public int getGameImage1() {
        return gameImage1;
    }

    public void setGameImage1(int gameImage1) {
        this.gameImage1 = gameImage1;
    }

    public int getGameImage2() {
        return gameImage2;
    }

    public void setGameImage2(int gameImage2) {
        this.gameImage2 = gameImage2;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Double getGameRating() {
        return gameRating;
    }

    public void setGameRating(Double gameRating) {
        this.gameRating = gameRating;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public ArrayList<ItemGameModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemGameModel> items) {
        this.items = items;
    }
}
