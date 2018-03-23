package e.josem.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by josem on 22/3/2018.
 */

public class MovieAdapter extends ArrayAdapter<MovieItem> {
    ArrayList<MovieItem> movies = new ArrayList<>();

    public MovieAdapter(Context context, int textViewId,ArrayList<MovieItem> movies){
        super(context,textViewId,movies);
        this.movies = movies;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.grid_view_items, null);
        TextView titleText = v.findViewById(R.id.titleText);
        TextView starsText = v.findViewById(R.id.starsText);
        TextView metaScoreText = v.findViewById(R.id.metaScoreText);
        ImageView imageView = v.findViewById(R.id.movieImg);
        titleText.setText(movies.get(position).getTitle());
        starsText.setText("Stars: " + movies.get(position).getStars());
        metaScoreText.setText("Metascore: " + movies.get(position).getMetaScore());
        if(movies.get(position).getMovieImage() != null)
            imageView.setImageBitmap(movies.get(position).getMovieImage());
        else
            imageView.setImageResource(movies.get(position).getImageResource());

        return v;

    }
}
