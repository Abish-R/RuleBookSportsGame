package Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by INDP on 17-Jun-16.
 */
public class ConstantGetterMainPage {
    public ConstantGetterMainPage(){}

    public static List<String> getSportsData(){
        List<String> list = new ArrayList<String>();
        list.add("Cricket");list.add("FootBall");list.add("Hockey");list.add("Kabadi");list.add("Badminton");
        list.add("Ball Badminton");list.add("VolleyBall");

        return list;
    }

}
