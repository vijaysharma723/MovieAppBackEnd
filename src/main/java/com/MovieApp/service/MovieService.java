package com.MovieApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieApp.models.FavouritiesList;
import com.MovieApp.repository.FavouriteMovieRepo;


@Service
public class MovieService {



	@Autowired 
	private FavouriteMovieRepo repo;
	
	public List<FavouritiesList> getAllMovies() {
		
		return repo.findAll();
	}

}
