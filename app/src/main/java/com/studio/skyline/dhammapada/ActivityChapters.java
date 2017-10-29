package com.studio.skyline.dhammapada;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class ActivityChapters extends AppCompatActivity implements
    Fragment_Ulubione.OnFragmentInteractionListener
{



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        //creates a new variable of class Fragment, which will store the current fragment
        Fragment selectedFragment = null;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_chapters_glowna:
                    Intent myIntent = new Intent(getBaseContext(), ActivityMainMenu.class);
                    startActivity(myIntent);
                    return true;

                case R.id.navigation_chapters_ulubione:

                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction().addToBackStack("Frag2");
                    selectedFragment = Fragment_Ulubione.newInstance("1","1");
                    transaction2.replace(R.id.activity_spis_tresci, selectedFragment);
                    transaction2.commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters_list);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onBackPressed()
    {
        //It will remove the fragment from the activity if it is added and if it isn't
        //then the back button will act as normal and destroy the activitiy
        if (getSupportFragmentManager().findFragmentByTag("Frag2") != null) {
            getSupportFragmentManager().popBackStackImmediate("Frag2",0);
        } else {
            super.onBackPressed();
        }
    }

    public void onChaptersParyTVclick(View v) {
        Intent myIntent = new Intent(getBaseContext(), ActivityChapter1Pary.class);
        startActivity(myIntent);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
