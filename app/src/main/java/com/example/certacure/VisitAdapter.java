package com.example.certacure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.view.*;

public class VisitAdapter extends RecyclerView.Adapter<VisitAdapter.ViewHolder> {

        private List<String> visitFilter;
        private LayoutInflater mInflater;
        private ItemClickListener mClickListener;
        int selectedPos =0;
        // data is passed into the constructor
        VisitAdapter(Context context, List<String> animals) {
            this.mInflater = LayoutInflater.from(context);
            this.visitFilter = animals;
        }

        // inflates the row layout from xml when needed
        @Override
        @NonNull
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.visit_fileter_layout, parent, false);
            return new ViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull VisitAdapter.ViewHolder holder, int position) {
        String animal = visitFilter.get(position);

        holder.myTextView.setText(animal);
        if(selectedPos==position)
            holder.myTextView.setBackground(ContextCompat.getDrawable(holder.myTextView.getContext(), R.drawable.tab_background));
        else
            holder.myTextView.setBackground(ContextCompat.getDrawable(holder.myTextView.getContext(), R.drawable.tab_background_unclicked));


    }

        // total number of rows
        @Override
        public int getItemCount() {
            return visitFilter.size();
        }

        // stores and recycles views as they are scrolled off screen
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView myTextView;

            ViewHolder(View itemView) {
                super(itemView);
                myTextView = itemView.findViewById(R.id.visit_filter_txt);
                myTextView.setOnClickListener(this);
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
            return visitFilter.get(id);
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

