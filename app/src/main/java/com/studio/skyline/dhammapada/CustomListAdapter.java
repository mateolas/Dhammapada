package com.studio.skyline.dhammapada;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by aneimat on 28.10.2017.
 */

public class CustomListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;

    //to store the images
    //private final Integer[] imageIDarray;

    //to store the sentence
    private final String[] sentenceArray;
    private String tempString;

    public CustomListAdapter(Activity context, String[] sentenceArrayParam) {
        super(context, R.layout.listview_row, sentenceArrayParam);
        this.context = context;
        this.sentenceArray = sentenceArrayParam;
    }


    //this method is used automatically by the app to populate the data into each row
    public View getView(final int position, View view, ViewGroup parent) {
        final LayoutInflater inflater = context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.listview_row, null, true);
        //this code gets references to objects in the listview_row.xml file
        //create variables from XML file
        final TextView nameTextField = (TextView) rowView.findViewById(R.id.sentenceTextID);
        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(sentenceArray[position]);
        ToggleButton toggleButtonFavourite = (ToggleButton) rowView.findViewById(R.id.toggle__button_favourite);

        toggleButtonFavourite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(context, "Dodano" + sentenceArray[position], Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context, "Usunięto" + sentenceArray[position], Toast.LENGTH_LONG).show();
                }
            }
        });

        //setting a clicklistner on togglebutton
        //toggleButtonFavourite.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View v) {
           //     Toast.makeText(context, sentenceArray[position], Toast.LENGTH_LONG).show();
           // }
        //});


        return rowView;
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return super.getPosition(item);
    }
}
