package abish.rulebooksportsgame.Models;

import abish.rulebooksportsgame.R;

/**
 * Created by kapil on 21/08/16.
 */
public class ThemeGetSet {
    public static int[] images={R.drawable.ic_menu_share,R.drawable.ic_menu_share,R.drawable.ic_menu_share,R.drawable.ic_menu_share,
            R.drawable.ic_menu_share,R.drawable.ic_menu_share};
    public static String[] themeNames= {"Default","One", "TwoTwo","Three","FourFour","Five"};
    int selected,themeImages;
    String themeName;

    public ThemeGetSet(){}

    public void setThemeImage(int select){
        themeImages=select;
    }
    public void setThemeName(String select){
        themeName=select;
    }
    public void setSelected(int select){
        selected=select;
    }

    public int getThemeImage(){
        return themeImages;
    }
    public String getThemeName(){
        return themeName;
    }
    public int getSelected(){
        return selected;
    }
}
