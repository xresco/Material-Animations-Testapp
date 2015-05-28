
package com.abed.main.Models;

import org.json.JSONObject;

public class Image_Details extends Abstract_Model {
   	private int aspect_ratio;
   	private String file_path;
   	private int height;
   	private String iso_639_1;
   	private int vote_average;
   	private int vote_count;
   	private int width;

	public Image_Details(JSONObject jsonObject)
	{
		super(jsonObject);
		try{
			aspect_ratio=jsonObject.getInt("aspect_ratio");
			height=jsonObject.getInt("height");
			vote_average=jsonObject.getInt("vote_average");
			vote_count=jsonObject.getInt("vote_count");
			width=jsonObject.getInt("width");
			file_path=jsonObject.getString("file_path");
			iso_639_1=jsonObject.getString("iso_639_1");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

 	public int getAspect_ratio(){
		return this.aspect_ratio;
	}
	public void setAspect_ratio(int aspect_ratio){
		this.aspect_ratio = aspect_ratio;
	}
 	public String getFile_path(){
		return this.file_path;
	}
	public void setFile_path(String file_path){
		this.file_path = file_path;
	}
 	public int getHeight(){
		return this.height;
	}
	public void setHeight(int height){
		this.height = height;
	}
 	public String getIso_639_1(){
		return this.iso_639_1;
	}
	public void setIso_639_1(String iso_639_1){
		this.iso_639_1 = iso_639_1;
	}
 	public int getVote_average(){
		return this.vote_average;
	}
	public void setVote_average(int vote_average){
		this.vote_average = vote_average;
	}
 	public int getVote_count(){
		return this.vote_count;
	}
	public void setVote_count(int vote_count){
		this.vote_count = vote_count;
	}
 	public int getWidth(){
		return this.width;
	}
	public void setWidth(int width){
		this.width = width;
	}
}
