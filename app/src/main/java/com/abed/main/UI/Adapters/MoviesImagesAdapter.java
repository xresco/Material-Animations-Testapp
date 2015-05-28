/**
 *
 */
package com.abed.main.UI.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.abed.main.Models.Config_Images;
import com.abed.main.Models.Configuration;
import com.abed.main.Models.Image_Details;
import com.abed.main.Models.Video_Metadata;
import com.abed.main.R;
import com.abed.main.UI.LargeImageActivity;
import com.abed.main.UI.MovieDetailsActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;


/**
 * The Class TracksAdapter.
 *
 * @author Kishore
 */
public class MoviesImagesAdapter extends BaseAdapter {

    /** The context. */
    private Context context;

    /** The inflater. */
    private LayoutInflater inflater;

    /** The product items. */
    private ArrayList<Image_Details> items;

    public MoviesImagesAdapter(Context context, ArrayList<Image_Details> items) {

        this.context = context;
        this.items = items;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return items.size();
    }


    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }


    @Override
    public long getItemId(int arg0) {
        return arg0;
    }



    @Override
    public View getView(final int position, View convertView,
                        final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.images_item_list, parent,false);
        ViewCache viewCache = new ViewCache(rowView);


        TextView txtName = viewCache.getName();
        final ImageView imgIcon = viewCache.getIcon();

        txtName.setText("Votes: "+items.get(position).getVote_count());

        if(Configuration.getInstance(null)!=null) {
            Config_Images config_images=Configuration.getInstance(null).getConfigImages();
            Glide.with(context)
                    .load(config_images.getBase_url() +config_images.getStill_sizes().get(1)+ items.get(position).getFile_path())
                    .into(imgIcon);
        }

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Configuration.getInstance(null)!=null) {
                    Config_Images config_images = Configuration.getInstance(null).getConfigImages();
                    Intent intent = new Intent(context, LargeImageActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("url", config_images.getBase_url() + config_images.getStill_sizes().get(1) + items.get(position).getFile_path());
                    intent.putExtras(bundle);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity)context,imgIcon,"imgTransition");
                    if (android.os.Build.VERSION.SDK_INT>= 16)
                        context.startActivity(intent, options.toBundle());
                    else
                        context.startActivity(intent);
                }
            }
        });
        return rowView;
    }


    /**
     * The Class ViewCache.
     */
    class ViewCache {

        TextView txtName;
        ImageView imgIcon;


        /**
         * The base view.
         */
        View baseView;

        /**
         * Instantiates a new view cache.
         *
         * @param base the base
         */
        public ViewCache(View base) {
            this.baseView = base;

        }

        /**
         * Gets the name.
         *
         * @return the name
         */
        public TextView getName() {
            if (txtName == null) {
                txtName = (TextView) baseView.findViewById(R.id.txtName);
            }
            return txtName;
        }

        /**
         * Gets the icon.
         *
         * @return the icon
         */
        public ImageView getIcon() {

            imgIcon = (ImageView) baseView.findViewById(R.id.imgcon);
            return imgIcon;
        }
    }

}
