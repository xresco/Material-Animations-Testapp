
package com.abed.main.Models;

import org.json.JSONObject;

import java.util.List;

public class Production_companies extends Abstract_Model{
   	private String name;

 	public Production_companies(JSONObject jsonObject)
	{
		super(jsonObject);
		try {
			name=jsonObject.getString("name");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}
