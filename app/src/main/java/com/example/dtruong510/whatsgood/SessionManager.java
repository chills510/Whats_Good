package com.example.dtruong510.whatsgood;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ChueYee on 4/27/2016.
 */
public class SessionManager
{
    public void setPreferences(Context context, String key, String value)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("users", Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getPreferences(Context context, String key)
    {
        SharedPreferences prefs = context.getSharedPreferences("users", Context.MODE_PRIVATE);
        String position = prefs.getString(key, "");

        return position;
    }
}
