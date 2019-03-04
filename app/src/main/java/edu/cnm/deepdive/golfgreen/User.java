package edu.cnm.deepdive.golfgreen;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity(foreignKeys = @ForeignKey(entity = Locations.class,
    parentColumns = "user_id", childColumns = "user_id",
    onDelete = ForeignKey.CASCADE)
)
public class User {

}
