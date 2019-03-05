package edu.cnm.deepdive.golfgreen.model.dao;

import android.app.Application;
import edu.cnm.deepdive.golfgreen.model.GolfDB;

public class GolfApplication extends Application {

  private static GolfApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
   /* Stetho.initializeWithDefaults(this); // Comment out this line to disable Stetho.*/
  }

  /**
   * Returns this instance, for access to application context across the app.
   *
   * @return singleton instance.
   */
  public static GolfApplication getInstance() {
    return instance;
  }
}
