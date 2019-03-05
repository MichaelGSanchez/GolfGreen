package edu.cnm.deepdive.golfgreen.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Location.class,
    parentColumns = "location_id", childColumns = "location_id",//This may need to be course_id
    onDelete = ForeignKey.CASCADE)
)
public class CourseLocation {

  @ColumnInfo(name = "course_id")
  @PrimaryKey(autoGenerate = true)
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
