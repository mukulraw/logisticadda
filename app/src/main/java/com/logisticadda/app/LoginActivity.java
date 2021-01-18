package com.logisticadda.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import im.delight.android.webview.AdvancedWebView;

public class LoginActivity extends AppCompatActivity implements AdvancedWebView.Listener {

    BottomNavigationView navigation;
    AdvancedWebView mWebView;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.bottomNavigationView);
        mWebView = findViewById(R.id.replace);
        progress = findViewById(R.id.progressBar);

        mWebView.setListener(this, this);
        mWebView.setMixedContentAllowed(false);
        mWebView.loadUrl("https://www.logisticadda.in/payment");

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finishAffinity();
                        break;
                    case R.id.action_blog:
                        Intent intent2 = new Intent(LoginActivity.this, SellActivity.class);
                        startActivity(intent2);
                        finishAffinity();

                        break;
                    case R.id.action_orders:

                        break;
                }
                return true;
            }
        });

        progress.setVisibility(View.VISIBLE);
        navigation.setSelectedItemId(R.id.action_orders);

    }
    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        mWebView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWebView.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
        // ...
    }

    @Override
    public void onBackPressed() {
        if (!mWebView.onBackPressed()) { return; }
        // ...
        super.onBackPressed();
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageFinished(String url) {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) { }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) { }

    @Override
    public void onExternalPageRequest(String url) { }

}