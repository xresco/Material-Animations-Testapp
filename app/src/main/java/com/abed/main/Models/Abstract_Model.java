package com.abed.main.Models;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by mindvalley on 5/26/15.
 */
public class Abstract_Model implements Serializable {

    protected int id;
    public Abstract_Model(JSONObject jsonObject)
    {
        try{
            id=jsonObject.getInt("id");
        }catch (Exception e)
        {
        }
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
}
