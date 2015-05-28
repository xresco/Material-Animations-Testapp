package com.abed.main.UI;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.abed.main.BuildConfig;
import com.abed.main.Controllers.JsonRequestManager;
import com.abed.main.Models.Configuration;
import com.abed.main.Models.Page;
import com.abed.main.Models.Video_Metadata;
import com.abed.main.R;
import com.abed.main.UI.Adapters.MoviesInfoAdapter;

import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class ItemsFragment extends Fragment implements SearchView.OnQueryTextListener, AbsListView.OnScrollListener{

    private View rootView;
    private GridView productGrid;
    private Spinner sItems;
    private  String url="https://www.zalora.com.my/mobile-api/women/clothing";
    private ProgressBar progressBar;
    private String last_url;
    private int page_count=1;
    private int preLastItem;

    private ArrayList<Video_Metadata> videos;
    private MoviesInfoAdapter adapter;
    public ItemsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_products, container, false);
        init();
        return rootView;
    }

    public void init()
    {
        progressBar=(ProgressBar)rootView.findViewById(R.id.progress);
        productGrid=(GridView)rootView.findViewById(R.id.productGrid);
        productGrid.setOnScrollListener(this);
        last_url=BuildConfig.SERVER_DOMAIN + BuildConfig.SEARCH_API + "api_key=" + BuildConfig.API_KEY + "&query=game";
        videos=new ArrayList<>();
        adapter=new MoviesInfoAdapter(getActivity(),videos);
        productGrid.setAdapter(adapter);
        makeRequest(last_url);
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView lw, final int firstVisibleItem,
                         final int visibleItemCount, final int totalItemCount) {


        final int lastItem = firstVisibleItem + visibleItemCount;
        if(lastItem == totalItemCount) {
            if(preLastItem!=lastItem){ //to avoid multiple calls for last item
                makeRequest(last_url + "&page=" + (++page_count));
                preLastItem= lastItem;
            }

        }

    }


    public void makeRequest(final String url)
    {
        if(Configuration.getInstance(null)==null)
            makeRequestWithConfiguration(url);
        else {
            makeRequestWithoutConfiguration(url);
        }
    }

    public void makeRequestWithoutConfiguration(final String url)
    {
        JsonRequestManager jsonRequestManager=new JsonRequestManager(getActivity(),url);
        jsonRequestManager.setDataLoadListener(new JsonRequestManager.DataLoadListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                progressBar.setVisibility(View.GONE);
                Page p=new Page(jsonObject);
                videos.addAll(p.getResults());
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFail(String message) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(),"Loading failed",Toast.LENGTH_SHORT).show();
            }
        });
        jsonRequestManager.doRequest();
    }
    public void makeRequestWithConfiguration(final String url)
    {
        progressBar.setVisibility(View.VISIBLE);

        String config_url=BuildConfig.SERVER_DOMAIN + BuildConfig.CONFIG_API + "api_key=" + BuildConfig.API_KEY;
        JsonRequestManager jsonRequestManager=new JsonRequestManager(getActivity(),config_url);
        jsonRequestManager.setDataLoadListener(new JsonRequestManager.DataLoadListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                Configuration.getInstance(jsonObject);
                makeRequestWithoutConfiguration(url);
            }

            @Override
            public void onFail(String message) {
            }
        });
        jsonRequestManager.doRequest();

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        last_url=BuildConfig.SERVER_DOMAIN + BuildConfig.SEARCH_API + "api_key=" + BuildConfig.API_KEY + "&query="+query;
        makeRequest(last_url);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        last_url=BuildConfig.SERVER_DOMAIN + BuildConfig.SEARCH_API + "api_key=" + BuildConfig.API_KEY + "&query="+newText;
        makeRequest(last_url);

        return false;
    }
}
