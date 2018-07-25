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
public class CafeFragment extends Fragment {
    private String description;
    private int imageID;
    private String name;
    private String address;

    public CafeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);
        final ArrayList<Place> placeList = new ArrayList<>();
        placeList.add(new Place(getString(R.string.pomidor_cafe), getString(R.string.pomidor_cafe_address), R.drawable.cafe_pomidor, getString(R.string.pomidor_cafe_description)));
        placeList.add(new Place(getString(R.string.cows_cafe), getString(R.string.cows_cafe_address), R.drawable.cafe_the_telki, getString(R.string.cows_cafe_description)));
        placeList.add(new Place(getString(R.string.pizza_cafe), getString(R.string.pizza_cafe), R.drawable.cafe_pizza_mia, getString(R.string.pizza_cafe_description)));
        placeList.add(new Place(getString(R.string.elephant_cafe), getString(R.string.elephant_cafe_address), R.drawable.cafe_slon, getString(R.string.elephant_cafe_description)));
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
