package edu.cnm.deepdive.golfgreen.model.dao;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import edu.cnm.deepdive.golfgreen.model.GolfDB;
import edu.cnm.deepdive.golfgreen.model.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocationDaoTest {

  private GolfDB golfDB;
  private LocationDao locationDao;

  @Before
  public void setUp() throws Exception {
    Context context = InstrumentationRegistry.getContext();
    golfDB = Room.inMemoryDatabaseBuilder(context, GolfDB.class).build();
    locationDao = golfDB.getLocationDao();
  }

  @Test
  //TODO Add delete option from favorite courses
  public void insert() {
    //insert just shows that something has been inserted?
    Location location = new Location();
    //What we want to get
    //
    //
    //
    //
    //the actual test, if things are working or not working

  }

  @After
  public void tearDown() throws Exception {
    golfDB.close();
  }
}