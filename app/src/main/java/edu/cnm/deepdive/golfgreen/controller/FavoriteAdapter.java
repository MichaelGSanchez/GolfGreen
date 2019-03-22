package edu.cnm.deepdive.golfgreen.controller;


import android.content.Context;
import android.support.v4.app.FragmentActivity;
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
    View view = inflater.inflate(R.layout.fragment_course_favorite, null);//NULL IS FOR THE VIEW GROUP SHOULD YOU NEED IT
    FavoriteViewHolder holder = new FavoriteViewHolder(view);
    return holder;
  }

  @Override
  public void onBindViewHolder(FavoriteViewHolder holder, int position) {
    Course course =  favoriteList.get(position);

    holder.textViewCourseName.setText(course.getCourseName());
    holder.textViewPrice.setText(course.getPrice());
    holder.textViewDifficulty.setText(course.getDifficulty());
    holder.textViewPhoneNumber.setText((int) course.getPhoneNumber());//Casted to int, that may not be needed

  }

  @Override
  public int getItemCount() {
    return favoriteList.size();
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
