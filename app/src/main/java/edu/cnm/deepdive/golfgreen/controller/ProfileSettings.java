package edu.cnm.deepdive.golfgreen.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.golfgreen.R;

/**
 * This is the java class that is used to create and start the <code>ProfileSettings</code>
 * fragment.
 */

public class ProfileSettings extends Fragment {

  /**
   * <code>onCreateView</code> inflates and displays the .XML file <code>fragment_profile_settings</code>
   * and brings the display to the fragment once it has been selected by the user.
   *
   * @param inflater inflates the .XML associated with the fragment
   * @param container refers to the fragment container in the <code>content_main.xml</code>
   * @param savedInstanceState saves the instance of the fragment created.
   * @return returns the updated view
   */
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_profile_settings, container, false);
    Bundle args = getArguments();

    return view;
  }

}
