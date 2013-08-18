package com.atspeedcorp.happyhours;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapOutletActivity extends Activity implements OnClickListener {
	
	private double mLatitude = 12.9245888;
	private double mLongitude = 77.6649452;

	
	private LatLng ITEMLAT_LONG = new LatLng(mLatitude, mLongitude);
	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_outlet);
		intialiseView();
	}

	private void intialiseView() {
		Button lGetDirectionButton = (Button) findViewById(R.id.getDirection);
		lGetDirectionButton.setOnClickListener(this);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		        .getMap();
	    Marker hamburg = map.addMarker(new MarkerOptions().position(ITEMLAT_LONG)
	        .title("Item Location"));

	    // Move the camera instantly to hamburg with a zoom of 15.
	    map.moveCamera(CameraUpdateFactory.newLatLngZoom(ITEMLAT_LONG, 300));

	    // Zoom in, animating the camera.
	    map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
	}
	
	private void launchActivityToGetDirection()
	{
		String str1 = String.valueOf(mLatitude);
        StringBuilder localStringBuilder = new StringBuilder(str1).append(",").append(mLongitude);
        Uri localUri = Uri.parse("http://maps.google.com/maps?daddr=" + localStringBuilder.toString());
        Intent localIntent1 = new Intent("android.intent.action.VIEW", localUri);
        localIntent1.addFlags(268435456);
        startActivity(localIntent1);
	}

	@Override
	public void onClick(View aView) {
		switch (aView.getId())
		{
			case R.id.getDirection:
				launchActivityToGetDirection();
			break;
		}
		
	}


}
