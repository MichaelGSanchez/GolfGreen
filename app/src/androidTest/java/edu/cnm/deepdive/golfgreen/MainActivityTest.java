package edu.cnm.deepdive.golfgreen;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;
import edu.cnm.deepdive.golfgreen.controller.MainActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule =
      new ActivityTestRule<>(MainActivity.class);


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