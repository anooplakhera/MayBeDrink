package com.app.maybedrink.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.maybedrink.R;
import com.app.maybedrink.adapter.HomeAdapter;
import com.app.maybedrink.model.HomeItem;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeAdapter mAdapter;
    private List<HomeItem> dataList;
    //private RecyclerView.LayoutManager mLayoutManager;
    private GridLayoutManager mLayoutManager;

    int height = 0;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/

        dataList = new ArrayList<>();

        dataList.add(new HomeItem("Messages", 1, R.drawable.bubble_icon, 0));
        dataList.add(new HomeItem("Search", 2, R.drawable.search_icon, 0));
        dataList.add(new HomeItem("Shots", 3, R.drawable.shot_icon, 2));

        dataList.add(new HomeItem("Match Maker", 4, R.drawable.match_icon, 0));
        dataList.add(new HomeItem("Mutual Attractions", 5, R.drawable.mutual_icon, 0));
        dataList.add(new HomeItem("My Drinks", 6, R.drawable.tequila_icon, 0));

        dataList.add(new HomeItem("My Videos", 7, R.drawable.video_icon, 0));
        dataList.add(new HomeItem("My Pictures", 8, R.drawable.picture_icon, 5));
        dataList.add(new HomeItem("My Dates", 9, R.drawable.dates_icon, 0));

        dataList.add(new HomeItem("My Favorites", 10, R.drawable.favorite_icon, 0));
        dataList.add(new HomeItem("My Blocks", 11, R.drawable.block_icon, 0));
        dataList.add(new HomeItem("Settings", 12, R.drawable.setting_icon, 0));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        headerView(view);

        recyclerView = view.findViewById(R.id.recyclerView);


        mLayoutManager = new GridLayoutManager(getActivity(), 3);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        final ViewTreeObserver observer= recyclerView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        Log.e("Log", "Height: " + recyclerView.getHeight());
                        if(height == 0){
                            height = recyclerView.getHeight();
                            mAdapter = new HomeAdapter(getContext(), dataList, height);
                            recyclerView.setAdapter(mAdapter);
                        }
                    }
                });

        /*if(height == 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mAdapter = new HomeAdapter(getContext(), dataList, height);
                    recyclerView.setAdapter(mAdapter);
                }
            }, 2000);
        }
        else {
            mAdapter = new HomeAdapter(getContext(), dataList, height);
            recyclerView.setAdapter(mAdapter);
        }*/


        return view;
    }

    public int getRecyclerViewHeight(){

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recyclerView.getLayoutParams();
        return layoutParams.height;
    }

    private void headerView(View view){

        TextView textView = view.findViewById(R.id.titleTextView);
        textView.setText("Dashboard");
        LinearLayout backLayout = view.findViewById(R.id.backLayout);
        backLayout.setVisibility(View.GONE);
        /*backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        ImageView rightImageView = view.findViewById(R.id.rightImageView);
        rightImageView.setVisibility(View.VISIBLE);
        rightImageView.setImageResource(R.drawable.alarm);

    }

}
