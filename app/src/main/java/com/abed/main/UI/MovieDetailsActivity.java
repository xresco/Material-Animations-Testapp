package com.abed.main.UI;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.abed.main.BuildConfig;
import com.abed.main.Controllers.JsonRequestManager;
import com.abed.main.Models.Config_Images;
import com.abed.main.Models.Configuration;
import com.abed.main.Models.Movie;
import com.abed.main.Models.Page;
import com.abed.main.Models.Video_Metadata;
import com.abed.main.R;
import com.abed.main.UI.Adapters.MoviesInfoAdapter;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.util.ArrayList;

public class MovieDetailsActivity extends ParentActivity {

    private ImageView imgCover;
    private TextView txtTitle;
    private TextView txtOverview;
    private Button btnGallery;
    private ProgressBar progressBar;
    private Video_Metadata metadata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));

        metadata=(Video_Metadata)getIntent().getExtras().getSerializable("movie");
        setTitle(metadata.getTitle());
        setContentView(R.layout.activity_movie_details);
        imgCover=(ImageView) findViewById(R.id.imgCover);
        txtTitle=(TextView) findViewById(R.id.txtTitle);
        txtOverview=(TextView) findViewById(R.id.txtOverview);
        btnGallery=(Button) findViewById(R.id.btnGallery);
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MovieDetailsActivity.this,MovieImagesActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("movie", metadata);
                intent.putExtras(bundle);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MovieDetailsActivity.this);
                if (android.os.Build.VERSION.SDK_INT>= 16)
                    startActivity(intent, options.toBundle());
                else
                    startActivity(intent);

            }
        });

        txtTitle.setText(metadata.getTitle());
        progressBar=(ProgressBar) findViewById(R.id.progress);

        if(Configuration.getInstance(null)!=null) {
            Config_Images config_images = Configuration.getInstance(null).getConfigImages();
            Glide.with(this)
                    .load(config_images.getBase_url() + config_images.getStill_sizes().get(1) + metadata.getBackdrop_path())
                    .into(imgCover);

            makeRequest(BuildConfig.SERVER_DOMAIN + BuildConfig.MOVIE_API + metadata.getId() + "?api_key=" + BuildConfig.API_KEY + "&query=game");
        }

    }


    public void makeRequest(final String url)
    {
        progressBar.setVisibility(View.VISIBLE);
        JsonRequestManager jsonRequestManager=new JsonRequestManager(this,url);
        jsonRequestManager.setDataLoadListener(new JsonRequestManager.DataLoadListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                progressBar.setVisibility(View.GONE);
                Movie movie=new Movie(jsonObject);
                txtOverview.setText(movie.getOverview());

            }

            @Override
            public void onFail(String message) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MovieDetailsActivity.this, "Loading failed", Toast.LENGTH_SHORT).show();
            }
        });
        jsonRequestManager.doRequest();
    }
}
