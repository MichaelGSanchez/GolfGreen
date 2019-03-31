package edu.cnm.deepdive.golfgreen.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * Demonstrates the use of {@link RecyclerView} with a {@link LinearLayoutManager} to be used in
 * multiple fragments
 */

public class RecyclerViewFragment extends Fragment {

  private static final String TAG = "RecyclerViewFragment";
  private static final String KEY_LAYOUT_MANAGER = "layoutManager";
  public static final String KEY_COURSES = "courses";
  private ArrayList<Course> courses;


  /**
   * Purposefully is in place to help with the implementation of <code>RecyclerViewFragment</code>
   * above.
   */
  public RecyclerViewFragment() {
    this.courses = null;
  }

  /**
   * Is used to help with the layout of the REcyclerView
   */
  private enum LayoutManagerType {
    LINEAR_LAYOUT_MANAGER
  }

  protected LayoutManagerType currentLayoutManagerType;
  protected RecyclerView recyclerView;
  protected RecyclerView.Adapter adapter;
  protected RecyclerView.LayoutManager layoutManager;
  protected List<Course> favoriteList;

  /**
   * Will initialize dataset, from built in database csv files.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  /**
   * Is used to initialize the recyclerView and layout the elements to the recyclerView. This also
   * let's the recycler view know that the elements will be displayed in a LinearLayout format.
   *
   * @param inflater inflates <code>fragment_recycler_view</code>
   * @param container refers to the fragment container in <code>content_main.xml</code>
   * @param savedInstanceState saves the instance created
   * @return return the updated recycler view
   */
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
    view.setTag(TAG);
    courses = (ArrayList<Course>) getArguments().getSerializable(KEY_COURSES);
    recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
    layoutManager = new LinearLayoutManager(getActivity());
    currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

    if (savedInstanceState != null) {

      currentLayoutManagerType = (LayoutManagerType) savedInstanceState
          .getSerializable(KEY_LAYOUT_MANAGER);
    }
    setRecyclerViewLayoutManager(currentLayoutManagerType);

    adapter = new RecycleViewAdapter(getActivity(), courses);
    recyclerView.setAdapter(adapter);
    return view;
  }

  /**
   * Set RecyclerView's LayoutManager to the one given.
   *
   * @param layoutManagerType Type of layout manager to switch to.
   */
  public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
    int scrollPosition = 0;

    /**
     * If a layout manager has already been set, get current scroll position.
     */

    if (recyclerView.getLayoutManager() != null) {
      scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
          .findFirstCompletelyVisibleItemPosition();

    }

    switch (layoutManagerType) {

      case LINEAR_LAYOUT_MANAGER:
        layoutManager = new LinearLayoutManager(getActivity());
        currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        break;
      default:
        layoutManager = new LinearLayoutManager(getActivity());
        currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
    }

    recyclerView.setLayoutManager(layoutManager);
    recyclerView.scrollToPosition(scrollPosition);
  }

  /**
   * Saves the now selected layout and layoutManager
   *
   * @param savedInstanceState Saves currently selected layout manager.
   */
  @Override
  public void onSaveInstanceState(Bundle savedInstanceState) {
    //
    savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, currentLayoutManagerType);
    super.onSaveInstanceState(savedInstanceState);
  }

}