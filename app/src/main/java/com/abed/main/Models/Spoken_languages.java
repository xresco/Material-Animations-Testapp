
package com.abed.main.Models;

import org.json.JSONObject;

import java.util.List;

public class Spoken_languages extends Abstract_Model{
   	private String iso_639_1;
   	private String name;

	public Spoken_languages(JSONObject jsonObject)
	{
		super(jsonObject);
		try {
			name=jsonObject.getString("name");
			iso_639_1=jsonObject.getString("iso_639_1");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
 	public String getIso_639_1(){
		return this.iso_639_1;
	}
	public void setIso_639_1(String iso_639_1){
		this.iso_639_1 = iso_639_1;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}
