package course.coursera.webpage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.NumberPicker;

public class Webpage extends AppCompatActivity implements View.OnClickListener{

    private NumberPicker numberPicker;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_webpage);


        numberPicker = (NumberPicker)findViewById(R.id.numberpicker);

        String[] possibilities = {
                "facebook",
                "android",
                "twitter"
        };

        final Button ok = (Button)findViewById(R.id.button);
        ok.setOnClickListener(this);

        numberPicker.setDisplayedValues(possibilities);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(possibilities.length-1);

        webView = (WebView)findViewById(R.id.webView);
    }

    @Override
    public void onClick(View v) {
        int value = numberPicker.getValue();
        switch (value) {

            case 0 :
                loadUrl("http://www.facebook.com");
                break;
            case 1:
                loadUrl("http://www.google.com");
                break;
            case 2:
                loadUrl("http://www.twitter.com");
                break;
            default:
                throw new IllegalArgumentException("Does not match");
        }
    }

    private void loadUrl(final String url) {
        final WebViewClient webViewClient = new WebViewClient();
        webView.setWebViewClient(webViewClient);
        webView.loadUrl(url);
    }
}
