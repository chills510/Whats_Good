package com.example.dtruong510.whatsgood;

/**
 * Created by chueyee on 4/6/16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDBHandler extends SQLiteOpenHelper{

    //DATABASE VERSION
    private static final int DATABASE_VERSION = 1;

    //DATABASE NAME
    private static final String DATABASE_NAME = "UserDB";

    public UserDBHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_UserDB_TABLE = "CREATE TABLE " + User.TABLE + "("
                + User.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + User.COLUMN_EMAIL + " TEXT, "
                + User.COLUMN_PASSWORD + " TEXT)";

        db.execSQL(CREATE_UserDB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE);

        //Creates Table Again
        onCreate(db);
    }

}
