package com.example.android.tourguideapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {
    private Context context = getContext();

    public PlaceAdapter(Activity context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View ListItemView = convertView;
        if (ListItemView == null) {
            ListItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Place current = getItem(position);
        TextView nameOfPlace = ListItemView.findViewById(R.id.place_name);
        nameOfPlace.setText(current.getNameOfPlace());
        TextView address = ListItemView.findViewById(R.id.place_address);
        address.setText(current.getAddress());
        ImageView pictureOfPlace = ListItemView.findViewById(R.id.image);
        pictureOfPlace.setImageResource(current.getImageResourceId());

        return ListItemView;
    }
}
