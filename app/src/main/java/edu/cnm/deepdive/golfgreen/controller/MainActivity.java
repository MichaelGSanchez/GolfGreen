package edu.cnm.deepdive.golfgreen.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import edu.cnm.deepdive.golfgreen.R;
import edu.cnm.deepdive.golfgreen.service.GoogleSignInService;


/**
 * This <code>MainActivity</code> is the launching point of the entire app.
 * The app runs through <code>MainActivity</code> and implements the navigational
 * features of its {@link NavigationView} in the <code>MainActivity</code>
 *
 *
 * @author Michael Sanchez
 * @version 1.0
 *
 */

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener   {

  /**
   *<code>OnCreate</code> launches the app within the <code> MainActivity </code> method. In
   * <code>onCreate</code> it calls the <code>R.layout.activity_main</code> to enable all
   * other <code>.XML</code> files. Furthermore, it also uses a {@link FragmentManager} to
   * have the app start in its <code>Home</code> fragment.
   *
   *
   * @param savedInstanceState Saves the instance created in <code>onCreate</code>
   */

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


  /**
   * <code>onBackPressed</code> ensures that when back is pressed it exits the
   * app, that is unless the nav drawer is open.  If the nav drawer is open the back arrow
   * or button simply exits you from the nav drawer back to what you were doing in the app.
   */

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  /**
   * <code>onCreateOptionsMenu</code> inflates <code>R.menu.options_menu</code>
   * which houses the signout function and search bar. Which is the crux of the entire application.
   * @param menu this is simply calling the menu which it will implement in
   * <code>onCreateOptionsMenu</code>
   *
   */

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.options_menu, menu);

    return true;
  }

  /**
   * <code>onOptionsItemSelected</code> provides the ability to switch back and fourth between
   * the items in <code>onCreateOptionsMenu</code>.
   *
   * @param item calls the menu items to select from
   * @return returns boolean value of handled once an item is selected.
   */

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


  /**
   * <code>onNavigationItemSelected</code> is a switch statement that launches fragments
   * once they are selected.
   *
   * @param item gets the id associated with each fragment.
   * @return closes the drawer once the desired fragment is selected and started.
   */
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

  /**
   * Once the {@link Fragment} is selected from <code>onNavigationItemSelected</code> this
   * initializes the fragment to start.
   */
  public void loadFragment(Fragment fragment, int container, String tag, Bundle args) {
    FragmentManager manager = getSupportFragmentManager();
    if (args != null) {
      fragment.setArguments(args);
    }
    manager.beginTransaction()
        .add(container, fragment, tag)
        .commit();
  }

  /**
   * <code>signOut</code> is used so the user may sign out of their signed in google
   * account, should they desire.
   *
   */
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
