package com.ErrorMovieApp.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Spoken_languages 
{
private String iso_639_1;
private String name;
public Spoken_languages() {
	super();
	// TODO Auto-generated constructor stub
}
public Spoken_languages(String iso_639_1, String name) {
	super();
	this.iso_639_1 = iso_639_1;
	this.name = name;
}
public String getIso_639_1() {
	return iso_639_1;
}
public void setIso_639_1(String iso_639_1) {
	this.iso_639_1 = iso_639_1;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Spoken_languages [iso_639_1=" + iso_639_1 + ", name=" + name + "]";
}


}
