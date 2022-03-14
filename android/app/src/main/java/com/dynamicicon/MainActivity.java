package com.dynamicicon;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.ReactMethod;

public class MainActivity extends ReactActivity {

  private static Activity mCurrentActivity = null;

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "dynamicicon";
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mCurrentActivity = this;
  }

  public static Activity getActivity(){
    Activity activity = new Activity();
    activity = mCurrentActivity;
    return activity;
  }
}
