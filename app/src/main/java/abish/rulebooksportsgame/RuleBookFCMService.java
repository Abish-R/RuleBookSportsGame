package abish.rulebooksportsgame;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by kapil on 24/07/16.
 */
public class RuleBookFCMService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("Tag", "Refreshed token: " + refreshedToken);

        // TODO: Implement this method to send any registration to your app's servers.
        //sendRegistrationToServer(refreshedToken);
//        Server key
//        AIzaSyCNz_Q63RUnoy4a8IQIIuDMk2REWoGTvNY
//        Sender ID
//        75893989295
    }
}
