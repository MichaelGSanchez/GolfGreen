package edu.cnm.deepdive.golfgreen.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = CourseLocation.class,
    parentColumns = "location_id", childColumns = "location_id",
    onDelete = ForeignKey.CASCADE)
)

public class Location {

  @ColumnInfo(name = "location_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @NonNull

  private Long latitude;
  private Long longitude;
  private String city;
  private Long zip;
  private int maxRadius;
  private Date timeStamp;

  public long getId(){
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  public Long getLatitude(){
    return latitude;
  }

  public void setLatitude(Long latitude) {
    this.latitude = latitude;
  }

  public Long getLongitude() {
    return longitude;
  }

  public void setLongitude(Long longitude) {
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


}
