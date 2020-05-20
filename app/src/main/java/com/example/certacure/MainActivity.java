package com.example.certacure;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    androidx.viewpager.widget.ViewPager viewPager;
    androidx.viewpager.widget.ViewPager viewPager1;
    androidx.viewpager.widget.ViewPager viewPager3;
    Button continue1;
    LinearLayout linearLayout;
    private int dotsCount;
    private ImageView[] dots;
    ImageButton next,back;
float x1,x2,y1,y2;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        linearLayout = findViewById(R.id.sliderDots);
        viewPager1 = findViewById(R.id.viewPager2);
        viewPager3 = findViewById(R.id.viewPager3);
        viewPager = findViewById(R.id.viewPager);
        continue1=findViewById(R.id.img);
        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPager.getCurrentItem()==0)
                {
                startActivity(new Intent(MainActivity.this,LoginActivityPatient.class));
                }
                else if(viewPager.getCurrentItem()==1)
                {
                    Toast.makeText(MainActivity.this,"Doctor login is not ready yet",Toast.LENGTH_SHORT).show();
                }
            }
        });
        next = findViewById(R.id.right);
        back = findViewById(R.id.left);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                viewPager1.setCurrentItem(viewPager1.getCurrentItem() + 1, true);
                viewPager3.setCurrentItem(viewPager3.getCurrentItem() + 1, true);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
                viewPager1.setCurrentItem(viewPager1.getCurrentItem() - 1, true);
                viewPager3.setCurrentItem(viewPager3.getCurrentItem() - 1, true);
            }
        });
        TextAdapter2 adapter3 = new TextAdapter2(this);
        TextAdapter adapter1 = new TextAdapter(this);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager1.setAdapter(adapter1);
        viewPager3.setAdapter(adapter3);
        dotsCount = Objects.requireNonNull(viewPager1.getAdapter()).getCount();
        dots = new ImageView[dotsCount];
        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonselected_item));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            linearLayout.addView(dots[i], params);


        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selecteditem_dot));
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            private float pointX;
            private float pointY;
            private int tolerance = 50;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        x1=event.getX();
                        y1=event.getY();
                        break;//This is important, if you return TRUE the action of swipe will not take place.
                    case MotionEvent.ACTION_UP:
                        x2=event.getX();
                        y2=event.getY();
                        if(x1>x2)
                        {
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
                            viewPager1.setCurrentItem(viewPager1.getCurrentItem()+1,true);
                            viewPager3.setCurrentItem(viewPager3.getCurrentItem()+1,true);
                        }
                        else if(x1<x2)
                        {
                            viewPager.setCurrentItem(viewPager.getCurrentItem()-1,true);
                            viewPager1.setCurrentItem(viewPager1.getCurrentItem()-1,true);
                            viewPager3.setCurrentItem(viewPager3.getCurrentItem()-1,true);
                        }
                        break;
                }
                return false;
            }

        });
        viewPager1.setOnTouchListener(new View.OnTouchListener() {
            private float pointX;
            private float pointY;
            private int tolerance = 50;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        x1=event.getX();
                        y1=event.getY();
                        break;//This is important, if you return TRUE the action of swipe will not take place.
                    case MotionEvent.ACTION_UP:
                        x2=event.getX();
                        y2=event.getY();
                        if(x1>x2)
                        {
                            viewPager1.setCurrentItem(viewPager1.getCurrentItem()+1,true);

                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
                            viewPager3.setCurrentItem(viewPager3.getCurrentItem()+1,true);
                        }
                        else if(x1<x2)
                        {
                            viewPager1.setCurrentItem(viewPager1.getCurrentItem()-1,true);

                            viewPager.setCurrentItem(viewPager.getCurrentItem()-1,true);
                            viewPager3.setCurrentItem(viewPager3.getCurrentItem()-1,true);
                        }
                        break;
                }
                return false;
            }

        });
        viewPager3.setOnTouchListener(new View.OnTouchListener() {
            private float pointX;
            private float pointY;
            private int tolerance = 50;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        x1=event.getX();
                        y1=event.getY();
                        break;//This is important, if you return TRUE the action of swipe will not take place.
                    case MotionEvent.ACTION_UP:
                        x2=event.getX();
                        y2=event.getY();
                        if(x1>x2)
                        {
                            viewPager3.setCurrentItem(viewPager3.getCurrentItem()+1,true);

                            viewPager1.setCurrentItem(viewPager1.getCurrentItem()+1,true);
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
                        }
                        else if(x1<x2)
                        {
                            viewPager3.setCurrentItem(viewPager3.getCurrentItem()-1,true);

                            viewPager1.setCurrentItem(viewPager1.getCurrentItem()-1,true);
                            viewPager.setCurrentItem(viewPager.getCurrentItem()-1,true);
                        }
                        break;
                }
                return false;
            }

        });
    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonselected_item));

                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selecteditem_dot));

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

@Override
    public  boolean onTouchEvent(MotionEvent motionEvent)
    {
        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1=motionEvent.getX();
                y1=motionEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2=motionEvent.getX();
                y2=motionEvent.getY();
                if(x1>x2)
                {
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
                    viewPager1.setCurrentItem(viewPager1.getCurrentItem()+1,true);
                    viewPager3.setCurrentItem(viewPager3.getCurrentItem()+1,true);
                }
                else if(x1<x2)
                {
                    viewPager.setCurrentItem(viewPager.getCurrentItem()-1,true);
                    viewPager1.setCurrentItem(viewPager1.getCurrentItem()-1,true);
                    viewPager3.setCurrentItem(viewPager3.getCurrentItem()-1,true);
                }
                break;
        }
        return false;
    }

}
