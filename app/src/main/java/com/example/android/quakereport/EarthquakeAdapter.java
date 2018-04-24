package com.example.android.quakereport;

import android.app.Activity;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.w3c.dom.Text;
import android.graphics.drawable.GradientDrawable;

import java.util.ArrayList;

/**
 * Created by Ola on 21.04.2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context,0,earthquakes);
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double mag){
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(mag);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);

            Earthquake currentEarthquake = getItem(position);

            String location = currentEarthquake.getMyEarthquakePlace();
            String locationPartOne;
            String locationPartTwo;

            if (location.contains(LOCATION_SEPARATOR)){
                String[] parts = location.split(LOCATION_SEPARATOR);
                locationPartOne = parts[0] + LOCATION_SEPARATOR;
                locationPartTwo = parts[1];
            } else {
                locationPartOne = "Near of";
                locationPartTwo = location;
            }

            double mag = currentEarthquake.getMyEarthquakeMagnitude();

            TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
            magnitude.setText(formatMagnitude(mag));

            TextView placePartOne = (TextView) listItemView.findViewById(R.id.location_offset);
            placePartOne.setText(locationPartOne);

            TextView placePartTwo = (TextView) listItemView.findViewById(R.id.primary_location);
            placePartTwo.setText(locationPartTwo);

            Date dateObject = new Date(currentEarthquake.getMyEarthquakeTime());

            TextView time = (TextView) listItemView.findViewById(R.id.time);
            time.setText(formatTime(dateObject));

            TextView date = (TextView) listItemView.findViewById(R.id.date);
            date.setText(formatDate(dateObject));

            // Set the proper background color on the magnitude circle.
            // Fetch the background from the TextView, which is a GradientDrawable.
            GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

            // Get the appropriate background color based on the current earthquake magnitude
            int magnitudeColor = getMagnitudeColor(currentEarthquake.getMyEarthquakeMagnitude());

            // Set the color on the magnitude circle
            magnitudeCircle.setColor(magnitudeColor);

        }
        return listItemView;
    }
}
