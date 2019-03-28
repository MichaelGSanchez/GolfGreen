package edu.cnm.deepdive.golfgreen.controller;

import static edu.cnm.deepdive.golfgreen.controller.RecyclerViewFragment.KEY_COURSES;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.golfgreen.R;
import edu.cnm.deepdive.golfgreen.model.Course;
import edu.cnm.deepdive.golfgreen.model.GolfDB.SearchTask;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass. Inflates and activates the .XML file
 * <code>fragment_search_result</code>
 */
public class SearchResult extends Fragment {

  public static final String SEARCH_KEY = "search";
  private RecyclerViewFragment recyclerViewFragment;
  private RecyclerViewAdapter adapter;

  public static SearchResult newInstance(String search) {

    Bundle args = new Bundle();
    args.putString(SEARCH_KEY, search);
    SearchResult fragment = new SearchResult();
    fragment.setArguments(args);
    return fragment;
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_search_result, container, false);

    String query = getArguments().getString(SEARCH_KEY);

    new SearchTask(){
      @Override
      protected void onPostExecute(ArrayList<Course> courses) {
        recyclerViewFragment = new RecyclerViewFragment();
        Bundle args = new Bundle();
        args.putSerializable(KEY_COURSES, courses);
        recyclerViewFragment.setArguments(args);
        getFragmentManager().beginTransaction().add(
            R.id.search_result_fragment_container, recyclerViewFragment, "FragmentContainer")
            .commit();

        updateUI();
      }
    }.execute(query);

    return view;
  }

  /**
   * Is part of the fragment class to implement the updated UI.
   */
  @Override
  public void onResume() {
    super.onResume();
    updateUI();
  }

  private void updateUI() {
    //Do nothing!
  }

  /**
   * This is the holder, that is used to help describe the metadata found in the adapter and where
   * it will be displayed in the <code>RecyclerView</code>
   */
  private class RecyclerViewHolder extends RecyclerView.ViewHolder
      implements View.OnClickListener {

    private TextView courseName;
    private TextView phoneNumber;
    private TextView price;
    private TextView difficulty;

    /**
     * Holds the data that will be displayed in each individual card.
     *
     * @param inflater inflates <code>R.layout.course_item</code>
     * @param parent refers to the ViewGroup and how the information will be displayed being set
     * based off of its parent
     */
    public RecyclerViewHolder(LayoutInflater inflater, ViewGroup parent) {
      super(inflater.inflate(R.layout.course_item, parent, false));
      itemView.setOnClickListener(this);

      courseName = (TextView) itemView.findViewById(R.id.textViewCourseName);
      price = (TextView) itemView.findViewById(R.id.textViewPrice);
      difficulty = (TextView) itemView.findViewById(R.id.textViewDifficulty);
      phoneNumber = (TextView) itemView.findViewById(R.id.textViewPhoneNumber);

    }

    /**
     * This will take you to the individual course page from the <code>favoriteCourses</code>
     * fragment.
     */
    @Override
    public void onClick(View view) {
      //TODO implement onClick to open selected course page from the favorite fragment.
    }

    /**
     * Connects the data being pulled from the <code>Course</code> class.
     *
     * @param course is the entity that houses the parameters on info that a course may be able to
     * display
     */
    public void bind(Course course) {
      courseName.setText(Course.class.getName());
      phoneNumber.setText(Course.class.getName());
      price.setText(Course.class.getName());
      difficulty.setText(Course.class.getName());

    }
  }

  /**
   * The adapter that links <code>RecycleViewAdapter</code> and <code>CourseFavorite</code>.  This
   * adapter returns a list from <code>Course.java</code>.
   */
  private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Course> courses;

    public RecyclerViewAdapter(List<Course> courses) {

    }

    /**
     * <code>onCreateViewHolder</code> returns the new layout that has been inflated
     *
     * @param parent is the parameter given to <code>ViewGroup</code>
     * @param viewType is the view type to help implement the <code>recyclerView</code>
     * @return returns the updated <code>RecyclerViewHolder</code>
     */
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

      return new SearchResult.RecyclerViewHolder(layoutInflater, parent);
    }

    /**
     * Binds the information from the holder and adapter to help implement <code<>RecyclerView</>
     *
     * @param holder is the holder of the metadata being passed to the
     * <code>onBindViewHolder</code>
     * @param position get's the information from <code>Course.java</code>
     */

    @Override
    public void onBindViewHolder(SearchResult.RecyclerViewHolder holder, int position) {
      Course course = courses.get(position);
      holder.bind(course);
    }

    /**
     * retrieves the number of items being passed to the recycler view and returns their size.
     *
     * @return returns the items from <code>courses<code/>
     */
    @Override
    public int getItemCount() {
      return courses.size();
    }
  }


}
