package com.abed.main.UI;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.abed.main.BuildConfig;
import com.abed.main.Controllers.JsonRequestManager;
import com.abed.main.Models.Config_Images;
import com.abed.main.Models.Configuration;
import com.abed.main.Models.Image_Details;
import com.abed.main.Models.Movie;
import com.abed.main.Models.Movie_Images;
import com.abed.main.Models.Video_Metadata;
import com.abed.main.R;
import com.abed.main.UI.Adapters.MoviesImagesAdapter;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.util.ArrayList;

public class MovieImagesActivity extends ParentActivity {
    private ProgressBar progressBar;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (android.os.Build.VERSION.SDK_INT>=21)
            supportPostponeEnterTransition();
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));

        Video_Metadata metadata=(Video_Metadata)getIntent().getExtras().getSerializable("movie");
        setTitle(metadata.getTitle());
        setContentView(R.layout.activity_movie_images);
        progressBar=(ProgressBar) findViewById(R.id.progress);
        gridView=(GridView) findViewById(R.id.images_grid);
        makeRequest(BuildConfig.SERVER_DOMAIN + BuildConfig.MOVIE_API + metadata.getId() + "/images?api_key=" + BuildConfig.API_KEY + "&query=game");


    }


    public void makeRequest(final String url)
    {
        progressBar.setVisibility(View.VISIBLE);
        JsonRequestManager jsonRequestManager=new JsonRequestManager(this,url);
        jsonRequestManager.setDataLoadListener(new JsonRequestManager.DataLoadListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                progressBar.setVisibility(View.GONE);
                Movie_Images movie_images=new Movie_Images(jsonObject);
                ArrayList<Image_Details> arrayList=new ArrayList<Image_Details>();
                arrayList.addAll(movie_images.getPosters());
                arrayList.addAll(movie_images.getBackdrops());

                gridView.setAdapter(new MoviesImagesAdapter(MovieImagesActivity.this,arrayList));
                if (android.os.Build.VERSION.SDK_INT>=21)
                    supportStartPostponedEnterTransition();

            }

            @Override
            public void onFail(String message) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MovieImagesActivity.this, "Loading failed", Toast.LENGTH_SHORT).show();
            }
        });
        jsonRequestManager.doRequest();
    }
}
