package com.example.dtruong510.whatsgood;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class profileFragment extends Fragment{
    private Button logOutButton, createServiceButton;


    public profileFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        logOutButton = (Button)view.findViewById(R.id.logoutBtn);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profileFragment.this.getActivity(), start_up.class));
            }
        });

        createServiceButton = (Button) view.findViewById(R.id.createServiceBtn);
        createServiceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profileFragment.this.getActivity(), disclaimerPage.class));
            }
        });

        return view;





    }
}
