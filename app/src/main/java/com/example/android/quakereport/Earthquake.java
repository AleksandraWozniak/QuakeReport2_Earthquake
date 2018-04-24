package com.example.android.quakereport;

/**
 * Created by Ola on 21.04.2018.
 */

public class Earthquake {
    // Location of the earthquake
    private String mEarthquakePlace;

    // Magnitude of the earthquake
    private double mEarthquakeMagnitude;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    /** Website URL of the earthquake */
    private String mUrl;

    /// Constructor of a new earthquake object
    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param earthquakeMagnitude is the magnitude (size) of the earthquake
     * @param earthquakePlace is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the earthquake happened
     * @param url is the website URL to find more details about the earthquake
     */
    public Earthquake(String earthquakePlace, double earthquakeMagnitude, Long timeInMilliseconds, String url){
        mEarthquakePlace = earthquakePlace;
        mEarthquakeMagnitude = earthquakeMagnitude;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    // public getter methods so that each data type is returned

    /** Returns the location of the earthquake. */
    public String getMyEarthquakePlace(){
        return mEarthquakePlace;
    }

    /** Returns the magnitude of the earthquake. */
    public double getMyEarthquakeMagnitude(){
        return mEarthquakeMagnitude;
    }

    /** Returns the time of the earthquake.*/
    public long getMyEarthquakeTime(){
        return mTimeInMilliseconds;
    }

    /** Returns the website URL to find more information about the earthquake. */
    public String getMyUrl(){
        return mUrl;
    }
}
