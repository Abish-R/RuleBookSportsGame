package abish.rulebooksportsgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by INDP on 16-Jul-16.
 */
public class WebPageLoader extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        WebView webveiw = (WebView)findViewById(R.id.webveiw);
        webveiw.loadUrl("www.helixtech.co");
    }
}
