package com.example.test_api.activity;

import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.example.test_api.R;
import com.example.test_api.R.layout;
import com.example.test_api.R.menu;
import com.example.test_api.adapter.MyAdapter;
import com.example.test_api.entity.Results;
import com.example.test_api.presenter.IPresenterData;
import com.example.test_api.presenter.impl.PresenterDataImpl;
import com.example.test_api.view.IView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements IView {
	@ViewInject(R.id.lv_test_api)
	private ListView lvTest;
	private IPresenterData presenterData;
	private List<Results> results;
	private MyAdapter adapter;

	public MainActivity() {
		super();
		presenterData = new PresenterDataImpl(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		x.view().inject(this);
		presenterData.loadData();
		setListeners();
	}

	private void setListeners() {
		lvTest.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(MainActivity.this, WebActivity.class);
				intent.putExtra("url", results.get(position).getUrl());
				startActivity(intent);
			}
		});

	}

	@Override
	public void setData(List<Results> results) {
		this.results = results;

	}

	@Override
	public void showData() {
		adapter = new MyAdapter(this, results);
		lvTest.setAdapter(adapter);
	}

}
