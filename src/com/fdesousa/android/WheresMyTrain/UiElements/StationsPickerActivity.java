package com.fdesousa.android.WheresMyTrain.UiElements;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.fdesousa.android.WheresMyTrain.R;
import com.fdesousa.android.WheresMyTrain.Library.ConfigCodes;
import com.fdesousa.android.WheresMyTrain.Library.requests.StationsList.StationsListLine;
import com.fdesousa.android.WheresMyTrain.Library.requests.StationsList.StationsListStation;

public class StationsPickerActivity extends ListActivity {

	private ArrayAdapter<StationsListStation> adapter;
	private UiController uiController;
	/**
	 * Simple boolean for determining whether the Custom Title bar window
	 * feature is enabled
	 */
	private boolean customTitleBar;
	private String linecode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Requesting window features must be done before anything else, so do it now
		customTitleBar = requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Set the content view to our main layout
		setContentView(R.layout.widget_config_layout);

		//	Get the extras from our passed-in Intent
		Bundle extras = getIntent().getExtras();
		int colour = extras.getInt(ConfigCodes.LINE_COLOUR_EXTRA, android.R.color.black);
		StationsListLine line = extras.getParcelable(ConfigCodes.SLLINE_EXTRA);
		this.linecode = line.linecode;

		// Setup the cancel result first, in case the user cancels this activity early
		setResult(RESULT_CANCELED, new Intent());

		//	Setup the uiController for later use
		uiController = new UiControllerConfig(getResources(), getAssets(), customTitleBar, this, true);
		uiController.setTextColour(colour);
		uiController.setTitleBarColour(colour);
		uiController.refreshMainTitleBar("Choose Station");

		//	Setup the adapter, set it to the Activity
		adapter = new StationsArrayAdapter(this, line.stations, uiController);
		setListAdapter(adapter);

		//	Finally call method to setup back button
		setUpBackButton();
	}

	/**
	 * Convenience method to set the back button to finish the current activity
	 */
	private void setUpBackButton() {
		Button backButton = (Button) findViewById(R.id.custom_title_bar_btn_back_config);
		backButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//	Assume that a result of some kind has been set
				//	So we just finish this activity. Done
				StationsPickerActivity.this.finish();
			}
		});
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String stationcode = adapter.getItem(position).stationcode;
		//	Construct a proper result to return
		Intent result = new Intent()
		.putExtra(ConfigCodes.LINE_CODE_RESULT, this.linecode)
		.putExtra(ConfigCodes.STATION_CODE_RESULT, stationcode);
		setResult(RESULT_OK, result);
		//	Since the result has been finished and set, finish up
		finish();
	}

}
