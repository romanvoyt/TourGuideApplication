package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class Place extends AppCompatActivity {

    private String mNameOfPlace;
    private String mAddress;
    private String mPhoneNumber;
    private String mDescription;
    private int mImageResourceId;

    public Place(String nameOfPlace, String address, int imageResourceId, String description) {

        mNameOfPlace = nameOfPlace;
        mAddress = address;
        mImageResourceId = imageResourceId;
        mDescription = description;

    }

    public Place(String nameOfPlace, String address, int imageResourceId, String description, String phoneNumber) {

        mNameOfPlace = nameOfPlace;
        mAddress = address;
        mImageResourceId = imageResourceId;
        mDescription = description;
        mPhoneNumber = phoneNumber;

    }

    public String getAddress() {
        return mAddress;
    }

    public String getNameOfPlace() {
        return mNameOfPlace;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

}
