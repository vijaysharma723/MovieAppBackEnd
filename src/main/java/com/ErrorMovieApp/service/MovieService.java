package com.ErrorMovieApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ErrorMovieApp.models.FavouritiesList;
import com.ErrorMovieApp.repository.FavouriteMovieRepo;


@Service
public class MovieService {



	@Autowired 
	private FavouriteMovieRepo repo;
	
	public List<FavouritiesList> getAllMovies() {
		
		return repo.findAll();
	}

}
