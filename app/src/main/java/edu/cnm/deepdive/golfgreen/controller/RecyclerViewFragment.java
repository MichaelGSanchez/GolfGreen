package edu.cnm.deepdive.golfgreen.controller;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import edu.cnm.deepdive.golfgreen.R;
import edu.cnm.deepdive.golfgreen.model.Course;
import java.util.List;

/**
 * Demonstrates the use of {@link RecyclerView} with a {@link LinearLayoutManager} and a
 * {@link GridLayoutManager}.
 */
public class RecyclerViewFragment extends Fragment {

  private static final String TAG = "RecyclerViewFragment";
  private static final String KEY_LAYOUT_MANAGER = "layoutManager";


  private enum LayoutManagerType {
    LINEAR_LAYOUT_MANAGER
  }

  protected LayoutManagerType currentLayoutManagerType;
  protected RecyclerView recyclerView;
  protected Adapter adapter;
  protected RecyclerView.LayoutManager layoutManager;
  protected List<Course> favoriteList;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Initialize dataset, this data would usually come from a local content provider or
    // remote server.

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
    view.setTag(TAG);

    // BEGIN_INCLUDE(initializeRecyclerView)
    recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

    // LinearLayoutManager is used here, this will layout the elements in a similar fashion
    // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
    // elements are laid out.
    layoutManager = new LinearLayoutManager(getActivity());

    currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

    if (savedInstanceState != null) {
      // Restore saved layout manager type.
      currentLayoutManagerType = (LayoutManagerType) savedInstanceState
          .getSerializable(KEY_LAYOUT_MANAGER);
    }
    setRecyclerViewLayoutManager(currentLayoutManagerType);
/*

    adapter = new ();
    // Set CustomAdapter as the adapter for RecyclerView.
    recyclerView.setAdapter((RecyclerView.Adapter) adapter);
    // END_INCLUDE(initializeRecyclerView)
*/

    return view;
  }

  /**
   * Set RecyclerView's LayoutManager to the one given.
   *
   * @param layoutManagerType Type of layout manager to switch to.
   */
  public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
    int scrollPosition = 0;

    // If a layout manager has already been set, get current scroll position.
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

  @Override
  public void onSaveInstanceState(Bundle savedInstanceState) {
    // Save currently selected layout manager.
    savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, currentLayoutManagerType);
    super.onSaveInstanceState(savedInstanceState);
  }

  /**
   * Generates Strings for RecyclerView's adapter. This data would usually come
   * from a local content provider or remote server.
   */
}