package com.example.paynav_assignment.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static com.example.paynav_assignment.Adapters.Freq_grid_adapter.photos;
import static com.example.paynav_assignment.Adapters.Freq_grid_adapter.bottomsheet_state;


import com.example.paynav_assignment.Adapters.Freq_grid_adapter;
import com.example.paynav_assignment.Adapters.Recents_grid;
import com.example.paynav_assignment.Adapters.ReturnReceiveAdapter;
import com.example.paynav_assignment.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    GridView frequently_contact_grid;
    GridView recents_grid;
    public static BottomSheetBehavior bottomSheetBehavior;
    RelativeLayout relativeLayout;
    FrameLayout sheet;

    CoordinatorLayout main;

    ImageView toolbar_back_btn;
    ImageView bottom_sheet_up_btn;

    LinearLayout linearLayout;
    Freq_grid_adapter freq_grid_adapter;

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ReturnReceiveAdapter returnReceiveAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomsheet_state = true;

        initalize();

        return_receive_viewpager();

        bottomSheet();


    }


    private void initalize() {

        // TOOL BAR
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);



        // initalizations
        linearLayout = findViewById(R.id.refer_bottom_sheet);
        relativeLayout = findViewById(R.id.name_column);
        toolbar_back_btn = findViewById(R.id.toolbar_back_btn);
        bottom_sheet_up_btn = findViewById(R.id.bottom_sheet_up_btn);
        toolbar_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        main = findViewById(R.id.main);
        sheet = findViewById(R.id.sheet);
    }


    private void bottomSheet() {
        View sheet = findViewById(R.id.sheet);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.bottomsheet_shape_collapsed, null);
        Drawable drawable1 = ResourcesCompat.getDrawable(getResources(), R.drawable.bottomsheet_shape_expanded, null);
        //Drawable drawable = getResources().getDrawable(R.drawable.bottomsheet_shape_collapsed);
        //Drawable drawable1 = getResources().getDrawable(R.drawable.bottomsheet_shape_expanded);


        bottomSheetBehavior = BottomSheetBehavior.from(sheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        //bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setPeekHeight(150);
        bottomSheetBehavior.setDraggable(false);
        bottom_sheet_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        // this is for making the bottom sheet length exact same, independent of display length
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int height = main.getHeight() - (linearLayout.getTop() + (linearLayout.getHeight()/2)) ;
                ViewGroup.LayoutParams params = sheet.getLayoutParams();
                // Changes the height and width to the specified *pixels*
                params.height = height;
                //params.width = 100;
                sheet.setLayoutParams(params);


            }
        }, 20);



        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState == BottomSheetBehavior.STATE_COLLAPSED){
                    sheet.setBackground(drawable);
                    bottom_sheet_up_btn.setVisibility(View.VISIBLE);
                    photos[4] = R.mipmap.e;
                    bottomsheet_state = false;
                    freq_grid_adapter.notifyDataSetChanged();
                }
                if(newState == BottomSheetBehavior.STATE_EXPANDED){
                    sheet.setBackground(drawable1);
                    bottom_sheet_up_btn.setVisibility(View.INVISIBLE);
                    photos[4] = R.drawable.arrow_down_24;
                    bottomsheet_state = true;
                    freq_grid_adapter.notifyDataSetChanged();
                }
                if(newState == BottomSheetBehavior.STATE_DRAGGING){
                    sheet.setBackground(drawable1);
                    bottom_sheet_up_btn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                frequently_contact_grid = findViewById(R.id.frequently_contact_grid);
                frequently_contact_grid.setAdapter(freq_grid_adapter = new Freq_grid_adapter(getApplicationContext()));

                recents_grid = findViewById(R.id.recents_grid);
                recents_grid.setAdapter(new Recents_grid(getApplicationContext()));


            }
        }, 50);
//        frequently_contact_grid = findViewById(R.id.frequently_contact_grid);
//        frequently_contact_grid.setAdapter(freq_grid_adapter = new Freq_grid_adapter(this));
//
//        recents_grid = findViewById(R.id.recents_grid);
//        recents_grid.setAdapter(new Recents_grid(this));
    }

    private void return_receive_viewpager() {


        tabLayout = findViewById(R.id.return_receive_tab);
        viewPager2 = findViewById(R.id.return_receive_viewpager);

        FragmentManager fm = getSupportFragmentManager();
        returnReceiveAdapter = new ReturnReceiveAdapter(fm, getLifecycle());
        viewPager2.setAdapter(returnReceiveAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("return"));
        tabLayout.addTab(tabLayout.newTab().setText("receive"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}