package com.example.certacure;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PatientActivity extends AppCompatActivity {
    private VisitAdapter adapter;
    private TestsAdapter testsAdapter;
    TextView visit_filter_txt;
    int visibleItemCount;
    TextView visitfilter_count;
    ArrayList<String> visitFilter = new ArrayList<>();
    ArrayList<Drawable> testsImages = new ArrayList<>();
    ArrayList<String> testsText = new ArrayList<>();
    ArrayList<String> testsText2 = new ArrayList<>();

    LinearLayoutManager horizontalLayoutManager;
    LinearLayoutManager horizontalLayoutManager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.patient_layout);
        visitFilter.add("Latest Visit");
        visitFilter.add("Previous Visit");
        visitFilter.add("All Visits");
        visitFilter.add("Not visible Item");
        visitFilter.add("Not visible Item");
        visitFilter.add("Not visible Item");
        visitFilter.add("Not visible Item");
        visitFilter.add("Not visible Item");
        testsImages.add(ContextCompat.getDrawable(getApplicationContext(),R.drawable.testxxxhdpi));
        testsText.add("Test\nResult");
        testsText2.add("");
        testsImages.add(ContextCompat.getDrawable(getApplicationContext(),R.drawable.radiologyxxxhdpi));
        testsText.add("Radiology");
        testsText2.add("review your reports\n" +
                "and contact your doctor\n" +
                "to discuss the results");
        testsImages.add(ContextCompat.getDrawable(getApplicationContext(),R.drawable.drugcalenderxxxhdpi));
        testsText.add("My Drugs\nCalender");
        testsText2.add("");



        androidx.recyclerview.widget.RecyclerView recyclerView = findViewById(R.id.visit_rv);
        androidx.recyclerview.widget.RecyclerView recyclerView1 = findViewById(R.id.tests);
         horizontalLayoutManager
                = new LinearLayoutManager(PatientActivity.this, LinearLayoutManager.HORIZONTAL, false);
        horizontalLayoutManager1
                = new LinearLayoutManager(PatientActivity.this, LinearLayoutManager.HORIZONTAL, false);
recyclerView1.setLayoutManager(horizontalLayoutManager1);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        adapter = new VisitAdapter(this, visitFilter);
        testsAdapter = new TestsAdapter(this,testsImages,testsText,testsText2);
        recyclerView1.setAdapter(testsAdapter);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(onScrollListener);
        visitfilter_count=findViewById(R.id.non_visible_filter);

        visit_filter_txt = findViewById(R.id.visit_filter_txt);


    }
    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            visibleItemCount = horizontalLayoutManager.findFirstCompletelyVisibleItemPosition();
            if(visibleItemCount==visitFilter.size()-1)
            {
                visitfilter_count.setVisibility(View.INVISIBLE);
            }
            else {
                visitfilter_count.setText("+" + Integer.toString(visitFilter.size() - (visibleItemCount + 2)));
            }
        }
    };


}


