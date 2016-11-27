package com.example.android.testnavandmaps2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static android.widget.Toast.LENGTH_LONG;


/**
 * Created by snehith on 22/11/16.
 */

public class MapsActivity extends Fragment {

    private static final int PLACE_PICKER_REQUEST = 1;
    GoogleMap googleMap;
    MapView mMapView;
    private GoogleApiClient mGoogleApiClient;
    boolean colorCoded = false;



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    public MapsActivity(){
        // Required empty public constructor
    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

      //      String strtext = this.getArguments().getString("edttext");
      //      Toast.makeText(getContext(), strtext, LENGTH_LONG).show();
      //      System.out.println(strtext);

            mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                googleMap.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                LatLng raipur = new LatLng(21.259651, 81.617697);
                LatLng raipur1 = new LatLng(19.259651, 86.617697);
                LatLng raipur2= new LatLng(9.259651, 92.617697);
                LatLng raipur3 = new LatLng(31.259651, 54.617697);
                LatLng raipur4 = new LatLng(26.259651, 80.617697);
                LatLng raipur5 = new LatLng(24.259651, 87.617697);
                LatLng raipur6 = new LatLng(25.259651, 84.617697);

/*
                MarkerOptions marker = new MarkerOptions().position(raipur).title("Marker Title").snippet("Marker Description");
                googleMap.addMarker(marker);
*/
                googleMap.addMarker(new MarkerOptions()
                        .position(raipur)
                        .title("Sydney")
                        .snippet("Population: 4,627,300")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.bridge)));

                googleMap.addMarker(new MarkerOptions()
                        .position(raipur1)
                        .title("Sydney")
                        .snippet("Population: 4,627,300")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.bridge)));

                googleMap.addMarker(new MarkerOptions()
                        .position(raipur2)
                        .title("Sydney")
                        .snippet("Population: 4,627,300")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.bridge)));
                googleMap.addMarker(new MarkerOptions()
                        .position(raipur3)
                        .title("Sydney")
                        .snippet("Population: 4,627,300")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.bridge)));
                googleMap.addMarker(new MarkerOptions()
                        .position(raipur4)
                        .title("Sydney")
                        .snippet("Population: 4,627,300")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.bridge)));
                googleMap.addMarker(new MarkerOptions()
                        .position(raipur5)
                        .title("Sydney")
                        .snippet("Population: 4,627,300")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.bridge)));
                googleMap.addMarker(new MarkerOptions()
                        .position(raipur6)
                        .title("Sydney")
                        .snippet("Population: 4,627,300")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.bridge)));


                TextView tv = (TextView) getActivity().findViewById(R.id.testView);
                Toast.makeText(getContext(),tv.getText(),Toast.LENGTH_SHORT).show();

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(raipur).zoom(7).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });


            return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }



}
