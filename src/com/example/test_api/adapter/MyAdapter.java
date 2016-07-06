package com.example.test_api.adapter;

import java.util.List;

import com.example.test_api.R;
import com.example.test_api.entity.Results;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private Context context;
	private List<Results> results;
	private LayoutInflater layoutInflater;

	public MyAdapter(Context context, List<Results> results) {
		this.context = context;
		this.results = results;
		this.layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {

		return results.size();
	}

	@Override
	public Results getItem(int position) {
		return results.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Results result = getItem(position);
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.item_word, null);

			holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
			holder.tv_content = (TextView) convertView
					.findViewById(R.id.tv_content);
			holder.tv_writer = (TextView) convertView
					.findViewById(R.id.tv_writer);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		holder.tv_time.setText(result.getCreatedAt());
		holder.tv_content.setText(result.getDesc());
		holder.tv_writer.setText(result.getWho());

		return convertView;
	}

	class ViewHolder {
		TextView tv_time;
		TextView tv_content;
		TextView tv_writer;
	}

}
