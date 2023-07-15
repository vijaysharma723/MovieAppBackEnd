package com.MovieApp.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Genres 
{
private int id;
private String name;
public Genres() {
	super();
	// TODO Auto-generated constructor stub
}
public Genres(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Genres [id=" + id + ", name=" + name + "]";
}



}
