package edu.cnm.deepdive.golfgreen.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.golfgreen.model.Location;
import java.util.List;

@Dao
public interface LocationDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(Location... locations);
  @Insert
  List<Long> insert(List<Location> locations);

  @Query("SELECT * FROM Location WHERE location_id = :locationId")
  Location findFirstByLocations(long locationId);

  @Query("SELECT * FROM Location")
  //TODO By location
  List<Location> findAll();
}
