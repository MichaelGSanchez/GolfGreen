package edu.cnm.deepdive.golfgreen.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.golfgreen.R;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

  private List<String> data;
  private LayoutInflater inflater;
  private ItemClickListener clickListener;

  // data is passed into the constructor
  FavoriteAdapter(Context context, List<String> data) {
    this.inflater = LayoutInflater.from(context);
    this.data = data;
  }

  // inflates the row layout from xml when needed
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.fragment_course_favorite, parent, false);
    return new ViewHolder(view);
  }

  // binds the data to the TextView in each row
  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    String animal = data.get(position);
    holder.myTextView.setText(animal);
  }

  // total number of rows
  @Override
  public int getItemCount() {
    return data.size();
  }


  // stores and recycles views as they are scrolled off screen
  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView myTextView;

    ViewHolder(View itemView) {
      super(itemView);
      myTextView = itemView.findViewById(R.id.fragment_course_favorite);
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      if (clickListener != null)
        clickListener.onItemClick(view, getAdapterPosition());
    }
  }

  // convenience method for getting data at click position
  String getItem(int id) {
    return data.get(id);
  }

  // allows clicks events to be caught
  void setClickListener(ItemClickListener itemClickListener) {
    this.clickListener = itemClickListener;
  }

  // parent activity will implement this method to respond to click events
  public interface ItemClickListener {

    void onItemClick(View view, int position);
  }
}