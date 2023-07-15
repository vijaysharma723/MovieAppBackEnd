package com.MovieApp.models;



import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results 
{
private double popularity;
private String overview;
private String release_date;
private int vote_count;
private boolean video;
private String poster_path;
private int id;
private boolean adult;
private String backdrop_path;
private List<Integer> genre_ids ;
private String original_language;
private String original_title;
private String title;
private double vote_average;
public Results() {
	super();
	// TODO Auto-generated constructor stub
}











public Results(double popularity, String overview, String release_date, int vote_count, boolean video,
		String poster_path, int id, boolean adult, String backdrop_path, List<Integer> genre_ids,
		String original_language, String original_title, String title, double vote_average) {
	super();
	this.popularity = popularity;
	this.overview = overview;
	this.release_date = release_date;
	this.vote_count = vote_count;
	this.video = video;
	this.poster_path = poster_path;
	this.id = id;
	this.adult = adult;
	this.backdrop_path = backdrop_path;
	this.genre_ids = genre_ids;
	this.original_language = original_language;
	this.original_title = original_title;
	this.title = title;
	this.vote_average = vote_average;
}











public String getPoster_path() {
	return poster_path;
}
public void setPoster_path(String poster_path) {
	this.poster_path = poster_path;
}
public String getBackdrop_path() {
	return backdrop_path;
}
public void setBackdrop_path(String backdrop_path) {
	this.backdrop_path = backdrop_path;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public double getPopularity() {
	return popularity;
}

public void setPopularity(double popular) {
	this.popularity = popular;
}

public int getVote_count() {
	return vote_count;
}

public void setVote_count(int vote_count) {
	this.vote_count = vote_count;
}

public boolean isVideo() {
	return video;
}

public void setVideo(boolean video) {
	this.video = video;
}

public boolean isAdult() {
	return adult;
}

public void setAdult(boolean adult) {
	this.adult = adult;
}

public String getOriginal_language() {
	return original_language;
}

public void setOriginal_language(String original_language) {
	this.original_language = original_language;
}

public String getOriginal_title() {
	return original_title;
}

public void setOriginal_title(String original_title) {
	this.original_title = original_title;
}






public List<Integer> getGenre_ids() {
	return genre_ids;
}











public void setGenre_ids(List<Integer> genre_ids) {
	this.genre_ids = genre_ids;
}











public String getOverview() {
	return overview;
}





public void setOverview(String overview) {
	this.overview = overview;
}





public String getRelease_date() {
	return release_date;
}





public void setRelease_date(String release_date) {
	this.release_date = release_date;
}





public String getTitle() {
	return title;
}





public void setTitle(String title) {
	this.title = title;
}





public double getVote_average() {
	return vote_average;
}





public void setVote_average(double vote_average) {
	this.vote_average = vote_average;
}



@Override
public String toString() {
	return "Results [popularity=" + popularity + ", overview=" + overview + ", release_date=" + release_date
			+ ", vote_count=" + vote_count + ", video=" + video + ", poster_path=" + poster_path + ", id=" + id
			+ ", adult=" + adult + ", backdrop_path=" + backdrop_path + ", genre_ids=" + genre_ids
			+ ", original_language=" + original_language + ", original_title=" + original_title + ", title=" + title
			+ ", vote_average=" + vote_average + "]";
}


}



