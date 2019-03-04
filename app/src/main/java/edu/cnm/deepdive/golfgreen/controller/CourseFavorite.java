package edu.cnm.deepdive.golfgreen.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.golfgreen.R;


public class CourseFavorite extends Fragment {

  public static final String BODY_TEXT_KEY = "body_text";

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_course_favorite, container, false);
    Bundle args = getArguments();
    if (args != null){
      String body = args.getString(BODY_TEXT_KEY);
      if(body != null){
        TextView bodyText = view.findViewById(R.id.body_text);
        bodyText.setText(body);
      }
    }
    return view;
  }

}
