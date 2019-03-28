package edu.cnm.deepdive.golfgreen;

import android.app.Application;
import com.facebook.stetho.Stetho;

/**
 * Extends the built in <code>Application.java</code> class to allow the functionality of the app to
 * come across the view model.
 */

public class GolfApplication extends Application {

  private static GolfApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this);
  }
  /**
   * Returns this instance, for GolfApplication to application context across the app.
   *
   * @return singleton instance.
   */
  public static GolfApplication getInstance() {
    return instance;
  }
}
