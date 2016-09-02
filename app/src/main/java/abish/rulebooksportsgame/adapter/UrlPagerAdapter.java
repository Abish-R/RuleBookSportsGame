package abish.rulebooksportsgame.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragments.UrlHandlingFragment;
//import fragments.RanksUrlHandleFragment;
//import fragments.RecordsUrlHandleFragment;
//import fragments.RulesUrlHandleFragment;
//import fragments.ScheduleUrlHandleFragment;

/**
 * Created by kapil on 09/08/16.
 */
public class UrlPagerAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public UrlPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        Bundle b = new Bundle();
        switch (position) {
            case 0:
                UrlHandlingFragment tab1 = new UrlHandlingFragment();
                b.putString("key","http://www.google.com");
                tab1.setArguments(b);
                return tab1;
            case 1:
                UrlHandlingFragment tab2 = new UrlHandlingFragment();
                b.putString("key","https://www.irctc.co.in");
                tab2.setArguments(b);
                return tab2;
            case 2:
                UrlHandlingFragment tab3 = new UrlHandlingFragment();
                b.putString("key","https://www.linkedin.com");
                tab3.setArguments(b);
                return tab3;
            case 3:
                UrlHandlingFragment tab4 = new UrlHandlingFragment();
                b.putString("key","https://www.fb.com");
                tab4.setArguments(b);
                return tab4;
            case 4:
                UrlHandlingFragment tab5 = new UrlHandlingFragment();
                b.putString("key","https://www.twitter.com");
                tab5.setArguments(b);
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //this is where you set the titles
        switch(position) {
            case 0:
                return "History";
            case 1:
                return "Rule Page";
            case 2:
                return "ICC Ranks";
            case 3:
                return "World Records";
            case 4:
                return "Fixtures";
        }
        return null;
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
