package com.example.test_api.model;

import java.util.List;

import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.test_api.app.MyApplication;
import com.example.test_api.entity.QuestResult;
import com.example.test_api.entity.Results;
import com.google.gson.Gson;

public class ModelDataImpl implements IModelData {

	@Override
	public void findAllData(final IModelCallback callback) {
		String url = "http://gank.io/api/data/Android/10/1";
		StringRequest request = new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				QuestResult result = gson.fromJson(response, QuestResult.class);
				List<Results> results = result.getResults();
				callback.findData(results);

			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub

			}
		});
		MyApplication.getQueue().add(request);
	}

}
