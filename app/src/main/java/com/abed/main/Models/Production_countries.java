
package com.abed.main.Models;

import org.json.JSONObject;

import java.util.List;

public class Production_countries extends Abstract_Model{
   	private String iso_3166_1;
   	private String name;

	public Production_countries(JSONObject jsonObject)
	{
		super(jsonObject);
		try {
			name=jsonObject.getString("name");
			iso_3166_1=jsonObject.getString("iso_3166_1");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
 	public String getIso_3166_1(){
		return this.iso_3166_1;
	}
	public void setIso_3166_1(String iso_3166_1){
		this.iso_3166_1 = iso_3166_1;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}
