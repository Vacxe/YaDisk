package yadisk.nitribubbles.com.yadisk.data.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static yadisk.nitribubbles.com.yadisk.core.Constants.TOKEN;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class LocalStorage {
    final SharedPreferences sharedPreferences;

    public LocalStorage(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void saveToken(String token){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(TOKEN, token);
        editor.apply();
    }



    public String getToken(){
       return sharedPreferences.getString(TOKEN, null);
    }
}
