package com.example.certacure;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.view.*;

public class TestsAdapter extends RecyclerView.Adapter<TestsAdapter.ViewHolder> {

    private List<Drawable> testImage;
    private List<String>  testText;
    private List<String>  testText2;

    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    int selectedPos =0;
    // data is passed into the constructor
    TestsAdapter(Context context, List<Drawable> image,List<String>testText ,List<String> testText2
    ) {
        this.mInflater = LayoutInflater.from(context);
        this.testImage = image;
        this.testText = testText;
        this.testText2 = testText2;

    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.tests_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestsAdapter.ViewHolder holder, int position) {
        Drawable image = testImage.get(position);
        String text= testText.get(position);
        String text2= testText2.get(position);
        holder.myImageview.setBackgroundDrawable(image);
        holder.testText.setText(text);
        holder.testText2.setText(text2);
        if(selectedPos==position)
            holder.selectedImage.setVisibility(View.VISIBLE);
        else
            holder.selectedImage.setVisibility(View.INVISIBLE);


    }

    // total number of rows
    @Override
    public int getItemCount() {
        return testImage.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView myImageview;
        ImageView selectedImage;
        TextView testText;
        TextView testText2;

        ViewHolder(View itemView) {
            super(itemView);
            testText = itemView.findViewById(R.id.test_text);
            myImageview = itemView.findViewById(R.id.test_background);
            testText2=itemView.findViewById(R.id.test_text2);
            myImageview.setOnClickListener(this);
            testText.setOnClickListener(this);
            selectedImage = itemView.findViewById(R.id.selected_test);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            selectedPos=getAdapterPosition();

            notifyDataSetChanged();
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return testImage.get(id).toString();
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

