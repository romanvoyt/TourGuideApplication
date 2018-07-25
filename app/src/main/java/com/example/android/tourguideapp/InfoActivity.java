package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    private int imageID;
    private String name;
    private String description;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_activity);

        name = getIntent().getStringExtra(getString(R.string.name));
        description = getIntent().getStringExtra(getString(R.string.description));
        imageID = getIntent().getIntExtra("1", 0);
        address = getIntent().getStringExtra(getString(R.string.address));

        ImageView headerImage = findViewById(R.id.image);
        headerImage.setImageResource(imageID);

        TextView mNameOfPlace = findViewById(R.id.name);
        mNameOfPlace.setText(name);
        setTitle(name);

        TextView mDescription = findViewById(R.id.description);
        mDescription.setText(description);

        TextView mAddresssOfPlace = findViewById(R.id.address);
        mAddresssOfPlace.setText(getString(R.string.address_left) + address);

    }
}
