package com.example.intive_fdv.ui.details_user;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.intive_fdv.R;
import com.example.intive_fdv.models.User;
import com.example.intive_fdv.utils.CheckRealConnection;
import com.example.intive_fdv.utils.UtilsImage;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsUserActivity extends AppCompatActivity {

    private User user;
    private CircleImageView imageProfile;
    private TextView txtEmail, txtPhone, txtCell, txtNat, txtGender, txtName;

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
        initView(user);
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
