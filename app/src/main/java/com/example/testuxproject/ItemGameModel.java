package com.example.testuxproject;

public class ItemGameModel {
    String itemGameName;
    String itemGameShop;
    String itemGamePrice;
    int itemGameImage;

    public ItemGameModel(String itemGameName, String itemGameShop, String itemGamePrice, int itemGameImage) {
        this.itemGameName = itemGameName;
        this.itemGameShop = itemGameShop;
        this.itemGamePrice = itemGamePrice;
        this.itemGameImage = itemGameImage;
    }

    public String getItemGameName() {
        return itemGameName;
    }

    public String getItemGameShop() {
        return itemGameShop;
    }

    public String getItemGamePrice() {
        return itemGamePrice;
    }

    public int getItemGameImage() {
        return itemGameImage;
    }
}
