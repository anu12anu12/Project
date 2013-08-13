package com.atspeedcorp.happyhours;

import android.app.Activity;
import android.os.Bundle;

public class BaseScreenActivity extends Activity {
	CommonMenu bottomMenu;
	protected Bundle instanceState;
	protected String activePage = "";
	

	public final CommonMenu GetCommonMenu()
	{
		return this.bottomMenu;
	}
	protected void onCreate(Bundle savedInstanceState, int aLayout) {
		super.onCreate(savedInstanceState);
		instanceState = savedInstanceState;
		Bundle localBundle = getIntent().getExtras();
	    if ((localBundle != null) && (localBundle.getString("activePage") != null))
	    {
	      String str1 = localBundle.getString("activePage");
	      this.activePage = str1;
	    }
	    
	    setContentView(aLayout);
	    this.bottomMenu = new CommonMenu(this);
	}


}
