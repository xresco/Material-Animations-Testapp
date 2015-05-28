package com.abed.main.UI;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.abed.main.R;


public class ItemsActivity extends ParentActivity {

    ItemsFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));

        setContentView(R.layout.activity_items);
        fragment=(ItemsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_items, menu);
        // Associate searchable configuration with the SearchView

        SearchManager searchManager =(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        SearchableInfo info =searchManager.getSearchableInfo(getComponentName());
        searchView.setSearchableInfo(info);
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener( fragment);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
