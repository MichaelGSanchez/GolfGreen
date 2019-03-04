package edu.cnm.deepdive.golfgreen.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import edu.cnm.deepdive.golfgreen.entity.Locations;

@Entity(foreignKeys = @ForeignKey(entity = Locations.class,
    parentColumns = "user_id", childColumns = "user_id",
    onDelete = ForeignKey.CASCADE)
)
public class User {

}
