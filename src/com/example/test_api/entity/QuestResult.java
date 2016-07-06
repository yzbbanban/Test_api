package com.example.test_api.entity;

import java.util.List;

public class QuestResult {
	private boolean error;
	private List<Results> results;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

}
