package com.example.iotworkshop;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b2;
    EditText editText;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b2 = findViewById(R.id.btn2);
        editText = findViewById(R.id.et_1);
        sw = findViewById(R.id.sw1);
    }

    //*********************************************************************************************************************************
    @SuppressLint({"SetJavaScriptEnabled", "ShowToast"})
    public void setdatainweb(String p1, String p2)
    {
        WebView myWebView = (WebView) findViewById(R.id.wb_1);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setAppCacheEnabled(true);
        myWebView.getSettings().setDatabaseEnabled(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setGeolocationEnabled(true);
        myWebView.setWebChromeClient(new WebChromeClient() {
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });
        System.out.println("datadatadata");
        String url = "https://srushtikhunt.000webhostapp.com/setdata.php?flag="+p2+"&str="+p1;
        System.out.println(url);
        myWebView.loadUrl(url);
        Toast.makeText(this,"Data send",Toast.LENGTH_LONG);
    }
    public void sendata(View view) {
        String s = sw.isChecked() ? "1" : "0";
        setdatainweb(editText.getText().toString(),s);
    }
    //*********************************************************************************************************************************
}
