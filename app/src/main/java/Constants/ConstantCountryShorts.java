package Constants;

import java.util.Arrays;

/**
 * Created by INDP on 17-Jul-16.
 */
public class ConstantCountryShorts {
    public static String[] cricketTeams={"India","Australia","Bangladesh","New Zealand","South Africa","Pakistan",
            "Sri Lanka","England","Zimbabwe","West Indies","Afghanistan","Ireland","Nepal","Scotland","Netherlands",
            "United Arab Emirates","Hong Kong","Kenya","Bermuda"};
    public static String[] cricketTeamShortcuts={"IND","AUS","BAN","NZ","SA","PAK","SL","ENG","ZIM","WI","AFG","IRE",
            "NEP","SCO","NET","UAE","HK","KEN","BER"};

    public static String getCountryPostion(String country) {
        int position = -1;
        position = Arrays.asList(cricketTeams).indexOf(country);
        if (position> -1)
            return getCountryShortcut(position);
        else
            return null;
    }

    private static String getCountryShortcut(int pos){
        return cricketTeamShortcuts[pos];
    }
}
