package abish.rulebooksportsgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Constants.Constant;
import Constants.ConstantGetterMainPage;
import abish.rulebooksportsgame.adapter.MainPageAdapter;
import util.SetCustomThemeToActivity;

/**
 * Created by INDP on 17-Jun-16.
 */
public class MainSportsPage extends AppCompatActivity{
    RecyclerView mainpage_recycler;
    MainPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SetCustomThemeToActivity obj = new SetCustomThemeToActivity();
        obj.setCustomTheme(this, Constant.theme);

        setContentView(R.layout.sports_mainpage);

        initializeView();
    }

    public void initializeView(){
        mainpage_recycler = (RecyclerView) findViewById(R.id.mainpage_recycler);

        adapter = new MainPageAdapter(this,ConstantGetterMainPage.getSportsData());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mainpage_recycler.setLayoutManager(mLayoutManager);
        mainpage_recycler.setItemAnimator(new DefaultItemAnimator());
        mainpage_recycler.setAdapter(adapter);
    }

    public List<String> getSportsData(){
        List<String> list = new ArrayList<String>();
        list.add("Cricket");list.add("FootBall");list.add("Hockey");list.add("Kabadi");list.add("Badminton");
        list.add("Ball Badminton");list.add("VolleyBall");

        return list;
    }
}
