package Supporters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragments.CricketHistory;
import fragments.CricketRecords;
import fragments.CricketRules;

/**
 * Created by INDP on 26-Jun-16.
 */
public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                CricketHistory tab1 = new CricketHistory();
                return tab1;
            case 1:
                CricketRules tab2 = new CricketRules();
                return tab2;
            case 2:
                CricketRecords tab3 = new CricketRecords();
                return tab3;
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
                return "World Records";
        }
        return null;
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
