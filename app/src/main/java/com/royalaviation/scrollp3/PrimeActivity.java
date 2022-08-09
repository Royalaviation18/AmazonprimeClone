package com.royalaviation.scrollp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PrimeActivity extends AppCompatActivity {

    private WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
        getSupportActionBar().hide();
        wb = findViewById(R.id.webView);
        wb.setWebViewClient(new WebViewClient()); //to open from our app we write this line
        wb.loadUrl("https://www.primevideo.com/"); //loads from external browser

        WebSettings wbSettings = wb.getSettings();
        wbSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (wb.canGoBack()) {
            wb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}