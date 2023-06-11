package com.example.software_dev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    Home home=new Home();
    Profile profile=new Profile();
    Booking booking=new Booking();
    Fragment active=home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        bottomNavigationView=findViewById(R.id.bottomnavigationbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,home).addToBackStack("Fragment1").commit();
                return true;
            case R.id.booking:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,booking).addToBackStack("Fragment1").commit();
                return true;
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,profile).addToBackStack("Fragment1").commit();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();

        if (backStackEntryCount > 0) {
            Fragment currentFragment = fragmentManager.findFragmentById(R.id.main_fragment_container);

            if (currentFragment instanceof Booking || currentFragment instanceof Profile) {
                fragmentManager.popBackStack("Fragment1", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                bottomNavigationView.setSelectedItemId(R.id.home);
            } else {
                super.onBackPressed();
            }
        } else {
            Fragment currentFragment = fragmentManager.findFragmentById(R.id.main_fragment_container);

            if (currentFragment instanceof Home) {
                finish();
            } else {
                super.onBackPressed();
            }
        }
    }
}