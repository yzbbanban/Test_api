package com.example.test_api.activity;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.example.test_api.R;
import com.example.test_api.R.layout;
import com.example.test_api.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.webkit.WebView;

public class WebActivity extends Activity {
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		x.view().inject(this);
		setData();
	}

	private void setData() {
		Intent intent = getIntent();
		String url = intent.getStringExtra("url");
		webView = new WebView(this);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(url);
		setContentView(webView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web, menu);
		return true;
	}

}
