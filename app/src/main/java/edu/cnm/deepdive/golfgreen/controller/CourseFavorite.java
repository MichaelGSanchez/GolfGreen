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
import java.util.ArrayList;
import java.util.List;


public class CourseFavorite extends Fragment  {

  private RecyclerViewFragment recyclerViewFragment;
  private FavoriteAdapter adapter;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_course_favorite, container, false);

    List<Course>courses = new ArrayList<>();
    Course course = new Course(0, "Course: UNM North", 35, 7, "url: unm.edu", 505l-555l-5555l);
    courses.add(course);

    recyclerViewFragment = new RecyclerViewFragment(courses);
    getFragmentManager().beginTransaction().add(
         R.id.course_favorite_fragment_container, recyclerViewFragment,"FragmentContainer")
        .commit();

    updateUI();

    return view;
  }

  @Override
  public void onResume(){
    super.onResume();
    updateUI();
  }

  private void updateUI(){

  }
  private class FavoriteViewHolder extends RecyclerView.ViewHolder
      implements View.OnClickListener{

    private TextView courseName;
    private TextView phoneNumber;
    private TextView price;
    private TextView difficulty;


    public FavoriteViewHolder(LayoutInflater inflater, ViewGroup parent) {
      super(inflater.inflate(R.layout.course_item, parent, false));
      itemView.setOnClickListener(this);

      courseName = (TextView) itemView.findViewById(R.id.textViewCourseName);
      price = (TextView) itemView.findViewById(R.id.textViewPrice);
      difficulty = (TextView) itemView.findViewById(R.id.textViewDifficulty);
      phoneNumber = (TextView) itemView.findViewById(R.id.textViewPhoneNumber);

    }

/*
    @Override
    public void onClick(View v) {

    }
*/

    @Override
    public void onClick(View view){

    }

    public void bind(Course course){
      courseName.setText(Course.class.getName());

    }
  }

  private class FavoriteAdapter extends RecyclerView.Adapter<FavoriteViewHolder> {

    private List<Course> courses;

    public FavoriteAdapter(List<Course> courses) {

    }

    @Override
    public FavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

      return new FavoriteViewHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(FavoriteViewHolder holder, int position) {
      Course course = courses.get(position);
      holder.bind(course);
    }

    @Override
    public int getItemCount() {
      return courses.size();
    }
  }

}
