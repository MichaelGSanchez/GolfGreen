package edu.cnm.deepdive.golfgreen.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity(

)
public class User {
  @ColumnInfo(name = "user_id")
  @PrimaryKey(autoGenerate = true)

  private Long id;
  private String firstName;
  private String lastName;
  private String userName;
  private String favoriteCourse;


  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
