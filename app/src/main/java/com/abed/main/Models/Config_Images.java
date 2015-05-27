
package com.abed.main.Models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Config_Images extends Abstract_Model {
   	private ArrayList<String> backdrop_sizes=new ArrayList<>();
   	private String base_url;
   	private ArrayList<String> logo_sizes=new ArrayList<>();
   	private ArrayList<String> poster_sizes=new ArrayList<>();
   	private ArrayList<String> profile_sizes=new ArrayList<>();
   	private String secure_base_url;
   	private ArrayList<String> still_sizes=new ArrayList<>();

	public Config_Images(JSONObject jsonObject)
	{
		super(jsonObject);
		try{
			JSONArray jsonArray = jsonObject.getJSONArray("backdrop_sizes");
			for (int i = 0; i < jsonArray.length(); i++) {
				backdrop_sizes.add(jsonArray.getString(i));
			}

			jsonArray = jsonObject.getJSONArray("logo_sizes");
			for (int i = 0; i < jsonArray.length(); i++) {
				logo_sizes.add(jsonArray.getString(i));
			}


			jsonArray = jsonObject.getJSONArray("poster_sizes");
			for (int i = 0; i < jsonArray.length(); i++) {
				poster_sizes.add(jsonArray.getString(i));
			}


			jsonArray = jsonObject.getJSONArray("profile_sizes");
			for (int i = 0; i < jsonArray.length(); i++) {
				profile_sizes.add(jsonArray.getString(i));
			}

			jsonArray = jsonObject.getJSONArray("still_sizes");
			for (int i = 0; i < jsonArray.length(); i++) {
				still_sizes.add(jsonArray.getString(i));
			}

			base_url=jsonObject.getString("base_url");
			secure_base_url=jsonObject.getString("secure_base_url");

		}catch (Exception e)
		{
            e.printStackTrace();
		}
	}
 	public ArrayList<String> getBackdrop_sizes(){
		return this.backdrop_sizes;
	}
	public void setBackdrop_sizes(ArrayList<String> backdrop_sizes){
		this.backdrop_sizes = backdrop_sizes;
	}
 	public String getBase_url(){
		return this.base_url;
	}
	public void setBase_url(String base_url){
		this.base_url = base_url;
	}
 	public ArrayList<String> getLogo_sizes(){
		return this.logo_sizes;
	}
	public void setLogo_sizes(ArrayList<String> logo_sizes){
		this.logo_sizes = logo_sizes;
	}
 	public ArrayList<String> getPoster_sizes(){
		return this.poster_sizes;
	}
	public void setPoster_sizes(ArrayList<String> poster_sizes){
		this.poster_sizes = poster_sizes;
	}
 	public ArrayList<String> getProfile_sizes(){
		return this.profile_sizes;
	}
	public void setProfile_sizes(ArrayList<String> profile_sizes){
		this.profile_sizes = profile_sizes;
	}
 	public String getSecure_base_url(){
		return this.secure_base_url;
	}
	public void setSecure_base_url(String secure_base_url){
		this.secure_base_url = secure_base_url;
	}
 	public ArrayList<String> getStill_sizes(){
		return this.still_sizes;
	}
	public void setStill_sizes(ArrayList<String> still_sizes){
		this.still_sizes = still_sizes;
	}
}
