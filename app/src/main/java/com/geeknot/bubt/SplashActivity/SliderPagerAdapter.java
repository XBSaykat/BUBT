package com.geeknot.bubt.SplashActivity;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geeknot.bubt.R;

import java.util.ArrayList;

public class SliderPagerAdapter extends PagerAdapter {

    ArrayList<String> image_arraylist;
    Activity context;
    LayoutInflater layoutInflater;

    public SliderPagerAdapter(ArrayList<String> image_arraylist, Activity context) {
        this.image_arraylist = image_arraylist;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.layout_slider, container, false);
        TextView tvSlider = (TextView) view.findViewById(R.id.tv_slider);
        tvSlider.setText(image_arraylist.get(position));

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return image_arraylist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
