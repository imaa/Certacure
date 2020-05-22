package com.example.certacure;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class TextAdapter extends PagerAdapter {
    private Context mContext;
    private int[] textIds=new int[]{R.string.patient,R.string.doctor};
    TextAdapter(Context context)
    {
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        TextView textView = new TextView(mContext);
        textView.setText(textIds[position]);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setTextSize(25);
        container.addView(textView,0);

        return textView;
    }

    @Override
    public int getCount() {
        return textIds.length;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
