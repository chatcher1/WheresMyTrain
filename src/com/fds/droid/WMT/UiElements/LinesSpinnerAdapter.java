package com.fds.droid.WMT.UiElements;

/******************************************************************************
 * Copyright 2011 Filipe De Sousa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *****************************************************************************/

import java.util.List;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.fdesousa.android.WheresMyTrain.R;
import com.fds.droid.WMT.Library.requests.StationsList.StationsListLine;

/**
 * <b>LinesSpinnerAdapter ; SpinnerAdapter</b>
 * <p>
 * Adapter to handle using a list of SLLine with Android Spinner widget<br/>
 * cf. http://stackoverflow.com/questions/6562236/
 * </p>
 * 
 * @author Filipe De Sousa
 * @version 0.7
 */
public class LinesSpinnerAdapter implements SpinnerAdapter {
	private List<StationsListLine> lines;
	private LayoutInflater layoutInflater;
	private UiController uiController;

	public LinesSpinnerAdapter(List<StationsListLine> lines, LayoutInflater layoutInflater,
			UiController uiController) {
		this.lines = lines;
		this.layoutInflater = layoutInflater;
		this.uiController = uiController;
	}

	@Override
	public int getCount() {
		return lines.size();
	}

	@Override
	public Object getItem(int position) {
		return lines.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getItemViewType(int position) {
		return android.R.layout.simple_spinner_dropdown_item;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		StationsListLine line = (StationsListLine) getItem(position);

		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.spinner_row, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.row);
		int colour = uiController.getLineColour(line.linecode);
		tv.setTextColor(colour);
		tv.setTypeface(uiController.book);
		tv.setText(line.linename);

		return convertView;
	}

	@Override
	public int getViewTypeCount() {
		return android.R.layout.simple_spinner_dropdown_item;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return this.getView(position, convertView, parent);
	}

}
