package com.example.intive_fdv.ui.details_user;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.intive_fdv.R;
import com.example.intive_fdv.models.User;
import com.example.intive_fdv.utils.CheckRealConnection;
import com.example.intive_fdv.utils.UtilsImage;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsUserActivity extends AppCompatActivity implements OnMapReadyCallback {

    private User user;
    private CircleImageView imageProfile;
    private TextView txtEmail, txtPhone, txtCell, txtNat, txtGender, txtName;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_user);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.details_user));
        Bundle extras = getIntent().getExtras();
        user = (User) extras.getSerializable(User.tagUser);
        imageProfile = (CircleImageView) findViewById(R.id.imageProfile);
        txtName = (TextView) findViewById(R.id.txtName);
        txtGender = (TextView) findViewById(R.id.txtGender);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtCell = (TextView) findViewById(R.id.txtCel);
        txtNat = (TextView) findViewById(R.id.txtNat);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        initView(user);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        LatLng ny = new LatLng(Double.valueOf(user.getLocation().getCoordinates().getLatitude()),
                                Double.valueOf(user.getLocation().getCoordinates().getLongitude()));

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(ny);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ny));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initView(User user) {

        txtName.setText(user.getName().getFirst()+" "+user.getName().getLast());
        txtGender.setText(getString(R.string.gender)+" "+user.getGender());
        txtEmail.setText(getString(R.string.email)+" "+user.getEmail());
        txtPhone.setText(getString(R.string.phone)+" "+user.getPhone());
        txtCell.setText(getString(R.string.cell)+" "+user.getCell());
        txtNat.setText(getString(R.string.nat)+" "+user.getNat());

        new CheckRealConnection(this, new CheckRealConnection.OnCheckConnection() {
            @Override
            public void whileLoad() {

            }

            @Override
            public void onPostConnection(boolean success) {
                if(success){
                    UtilsImage.loadImage(DetailsUserActivity.this, user.getPicture().getLarge(), imageProfile);
                }
            }
        });
    }


}
