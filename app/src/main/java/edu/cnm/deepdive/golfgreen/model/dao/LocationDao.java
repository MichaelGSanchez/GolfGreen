package edu.cnm.deepdive.golfgreen.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.golfgreen.model.Course;
import edu.cnm.deepdive.golfgreen.model.Location;
import java.util.List;

/**
 * The Dao that accesses the information and in <code>Location.java</code>
 */

@Dao
public interface LocationDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(Location... locations);


  @Insert
  List<Long> insert(List<Location> locations);

  @Query("SELECT * FROM Location WHERE location_id = :locationId")
  Location findFirstByLocations(long locationId);


  @Query("SELECT * FROM Course INNER JOIN CourseLocation ON Course.course_id = CourseLocation.course_id "
      + "INNER JOIN Location ON Location.location_id = CourseLocation.location_id "
      + "WHERE city LIKE '%' || :search || '%' OR zip LIKE  '%' || :search || '%'")
  List<Course> findAllByCityOrZip(String search);
}
