package com.melayer.webview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Uri uri = Uri.parse("http://www.codekul.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent); takes you to browser*/

        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
               MainActivity.this.setProgress(newProgress);
            }
        });

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Log.i("@codekul","Error - "+error);
            }
        });
        webView.loadUrl("http://codekul.com");
        //webView.loadData("<html><body><h1>{code}kul; <p> कोडकुल </h1></body></html>","text/html; charset=utf-8","utf-8");

    }
}
