package edu.cnm.deepdive.golfgreen;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity(foreignKeys = @ForeignKey(entity = CourseLocations.class,
    parentColumns = "course_id", childColumns = "course_id",
    onDelete = ForeignKey.CASCADE)
)

public class Courses {

}
