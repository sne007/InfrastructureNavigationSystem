package com.example.android.testnavandmaps2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by snehith on 22/11/16.
 */

public class FiltersActivity extends Fragment {

    SendMessage SM;
    Button button;
    interface SendMessage{
        public void sendData(String message);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v;

        v =  inflater.inflate(R.layout.fragment_filters, container, false);
        button = (Button) v.findViewById(R.id.apply_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new MapsActivity();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return v;
    }
/*
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            SM = (SendMessage)context;
        }
        catch (ClassCastException e){
            throw new ClassCastException("You need to implement SendData Methods");
        }

    }
    */
}
