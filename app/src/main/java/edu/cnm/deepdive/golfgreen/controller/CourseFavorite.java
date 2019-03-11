package edu.cnm.deepdive.golfgreen.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.golfgreen.R;
import edu.cnm.deepdive.golfgreen.model.Course;
import java.util.List;


public class CourseFavorite extends Fragment {


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_course_favorite, container, false);
    Bundle args = getArguments();

/*   favoriteCourseRecyclerView = (RecyclerView) view
       .findViewById(R.id.fragment_course_favorite);
   favoriteCourseRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    updateUI();*/

    return view;
  }

/*  public class CourseHolder extends CourseFavorite{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter courseAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.fragment_course_favorite);
      recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

      // use this setting to improve performance if you know that changes
      // in content do not change the layout size of the RecyclerView
      recyclerView.setHasFixedSize(true);

      // use a linear layout manager
      layoutManager = new LinearLayoutManager(this);
      recyclerView.setLayoutManager(layoutManager);

      // specify an adapter (see also next example)
      adapter = new MyAdapter(myData);
      recyclerView.setAdapter(adapter);
    }

  }*/
/*  public class MyAdapter extends RecyclerView.Adapter<CourseHolder> {

    private List<Course> dataset;

    public CourseHolder(List<Course> courses) {
      courses = courses;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

      public TextView textView;
      public MyViewHolder(TextView v) {
        super(v);
        textView = v;
      }
    }

    public MyAdapter(List<Course> myDataset) {
      dataset = myDataset;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
        int viewType) {
      // create a new view
      TextView v = (TextView) LayoutInflater.from(parent.getContext())
          .inflate(R.layout.fragment_profile_settings, parent, false);

      MyViewHolder vh = new MyViewHolder(v);
      return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CourseHolder holder, int position) {
      // - get element from your dataset at this position
      // - replace the contents of the view with that element
      holder.textView.setText(CourseHolder<position>);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
      return dataset.size();
    }
  }*/


}
