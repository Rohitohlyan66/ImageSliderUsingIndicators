package com.example.instaslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager2 imageContainer;
    SliderAdapter adapter;
    int list[];
    TextView[] dots;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageContainer = findViewById(R.id.image_container);
        layout = findViewById(R.id.dots_container);

        dots = new TextView[5];

        list = new int[5];
        list[0] = getResources().getColor(R.color.black);
        list[1] = getResources().getColor(R.color.red);
        list[2] = getResources().getColor(R.color.green);
        list[3] = getResources().getColor(R.color.yellow);
        list[4] = getResources().getColor(R.color.orange);

        adapter = new SliderAdapter(list);
        imageContainer.setAdapter(adapter);

        setIndicators();

        imageContainer.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                selectedDots(position);
                super.onPageSelected(position);
            }
        });

    }

    private void selectedDots(int position) {
        for (int i = 0; i < dots.length; i++) {
            if (i == position) {
                dots[i].setTextColor(list[position]);
            } else {
                dots[i].setTextColor(getResources().getColor(R.color.grey));
            }
        }
    }

    private void setIndicators() {
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(18);
            layout.addView(dots[i]);
        }

    }
}