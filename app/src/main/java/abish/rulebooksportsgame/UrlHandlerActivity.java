package abish.rulebooksportsgame;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Constants.Constant;
import abish.rulebooksportsgame.adapter.Pager;
import abish.rulebooksportsgame.adapter.UrlPagerAdapter;
import util.SetCustomThemeToActivity;

public class UrlHandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetCustomThemeToActivity obj = new SetCustomThemeToActivity();
        obj.setCustomTheme(this, Constant.theme);

        setContentView(R.layout.url_handling_activity);
        ViewPager url_container = (ViewPager)findViewById(R.id.url_container);

        //Creating our pager adapter
        UrlPagerAdapter adapter = new UrlPagerAdapter(getSupportFragmentManager(), 5);

        //Adding adapter to pager
        url_container.setAdapter(adapter);
        //viewPager.setPageTransformer(true, new FadePageTransformer());
        url_container.setOffscreenPageLimit(1);
    }
}
