package byteshaft.com.arabah.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;


public class AppGlobals extends Application {

    private static Context sContext;
    public static final String KEY_FOOD_TRUCK_NAME = "truck_name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_Description = "description";
    public static final String KEY_USER_LOCATION= "location";
    public static final String KEY_USER_ID = "id";
    public static final String KEY_PHONE_NUMBER = "mobile_number";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_USER_LOGIN = "user_login";
    public static final String KEY_SHOW_HIDE_SWITCH = "show_hide_switch";
    public static int responseCode = 0;
    public static int readresponseCode = 0;
    public static final String KEY_USER_DETAILS = "user_details";
    public static boolean logout = false;
    public static final String BASE_URL = "http://46.101.27.152/api/";
    public static boolean dialogCancel = false;
    public static Typeface typefaceBold;
    public static Typeface typefaceNormal;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }

    public static void setResponseCode(int code) {
        responseCode = code;
    }

    public static int getResponseCode() {
        return responseCode;
    }

    public static SharedPreferences getPreferenceManager() {
        return getContext().getSharedPreferences("shared_prefs", MODE_PRIVATE);
    }

    public static void saveDataToSharedPreferences(String key, String value) {
        SharedPreferences sharedPreferences = getPreferenceManager();
        sharedPreferences.edit().putString(key, value).apply();
    }

    public static String getStringFromSharedPreferences(String key) {
        SharedPreferences sharedPreferences = getPreferenceManager();
        return sharedPreferences.getString(key, "");
    }

    public static void saveUserLogin(boolean value) {
        SharedPreferences sharedPreferences = getPreferenceManager();
        sharedPreferences.edit().putBoolean(AppGlobals.KEY_USER_LOGIN, value).apply();
    }

    public static boolean isUserLoggedIn() {
        SharedPreferences sharedPreferences = getPreferenceManager();
        return sharedPreferences.getBoolean(AppGlobals.KEY_USER_LOGIN, false);
    }

    public static void setSwitchOn(boolean value) {
        SharedPreferences sharedPreferences = getPreferenceManager();
        sharedPreferences.edit().putBoolean(AppGlobals.KEY_SHOW_HIDE_SWITCH, value).apply();
    }

    public static boolean isSwitchOn() {
        SharedPreferences sharedPreferences = getPreferenceManager();
        return sharedPreferences.getBoolean(AppGlobals.KEY_SHOW_HIDE_SWITCH, false);
    }

    public static void alertDialog(Activity activity, String title, String msg) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(msg).setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
