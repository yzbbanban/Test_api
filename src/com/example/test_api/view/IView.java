package com.example.test_api.view;

import java.util.List;

import com.example.test_api.entity.Results;

public interface IView {
	void setData(List<Results> results);

	void showData();
}
