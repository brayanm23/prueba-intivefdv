package com.example.intive_fdv.utils;

import android.content.Context;
import android.widget.ImageView;

import com.example.intive_fdv.R;
import com.squareup.picasso.Picasso;

public class UtilsImage {

    public static void loadImage(Context context, String photoUrl, ImageView view) {
        if (!photoUrl.isEmpty()) {
            Picasso.with(context).load(photoUrl).
                //error(ContextCompat.getDrawable(context, R.drawable.imagen_no_disponible)).
            into(view);
        }
    }
}
