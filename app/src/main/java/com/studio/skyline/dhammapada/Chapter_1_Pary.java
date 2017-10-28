package com.studio.skyline.dhammapada;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Chapter_1_Pary extends AppCompatActivity {

    String[] sentenceArray =
            {"1. Zdanie 1",
                    "2. Zdanie 2",
                    "3. Zdanie 3"
            };

    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_1__pary);

        //creating an instance of CustomListAdpater
        //feeding data arrays into it
        //tell ListView to use in

        //creates an instance of our CustomListAdapter and gives the data arrays as a parameter
        CustomListAdapter whatever = new CustomListAdapter(this,sentenceArray);

        //gets a reference to the actual ListView object from the activity_chapter_1_pary
        listView = (ListView)findViewById(R.id.lv_Rozdzial1_Pary);

        //tells the ListView to use our adapter
        listView.setAdapter(whatever);
    }


    //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    //setSupportActionBar(toolbar);

    //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    //fab.setOnClickListener(new View.OnClickListener() {
    //    @Override
    //    public void onClick(View view) {
    //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
    //               .setAction("Action", null).show();
    //   }
    //});
}

