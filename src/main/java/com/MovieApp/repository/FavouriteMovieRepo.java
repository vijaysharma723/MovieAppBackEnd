package com.MovieApp.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.MovieApp.models.FavouritiesList;



public interface FavouriteMovieRepo extends MongoRepository<FavouritiesList, String>
{

	int findOneById(int id);
	


@Query(value="{'id' : ?0}", delete = true)
Long deleteById(int _id);






FavouritiesList getOneById(int _id);


	

}
