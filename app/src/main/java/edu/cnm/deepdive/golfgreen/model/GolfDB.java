package edu.cnm.deepdive.golfgreen.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import edu.cnm.deepdive.golfgreen.GolfApplication;
import edu.cnm.deepdive.golfgreen.R;
import edu.cnm.deepdive.golfgreen.model.GolfDB.Converters;
import edu.cnm.deepdive.golfgreen.model.dao.CourseDao;
import edu.cnm.deepdive.golfgreen.model.dao.CourseLocationDao;
import edu.cnm.deepdive.golfgreen.model.dao.LocationDao;
import edu.cnm.deepdive.golfgreen.model.dao.UserDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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

@TypeConverters(
    Converters.class
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

  public static class Converters {

    @Nullable
    @TypeConverter
    public static Date dateFromLong(@Nullable Long time) {
      return (time != null) ? new Date(time) : null;
    }

    @Nullable
    @TypeConverter
    public static Long longFromDate(@Nullable Date time) {
      return (time != null) ? time.getTime() : null;
    }


  }

  private class Callback extends RoomDatabase.Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      new PreLoadTask().start();
    }
  }

  private class PreLoadTask extends Thread {

    @Override
    public void run() {
      loadCourses();
      loadLocations();
      loadCourseLocations();
      loadUsers();
    }

    private void loadCourses() {
      try (
          InputStream input = GolfApplication.getInstance().getResources()
              .openRawResource(R.raw.courses);
          Reader reader = new InputStreamReader(input);
          CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withQuote('"').withTrim());
      ) {
        List<Course> courses = new LinkedList<>();
        for (CSVRecord record : parser) {
          Course course = new Course();
          course.setId(Long.parseLong(record.get(0)));
          course.setCourseName(record.get(1));
          course.setPrice(Integer.parseInt(record.get(2)));
          course.setDifficulty(Integer.parseInt(record.get(3)));
          course.setUrl(record.get(4));
          course.setPhoneNumber(Long.parseLong(record.get(5)));

          courses.add(course);
        }
        GolfDB.getInstance().getCourseDao().insert(courses);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    private void loadLocations() {
      try (
          InputStream input = GolfApplication.getInstance().getResources()
              .openRawResource(R.raw.location);
          Reader reader = new InputStreamReader(input);
          CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withQuote('"').withTrim());
      ) {
        List<Location> locations = new LinkedList<>();
        for (CSVRecord record : parser) {
          Location location = new Location();
          location.setId(Long.parseLong(record.get(0)));
          location.setLatitude(Long.parseLong(record.get(1)));
          location.setLatitude(Long.parseLong(record.get(2)));
          location.setCity(record.get(3));
          location.setZip(Long.parseLong(record.get(4)));
          location.setMaxRadius(Integer.parseInt(record.get(5)));
          //TODO add in location.setTimeStamp into location
          locations.add(location);

        }
        GolfDB.getInstance().getLocationDao().insert(locations);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    private void loadCourseLocations() {
      try (
          InputStream input = GolfApplication.getInstance().getResources()
              .openRawResource(R.raw.courselocations);
          Reader reader = new InputStreamReader(input);
          CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withTrim());
      ) {
        List<CourseLocation> courseLocations = new LinkedList<>();
        for (CSVRecord record : parser) {
          CourseLocation courseLocation = new CourseLocation();
          courseLocation.setId(Long.parseLong(record.get(0)));
          courseLocation.setLocationId(Long.parseLong(record.get(1)));
          courseLocations.add(courseLocation);
        }
        GolfDB.getInstance().getCourseLocationDao().insert(courseLocations);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    private void loadUsers() {
      try (
          InputStream input = GolfApplication.getInstance().getResources()
              .openRawResource(R.raw.user);
          Reader reader = new InputStreamReader(input);
          CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withTrim());
      ) {
        List<User> users = new LinkedList<>();
        for (CSVRecord record : parser) {
          User user = new User();
          user.setFirstName(record.get(0));
          user.setLastName(record.get(1));
          user.setUserName(record.get(2));
          user.setFirstName(record.get(3));
        }
        GolfDB.getInstance().getUserDao().insert(users);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

}
