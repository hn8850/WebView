package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webv = findViewById(R.id.WebV);
        EditText input = findViewById(R.id.Edit);
        Button b = findViewById(R.id.button);

        webv.getSettings().setJavaScriptEnabled(true);
        webv.setWebViewClient(new MyWebViewClient());

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = input.getText().toString();
                input.setEnabled(false);
                webv.loadUrl(url);

            }
        });
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}