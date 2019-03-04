package edu.cnm.deepdive.golfgreen.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import edu.cnm.deepdive.golfgreen.entity.CourseLocations;

@Entity(foreignKeys = @ForeignKey(entity = CourseLocations.class,
    parentColumns = "location_id", childColumns = "location_id",
    onDelete = ForeignKey.CASCADE)
)

public class Locations {

}
