package com.example.testuxproject;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class TransactionModel implements Parcelable {
    String itemName;
    String gameName;
    Integer itemPrice;
    Integer quantity;


    public TransactionModel(String itemName, String gameName, Integer itemPrice, Integer quantity) {
        this.itemName = itemName;
        this.gameName = gameName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    protected TransactionModel(Parcel in) {
        itemName = in.readString();
        gameName = in.readString();

        if (in.readByte() == 0) {
            itemPrice = null;
        } else {
            itemPrice = in.readInt();
        }

        if (in.readByte() == 0) {
            quantity = null;
        } else {
            quantity = in.readInt();
        }
    }

    public static final Creator<TransactionModel> CREATOR = new Creator<TransactionModel>() {
        @Override
        public TransactionModel createFromParcel(Parcel in) {
            return new TransactionModel(in);
        }

        @Override
        public TransactionModel[] newArray(int size) {
            return new TransactionModel[size];
        }
    };

    public String getItemName() {
        return itemName;
    }

    public String getGameName() {
        return gameName;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public String getQuantity() { return quantity.toString() + " pc(s)"; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(itemName);
        parcel.writeString(gameName);

        if (itemPrice == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(itemPrice);
        }

        if (quantity == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(quantity);
        }
    }

}


