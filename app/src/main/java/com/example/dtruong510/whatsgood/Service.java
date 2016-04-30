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
    public String service_price;
    public int service_hours;
    public String service_description;
    public int service_rating_price;
    public int service_rating_quality;
    public boolean sales_check;

    private int sID, uID, sHours, sRatingPrice, sRatingQuality;
    private String sPrice;
    private String sName, sDescription;
    private boolean sSales;


    public void setSID(int service_ID)
    {
        this.sID = service_ID;
    }

    public int getSID()
    {
        return this.sID;
    }

    public void setUID(int user_ID)
    {
        this.uID = user_ID;
    }

    public int getUID()
    {
        return this.uID;
    }

    public void setSName(String service_name)
    {
        this.sName = service_name;
    }

    public String getSName()
    {
        return this.sName;
    }

    public void setSPrice(String service_price)
    {
        this.sPrice = service_price;
    }

    public String getSPrice()
    {
        return this.sPrice;
    }

    public void setSHours(int service_hours)
    {
        this.sHours = service_hours;
    }

    public int getSHours()
    {
        return this.sHours;
    }

    public void setSDescriptions(String service_description)
    {
        this.sDescription = service_description;
    }

    public String getsDescription()
    {
        return this.sDescription;
    }

    public void setPriceRating(int service_rating_price)
    {
        this.sRatingPrice = service_rating_price;
    }

    public int getPriceRating()
    {
        return this.sRatingPrice;
    }

    public void setQualityRating(int service_rating_quality)
    {
        this.sRatingQuality = service_rating_quality;
    }

    public int getQualityRating()
    {
        return this.sRatingQuality;
    }

    public void setSalesCheck(boolean sales_check)
    {
        this.sSales = sales_check;
    }

    public boolean getSalesCheck()
    {
        return this.sSales;
    }
}
