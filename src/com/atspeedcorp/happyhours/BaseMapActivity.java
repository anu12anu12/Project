package com.atspeedcorp.happyhours;

import android.os.Bundle;

import com.google.android.maps.MapActivity;

public class BaseMapActivity extends MapActivity {

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	protected void onCreate(Bundle aBundle, int aLayout)
	{
		super.onCreate(aBundle);
		setContentView(aLayout);
	}
}
