package edu.cnm.deepdive.golfgreen.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cnm.deepdive.golfgreen.R;
import edu.cnm.deepdive.golfgreen.model.Course;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link RecyclerViewFragment.OnFragmentInteractionListener} interface to handle interaction
 * events. Use the {@link RecyclerViewFragment#newInstance} factory method to create an instance of
 * this fragment.
 */
public class RecyclerViewFragment extends Fragment {

  RecyclerView recyclerView;

  List<Course> favoriteList;



  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_recycler_view, container, false);

  }

/*  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_recycler_view);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager (new LinearLayoutManager(this));

    favoriteList = new ArrayList<>();

  }*/
}
