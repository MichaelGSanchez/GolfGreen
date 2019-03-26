package edu.cnm.deepdive.golfgreen.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.golfgreen.model.Course;
import edu.cnm.deepdive.golfgreen.model.CourseLocation;
import edu.cnm.deepdive.golfgreen.model.Location;
import edu.cnm.deepdive.golfgreen.model.User;
import java.util.List;


/**
 * The Dao interface that access the items being passed from <code>CourseLocation.java</code>
 */
@Dao
public interface CourseLocationDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(CourseLocation... courseLocation);

  @Insert
  List<Long> insert(List<CourseLocation> courseLocation);

  @Query("SELECT * FROM CourseLocation")
  List<CourseLocation> findSelect();

  //TODO By location filter

}
