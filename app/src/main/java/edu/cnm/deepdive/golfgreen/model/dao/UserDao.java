package edu.cnm.deepdive.golfgreen.model.dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.support.annotation.Nullable;
import edu.cnm.deepdive.golfgreen.model.User;
import java.util.List;

@Dao
public interface UserDao {

  @Insert
  List<Long> insert(User... user);

  @Insert
  List<Long> insert(List<User> user);


  @Query("SELECT first_name, last_name, user_name FROM User")
   List<User> findSelect();



}
