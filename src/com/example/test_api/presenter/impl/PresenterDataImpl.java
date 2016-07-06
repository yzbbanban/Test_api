package com.example.test_api.presenter.impl;

import java.util.List;

import com.example.test_api.entity.Results;
import com.example.test_api.model.IModelCallback;
import com.example.test_api.model.IModelData;
import com.example.test_api.model.ModelDataImpl;
import com.example.test_api.presenter.IPresenterData;
import com.example.test_api.view.IView;

public class PresenterDataImpl implements IPresenterData {
	private IView view;
	private IModelData model;

	public PresenterDataImpl(IView view) {
		this.view = view;
		model = new ModelDataImpl();
	}

	@Override
	public void loadData() {
		model.findAllData(new IModelCallback() {

			@Override
			public void findData(Object object) {
				List<Results> results = (List<Results>) object;
				view.setData(results);
				view.showData();
			}
		});

	}
}
