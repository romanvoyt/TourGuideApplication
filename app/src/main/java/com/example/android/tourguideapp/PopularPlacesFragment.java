package com.example.android.tourguideapp;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularPlacesFragment extends Fragment {
    private String description;
    private int imageID;
    private String name;
    private String address;

    public PopularPlacesFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);
        final ArrayList<Place> placeList = new ArrayList<>();
        placeList.add(new Place(getString(R.string.kirovka), getString(R.string.kirovka_address), R.drawable.place_kirovka, getString(R.string.kirovka_description)));
        placeList.add(new Place(getString(R.string.revolution_square), getString(R.string.revolution_square_address), R.drawable.place_revolution_square, getString(R.string.revolution_square_description)));
        placeList.add(new Place(getString(R.string.gagarin_park), getString(R.string.gagarin_park_address), R.drawable.place_park_gagarina, getString(R.string.gagarin_park_description)));
        placeList.add(new Place(getString(R.string.SUSU), getString(R.string.susu_address), R.drawable.place_sharaga, getString(R.string.SUSU_description), getString(R.string.susu_phone)));
        PlaceAdapter itemsAdapter = new PlaceAdapter(getActivity(), placeList);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Place place = placeList.get(i);
                name = place.getNameOfPlace();
                description = place.getDescription();
                imageID = place.getImageResourceId();
                address = place.getAddress();

                Intent nextActivity = new Intent(getActivity(), InfoActivity.class);
                nextActivity.putExtra(getString(R.string.name), name);
                nextActivity.putExtra("1", imageID);
                nextActivity.putExtra(getString(R.string.description), description);
                nextActivity.putExtra(getString(R.string.address), address);

                startActivity(nextActivity);

            }
        });
        return rootView;
    }
}
