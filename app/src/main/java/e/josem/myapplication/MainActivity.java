package e.josem.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Document document;
    String[] titles = new String[20];
    String[] src = new String[20];
    String[] stars = new String[20];
    String[] metaScores = new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute("http://www.imdb.com/list/ls064079588/");


    }

    class DownloadTask extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... url) {

            try {
                document = Jsoup.connect(url[0]).get();
                Log.d("download task","mensaje");
                Log.d("html",document.getAllElements().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }


        protected void onPostExecute(String s) {
            // Elements moviesTitles = document.select(".lister-list .lister-item mode-detail .lister-item-content .lister-item-header a");
            Elements moviesTitles = document.select(".lister-item-header a");
            Elements moviesImage = document.select(".lister-item-image .loadlate");
            Elements movieStars = document.select(".lister-item-content .ratings-bar .inline-block.ratings-imdb-rating strong");
            Elements movieMetaScore =document.select(".lister-item-content .ratings-bar .inline-block.ratings-metascore span");

            for(int i = 0; i<20; i++)
            {
                titles[i]=(moviesTitles.get(i).text());
                src[i] = moviesImage.get(i).attr("loadlate");
                stars[i] = movieStars.get(i).text();
                metaScores[i] = movieMetaScore.get(i).text();

            }
        }

    }

}
