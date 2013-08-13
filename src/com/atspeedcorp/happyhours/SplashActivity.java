package com.atspeedcorp.happyhours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class SplashActivity extends Activity {
    private boolean isStopSplash;
    private CountDownTimer countDownSplash;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash); 
		isStopSplash = false;
		
		countDownSplash = new CountDownTimer(2000, 1)
		{

			@Override
			public void onFinish() {
				if (SplashActivity.this.isStopSplash)
			          return;
		        if (SplashActivity.this == null)
		          return;
		        if (SplashActivity.this.isFinishing())
		          return;
		        
		        startApp();
			}

			@Override
			public void onTick(long arg0) {
				
			}
			
		};
		countDownSplash.start();
	}
	
	
	private void startApp() {
		Intent localIntent = new Intent(SplashActivity.this, SearchActivity.class);
        startActivity(localIntent);
        finish();

	}
	@Override
	public void onPause()
	{
		super.onPause();
		this.isStopSplash = true;
	}

	public void onBackPressed()
	{
		super.onBackPressed();
		if (this.countDownSplash != null)
			countDownSplash.cancel();
		finish();
	}

}
