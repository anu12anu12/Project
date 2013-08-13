package com.atspeedcorp.happyhours;

import android.os.Bundle;
import android.util.Log;

public class DetailDealActivity extends BaseScreenActivity {
	private static final String TAG = "DetailDealActivity";

	@Override
	protected void onCreate(Bundle aSavedInstanceState) {
		Log.d(TAG, "onCreate DetailDealActivity Called");
		super.onCreate(aSavedInstanceState, R.layout.detaildeal);
	}


}
