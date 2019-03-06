package edu.cnm.deepdive.golfgreen.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.golfgreen.R;

public class ProfileSettings extends Fragment {


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_profile_settings, container, false);
    Bundle args = getArguments();

    return view;
  }

}
