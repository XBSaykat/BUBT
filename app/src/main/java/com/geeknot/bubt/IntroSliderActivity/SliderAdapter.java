package com.geeknot.bubt.IntroSliderActivity;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geeknot.bubt.R;

public class SliderAdapter extends PagerAdapter {

    Context context;

    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {

        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.info,
            R.drawable.routine,
            R.drawable.alarm,
            R.drawable.document,
            R.drawable.notification,
            R.drawable.done
    };

    public String[] slide_headings = {
            "Insert Your Informations",
            "View or Adjust Routine",
            "Keep Yourself Active",
            "Grab Necessary Documents",
            "Get Notifications",
            "Almost Done"
    };

    public String[] slide_descs = {
            "Insert Your Informations",
            "View or Adjust Routine",
            "Keep Yourself Active",
            "Grab Necessary Documents",
            "Get Notifications",
            "You are almost done with get introduced with this app. You can easily see these again from \"Instruction\" section. You can contact with us from \"Contact us\" section for any queary. Click \"Finish\" and get yourself in touch with some amazing features."
    };

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView= (ImageView) view.findViewById(R.id.slide_iv);
        TextView slideHeading = (TextView) view.findViewById(R.id.tv_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.tv_des);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);

    }
}
