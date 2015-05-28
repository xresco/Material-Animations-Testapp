/**
 *
 */
package com.abed.main.UI.Adapters;

import java.util.ArrayList;

import com.abed.main.Models.Config_Images;
import com.abed.main.Models.Configuration;
import com.abed.main.Models.Video_Metadata;
import com.abed.main.R;

import com.abed.main.UI.MovieDetailsActivity;
import com.bumptech.glide.Glide;

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


/**
 * The Class TracksAdapter.
 *
 * @author Kishore
 */
public class MoviesInfoAdapter extends BaseAdapter {

    /** The context. */
    private Context context;

    /** The inflater. */
    private LayoutInflater inflater;

    /** The product items. */
    private ArrayList<Video_Metadata> items;

    public MoviesInfoAdapter(Context context, ArrayList<Video_Metadata> items) {

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
        View rowView = convertView;
        ViewCache viewCache = null;

        //	final TrackModel listModel = trackItems.get(position);
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.movie_item_list, parent,false);
            viewCache = new ViewCache(rowView);
            rowView.setTag(viewCache);
        } else {
            viewCache = (ViewCache) rowView.getTag();
        }


        TextView txtName = viewCache.getName();
        TextView txtPrice = viewCache.getPrice();
        TextView txtBrand= viewCache.getBrand();
        ImageView imgIcon = viewCache.getIcon();

        txtName.setText(items.get(position).getTitle());
        txtPrice.setText(items.get(position).getOriginal_title());
        txtBrand.setText(items.get(position).getRelease_date());

        if(Configuration.getInstance(null)!=null) {
            Config_Images config_images=Configuration.getInstance(null).getConfigImages();
            Glide.with(context)
                    .load(config_images.getBase_url() +config_images.getStill_sizes().get(1)+ items.get(position).getPoster_path())
                    .into(imgIcon);
        }

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MovieDetailsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("movie", items.get(position));
                intent.putExtras(bundle);
//                context.startActivity(intent);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity)context);
                if (android.os.Build.VERSION.SDK_INT>= 16)
                    context.startActivity(intent, options.toBundle());
                else
                    context.startActivity(intent);
            }
        });
        return rowView;
    }


    /**
     * The Class ViewCache.
     */
    class ViewCache {

        TextView txtName;
        TextView txtBrand;
        TextView txtPrice;
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
         * Gets the author.
         *
         * @return the author
         */
        public TextView getBrand() {
            if (txtBrand == null) {
                txtBrand = (TextView) baseView.findViewById(R.id.txtBrand);
            }
            return txtBrand;
        }

        /**
         * Gets the price.
         *
         * @return the price
         */
        public TextView getPrice() {
            if (txtPrice == null) {
                txtPrice = (TextView) baseView.findViewById(R.id.txtPrice);
            }
            return txtPrice;
        }

        /**
         * Gets the icon.
         *
         * @return the icon
         */
        public ImageView getIcon() {

            imgIcon = (ImageView) baseView.findViewById(R.id.imgIcon);
            return imgIcon;
        }
    }

}
