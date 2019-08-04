package com.example.intive_fdv.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.InetAddress;

/**
 * ----------------------------------------|
 * Created by Harold Montenegro on 9/28/16.|
 * ----------------------------------------|
 **/

/*Clase encargada de verificar si el dispositivo realmente tiene conexion a internet

Interface: whileLoad(): Realizar alguna accion en el activity mientras se esta realizando la
                        comprobacion.

           onPostConnection(boolean success): Esta se ejecuta al finalizar la comprobacion retornando
                                              true si existe una conexion a internet, de lo
                                              contrario false.*/

public class CheckRealConnection extends AsyncTask<String, Void, Boolean> {
    private Context context;
    private OnCheckConnection onCheckConnection;

    public interface OnCheckConnection{
        void whileLoad();
        void onPostConnection(boolean success);
    }

    public CheckRealConnection(Context context, OnCheckConnection onCheckConnection) {
        this.context = context;
        this.onCheckConnection = onCheckConnection;
        this.execute();
    }

    public void setOnCheckConnection (OnCheckConnection onCheckConnection){
        this.onCheckConnection = onCheckConnection;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        Log.d("Debug","CheckConnetion-> " + "Testing connection");
        if(onCheckConnection !=null){
            if(context instanceof Activity){
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onCheckConnection.whileLoad();
                    }
                });
            }
        }
        return checkInternetConnection(context);
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if(success){
            Log.d("Debug", "CheckConnetion-> " + "Connection Success");
        }else {
            Log.e("Debug","CheckConnetion-> " + "Connection Failed");
        }
        if(onCheckConnection !=null){
            onCheckConnection.onPostConnection(success);
        }
    }

    public static boolean checkInternetConnection(Context context) {

        try {
            if (isNetworkAvailable(context)){
                InetAddress ipAddr = InetAddress.getByName("google.com"); //You can replace it with your name
                return !ipAddr.equals("");
            }else {
                return  false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static boolean isNetworkAvailable(Context context) {
        /*Comprueba si en el dispositivo estan disponibles los medios para la comunicacion a
        internet*/
        ConnectivityManager manager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            // Network is present and connected
            isAvailable = true;
        }
        return isAvailable;
    }

}
