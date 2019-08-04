package com.example.intive_fdv.ui.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.example.intive_fdv.R;
import com.example.intive_fdv.models.User;
import com.example.intive_fdv.ui.home.adapter.UserGridViewAdapter;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeContract.View{

    protected ProgressDialog progressDialog;
    private GridView gridPicture;
    private HomeContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressDialog = new ProgressDialog(this);

        gridPicture = (GridView) findViewById(R.id.gridPicture);
        mPresenter = new HomePresenter(this, this);

        showProgressDialog(getString(R.string.searching));
        mPresenter.getUserService(50);

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


    @Override
    public void showUser(List<User> users) {
        UserGridViewAdapter adapter = new UserGridViewAdapter(HomeActivity.this, users);
        gridPicture.setAdapter(adapter);
        dismissProgressDialog();

    }

    @Override
    public void showErrorMessage(String message) {
        dismissProgressDialog();
        Toast.makeText(HomeActivity.this, message, Toast.LENGTH_LONG).show();
        finish();
    }

    public void showProgressDialog(String message) {
        if (progressDialog != null) {
            if(!isFinishing()) {
                if (!progressDialog.isShowing()) {
                    progressDialog.setMessage(message);
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.setIndeterminate(true);
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                } else {
                    progressDialog.setMessage(message);
                }
            }
        }
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
