package com.example.dtruong510.whatsgood;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.support.v4.app.FragmentManager;
import android.widget.ListView;
import android.widget.SearchView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class homepage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    NavigationView navigationView;
    private Button logOutButton, createServiceButton;
    ServiceRepo repo = new ServiceRepo(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout =(DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);


        //******SERVICE DATABASE DISPLAY******

        List<String> services = new ArrayList<>();
        ArrayList<HashMap<String, String>> servicelist = new ArrayList<>();

        servicelist.addAll(repo.getServiceList());


        ListView newsfeed = (ListView) findViewById(R.id.newsFeed);

        ArrayAdapter<HashMap<String, String>> arrayAdapter = new ArrayAdapter<HashMap<String, String>>(this, android.R.layout.simple_list_item_1, servicelist);
        newsfeed.setAdapter(arrayAdapter);
        newsfeed.setClickable(true);


        /******UNCOMMENT TO DISPLAY******/


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new homepageFragment());
        fragmentTransaction.commit();
        //getSupportActionBar().setTitle("Homepage");
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new homepageFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Hompage");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();

                        break;

                    case R.id.profile_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new profileFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Profile");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();


                        break;

                    case R.id.serviceView_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new serviceFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Services");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();


                        break;

                    case R.id.salesView_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new salesFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Sales");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();


                        break;

                }
                return false;
            }
        });


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }



    /*@Override
    public void quickSearchBtn()
    {
        Intent intent = getIntent();
        if(Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //DoSearchQueryFunction(query)
        }
    }*/
}