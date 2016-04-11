package com.example.dtruong510.whatsgood;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.usb.UsbAccessory;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;


/**
 * Created by Daniel on 4/10/2016.
 */
public class ServiceRepo {

    private ServiceDBHandler dbHandler;

    public ServiceRepo(Context context)
    {
        dbHandler = new ServiceDBHandler(context);
    }

    public int insert(Service service)
    {
        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Service.COLUMN_ID, service.user_ID);
        values.put(Service.COLUMN_SERVICE_ID, service.service_ID);
        values.put(Service.COLUMN_SERVICE_DESCRIPTION, service.service_description);
        values.put(Service.COLUMN_SERVICE_NAME, service.service_name);
        values.put(Service.COLUMN_SERVICE_HOURS,service.service_hours);
        values.put(Service.COLUMN_SERVICE_PRICE,service.service_price);
        values.put(Service.COLUMN_SERVICE_RATING_PRICE,service.service_rating_price);
        values.put(Service.COLUMN_SERVICE_RATING_QUALITY,service.service_rating_quality);

        //Inserting Row

        long user_id = db.insert(User.TABLE, null, values);
        db.close();
        return (int) user_id;
    }

    public void update(Service service)
    {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Service.COLUMN_ID, service.user_ID);
        values.put(Service.COLUMN_SERVICE_ID, service.service_ID);
        values.put(Service.COLUMN_SERVICE_DESCRIPTION, service.service_description);
        values.put(Service.COLUMN_SERVICE_NAME, service.service_name);
        values.put(Service.COLUMN_SERVICE_HOURS,service.service_hours);
        values.put(Service.COLUMN_SERVICE_PRICE,service.service_price);
        values.put(Service.COLUMN_SERVICE_RATING_PRICE,service.service_rating_price);
        values.put(Service.COLUMN_SERVICE_RATING_QUALITY,service.service_rating_quality);

        db.update(Service.TABLE, values, Service.COLUMN_ID + "= ?", new String[]{String.valueOf(service.user_ID)});
        db.close();
    }

    public ArrayList<HashMap<String, String>> getServiceList()
    {
        //Open connection to read
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        String query = "SELECT " +
                Service.COLUMN_ID + ", " +
                Service.COLUMN_SERVICE_ID + ", " +
                Service.COLUMN_SERVICE_DESCRIPTION +
                Service.COLUMN_SERVICE_NAME + ", " +
                Service.COLUMN_SERVICE_HOURS + ", " +
                Service.COLUMN_SERVICE_PRICE + ", " +
                Service.COLUMN_SERVICE_RATING_PRICE + ", " +
                Service.COLUMN_SERVICE_RATING_QUALITY + ", " +
                " FROM " + Service.TABLE;

        ArrayList<HashMap<String, String>> serviceList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(query, null);

        //loop through all rows and adding

        if(cursor.moveToFirst())
        {
            do{
                HashMap<String, String> service = new HashMap<String, String>();
                service.put("id", cursor.getString(cursor.getColumnIndex(Service.COLUMN_ID)));
                service.put("service id", cursor.getString(cursor.getColumnIndex(Service.COLUMN_SERVICE_ID)));
                service.put("service description", cursor.getString(cursor.getColumnIndex(Service.COLUMN_SERVICE_DESCRIPTION)));
                service.put("service name", cursor.getString(cursor.getColumnIndex(Service.COLUMN_SERVICE_NAME)));
                service.put("service hours", cursor.getString(cursor.getColumnIndex(Service.COLUMN_SERVICE_HOURS)));
                service.put("service price", cursor.getString(cursor.getColumnIndex(Service.COLUMN_SERVICE_PRICE)));
                service.put("service rating price", cursor.getString(cursor.getColumnIndex(Service.COLUMN_SERVICE_RATING_PRICE)));
                service.put("service rating quality", cursor.getString(cursor.getColumnIndex(Service.COLUMN_SERVICE_RATING_QUALITY)));
                serviceList.add(service);
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return serviceList;
    }



    }
