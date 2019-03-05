package edu.cnm.deepdive.golfgreen.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(
)

public class Course {

  @ColumnInfo(name = "course_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo (name = "course_name")
  private String courseName;

  @ColumnInfo(name = "price")
  private int price;

  @ColumnInfo(name = "difficulty")
  private int difficulty;

  @ColumnInfo(name = "url")
  private String url;

  @ColumnInfo(name = "phone_number")
  private long phoneNumber;


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(int difficulty) {
    this.difficulty = difficulty;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
