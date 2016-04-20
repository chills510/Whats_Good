package com.example.dtruong510.whatsgood;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class homepageFragment extends Fragment {

    //ServiceRepo repo = new ServiceRepo(this);

    public homepageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_homepage, container, false);
        ServiceRepo repo = new ServiceRepo(view.getContext());

        List<String> services = new ArrayList<>();
        ArrayList<HashMap<String, String>> servicelist = new ArrayList<>();

        servicelist.addAll(repo.getServiceList());

        ListView newsfeed = (ListView) view.findViewById(R.id.newsFeedView);

        ArrayAdapter<HashMap<String, String>> arrayAdapter = new ArrayAdapter<HashMap<String, String>>
                (view.getContext(), android.R.layout.simple_list_item_1, servicelist);
        newsfeed.setAdapter(arrayAdapter);
        newsfeed.setClickable(true);

        newsfeed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(homepageFragment.this.getActivity(), serviceInfo.class));
            }
        });
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_homepage, container, false);
        return view;
    }

}
