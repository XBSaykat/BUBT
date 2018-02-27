package com.geeknot.bubt.SplashActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geeknot.bubt.IntroSliderActivity.IntroSliderActivity;
import com.geeknot.bubt.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    Thread timer;

    private static final String TAG = "Glowing Text Example";

    TextView textView;

   /* Button loginAc;
    TextView signUpAc;*/

    float 	startGlowRadius = 25f,
            minGlowRadius   = 3f,
            maxGlowRadius   = 15f;

    GlowingText glowText;
    SplashActivity activity =this;

    ViewPager vp_slider;
    private LinearLayout ll_dots;
    private TextView[] dots;
    Activity context;
    SliderPagerAdapter sliderPagerAdapter;
    ArrayList<String> slider_image_list;
    int page_position = 0;
    public Handler handler;
    public Runnable update;

    /*public  void loginActivity(){
        loginAc= (Button)findViewById(R.id.link_login);
        loginAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginr = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(loginr);
            }
        });
    }

    public  void signUpActivity(){
        signUpAc= (TextView)findViewById(R.id.link_sign_up);
        signUpAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signr = new Intent(SplashActivity.this, SignUpActivity.class);
                startActivity(signr);
            }
        });
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timer = new Thread(){
            public void run(){
                try{
                    synchronized (this) {
                        wait(7000);
                    }
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashActivity.this, IntroSliderActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();

     /*   loginActivity();
        signUpActivity();*/

        textView  = (TextView) findViewById(R.id.tv_uni_name);

        glowText = new GlowingText(
                activity,           // Pass activity Object
                getBaseContext(),   // Context
                textView,           // TextView
                minGlowRadius,      // Minimum Glow Radius
                maxGlowRadius,      // Maximum Glow Radius
                startGlowRadius,    // Start Glow Radius - Increases to MaxGlowRadius then decreases to MinGlowRadius.
                Color.BLUE,         // Glow Color (int)
                3);                 // Glowing Transition Speed (Range of 1 to 10)

        // You can also use to set data dynamically
        glowText.setGlowColor(Color.CYAN);  //(int : 0xFFffffff)
        glowText.setStartGlowRadius(3f);
        glowText.setMaxGlowRadius(25f);
        glowText.setMinGlowRadius(3f);

        // You can use following methods to retrieve current data
        Log.d(TAG,"Current Glow Radius: "    +glowText.getCurrentGlowRadius());
        Log.d(TAG,"Max Glow Radius: "        +glowText.getMaxGlowRadius());
        Log.d(TAG,"Min Glow Radius: "        +glowText.getMinGlowRadius());
        Log.d(TAG,"Glow Color: "             +glowText.getGlowColor());
        Log.d(TAG,"Glow Transition Speed: "  +glowText.getTransitionSpeed());


        context = SplashActivity.this;

        init();
        addBottomDots(0);

        handler = new Handler();
        update = new Runnable() {
            public void run() {
                if (page_position == slider_image_list.size()) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                vp_slider.setCurrentItem(page_position, true);
            }
        };
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 2000);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            synchronized(timer){
                timer.notify();
            }
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(update);
        super.onDestroy();
        glowText.stopGlowing();
    }

    private void init() {

        vp_slider = (ViewPager) findViewById(R.id.vp_slider);
        ll_dots = (LinearLayout) findViewById(R.id.ll_dots);

        slider_image_list = new ArrayList<>();

        slider_image_list.add("Representing the University.");
        slider_image_list.add("Easy solution for Students and Teachers.");
        slider_image_list.add("Secure System.");

        sliderPagerAdapter = new SliderPagerAdapter(slider_image_list, context);
        vp_slider.setAdapter(sliderPagerAdapter);

        vp_slider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[slider_image_list.size()];

        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#FFFFFF"));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(context.getResources().getColor(R.color.colorLightBlue));
    }
}
