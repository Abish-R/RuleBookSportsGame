package util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import Constants.Constant;
import abish.rulebooksportsgame.R;

/**
 * Created by kapil on 22/08/16.
 */
public class SetCustomThemeToActivity {

    public void setCustomTheme(Activity activity, int pos) {
        switch (pos) {
            case -1:
                activity.setTheme(R.style.AppTheme);
                break;
            case 0:
                activity.setTheme(R.style.myStyle);
                break;
            case 1:
                activity.setTheme(R.style.myStyle1);
                break;
            case 2:
                activity.setTheme(R.style.myStyle2);
                break;
            case 3:
                activity.setTheme(R.style.myStyle3);
                break;
            case 4:
                activity.setTheme(R.style.myStyle4);
                break;
        }
        Constant.theme = pos;

        SharedPreferences sp = activity.getSharedPreferences(Constant.sharedPrefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putInt(Constant.sharedPrefThemeSaveKey, pos);
        ed.commit();
    }
}
