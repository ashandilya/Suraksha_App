package com.ashandilya.surakshaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView bingCovidMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bingCovidMap = findViewById(R.id.webview);

        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                1);

        WebSettings settings = bingCovidMap.getSettings();
        bingCovidMap.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return true;
            }
        });

        settings.setJavaScriptEnabled(true);
        settings.setGeolocationEnabled(true);

        bingCovidMap.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin,
                                                           GeolocationPermissions.Callback callback) {

                callback.invoke(origin, true, false);
            }
        });

        bingCovidMap.loadUrl("https://www.bing.com/covid/local/india");
    }

    }
