package com.example.dtruong510.whatsgood;

/**
 * Created by Daniel on 4/10/2016.
 */
public class Service {
    //Table Name
    public static final String TABLE = "service";

    //Table Columns
    public static final String COLUMN_ID = "user_id";
    public static final String COLUMN_SERVICE_ID = "service_id";
    public static final String COLUMN_SERVICE_NAME = "name";
    public static final String COLUMN_SERVICE_PRICE = "price";
    public static final String COLUMN_SERVICE_HOURS = "hours";
    public static final String COLUMN_SERVICE_DESCRIPTION = "description";
    public static final String COLUMN_SERVICE_RATING_PRICE = "price_rating";
    public static final String COLUMN_SERVICE_RATING_QUALITY = "quality_rating";
    public static final String COLUMN_SERVICE_SALE = "sale_check";

    //Data Storage
    public int service_ID;
    public int user_ID;
    public String service_name;
    public float service_price;
    public int service_hours;
    public String service_description;
    public int service_rating_price;
    public int service_rating_quality;
    public boolean sales_check;
}
