package com.fds.WMT.UiElements;

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

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.fds.WMT.Lines;
import com.fds.WMT.R;

/**
 * <b>UiController</b>
 * <p>
 * Convenience and utility class for handling some UI widgets, and useful
 * variables.<br/>
 * Provides access to useful variables (i.e. Typefaces, Application Resources,
 * etc.) and controls certain UI widgets for the application.
 * </p>
 * Extends UiController to add specific methods for WheresMyTrain's main Activity
 * @author Filipe De Sousa
 * @version 0.7
 */
public class UiControllerConfig extends UiController {

	private TextView lineTitle;
	private Button backButton;

	public UiControllerConfig(Resources resources, AssetManager assetManager, 
			boolean titleBarVisibility, Activity activity, boolean enableBack) {
		super(resources, assetManager, titleBarVisibility, activity);

		//	Set the back button's visibility GONE if it's not needed
		if (enableBack) {
			backButton.setVisibility(View.VISIBLE);
		} else {
			backButton.setVisibility(View.GONE);
		}
	}

	@Override
	protected void setupCustomTitleBar() {
		// Get the widget instances
		titleBar = activity.findViewById(R.id.custom_title_bar_config);
		lineTitle = (TextView) activity.findViewById(R.id.text_choose_line_config);
		lineTitle.setTypeface(bold);
		backButton = (Button) activity.findViewById(R.id.custom_title_bar_btn_back_config);
		backButton.setTypeface(bold);
	}

	@Override
	public void refreshMainTitleBar(String... params) {
		//	Nice and simple, just set the title bar string. Nothing special
		lineTitle.setText(params[0]);
	}

	public static void setWidgetTitleShape(RemoteViews remoteView, String linecode) {
		int resource = Lines.getLineByCode(linecode).getShapeCode();

		remoteView.setInt(R.id.line_station_layout_widget, "setBackgroundResource", resource);
	}
}
