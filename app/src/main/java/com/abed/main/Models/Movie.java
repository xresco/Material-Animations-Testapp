
package com.abed.main.Models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movie extends Abstract_Model{
   	private boolean adult;
   	private String backdrop_path;
   	private String belongs_to_collection;
   	private int budget;
   	private ArrayList<Genres> genres=new ArrayList<>();
   	private String homepage;
   	private String imdb_id;
   	private String original_language;
   	private String original_title;
   	private String overview;
   	private int popularity;
   	private String poster_path;
   	private ArrayList<Production_companies> production_companies=new ArrayList<>();
   	private ArrayList<Production_countries> production_countries=new ArrayList<>();
   	private String release_date;
   	private int revenue;
   	private int runtime;
   	private ArrayList<Spoken_languages> spoken_languages=new ArrayList<>();
   	private String status;
   	private String tagline;
   	private String title;
   	private boolean video;
   	private int vote_average;
   	private int vote_count;

	public Movie(JSONObject jsonObject)
	{
		super(jsonObject);
		try {
			adult=jsonObject.getBoolean("adult");
			video=jsonObject.getBoolean("video");
			backdrop_path=jsonObject.getString("backdrop_path");
			belongs_to_collection=jsonObject.getString("belongs_to_collection");
			homepage=jsonObject.getString("homepage");
			imdb_id=jsonObject.getString("imdb_id");
			original_language=jsonObject.getString("original_language");
			original_title=jsonObject.getString("original_title");
			overview=jsonObject.getString("overview");
			poster_path=jsonObject.getString("poster_path");
			release_date=jsonObject.getString("release_date");
			status=jsonObject.getString("status");
			tagline=jsonObject.getString("tagline");
			title=jsonObject.getString("title");
			budget=jsonObject.getInt("budget");
			popularity=jsonObject.getInt("popularity");
			revenue=jsonObject.getInt("revenue");
			runtime=jsonObject.getInt("runtime");
			vote_average=jsonObject.getInt("vote_average");
			vote_count=jsonObject.getInt("vote_count");

			JSONArray jsonArray = jsonObject.getJSONArray("genres");
			for (int i = 0; i < jsonArray.length(); i++) {
				genres.add(new Genres(jsonArray.getJSONObject(i)));
			}

			jsonArray = jsonObject.getJSONArray("production_companies");
			for (int i = 0; i < jsonArray.length(); i++) {
				production_companies.add(new Production_companies(jsonArray.getJSONObject(i)));
			}

			jsonArray = jsonObject.getJSONArray("production_countries");
			for (int i = 0; i < jsonArray.length(); i++) {
				production_countries.add(new Production_countries(jsonArray.getJSONObject(i)));
			}

			jsonArray = jsonObject.getJSONArray("spoken_languages");
			for (int i = 0; i < jsonArray.length(); i++) {
				spoken_languages.add(new Spoken_languages(jsonArray.getJSONObject(i)));
			}


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
 	public String getBelongs_to_collection(){
		return this.belongs_to_collection;
	}
	public void setBelongs_to_collection(String belongs_to_collection){
		this.belongs_to_collection = belongs_to_collection;
	}
 	public int getBudget(){
		return this.budget;
	}
	public void setBudget(int budget){
		this.budget = budget;
	}
 	public ArrayList<Genres> getGenres(){
		return this.genres;
	}
	public void setGenres(ArrayList<Genres> genres){
		this.genres = genres;
	}
 	public String getHomepage(){
		return this.homepage;
	}
	public void setHomepage(String homepage){
		this.homepage = homepage;
	}
 	public String getImdb_id(){
		return this.imdb_id;
	}
	public void setImdb_id(String imdb_id){
		this.imdb_id = imdb_id;
	}
 	public String getOriginal_language(){
		return this.original_language;
	}
	public void setOriginal_language(String original_language){
		this.original_language = original_language;
	}
 	public String getOriginal_title(){
		return this.original_title;
	}
	public void setOriginal_title(String original_title){
		this.original_title = original_title;
	}
 	public String getOverview(){
		return this.overview;
	}
	public void setOverview(String overview){
		this.overview = overview;
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
 	public ArrayList<Production_companies> getProduction_companies(){
		return this.production_companies;
	}
	public void setProduction_companies(ArrayList<Production_companies> production_companies){
		this.production_companies = production_companies;
	}
 	public ArrayList<Production_countries> getProduction_countries(){
		return this.production_countries;
	}
	public void setProduction_countries(ArrayList<Production_countries> production_countries){
		this.production_countries = production_countries;
	}
 	public String getRelease_date(){
		return this.release_date;
	}
	public void setRelease_date(String release_date){
		this.release_date = release_date;
	}
 	public int getRevenue(){
		return this.revenue;
	}
	public void setRevenue(int revenue){
		this.revenue = revenue;
	}
 	public int getRuntime(){
		return this.runtime;
	}
	public void setRuntime(int runtime){
		this.runtime = runtime;
	}
 	public ArrayList<Spoken_languages> getSpoken_languages(){
		return this.spoken_languages;
	}
	public void setSpoken_languages(ArrayList<Spoken_languages> spoken_languages){
		this.spoken_languages = spoken_languages;
	}
 	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status;
	}
 	public String getTagline(){
		return this.tagline;
	}
	public void setTagline(String tagline){
		this.tagline = tagline;
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
