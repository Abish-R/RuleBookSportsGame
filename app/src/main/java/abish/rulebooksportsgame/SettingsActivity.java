package abish.rulebooksportsgame;


import android.app.AlertDialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Constants.Constant;
import Constants.ConstantGetterMainPage;
import abish.rulebooksportsgame.adapter.CricketRankingAdapter;
import abish.rulebooksportsgame.adapter.MainPageAdapter;
import abish.rulebooksportsgame.adapter.SettingsPageAdapter;
import util.SetCustomThemeToActivity;

public class SettingsActivity extends AppCompatActivity {
    ArrayAdapter adapter;
    ArrayList<String> settingNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetCustomThemeToActivity obj = new SetCustomThemeToActivity();
        obj.setCustomTheme(this,Constant.theme);

        setContentView(R.layout.settings);
        RecyclerView settings = (RecyclerView)findViewById(R.id.settings);
        List<String> settingNames = new ArrayList<String>();
        settingNames.add("Change Theme");
        settingNames.add("Notification");
        settingNames.add("App Filter");
        settingNames.add("Set Home Page");
        settingNames.add("Write Us");

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        settings.setLayoutManager(mLayoutManager);
        settings.setItemAnimator(new DefaultItemAnimator());

        SettingsPageAdapter adapter = new SettingsPageAdapter(this,settingNames,0);
        settings.setAdapter(adapter);

        Button invoke = (Button) findViewById(R.id.invoke);
        invoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themeSelector();
            }
        });

    }
    private void themeSelector() {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(SettingsActivity.this);
        builderSingle.setIcon(R.drawable.common_google_signin_btn_icon_dark);
        builderSingle.setTitle("Select Theme");

        adapter = new ArrayAdapter(this, android.R.layout.select_dialog_singlechoice);
        adapter.add("myStyle");
        adapter.add("myStyle1");
        adapter.add("myStyle2");
        adapter.add("myStyle3");
        adapter.add("myStyle4");

        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builderSingle.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = adapter.getItem(which).toString();
                Toast.makeText(SettingsActivity.this,strName,Toast.LENGTH_LONG).show();
                Constant.reloaded=0;


            }
        });
        builderSingle.show();
    }




}
