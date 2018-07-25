package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {
    private String description;
    private int imageID;
    private String name;
    private String address;

    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);
        final ArrayList<Place> placeList = new ArrayList<>();
        placeList.add(new Place(getString(R.string.vidgof_hotel), getString(R.string.vidgof_hotel_address), R.drawable.hotel_vidgof, getString(R.string.vidgof_hotel_description)));
        placeList.add(new Place(getString(R.string.radison_hotel), getString(R.string.radison_hotel_address), R.drawable.hotel_radison, getString(R.string.radison_hotel_description)));
        placeList.add(new Place(getString(R.string.slavyanka_hotel), getString(R.string.slavyanka_hotel_address), R.drawable.hotel_slavyanka, getString(R.string.south_ural_hotel_description)));
        placeList.add(new Place(getString(R.string.south_ural_hotel), getString(R.string.south_ural_hotel_address), R.drawable.hotel_south_ural, getString(R.string.slavyanka_hotel_description)));
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
