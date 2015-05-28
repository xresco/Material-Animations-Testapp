package com.abed.main.UI;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.abed.main.BuildConfig;
import com.abed.main.Controllers.JsonRequestManager;
import com.abed.main.Models.Image_Details;
import com.abed.main.Models.Movie_Images;
import com.abed.main.Models.Video_Metadata;
import com.abed.main.R;
import com.abed.main.UI.Adapters.MoviesImagesAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;

import org.json.JSONObject;

import java.util.ArrayList;

public class LargeImageActivity extends ParentActivity {
    private ImageView imgcon;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT>=21)
            supportPostponeEnterTransition();

        String img_url=getIntent().getExtras().getString("url");
        setContentView(R.layout.activity_large_image);
        imgcon=(ImageView) findViewById(R.id.imgcon);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        Glide.with(this)
                .load(img_url)
                .into(new ViewTarget<ImageView, GlideDrawable>(imgcon) {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation anim) {
                        imgcon.setImageDrawable(resource);
                        if (android.os.Build.VERSION.SDK_INT>=21)
                            supportStartPostponedEnterTransition();
                        progressBar.setVisibility(View.GONE);

                        // Set your resource on myView and/or start your animation here.
                    }
                });

    }


}
