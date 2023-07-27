package com.example.testuxproject;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ItemGameModel implements Parcelable {
    String itemGameName;
    String itemGameShop;
    String itemGamePrice;
    int itemGameImage;

    public String getItemGameDesc() {
        return  itemGameName + " is a remarkable game item that offers an " +
                "incredible array of features and benefits to players in diverse gaming universes. With its exceptional qualities, this " +
                "item has become a highly sought-after asset among gamers.\n" + "With " + itemGameName +
                " you can enjoy the benefits of a budget-friendly game item that still provides a valuable boost to your gaming experience with only "
                + itemGamePrice + " coins, proving that you don't have to spend a fortune to have fun and succeed in the game.";
    }

    public ItemGameModel(String itemGameName, String itemGameShop, String itemGamePrice, int itemGameImage) {
        this.itemGameName = itemGameName;
        this.itemGameShop = itemGameShop;
        this.itemGamePrice = itemGamePrice;
        this.itemGameImage = itemGameImage;
    }

    protected ItemGameModel(Parcel in) {
        itemGameName = in.readString();
        itemGameShop = in.readString();
        itemGamePrice = in.readString();
        itemGameImage = in.readInt();
    }

    public static final Creator<ItemGameModel> CREATOR = new Creator<ItemGameModel>() {
        @Override
        public ItemGameModel createFromParcel(Parcel in) {
            return new ItemGameModel(in);
        }

        @Override
        public ItemGameModel[] newArray(int size) {
            return new ItemGameModel[size];
        }
    };

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



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(itemGameName);
        dest.writeString(itemGameShop);
        dest.writeString(itemGamePrice);
        dest.writeInt(itemGameImage);
    }
}
