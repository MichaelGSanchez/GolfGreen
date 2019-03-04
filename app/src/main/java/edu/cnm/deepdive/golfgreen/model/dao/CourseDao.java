package edu.cnm.deepdive.golfgreen.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.golfgreen.model.Course;
import java.util.List;

@Dao
public interface CourseDao {

  @Insert
  List<Long> insert(Course... course);

  @Insert
  List<Long> insert(List<Course> course);

  @Query
      ("SELECT * FROM Course")

   List<Course> findAll();

}
