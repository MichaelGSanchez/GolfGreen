package edu.cnm.deepdive.golfgreen.controller;

import android.content.Intent;
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
import org.w3c.dom.Text;


public class CourseFavorite extends Fragment  {

  private RecyclerView recyclerViewFragment;
  private FavoriteAdapter adapter;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

    recyclerViewFragment = (RecyclerView) view
        .findViewById(R.id.recyclerView);
    (recyclerViewFragment).setLayoutManager(new LinearLayoutManager(getActivity()));

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
  private class CrimeHolder extends RecyclerView.ViewHolder
      implements View.OnClickListener{

    private TextView courseName;
    private TextView phoneNumber;
    private TextView price;
    private TextView difficulty;


    public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
      super(inflater.inflate(R.layout.fragment_course_favorite, parent, false));
      itemView.setOnClickListener(this);

      courseName = (TextView) itemView.findViewById(R.id.textViewCourseName);
      price = (TextView) itemView.findViewById(R.id.textViewPrice);
      difficulty = (TextView) itemView.findViewById(R.id.textViewDifficulty);
      phoneNumber = (TextView) itemView.findViewById(R.id.textViewPhoneNumber);


    }

    @Override
    public void onClick(View v) {

    }

/*    @Override
    public void onClick(View view){
      CourseFavorite c = Course.new(getActivity(), mCrime.getId());
      startActivity(intent);
    }

    public void bind(Crime crime){
      mCrime = crime;
      courseName.setText(mCrime.getTitle());
      phoneNumber.setText(mCrime.getDate().toString());

    }
  }

  private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

    private List<Crime> mCrimes;

    public CrimeAdapter(List<Crime> crimes) {
      mCrimes = crimes;
    }

    @Override
    public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

      return new CrimeHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(CrimeHolder holder, int position) {
      Crime crime = mCrimes.get(position);
      holder.bind(crime);
    }

    @Override
    public int getItemCount() {
      return mCrimes.size();
    }*/
  }

}
