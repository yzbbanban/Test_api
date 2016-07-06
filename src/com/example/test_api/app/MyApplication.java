package com.example.test_api.app;

import org.xutils.x;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class MyApplication extends Application {
	private static MyApplication context;
	private static RequestQueue queue;

	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		x.Ext.init(context);
		queue = Volley.newRequestQueue(context);
	}

	public static MyApplication getContext() {
		return context;
	}

	public static RequestQueue getQueue() {
		return queue;
	}

}
