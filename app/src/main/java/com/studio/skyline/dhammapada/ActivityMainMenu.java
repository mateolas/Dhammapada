package com.studio.skyline.dhammapada;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class ActivityMainMenu extends AppCompatActivity implements
        Fragment_Ustawienia.OnFragmentInteractionListener,
        Fragment_Ulubione.OnFragmentInteractionListener,
        Fragment_Info.OnFragmentInteractionListener
{


      private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        //creates a new variable of class Fragment, which will store the current fragment
        Fragment selectedFragment = null;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_ustawienia:
                    //new variable of class FragmentTransaction
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().addToBackStack("Frag");
                                                //In variable selectedFragment we store an instance of our FirstFragment
                    selectedFragment = Fragment_Ustawienia.newInstance("1","1");
                    //replace MainActivqity with Fragment
                    transaction.replace(R.id.activity_main, selectedFragment);
                    transaction.commit();
                    return true;

                case R.id.navigation_ulubione:
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction().addToBackStack("Frag");
                    selectedFragment = Fragment_Ulubione.newInstance("1","1");
                    transaction2.replace(R.id.activity_main, selectedFragment);
                    transaction2.commit();
                    return true;

                case R.id.navigation_info:
                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction().addToBackStack("Frag");
                    selectedFragment = Fragment_Info.newInstance("1","1");
                    transaction3.replace(R.id.activity_main, selectedFragment);
                    transaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //transaction.replace(R.id.container, FirstFragment.newInstance("What","Ever"));
        //transaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void onDhammapadaTVclick(View v){
        Intent myIntent = new Intent(getBaseContext(), ActivityChapters.class);
        startActivity(myIntent);
    }



    @Override
    public void onBackPressed()
    {
        //It will remove the fragment from the activity if it is added and if it isn't
        //then the back button will act as normal and destroy the activitiy
        if (getSupportFragmentManager().findFragmentByTag("Frag") != null) {
            getSupportFragmentManager().popBackStackImmediate("Frag",0);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
