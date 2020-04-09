package com.app.maybedrink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.app.maybedrink.fragment.HomeFragment;
import com.app.maybedrink.fragment.MyProfileFragment;
import com.app.maybedrink.fragment.MyProfileStep1Fragment;
import com.app.maybedrink.fragment.MyProfileStep2Fragment;
import com.app.maybedrink.fragment.MyProfileStep3Fragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout bottomLayout5;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        bottomLayout5 = findViewById(R.id.bottomLayout5);



        fragment = new HomeFragment();
        loadFragment(fragment);

        bottomClick();
    }

    private void bottomClick(){
        bottomLayout5.setOnClickListener(v -> {
            fragment = new MyProfileFragment();
            loadFragment(fragment);
        });
    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {

            clearBackStackInclusive("Home");

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.content_frame, fragment, "Home");
            ft.addToBackStack("Home");
            ft.commit();
        }
    }
    public void clearBackStackInclusive(String tag) {
        try {
            getSupportFragmentManager().popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadFragmentByName(String fragName){

        if(fragName.equalsIgnoreCase("home")){
            fragment = new HomeFragment();
        }
        else if(fragName.equalsIgnoreCase("myProfile")){
            fragment = new MyProfileFragment();
        }
        else if(fragName.equalsIgnoreCase("myProfileStep1")){
            fragment = new MyProfileFragment();
        }
        else if(fragName.equalsIgnoreCase("myProfileStep2")){
            fragment = new MyProfileFragment();
        }
        else if(fragName.equalsIgnoreCase("myProfileStep3")){
            fragment = new MyProfileFragment();
        }
        else{
            fragment = new HomeFragment();
        }

        loadFragment(fragment);
    }

    @Override
    public void onBackPressed()
    {
        if(fragment instanceof MyProfileFragment){
            loadFragmentByName("home");
        }
        else if(fragment instanceof MyProfileStep1Fragment){
            loadFragmentByName("myProfile");
        }
        else if(fragment instanceof MyProfileStep2Fragment){
            loadFragmentByName("myProfileStep1");
        }
        else if(fragment instanceof MyProfileStep3Fragment){
            loadFragmentByName("myProfileStep2");
        }
        else {
            clearBackStackInclusive("Home");
            super.onBackPressed();
        }
    }

}
