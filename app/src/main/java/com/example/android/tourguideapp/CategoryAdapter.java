package com.example.android.tourguideapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return mContext.getString(R.string.popular_places);
        else if (position == 1)
            return mContext.getString(R.string.museums);
        else if (position == 2)
            return mContext.getString(R.string.cafe_restaurants);
        else
            return mContext.getString(R.string.hotels);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new PopularPlacesFragment();
        else if (position == 1)
            return new MuseumFragment();
        else if (position == 2)
            return new CafeFragment();
        else
            return new HotelFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

}
