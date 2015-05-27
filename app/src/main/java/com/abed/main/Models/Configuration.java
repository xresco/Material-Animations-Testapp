
package com.abed.main.Models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Configuration extends Abstract_Model{
   	private ArrayList<String> change_keys=new ArrayList<>();
   	private Config_Images configImages;
	private static Configuration instance;

	public static Configuration getInstance(JSONObject object) {
        if(instance!=null)
            return instance;
        if((instance==null) && (object!=null)) {
            instance = new Configuration(object);
            return instance;
        }
        return null;
	}

	private Configuration(JSONObject object)
	{
		super(object);
		try {
			JSONArray jsonArray = object.getJSONArray("change_keys");
			for (int i = 0; i < jsonArray.length(); i++) {
				change_keys.add(jsonArray.getString(i));
			}

			configImages=new Config_Images(object.getJSONObject("images"));
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}



 	public ArrayList<String> getChange_keys(){
		return this.change_keys;
	}
	public void setChange_keys(ArrayList<String> change_keys){
		this.change_keys = change_keys;
	}
 	public Config_Images getConfigImages(){
		return this.configImages;
	}
	public void setConfigImages(Config_Images configImages){
		this.configImages = configImages;
	}
}
