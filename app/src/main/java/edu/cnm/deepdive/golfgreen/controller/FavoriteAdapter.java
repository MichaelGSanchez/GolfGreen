package edu.cnm.deepdive.golfgreen.controller;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.golfgreen.R;
import edu.cnm.deepdive.golfgreen.model.Course;
import java.util.List;

/**
 * This adapter is the adapter for the <code>RecyclerViewFragment</code>.  This is a crucial class
 * that makes Recycler View possible.
 *
 * @author Michael Sanchez
 * @version 1.0
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

  Context context;
  private RecyclerViewFragment recyclerViewFragment;
  private List<Course> favoriteList;

  /**
   * This provides context for twhat the adapter will be exptected to return
   *
   * @param favoriteList the items which the adapter will grab to display to the fragment.
   */
  public FavoriteAdapter(Context context,
      List<Course> favoriteList) {
    this.context = context;
    this.favoriteList = favoriteList;

  }

  /**
   * <code>FavoriteViewHolder</code> holds the view that will need to be inflated
   * within the RecyclerView
   */
  @Override
  public FavoriteViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.course_item, viewGroup, false);
    FavoriteViewHolder holder = new FavoriteViewHolder(view);
    return holder;
  }

  /**
   * <code>onBindViewHolder</code> retrieves the information from <code>Course.java</code> and
   * utilizes <code>favoriteList</code> to assign a place where the information is stored once it is
   * retrieved from the <code>onCreateViewHolder</code>
   *
   * @param holder is passed from the <code>onCreateViewHolder</code>
   * @param position The place where the the int exists in the holder
   */
  @Override
  public void onBindViewHolder(FavoriteViewHolder holder, int position) {
    Course course = favoriteList.get(position);

    holder.textViewCourseName.setText(course.getCourseName());
    holder.textViewPrice.setText(String.valueOf(course.getPrice()));
    holder.textViewDifficulty.setText(String.valueOf(course.getDifficulty()));
    holder.textViewPhoneNumber
        .setText(String.valueOf(course.getPhoneNumber()));//Casted to int, that may not be needed

  }


  /**
   * gets the contents from the columns.
   */
  @Override
  public int getItemCount() {

    return favoriteList.size();
  }

  /**
   * <code>FavoriteViewHolder</code> outlines what the other holders should be expecting
   * when they are calling other methods, and pulls from the .XML file <code>course_item</code> that
   * define what wil be in each place within the card and recyclerView.
   */
  class FavoriteViewHolder extends RecyclerView.ViewHolder {

    TextView textViewCourseName, textViewPhoneNumber, textViewPrice, textViewDifficulty;

    public FavoriteViewHolder(View itemView) {
      super(itemView);

      textViewCourseName = itemView.findViewById(R.id.textViewCourseName);
      textViewPrice = itemView.findViewById(R.id.textViewPrice);
      textViewDifficulty = itemView.findViewById(R.id.textViewDifficulty);
      textViewPhoneNumber = itemView.findViewById(R.id.textViewPhoneNumber);
    }
  }


}
