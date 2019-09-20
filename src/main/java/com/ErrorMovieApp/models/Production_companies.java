package com.ErrorMovieApp.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Production_companies 
{
private String name;
private int id;
private String logo_path;
private String origin_country;
public Production_companies() {
	super();
	// TODO Auto-generated constructor stub
}
public Production_companies(String name, int id, String logo_path, String origin_country) {
	super();
	this.name = name;
	this.id = id;
	this.logo_path = logo_path;
	this.origin_country = origin_country;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLogo_path() {
	return logo_path;
}
public void setLogo_path(String logo_path) {
	this.logo_path = logo_path;
}
public String getOrigin_country() {
	return origin_country;
}
public void setOrigin_country(String origin_country) {
	this.origin_country = origin_country;
}
@Override
public String toString() {
	return "Production_companies [name=" + name + ", id=" + id + ", logo_path=" + logo_path + ", origin_country="
			+ origin_country + "]";
}



}
