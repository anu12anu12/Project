package com.atspeedcorp.happyhours;

import android.os.Bundle;
import android.util.Log;


public class HomeScreenActivity extends BaseScreenActivity {
	private static final String TAG = "HomeScreenActivity";

	@Override
	protected void onCreate(Bundle aSavedInstanceState) {
		Log.d(TAG, "onCreate HomeScreen Called");
		super.onCreate(aSavedInstanceState, R.layout.home);
	}

}
