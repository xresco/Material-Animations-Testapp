package com.abed.main.Controllers;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class JsonRequestManager {

    private final String LOG_TAG=getClass().getName();
    private  com.android.volley.toolbox.JsonObjectRequest jsObjRequest;
    private Context context;
    private String url;
    private DataLoadListener dataLoadListener;


    public JsonRequestManager(Context context, String url)
    {
        this.context=context;
        this.url=url;

    }


    public void doRequest() {
       jsObjRequest = new JsonObjectRequest(
                Request.Method.GET, url,(String) null, new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        if(dataLoadListener!=null)
                            dataLoadListener.onSuccess(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        if(dataLoadListener!=null)
                            dataLoadListener.onFail(error.getMessage());

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsObjRequest);
    }


    public void cancelRequest() {
        //stop the request from being called
        jsObjRequest.cancel();
    }

    public void setDataLoadListener(DataLoadListener dataLoadListener) {
        this.dataLoadListener = dataLoadListener;
    }

    public interface DataLoadListener{
        void onSuccess(JSONObject jsonObject);
        void onFail(String message);

    }

}
