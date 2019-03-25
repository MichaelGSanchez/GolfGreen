package edu.cnm.deepdive.golfgreen.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(
)

/**
 * Shows the data that is stored in the table for <code>Course.java</code>.  It also shows it's setters and getters
 * for the different fields stored in the <code>Course.java</code> field.
 *
 *  @author Michael Sanchez
 *  @version 1.0
 *
 */
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

  /**
   * Declares the values of each item within the table.
   */
  public Course(long id, String courseName, int price, int difficulty, String url,
      long phoneNumber) {
    this.id = id;
    this.courseName = courseName;
    this.price = price;
    this.difficulty = difficulty;
    this.url = url;
    this.phoneNumber = phoneNumber;
  }

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
