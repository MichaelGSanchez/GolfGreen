package edu.cnm.deepdive.golfgreen.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.util.Date;

/**
 * The entity class that stores the information in the location table.  This table has a many to
 * many relationship with <code>Course.java</code> and is the has an intermediary of
 * <code>CourseLocation.java</code>
 */

@Entity(
)

/**
 * The setters, getters and information stored in the table
 */

public class Location {

  public Location() {

  }

  @ColumnInfo(name = "location_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "latitude")
  private Double latitude;

  @ColumnInfo(name = "longitude")
  private Double longitude;

  @ColumnInfo(name = "city")
  private String city;

  @ColumnInfo(name = "zip")
  private Long zip;

  @ColumnInfo(name = "max_radius")
  private int maxRadius;

  @ColumnInfo(name = "time_stamp")
  private Date timeStamp;

  @ColumnInfo(name = "user_id")
  private long userId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Long getZip() {
    return zip;
  }

  public void setZip(Long zip) {
    this.zip = zip;
  }

  public int getMaxRadius() {
    return maxRadius;
  }

  public void setMaxRadius(int maxRadius) {
    this.maxRadius = maxRadius;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


}
