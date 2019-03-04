package edu.cnm.deepdive.golfgreen;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity(foreignKeys = @ForeignKey(entity =CourseLocations.class,
    parentColumns = "location_id", childColumns = "location_id",
    onDelete = ForeignKey.CASCADE)
)

public class Locations {

}
