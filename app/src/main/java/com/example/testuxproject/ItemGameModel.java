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
        return itemGameDesc;
    }

    public void setItemGameDesc(String itemGameDesc) {
        this.itemGameDesc = itemGameDesc;
    }

    String itemGameDesc;

    public ItemGameModel(String itemGameName, String itemGameShop, String itemGamePrice, int itemGameImage, String itemGameDesc) {
        this.itemGameName = itemGameName;
        this.itemGameShop = itemGameShop;
        this.itemGamePrice = itemGamePrice;
        this.itemGameImage = itemGameImage;
        this.itemGameDesc = itemGameDesc;
    }

    protected ItemGameModel(Parcel in) {
        itemGameName = in.readString();
        itemGameShop = in.readString();
        itemGamePrice = in.readString();
        itemGameImage = in.readInt();
        itemGameDesc = in.readString();
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
