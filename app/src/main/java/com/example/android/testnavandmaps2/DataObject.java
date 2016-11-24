package com.example.android.testnavandmaps2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by snehith on 23/11/16.
 */

public class DataObject implements Parcelable {

    String name = "";
    String favoriteWord = "";


    public DataObject(){

    }

    public DataObject(Parcel p){
        this.name = p.readString();
        this.favoriteWord = p.readString();
    }


    public static final Creator<DataObject> CREATOR = new Creator<DataObject>() {
        @Override
        public DataObject createFromParcel(Parcel in) {
            return new DataObject(in);
        }

        @Override
        public DataObject[] newArray(int size) {
            return new DataObject[size];
        }
    };


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(favoriteWord);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteWord() {
        return favoriteWord;
    }

    public void setFavoriteWord(String favoriteWord) {
        this.favoriteWord = favoriteWord;
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
