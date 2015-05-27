package com.abed.main.Models;

import org.json.JSONObject;

/**
 * Created by mindvalley on 5/26/15.
 */
public class Video_Metadata extends Abstract_Model{
    private boolean adult;
    private String backdrop_path;
    private String original_title;
    private int popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private boolean video;
    private int vote_average;
    private int vote_count;

    public Video_Metadata(JSONObject json)
    {
        super(json);
        try {
            adult = json.getBoolean("adult");
            video = json.getBoolean("video");
            backdrop_path=json.getString("backdrop_path");
            original_title=json.getString("original_title");
            poster_path=json.getString("poster_path");
            release_date=json.getString("release_date");
            title=json.getString("title");
            popularity=json.getInt("popularity");
            vote_average=json.getInt("vote_average");
            vote_count=json.getInt("vote_count");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean getAdult(){
        return this.adult;
    }
    public void setAdult(boolean adult){
        this.adult = adult;
    }
    public String getBackdrop_path(){
        return this.backdrop_path;
    }
    public void setBackdrop_path(String backdrop_path){
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_title(){
        return this.original_title;
    }
    public void setOriginal_title(String original_title){
        this.original_title = original_title;
    }
    public int getPopularity(){
        return this.popularity;
    }
    public void setPopularity(int popularity){
        this.popularity = popularity;
    }
    public String getPoster_path(){
        return this.poster_path;
    }
    public void setPoster_path(String poster_path){
        this.poster_path = poster_path;
    }
    public String getRelease_date(){
        return this.release_date;
    }
    public void setRelease_date(String release_date){
        this.release_date = release_date;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public boolean getVideo(){
        return this.video;
    }
    public void setVideo(boolean video){
        this.video = video;
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
}
