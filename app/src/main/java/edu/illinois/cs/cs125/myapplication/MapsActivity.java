package edu.illinois.cs.cs125.myapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.UiSettings;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_settings);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(40.113, -88.26);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Champaign"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mUiSettings = mMap.getUiSettings();

        // Keep the UI Settings state in sync with the checkboxes.
        mUiSettings.setZoomControlsEnabled(isChecked(R.id.zoom_buttons_toggle));
        mUiSettings.setScrollGesturesEnabled(isChecked(R.id.scroll_toggle));
        mUiSettings.setRotateGesturesEnabled(isChecked(R.id.rotate_toggle));
        mUiSettings.setCompassEnabled(isChecked(R.id.compass_toggle));

    }

    private UiSettings mUiSettings;



    private boolean isChecked(int id) {
        return ((CheckBox) findViewById(id)).isChecked();
    }

    private boolean checkReady() {
        if (mMap == null) {
            Toast.makeText(this, R.string.map_not_ready, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    public void setZoomButtonsEnabled(View v) {
        if (!checkReady()) {
            return;
        }
        mUiSettings.setZoomControlsEnabled(((CheckBox) v).isChecked());
    }

    public void setScrollGesturesEnabled(View v) {
        if (!checkReady()) {
            return;
        }
        mUiSettings.setScrollGesturesEnabled(((CheckBox) v).isChecked());
    }

    public void setCompassEnabled(View v) {
        if (!checkReady()) {
            return;
        }
        mUiSettings.setCompassEnabled(((CheckBox) v).isChecked());
    }
    public void setRotateGesturesEnabled(View v) {
        if (!checkReady()) {
            return;
        }
        mUiSettings.setRotateGesturesEnabled(((CheckBox) v).isChecked());
    }
}
