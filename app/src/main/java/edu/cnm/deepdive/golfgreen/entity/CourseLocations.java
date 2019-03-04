package edu.cnm.deepdive.golfgreen.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity(foreignKeys = @ForeignKey(entity = Locations.class,
    parentColumns = "location_id", childColumns = "location_id",
    onDelete = ForeignKey.CASCADE)
)
public class CourseLocations {

}
