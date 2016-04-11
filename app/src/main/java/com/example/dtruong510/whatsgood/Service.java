package com.example.dtruong510.whatsgood;

/**
 * Created by Daniel on 4/10/2016.
 */
public class Service {
    //Table Name
    public static final String TABLE = "service";

    //Table Columns
    public static final String COLUMN_ID = "user id";
    public static final String COLUMN_SERVICE_ID = "service id";
    public static final String COLUMN_SERVICE_NAME = "email";
    public static final String COLUMN_SERVICE_PRICE = "password";
    public static final String COLUMN_SERVICE_HOURS = "hours";
    public static final String COLUMN_SERVICE_DESCRIPTION = "description";
    public static final String COLUMN_SERVICE_RATING_PRICE = "price rating";
    public static final String COLUMN_SERVICE_RATING_QUALITY = "quality rating";

    //Data Storage
    public int service_ID;
    public int user_ID;
    public String service_name;
    public int service_price;
    public int service_hours;
    public String service_description;
    public int service_rating_price;
    public int service_rating_quality;
}
