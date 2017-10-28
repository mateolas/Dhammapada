package com.studio.skyline.dhammapada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DhammaChapters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhamma_chapters_list);
    }

    public void onChaptersParyTVclick(View v) {
        Intent myIntent = new Intent(getBaseContext(), Chapter_1_Pary.class);
        startActivity(myIntent);
    }
}
