package edu.cnm.deepdive.golfgreen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class courseFavorite extends Fragment {

  private static final String BODY_TEXT_KEY = "body_text";


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_course_favorite, container, false);
    Bundle args = getArguments();
    if (args != null){
      String body = args.getString(BODY_TEXT_KEY);
        if(body != null){
          TextView bodyText = getView().findViewById(R.id.body_text);
          bodyText.setText(body);
        }
    }
    return view;
  }


}
