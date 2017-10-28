package com.studio.skyline.dhammapada;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

    public CustomListAdapter(Activity context, String[] sentenceArrayParam) {
        super(context, R.layout.listview_row, sentenceArrayParam);
        this.context = context;
        this.sentenceArray = sentenceArrayParam;
    }

    //this method is used automatically by the app to populate the data into each row
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        //this code gets references to objects in the listview_row.xml file
        //create variables from XML file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.sentenceTextID);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(sentenceArray[position]);

        return rowView;
    }

}
