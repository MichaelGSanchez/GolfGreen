package edu.cnm.deepdive.golfgreen.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.Nullable;
import edu.cnm.deepdive.golfgreen.model.dao.CourseDao;
import edu.cnm.deepdive.golfgreen.model.dao.CourseLocationDao;
import edu.cnm.deepdive.golfgreen.model.dao.GolfApplication;
import edu.cnm.deepdive.golfgreen.model.dao.LocationDao;
import edu.cnm.deepdive.golfgreen.model.dao.UserDao;
import java.util.Calendar;

/**
 * Defines the local database as a collection of its entities and converters, with the singleton
 * pattern implemented for app-wide use of a single connection, and declares methods to retrieve
 * data access objects (DAOs) for the database entities.
 */
@Database(
    entities = {Course.class, CourseLocation.class, Location.class, User.class},
    version = 1,
    exportSchema = true
)

public abstract class GolfDB extends RoomDatabase {

  private static final String DB_NAME = "golf_db";

  /**
   * Returns the single instance of {@link GolfDB} for the current application context.
   *
   * @return single {@link GolfDB} instance reference.
   */
  public synchronized static GolfDB getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Returns an instance of a Room-generated implementation of {@link CourseDao}.
   *
   * @return data access object for CRUD operations involving {@link Course} instances.
   */
  public abstract CourseDao getCourseDao();

  public abstract CourseLocationDao getCourseLocationDao();

  public abstract LocationDao getLocationDao();

  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final GolfDB INSTANCE = Room.databaseBuilder(
        GolfApplication.getInstance().getApplicationContext(), GolfDB.class, DB_NAME)
        .build();

  }



}
