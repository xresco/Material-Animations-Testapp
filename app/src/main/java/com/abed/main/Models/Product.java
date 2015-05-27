package com.abed.main.Models;

import org.json.JSONArray;
import org.json.JSONObject;


public class Product {

    private String image_url;
    private String price;
    private String name;
    private String brand;


    public Product(JSONObject json)
    {

        try {
            JSONObject data=json.getJSONObject("data");
            JSONArray images=json.getJSONArray("images");
            JSONObject first_image=images.getJSONObject(0);

            image_url = first_image.getString("path");
            price = data.getString("price");
            name = data.getString("name");
            brand = data.getString("brand");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getImage_url() {
        return image_url;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }
}
