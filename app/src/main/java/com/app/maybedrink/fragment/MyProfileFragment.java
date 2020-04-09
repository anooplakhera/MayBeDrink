package com.app.maybedrink.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.maybedrink.MainActivity;
import com.app.maybedrink.R;
import com.app.maybedrink.adapter.HomeAdapter;
import com.app.maybedrink.model.HomeItem;

import java.util.ArrayList;
import java.util.List;


public class MyProfileFragment extends Fragment {


    public MyProfileFragment() {
        // Required empty public constructor
    }

    public static MyProfileFragment newInstance() {
        MyProfileFragment fragment = new MyProfileFragment();
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_myprofile, container, false);
        headerView(view);

        return view;
    }

    private void headerView(View view){

        TextView textView = view.findViewById(R.id.titleTextView);
        textView.setText("My profile");
        LinearLayout backLayout = view.findViewById(R.id.backLayout);
        //backLayout.setVisibility(View.GONE);
        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).loadFragmentByName("home");
            }
        });

        /*ImageView rightImageView = view.findViewById(R.id.rightImageView);
        rightImageView.setVisibility(View.VISIBLE);
        rightImageView.setImageResource(R.drawable.alarm);*/

    }

}
