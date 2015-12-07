package kr.ac.ssu.bon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import kr.ac.ssu.bon.R;

/**
 * Created by lk on 15. 12. 5..
 */
public class DiagnosisActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    Intent intent;
    ImageButton backButton;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        intent = getIntent();
        textView = (TextView)findViewById(R.id.readingTextView);
        backButton = (ImageButton)findViewById(R.id.backButton);
        webView = (WebView)findViewById(R.id.readingwebView);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        webView.setWebViewClient(new WebBrowserClient());
        webView.getSettings().setDefaultTextEncodingName("Euc-kr");
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(intent.getStringExtra("Url"));

        backButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }

    final class WebBrowserClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url) {
            view.loadUrl(url);
            Log.d("webview", url);
            return true;
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            Log.d("webview", "webview remove js");
            view.loadUrl("javascript:var div  = document.getElementById('header'); div.parentNode.removeChild(div);");
            view.loadUrl("javascript:var div  = document.getElementById('bbs-prevnext'); div.parentNode.removeChild(div);");
            view.loadUrl("javascript:var div  = document.getElementById('footer'); div.parentNode.removeChild(div);");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Log.d("webview", "webview loaded");
        }
    }
}
