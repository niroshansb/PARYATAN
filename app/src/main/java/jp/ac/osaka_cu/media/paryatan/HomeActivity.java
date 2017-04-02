package jp.ac.osaka_cu.media.paryatan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HomeActivity extends AppCompatActivity {
    private WebView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myView = (WebView) findViewById(R.id.mywebView);
        WebSettings webSettings=myView.getSettings();
        myView.getSettings().setJavaScriptEnabled(true);
        // improve webview performance
        myView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        myView.getSettings().setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);
        myView.getSettings().setAppCacheEnabled(true);
        myView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
     //   webSettings.setLayoutAlgorithm(webSettings.LayoutAlgorithm.NARROW_COLUMNS);
     //   webSettings.setUseWideViewPort(true);
        webSettings.setEnableSmoothTransition(true);



        myView.loadUrl("http://mapmint.media.osaka-cu.ac.jp/touristinfo.html");
        myView.setWebViewClient(new WebViewClient());





        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.hdpi_icon);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() ==KeyEvent.ACTION_DOWN){
            switch (keyCode){
               case  KeyEvent.KEYCODE_BACK:
                if (myView.canGoBack()){
                    myView.goBack();
                }
                else {
                    finish();
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
