package edu.cnm.deepdive.golfgreen.controller;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup.Input;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import edu.cnm.deepdive.golfgreen.R;
import edu.cnm.deepdive.golfgreen.model.Course;
import edu.cnm.deepdive.golfgreen.service.GoogleSignInService;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener   {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    Fragment fragmentHome = new Home();

    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentHome ,"home" );
    transaction.commit();

  }

/*  @Override
  public void NavigationView(View view, int position) {
    Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
  }*/
/*    try (
        InputStream input = getResources().openRawResource(R.raw.location);
        Reader reader = new InputStreamReader(input);
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
    ){
      for (CSVRecord record : parser){
        String col0 = record.get(0);
        String col1 = record.get(1);
      }
    } catch (IOException e) {
      Log.e("Welp, it don't work... ", getClass().getSimpleName());
    }*/




  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.options_menu, menu);

    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    boolean handeled = true;
    switch (item.getItemId()){
      case R.id.action_settings:
        getActionBar();
        break;
      case R.id.sign_out:
        signOut();
        break;
      default:
        handeled = super.onOptionsItemSelected(item);
    }
    return handeled;
  }

  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    Bundle args = new Bundle();
    switch (item.getItemId()) {
      case R.id.fragment_home:
        loadFragment(new Home(), R.id.fragment_container, "fragment_home", null);
        break;
      case R.id.fragment_course_favorite:
        loadFragment(new CourseFavorite(), R.id.fragment_container, "course_favorite_item",
            null);
        break;
      case R.id.fragment_search_result:
        loadFragment(new SearchResult(), R.id.fragment_container, "fragment_search_result",
            null);
        break;
      case R.id.fragment_individual_course:
        loadFragment(new IndividualCourse(), R.id.fragment_container, "fragment_individual_course",
            null);
        break;
      case R.id.fragment_profile_settings:
        loadFragment(new ProfileSettings(), R.id.fragment_container, "fragment_profile_settings",
            null);
        break;

    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  public void loadFragment(Fragment fragment, int container, String tag, Bundle args) {
    FragmentManager manager = getSupportFragmentManager();
    if (args != null) {
      fragment.setArguments(args);
    }
    manager.beginTransaction()
        .add(container, fragment, tag)
        .commit();
  }

  private void signOut(){
    GoogleSignInService.getInstance().getClient()
        .signOut()
        .addOnCompleteListener(this, (task -> {
          GoogleSignInService.getInstance().setAccount(null);
          Intent intent = new Intent (this, LoginActivity.class);
          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);
        }));
  }
}
