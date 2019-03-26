package edu.cnm.deepdive.golfgreen;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;
import edu.cnm.deepdive.golfgreen.controller.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule =
      new ActivityTestRule<>(MainActivity.class);


/*
  public void clickOnYourNavigationItem_ShowsYourScreen() {
    // Open Drawer to click on navigation.
    onView(withId(R.id.drawer_layout))
        .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
        .perform(DrawerActions.open()); // Open Drawer

    // Start the screen of your activity.
    onView(withId(R.id.nav_view))
        .perform(NavigationViewActions.navigateTo(R.id.fragment_course_favorite));

    // Check that you Activity was opened.
    String expectedNoStatisticsText = InstrumentationRegistry.getTargetContext()
        .getString(R.string.favorite_course);
    onView(withId(R.id.recyclerView)).check(matches(withText(expectedNoStatisticsText)));
  }
*/

  @Test
  public void navigateToCourseFavorite() {
    //Click on navigation item
    onView(withId(R.id.fragment_course_favorite))
        .perform(click());
    //Make sure fragment is loaded
    onView(withId(R.id.course_favorite_fragment_container))
        .check(matches(isDisplayed()));
  }

  @Test
  public void navigateToSearchFragment() {
    //Click on navigation item
    onView(withId(R.id.fragment_search_result))
        .perform(click());
    //Make sure fragment is loaded
    onView(withId(R.id.search_results))
        .check(matches(isDisplayed()));

  }

  @Test
  public void navigateToIndividualCourse() {
    //Click on navigation item
    onView(withId(R.id.fragment_individual_course))
        .perform(click());
    //Make sure fragment is loaded
    onView(withId(R.id.selected_course))
        .check(matches(isDisplayed()));
  }

  @Test
  public void navigateToProfileSettings() {
    //Click on navigation item
    onView(withId(R.id.profile_settings))
        .perform(click());
    //Make sure fragment is loaded
    onView(withId(R.id.profile_settings))
        .check(matches(isDisplayed()));
  }
}