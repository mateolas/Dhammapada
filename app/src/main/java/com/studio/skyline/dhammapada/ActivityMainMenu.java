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
import android.widget.TextView;

public class ActivityMainMenu extends AppCompatActivity implements
        Fragment_Ustawienia.OnFragmentInteractionListener,
        Fragment_Ulubione.OnFragmentInteractionListener,
        Fragment_Info.OnFragmentInteractionListener
{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        //creates a new variable of class Fragment, which will store the current fragment
        Fragment selectedFragment = null;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_ustawienia:
                    //new variable of class FragmentTransaction
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    //In variable selectedFragment we store an instance of our FirstFragment
                    selectedFragment = Fragment_Ustawienia.newInstance("1","2");
                    //replace MainActivqity with Fragment
                    transaction.replace(R.id.activity_main, selectedFragment);
                    transaction.commit();
                    return true;

                case R.id.navigation_ulubione:
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = Fragment_Ulubione.newInstance("3","4");
                    transaction2.replace(R.id.activity_main, selectedFragment);
                    transaction2.commit();
                    return true;

                case R.id.navigation_info:
                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = Fragment_Info.newInstance("5","6");
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
        Intent myIntent = new Intent(getBaseContext(), ActivityDhammaChapters.class);
        startActivity(myIntent);
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
