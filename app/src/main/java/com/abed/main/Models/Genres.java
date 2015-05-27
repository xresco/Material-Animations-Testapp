
package com.abed.main.Models;

import org.json.JSONObject;

import java.util.List;

public class Genres extends Abstract_Model{
   	private String name;

	public Genres(JSONObject jsonObject){
		super(jsonObject);
		try{
			name=jsonObject.getString("name");
		}catch (Exception e){

		}
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}
