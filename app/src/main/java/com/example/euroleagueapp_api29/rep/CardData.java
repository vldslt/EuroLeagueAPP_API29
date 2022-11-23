package com.example.euroleagueapp_api29.rep;

import android.os.Parcel;
import android.os.Parcelable;

public class CardData implements Parcelable {

    private String title;
    private String predict;

    public CardData(String title, String predict) {
        this.title = title;
        this.predict = predict;
    }

    public String getTitle() {
        return title;
    }
    public String getPredict() { return predict; }

    public void setTitle(String title) {this.title = title;}
    public void setPredict(String predict) {this.predict = predict;}


    protected CardData(Parcel in) {
        title = in.readString();
        predict = in.readString();
    }

    public static final Creator<CardData> CREATOR = new Creator<CardData>() {
        @Override
        public CardData createFromParcel(Parcel in) {return new CardData(in);}
        @Override
        public CardData[] newArray(int size) {return new CardData[size];        }
    };

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(predict);
    }
}
