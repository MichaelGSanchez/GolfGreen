package edu.cnm.deepdive.golfgreen.controller;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.golfgreen.R;
import edu.cnm.deepdive.golfgreen.model.Course;
import java.util.List;

//RecyclerView.Adapter
//RecyclerView.ViewHolder

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

  Context context;
  private RecyclerViewFragment recyclerViewFragment;
  private List<Course> favoriteList;

  public FavoriteAdapter(Context context,
      List<Course> favoriteList) {
    this.context = context;
    this.favoriteList = favoriteList;
  }

  @Override
  public FavoriteViewHolder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.course_item, viewGroup, false);
    FavoriteViewHolder holder = new FavoriteViewHolder(view);
    return holder;
  }

  @Override
  public void onBindViewHolder(FavoriteViewHolder holder, int position) {
    Course course =  favoriteList.get(position);

    holder.textViewCourseName.setText(course.getCourseName());
    holder.textViewPrice.setText(String.valueOf(course.getPrice()));
    holder.textViewDifficulty.setText(String.valueOf(course.getDifficulty()));
    holder.textViewPhoneNumber.setText(String.valueOf(course.getPhoneNumber()));//Casted to int, that may not be needed

  }

  @Override
  public int getItemCount() {
    return favoriteList.size();//Favorite list in a bundle, or in query when it rotates
  }

  class FavoriteViewHolder extends RecyclerView.ViewHolder{

    TextView textViewCourseName, textViewPhoneNumber, textViewPrice, textViewDifficulty;

    public FavoriteViewHolder( View itemView) {
      super(itemView);

      textViewCourseName = itemView.findViewById(R.id.textViewCourseName);
      textViewPrice = itemView.findViewById(R.id.textViewPrice);
      textViewDifficulty = itemView.findViewById(R.id.textViewDifficulty);
      textViewPhoneNumber = itemView.findViewById(R.id.textViewPhoneNumber);
    }
  }


}
