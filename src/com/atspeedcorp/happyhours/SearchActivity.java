package com.atspeedcorp.happyhours;

import android.os.Bundle;
import android.util.Log;

public class SearchActivity extends BaseScreenActivity{
	private static final String TAG = "SearchActivity";

	@Override
	protected void onCreate(Bundle aSavedInstanceState) {
		Log.d(TAG, "onCreate SearchActivity Called");
		super.onCreate(aSavedInstanceState, R.layout.search);
	}


}
