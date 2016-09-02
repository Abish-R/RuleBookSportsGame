package abish.rulebooksportsgame;

/** Profit Key 1.0.0
 *  Purpose	   : Splash Screen
 *  Created by : Abish
 *  Created Dt : 05-03-2016
 *  Modified on:
 *  Verified by:
 *  Verified Dt:
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import Constants.Constant;
import util.SetCustomThemeToActivity;


public class SplashScreen extends AppCompatActivity {
//EditStatusBar esb = new EditStatusBar(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = this.getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(this.getResources().getColor(R.color.green));
//        }
        /**Getting Username*/
        SharedPreferences sp=getSharedPreferences(Constant.sharedPrefName, Context.MODE_PRIVATE);
        Constant.theme = sp.getInt(Constant.sharedPrefThemeSaveKey, -1);
        Log.e("Username", Constant.theme+"");

        SetCustomThemeToActivity obj = new SetCustomThemeToActivity();
        obj.setCustomTheme(this,Constant.theme);
        setContentView(R.layout.activity_main);
        //setStatusBarColor(findViewById(R.id.statusBarBackground), getResources().getColor(R.color.status_biscuit));

//        Log.d(status_login, status_user);
        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(1000);    /** Thread will sleep for 3 seconds*/

                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                   // }
                } catch (Exception e) {
                }
            }
        };
        background.start();     /** start thread*/

    }

    /**Set color to statusbar*/
//    public void setStatusBarColor(View statusBar,int color){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow();
//            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //status bar height
//            //int actionBarHeight = getActionBarHeight();
//            int statusBarHeight = esb.getStatusBarHeight();
//            //action bar height
//            statusBar.getLayoutParams().height = statusBarHeight;// + actionBarHeight ;
//            statusBar.setBackgroundColor(color);
//        }
//    }


}
