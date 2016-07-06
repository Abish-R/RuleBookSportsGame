package abish.rulebooksportsgame;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import abish.rulebooksportsgame.adapter.Pager;

/**
 * Created by INDP on 21-Jun-16.
 */
public class CricketActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cricket_main);

        AppController analyticObject = (AppController) getApplication();
        mTracker = analyticObject.getDefaultTracker();


        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cricket");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("History"));
        tabLayout.addTab(tabLayout.newTab().setText("Rules"));
        tabLayout.addTab(tabLayout.newTab().setText("Rankings"));
        tabLayout.addTab(tabLayout.newTab().setText("Records"));
        tabLayout.addTab(tabLayout.newTab().setText("Fixtures"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.container);

        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new FadePageTransformer());
        viewPager.setOffscreenPageLimit(4);

        //set tablayout with viewpager
        tabLayout.setupWithViewPager(viewPager);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        //Toast.makeText(this, "I am Starter", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        //Toast.makeText(this, "I am Pauser", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        mTracker.setScreenName("Cricket Activity Live");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

//        mTracker.send(new HitBuilders.EventBuilder()
//                .setCategory("categoryId")
//                .setAction("actionId")
//                .setLabel("labelId")
//                .build());
        //Toast.makeText(this, "I am Resumer", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        //Toast.makeText(this, "I am Stoper", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "I am Destroyer", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        //Toast.makeText(this, "I am Restarter", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
//        tabLayout.setScrollPosition(tab.getPosition(),0,true);
//        tabLayout.setSelected(true);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public class FadePageTransformer implements ViewPager.PageTransformer {
        private float MIN_SCALE = 0.75f;
        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }


//            if(position <= -1.0F || position >= 1.0F) {
//                view.setTranslationX(view.getWidth() * position);
//                view.setAlpha(0.0F);
//            } else if( position == 0.0F ) {
//                view.setTranslationX(view.getWidth() * position);
//                view.setAlpha(1.0F);
//            } else {
//                // position is between -1.0F & 0.0F OR 0.0F & 1.0F
//                view.setTranslationX(view.getWidth() * -position);
//                view.setAlpha(1.0F - Math.abs(position));
//            }
        }
    }

}
