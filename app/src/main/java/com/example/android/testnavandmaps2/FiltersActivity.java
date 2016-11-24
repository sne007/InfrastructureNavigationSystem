package com.example.android.testnavandmaps2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;


/**
 * Created by snehith on 22/11/16.
 */

public class FiltersActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnConnectionFailedListener {

    private static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 2;
    Button button;
    boolean applyClicked = false;
    boolean checked = false;
    private GoogleApiClient mGoogleApiClient;
    int PLACE_PICKER_REQUEST = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_filters);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = (Button) findViewById(R.id.apply_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                DataObject data = new DataObject();
                CheckBox checkBox = (CheckBox) findViewById(R.id.ColorCoded_checkBox);
                if (checkBox.isChecked()){
                    data.setName("isChecked");
                }
//                data.setFavoriteWord(button.getText().toString());
                resultIntent.putExtra("data", data);
                setResult(RESULT_OK,resultIntent);
                finish();

            }
        });

        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seek_bar_investment);
        seekBar1.setMax(1000000000);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(getApplicationContext(),"progress is "+i,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button button2 = (Button) findViewById(R.id.clear_button);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


            }
        });


    }

/*
    public void test() throws GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
    }
*/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
