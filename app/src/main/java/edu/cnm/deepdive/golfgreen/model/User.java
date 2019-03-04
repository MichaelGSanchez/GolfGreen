package edu.cnm.deepdive.golfgreen.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Location.class,
    parentColumns = "user_id", childColumns = "user_id",
    onDelete = ForeignKey.CASCADE)
)
public class User {
  @ColumnInfo(name = "user_id")
  @PrimaryKey(autoGenerate = true)
  private long id;
  private Long userId;
  private String firstName;
  private String lastName;
  private String userName;
  private String favoriteCourse;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getFavoriteCourse() {
    return favoriteCourse;
  }

  public void setFavoriteCourse(String favoriteCourse) {
    this.favoriteCourse = favoriteCourse;
  }
}
