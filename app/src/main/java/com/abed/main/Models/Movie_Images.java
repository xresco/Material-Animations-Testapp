
package com.abed.main.Models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movie_Images extends Abstract_Model{
   	private ArrayList<Image_Details> backdrops=new ArrayList<>();
   	private ArrayList<Image_Details> posters=new ArrayList<>();

	public Movie_Images(JSONObject json)
    {
        super(json);
        try {
            JSONArray backdrops_array = json.getJSONArray("backdrops");
            JSONArray posters_array = json.getJSONArray("posters");
            for(int i=0;i<backdrops_array.length();i++)
            {
                backdrops.add(new Image_Details(backdrops_array.getJSONObject(i)));
            }

            for(int i=0;i<posters_array.length();i++)
            {
                posters.add(new Image_Details(posters_array.getJSONObject(i)));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }

 	public ArrayList<Image_Details> getBackdrops(){
		return this.backdrops;
	}
	public void setBackdrops(ArrayList<Image_Details> backdrops){
		this.backdrops = backdrops;
	}
 	public ArrayList<Image_Details> getPosters(){
		return this.posters;
	}
	public void setPosters(ArrayList<Image_Details> posters){
		this.posters = posters;
	}
}
