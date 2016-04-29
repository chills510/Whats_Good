package com.example.dtruong510.whatsgood;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class newsfeed extends AppCompatActivity {
    ServiceRepo repo = new ServiceRepo(this);

    private ImageButton logoBtn, salesBtn, serviceBtn, refreshBtn;
    public TextView username;
    private SearchView searchbtn;
    public String searchWord, passEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);

        Bundle extras = getIntent().getExtras();
        username = (TextView) findViewById(R.id.ProfileBtn);
        username.setText(extras.getString("getEmail"));


        List<String> services = new ArrayList<>();


        searchbtn = (SearchView) findViewById(R.id.search);

        refreshBtn = (ImageButton) findViewById(R.id.Logo);
        refreshBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ArrayList<HashMap<String, String>> servicelist = new ArrayList<>();

                servicelist.addAll(repo.getServiceList());

                if(servicelist != null) {

                    ListView newsfeed = (ListView) findViewById(R.id.newsfeed);

                    ArrayAdapter<HashMap<String, String>> arrayAdapter = new ArrayAdapter<>(newsfeed.this, android.R.layout.simple_list_item_1, servicelist);
                    newsfeed.setAdapter(arrayAdapter);
                    newsfeed.setClickable(true);

                    newsfeed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            startActivity(new Intent(newsfeed.this, serviceInfo.class));
                        }
                    });
                }
            }
        });

        username = (TextView) findViewById(R.id.ProfileBtn);

        username.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                passEmail = username.getText().toString();
                Intent intent = new Intent(newsfeed.this, profilePage.class);
                intent.putExtra("getEmail", passEmail);
                startActivity(intent);
            }
        });

        serviceBtn = (ImageButton) findViewById(R.id.ServiceBtn);
        serviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(newsfeed.this, createService.class));
            }
        });

        salesBtn = (ImageButton) findViewById(R.id.SalesBtn);
        salesBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ArrayList<HashMap<String, String>> saleslist = new ArrayList<>();

                saleslist.addAll(repo.getSalesList());

                if(saleslist != null) {

                    ListView newsfeed = (ListView) findViewById(R.id.newsfeed);

                    ArrayAdapter<HashMap<String, String>> arrayAdapter = new ArrayAdapter<>(newsfeed.this, android.R.layout.simple_list_item_1, saleslist);
                    newsfeed.setAdapter(arrayAdapter);
                    newsfeed.setClickable(true);

                    newsfeed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            startActivity(new Intent(newsfeed.this, serviceInfo.class));
                        }
                    });
                }
            }
        });
    }

}

