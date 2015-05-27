
package com.abed.main.Models;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class Page extends Abstract_Model{
   	private int page;
   	private ArrayList<Video_Metadata> results;
   	private int total_pages;
   	private int total_results;


	public Page(JSONObject jsonObject)
	{
		super(jsonObject);
		try{
			page=jsonObject.getInt("page");
			page=jsonObject.getInt("total_pages");
			page=jsonObject.getInt("total_results");

			results=new ArrayList<>();
			JSONArray results_array=jsonObject.getJSONArray("results");
			for(int i=0;i<results_array.length();i++)
			{
				results.add(new Video_Metadata(results_array.getJSONObject(i)));
			}
		}catch (Exception e){

		}
	}

 	public int getPage(){
		return this.page;
	}
	public void setPage(int page){
		this.page = page;
	}
 	public ArrayList<Video_Metadata> getResults(){
		return this.results;
	}
	public void setResults(ArrayList<Video_Metadata> results){
		this.results = results;
	}
 	public int getTotal_pages(){
		return this.total_pages;
	}
	public void setTotal_pages(int total_pages){
		this.total_pages = total_pages;
	}
 	public int getTotal_results(){
		return this.total_results;
	}
	public void setTotal_results(int total_results){
		this.total_results = total_results;
	}
}
