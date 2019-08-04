package com.example.intive_fdv.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.intive_fdv.R;
import com.example.intive_fdv.models.User;
import com.example.intive_fdv.ui.details_user.DetailsUserActivity;
import com.example.intive_fdv.utils.CheckRealConnection;
import com.example.intive_fdv.utils.UtilsImage;

import java.util.List;

public class UserGridViewAdapter extends BaseAdapter {

    private List<User> users;
    private Context context;

    public UserGridViewAdapter(Context context, List<User> users){
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_picture, viewGroup, false);
        }
        final User user = users.get(position);
        final ImageView imageProfile = (ImageView) view.findViewById(R.id.imageProfile);
        TextView txtNameUser = (TextView) view.findViewById(R.id.txtNameUser);

        txtNameUser.setText(user.getName().getFirst());

        new CheckRealConnection(context, new CheckRealConnection.OnCheckConnection() {
            @Override
            public void whileLoad() {

            }

            @Override
            public void onPostConnection(boolean success) {
                if(success){
                    UtilsImage.loadImage(context, user.getPicture().getLarge(), imageProfile);
                }
            }
        });

        imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = new Bundle();
                extras.putSerializable(User.tagUser, user);
                Intent intent = new Intent(context, DetailsUserActivity.class);
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        });



        return view;
    }
}
