
package com.reactlibrarynotchinfo;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.List;

public class RNNotchInfoModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNNotchInfoModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNNotchInfo";
  }

  private static boolean hasImmersive = false;

  private static boolean hasNotch = false;

  public List getDisplayCutoutRects (){
    List<Rect> rects = null;
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P){
      final ReactApplicationContext ctx = getReactApplicationContext();
      final Activity activity = getCurrentActivity();
      WindowInsets wi = null;
      wi = activity.getWindow().getDecorView().getRootWindowInsets();
      if (wi != null){
        DisplayCutout displayCutout = wi.getDisplayCutout();
        if (displayCutout != null) {
          rects = displayCutout.getBoundingRects();
        }
      }
    }
    return rects;
  }

  @ReactMethod
  public void hasNotch (Callback cb ){

    List<Rect> rects = getDisplayCutoutRects();

    if (rects == null || rects.size() == 0) {
      hasNotch = false;
    } else {
      hasNotch = true;
    }

    try {
      cb.invoke(hasNotch );
    } catch (Exception e) {
      cb.invoke(e.toString());
    }
  }

  @ReactMethod
  public void  notchHeight (Callback cb ){

    List<Rect> rects = getDisplayCutoutRects();

    int notchHeight = 0;

    if (rects != null && rects.size() > 0) {
      for (Rect rectangle : rects)
        if (rectangle.height() > 0) notchHeight = rectangle.height();
    }

    try {
      cb.invoke(notchHeight );
    } catch (Exception e) {
      cb.invoke(e.toString());
    }
  }
}