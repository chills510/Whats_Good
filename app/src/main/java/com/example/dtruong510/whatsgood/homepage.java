package com.example.dtruong510.whatsgood;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.List;

public class homepage extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView l;

    String[] services = {"Renes haircuts", "Cakes and Bakes", "Lawn Mowing", "Donut Delivery", "Maid Service", "Mechanic"
    , "I Sell Boba"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        l = (ListView) findViewById(R.id.theListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, services);
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);




    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView temp = (TextView) view;
        Toast.makeText(this,temp.getText() + "",Toast.LENGTH_SHORT).show();
    }
}