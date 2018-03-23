package e.josem.myapplication;

import android.graphics.Bitmap;

/**
 * Created by josem on 22/3/2018.
 */

public class MovieItem {
    String title;
    String stars;
    String metaScore;
    Bitmap movieImage;
    int imageResource;

    public MovieItem(String title, String stars, String metaScore, Bitmap movieImage){
        this.title = title;
        this.stars = stars;
        this.metaScore = metaScore;
        this.movieImage = movieImage;
    }
    public MovieItem(String title, String stars, String metaScore, int movieImage){
        this.title = title;
        this.stars = stars;
        this.metaScore = metaScore;
        this.imageResource = movieImage;
        this.movieImage = null;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getMetaScore() {
        return metaScore;
    }

    public void setMetaScore(String metaScore) {
        this.metaScore = metaScore;
    }

    public Bitmap getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Bitmap movieImage) {
        this.movieImage = movieImage;
    }
}
