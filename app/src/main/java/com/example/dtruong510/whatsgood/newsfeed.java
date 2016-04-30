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
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class newsfeed extends AppCompatActivity {
    ServiceRepo repo = new ServiceRepo(this);
    Service serviceClass = new Service();

    private ImageButton logoBtn, salesBtn, serviceBtn, refreshBtn;
    public TextView username;
    private SearchView searchbtn;
    public String searchWord, passEmail, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);

        Bundle extras = getIntent().getExtras();
        username = (TextView) findViewById(R.id.ProfileBtn);
        username.setText(extras.getString("getEmail"));


        //List<String> services = new ArrayList<>();


        searchbtn = (SearchView) findViewById(R.id.search);

        refreshBtn = (ImageButton) findViewById(R.id.Logo);
        refreshBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ArrayList<HashMap<String, String>> servicelist = new ArrayList<>();


                servicelist.addAll(repo.getServiceList());

                    if(servicelist != null)
                    {

                    HashMap<String, String> listofservice = new HashMap<String, String>();

                    String servicename = Service.COLUMN_SERVICE_NAME;
                    String serviceprice = Service.COLUMN_SERVICE_PRICE;

                    listofservice.put("service name", servicename);
                    listofservice.put("sevice price", serviceprice);

                    servicelist.add(listofservice);

                    }
                    String[] from = {"service name", "service price"};
                    int[] to = {R.id.service_name,R.id.price_value};

                    ListView newsfeed = (ListView) findViewById(R.id.newsfeed);
                    //TextView textView = (TextView) findViewById(R.id.service_name);
                    //TextView textView1 = (TextView) findViewById(R.id.price_value);

                    //ArrayAdapter<HashMap<String, String>> arrayAdapter = new ArrayAdapter<>(newsfeed.this, android.R.layout.simple_list_item_1, R.id.service_name, servicelist);
                    //ArrayAdapter<HashMap<String, String>> arrayAdapter = new ArrayAdapter<>(newsfeed.this, R.layout.content_newsfeed_display, from, to);
                    ListAdapter adapter = new SimpleAdapter(newsfeed.this, servicelist, R.layout.content_newsfeed_display, from, to);
                    newsfeed.setAdapter(adapter);
                    newsfeed.setClickable(true);

                    newsfeed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            startActivity(new Intent(newsfeed.this, serviceInfo.class));
                        }
                    });
                }
            //}
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
            public void onClick(View v) {
                ArrayList<HashMap<String, String>> saleslist = new ArrayList<>();

                saleslist.addAll(repo.getSalesList());

                if (saleslist != null) {

                    HashMap<String, String> listofservice = new HashMap<String, String>();

                    String servicename = Service.COLUMN_SERVICE_NAME;
                    String serviceprice = Service.COLUMN_SERVICE_PRICE;

                    listofservice.put("service name", servicename);
                    listofservice.put("sevice price", serviceprice);

                    saleslist.add(listofservice);
                }

                String[] from = {"service name", "service price"};
                int[] to = {R.id.service_name, R.id.price_value};

                final ListView newsfeed = (ListView) findViewById(R.id.newsfeed);

                //TextView textView = (TextView) findViewById(R.id.service_name);
                //TextView textView1 = (TextView) findViewById(R.id.price_value);

                //ArrayAdapter<HashMap<String, String>> arrayAdapter = new ArrayAdapter<>(newsfeed.this, android.R.layout.simple_list_item_1, R.id.service_name, servicelist);
                //ArrayAdapter<HashMap<String, String>> arrayAdapter = new ArrayAdapter<>(newsfeed.this, R.layout.content_newsfeed_display, from, to);
                ListAdapter adapter = new SimpleAdapter(newsfeed.this, saleslist, R.layout.content_newsfeed_display, from, to);
                newsfeed.setAdapter(adapter);
                newsfeed.setClickable(true);

                newsfeed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //data = (String) parent.getItemAtPosition(position);
                        //Intent intent = new Intent(newsfeed.this, serviceInfo.class);
                        //intent.putExtra("servicedata", data);
                        startActivity(new Intent(newsfeed.this, serviceInfo.class));
                    }
                });
            }
        });
    }

}