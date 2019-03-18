package edu.cnm.deepdive.golfgreen.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import edu.cnm.deepdive.golfgreen.R;


public class CourseFavorite extends Fragment implements OnClickListener {

  private RecyclerView recyclerView;
  private RecyclerView.Adapter adapter;
  private RecyclerView.LayoutManager layoutManager;

  @Override
  public void onCreate( Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Content(R.layout.fragment_course_favorite);
    recyclerView = (RecyclerView) findViewById(R.id.course_favorite);
    recyclerView.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    adapter = new MyAdapter(dataset);
    recyclerView.setAdapter(adapter);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_course_favorite, container, false);

    return view;
  }



}
