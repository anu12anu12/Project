package com.atspeedcorp.happyhours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class CommonMenu {
	private static final String TAG = "CommonMenu";
	private LinearLayout layoutAbout;
	private LinearLayout layoutFavorite;
	private LinearLayout layoutFloor;
	private LinearLayout layoutHome;
	private LinearLayout layoutInbox;
	private LinearLayout layoutList;
	private LinearLayout layoutMall;
	private LinearLayout layoutNearby;
	private LinearLayout layoutSearch;
	private LinearLayout layoutSetting;
	private Activity mActivity;
	private Location mLocation;
	private static Map<String, List<Activity>> activityStacks;
	private TabAction[] tabActions;

	static
	{
		activityStacks = new HashMap();
	}



	public CommonMenu(Activity aActivity) {
		mActivity = aActivity;
		TabAction[] arrayOfTabAction1 = new TabAction[9];
		View.OnClickListener lViewOnClickListener = new View.OnClickListener()
		{
		    public void onClick(View paramView)
		    {
		      CommonMenu.this.actionHome();
		    }
		};
		
		TabAction localTabAction = new TabAction(R.id.iconHome, HomeScreenActivity.class, lViewOnClickListener, R.id.homeLayout);
		arrayOfTabAction1[0] = localTabAction;
	}

	
	protected void actionHome()
	{
		Log.d(TAG, "Opening Home menu...");
		Intent lHomeIntent = new Intent(mActivity, HomeScreenActivity.class);
		mActivity.startActivity(lHomeIntent);
	}
	
	protected void actionSearch()
	{
		Log.d(TAG, "Opening Search menu...");
		Intent localIntent = new Intent(mActivity, SearchActivity.class);
		mActivity.startActivity(localIntent);
	}
	
	protected final void GoToSetting()
	{
		Log.d(TAG, "Opening Setting menu...");
		
		Intent localIntent = new Intent(mActivity, SettingActivity.class);
		mActivity.startActivity(localIntent);
	}
	

	  protected void actionNearby(Location aLocation)
	  {
	    this.mLocation = aLocation;
//	    GetNearbyDealTask localGetNearbyDealTask = new GetNearbyDealTask(localActivity);
//	    Double[] arrayOfDouble = new Double[2];
//	    Double localDouble1 = Double.valueOf(this.loc.getLatitude());
//	    arrayOfDouble[0] = localDouble1;
//	    Double localDouble2 = Double.valueOf(this.loc.getLongitude());
//	    arrayOfDouble[1] = localDouble2;
//	    AsyncTask localAsyncTask = localGetNearbyDealTask.execute(arrayOfDouble);
//	    GlobalParameter.LATITUDE = this.loc.getLatitude();
//	    GlobalParameter.LONGTITUDE = this.loc.getLongitude();
	  }
	  

	private class TabAction
	{
		private Class aActivityClass;
		private int mImageId;
		private int mLayoutBackground;
		private View.OnClickListener mOnClickListener;

	    public TabAction(int aImageId, Class aClass, View.OnClickListener aListener, int aLayoutId)
	    {
	      this.mImageId = aImageId;
	      this.aActivityClass = aClass;
	      this.mOnClickListener = aListener;
	      this.mLayoutBackground = aLayoutId;
	    }

	    public void updateActivityQueue(String paramString, Activity paramActivity)
	    {
	      List localList = (List) CommonMenu.activityStacks.get(paramString);
	      if (localList != null)
	      {
	        String str1 = paramActivity.getClass().getName();
	        String str2 = this.aActivityClass.getName();
	        if (str1.equals(str2))
	        {
	          int i = localList.size() + -1;
	          while (true)
	          {
	            if (i < 0)
	              return;
	            Activity localActivity1 = (Activity)localList.get(i);
	            if (!localActivity1.isFinishing())
	              localActivity1.finish();
	            Object localObject1 = localList.remove(i);
	            i += -1;
	          }
	        }
	        int i = localList.size() + -1;
	        while (true)
	        {
	          if (i < 0)
	          {
	            Activity localActivity2 = CommonMenu.this.mActivity;
	            boolean bool1 = localList.add(localActivity2);
	            return;
	          }
	          Activity localActivity3 = (Activity)localList.get(i);
	          String str3 = paramActivity.getClass().getName();
	          String str4 = localActivity3.getClass().getName();
	          if (str3.equals(str4))
	          {
	            int j = i;
	            while (true)
	            {
	              int k = localList.size();
	              if (j >= k)
	                break;
	              Activity localActivity4 = (Activity)localList.get(j);
	              if ((!localActivity4.isFinishing()) && (CommonMenu.this.mActivity.getParent() != null))
	              {
	                Class localClass1 = CommonMenu.this.mActivity.getParent().getClass();
	                Class localClass2 = localActivity4.getClass();
	                if (!localClass1.equals(localClass2))
	                  localActivity4.finish();
	              }
	              Object localObject2 = localList.remove(j);
	              j += 1;
	            }
	          }
	          i += -1;
	        }
	      }
	      String str5 = paramActivity.getClass().getName();
	      String str6 = this.aActivityClass.getName();
	      if (str5.equals(str6))
	        return;
	      ArrayList localArrayList = new ArrayList();
	      boolean bool2 = localArrayList.add(paramActivity);
	      Object localObject3 = CommonMenu.activityStacks.put(paramString, localArrayList);
	    }
	  }


}
