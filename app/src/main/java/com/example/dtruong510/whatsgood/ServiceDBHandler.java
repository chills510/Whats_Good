package com.example.dtruong510.whatsgood;

/**
 * Created by Daniel on 4/10/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ServiceDBHandler extends SQLiteOpenHelper{

    //DATABASE VERSION
    private static final int DATABASE_VERSION = 1;

    //DATABASE NAME
    public static final String DATABASE_NAME = "ServiceDB.db";

    public ServiceDBHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_ServiceDB_TABLE = "CREATE TABLE " + Service.TABLE + "("
                + User.COLUMN_ID + " INTEGER ,"
                + Service.COLUMN_SERVICE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Service.COLUMN_SERVICE_NAME + " TEXT, "
                + Service.COLUMN_SERVICE_DESCRIPTION + " TEXT, "
                + Service.COLUMN_SERVICE_PRICE + " FLOAT, "
                + Service.COLUMN_SERVICE_HOURS + " TEXT, "
                + Service.COLUMN_SERVICE_RATING_PRICE + " INTEGER, "
                + Service.COLUMN_SERVICE_RATING_QUALITY + " INTEGER)";

        db.execSQL(CREATE_ServiceDB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + Service.TABLE);

        //Creates Table Again
        onCreate(db);
    }
}
