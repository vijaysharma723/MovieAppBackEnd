package com.ErrorMovieApp.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviesList
{

	private int page;
	private List<Results> results;
	private int total_results;
	private int total_pages;
	

	public MoviesList() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public MoviesList(int page, List<Results> results, int total_results, int total_pages) {
		super();
		this.page = page;
		this.results = results;
		this.total_results = total_results;
		this.total_pages = total_pages;
	}


	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal_results() {
		return total_results;
	}
	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}
	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}

	
	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}


	@Override
	public String toString() {
		return "MoviesList [page=" + page + ", results=" + results + ", total_results=" + total_results
				+ ", total_pages=" + total_pages + "]";
	}



	
	
	
}
