package edu.cnm.deepdive.golfgreen.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.golfgreen.model.Course;
import edu.cnm.deepdive.golfgreen.model.CourseLocation;
import edu.cnm.deepdive.golfgreen.model.Location;
import java.util.List;

@Dao
public interface CourseLocationDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(CourseLocation... courseLocation);
  @Insert
  List<Long> insert(List<CourseLocation> courseLocation);

  @Query("SELECT * FROM CourseLocation WHERE courseLocation_id = :courseId")
  Course findFirstByCourse(long courseId);

  @Query("SELECT * FROM Course")
    //TODO By location
  List<Location> findAll();
}
