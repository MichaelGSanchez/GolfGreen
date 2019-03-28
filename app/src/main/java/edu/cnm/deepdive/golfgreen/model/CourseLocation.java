package edu.cnm.deepdive.golfgreen.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * An entity class that serves as the many to many intermediary between <code>Course.java</code> and
 * <code>Location.java</code>
 */
@Entity(foreignKeys = @ForeignKey(entity = Location.class,
    parentColumns = "location_id", childColumns = "location_id",//This may need to be course_id
    onDelete = ForeignKey.CASCADE),
    primaryKeys = {"course_id","location_id"}
)
public class CourseLocation {

  @ColumnInfo(name = "course_id")
  private long id;

  @ColumnInfo(name = "location_id")
  private long locationId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getLocationId() {
    return locationId;
  }

  public void setLocationId(long locationId) {
    this.locationId = locationId;
  }

}
