package sg.edu.rp.c346.rp_websites;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CustomAdapter extends MainActivity {
    WebView wvPage;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        wvPage=findViewById(R.id.webViewMyPage);
        wvPage.setWebViewClient(new WebViewClient());

        Intent intentReceived = getIntent();
        String url = intentReceived.getStringExtra("url");
        wvPage.loadUrl(url);

    }
}
