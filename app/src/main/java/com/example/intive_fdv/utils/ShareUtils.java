package com.example.intive_fdv.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class ShareUtils {

    private static String page = "page";
    private static String results = "results";
    private static String seed = "seed";

    public static Integer getPage(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(page, -1);
    }

    public static void setPage(Context context, Integer newPage) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(page, newPage);
        editor.apply();
    }

    public static Integer getResults(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(results, -1);
    }

    public static void setResults(Context context, Integer newResults) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(results, newResults);
        editor.apply();
    }

    public static String getSeed(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(seed, "");
    }

    public static void setSeed(Context context, String newSeed) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(seed, newSeed);
        editor.apply();
    }


    public static boolean removeAll(Context context) {
        try {
            SharedPreferences.Editor editor =
                    PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.clear();
            editor.apply();
            return true;
        } catch (Exception e) {
            Log.e("ERROR","SharedPreferences removeAll" + e.toString());
            e.printStackTrace();
            return false;
        }
    }
}
