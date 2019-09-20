package com.ErrorMovieApp.controller;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.ErrorMovieApp.models.Belongs_to_collection;
import com.ErrorMovieApp.models.FavouritiesList;
import com.ErrorMovieApp.models.Genres;
import com.ErrorMovieApp.models.MoviesList;
import com.ErrorMovieApp.models.Production_companies;
import com.ErrorMovieApp.models.Results;
import com.ErrorMovieApp.repository.FavouriteMovieRepo;
import com.ErrorMovieApp.response.MovieDetailsResponse;
import com.ErrorMovieApp.service.MovieService;
import com.fasterxml.jackson.databind.JsonNode;




@Component
@Controller
public class MovieController 
{
@Autowired
private RestTemplate rest;

@Autowired
private FavouriteMovieRepo repo;

@Autowired
private MovieService service;


@CrossOrigin
@GetMapping("/{moviename}")
public @ResponseBody MovieDetailsResponse getAllMovies(@PathVariable("moviename") String moviename)
{
	
	
	
	String url = "https://api.themoviedb.org/3/search/movie?api_key=8b5e3a87ebe14efb138bc4772c8b722c&query="+moviename;

	MovieDetailsResponse res = new MovieDetailsResponse();
	HttpHeaders headers = new HttpHeaders();

	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	HttpEntity<String> entity = new HttpEntity<String>(headers);
	MoviesList movielist = new MoviesList();	
	
	JsonNode list = rest.exchange(url, HttpMethod.GET, entity, JsonNode.class).getBody();
	
	JsonNode allData = list.get("results");
	movielist.setPage(list.get("page").asInt());
	movielist.setTotal_pages(list.get("total_pages").asInt());
	movielist.setTotal_results(list.get("total_results").asInt());
	
	List<Results> allresults = new ArrayList<Results>();
	List<MoviesList> movlist = new ArrayList<MoviesList>();

	
	for(JsonNode data : allData)
	{

	Results result = new Results();
	
	result.setAdult(data.get("adult").asBoolean());
	result.setBackdrop_path(data.get("backdrop_path").asText());
	result.setId(data.get("id").asInt()) ;
	result.setOriginal_language(data.get("original_language").asText());
	result.setOriginal_title(data.get("original_title").asText() );
	result.setOverview(data.get("overview").asText());
	result.setPopularity(data.get("popularity").asDouble());
	result.setPoster_path(data.get("poster_path").asText());
	result.setRelease_date(data.get("release_date").asText());
	result.setTitle(data.get("title").asText());
	result.setVideo(data.get("video").asBoolean());
	result.setVote_average(data.get("vote_average").asDouble());
	result.setVote_count(data.get("vote_count").asInt());

	

	allresults.add(result);
	movielist.setResults(allresults);
	}
	
	movlist.add(movielist);
	
	

	
	
	try
		{
	res.setMessage("Data retrieval successful");
	res.setData(movlist);
	res.setStatus(true);
		}
	catch (Exception e) 
		{
		res.setMessage("Data retrieval unsuccessful");
		res.setStatus(true);
		}
	return res;

	}


@CrossOrigin
@GetMapping("/TopRatedMovies")
public @ResponseBody MovieDetailsResponse getAllTopRatedMovies()
{
	String url = "https://api.themoviedb.org/3/movie/top_rated?api_key=8b5e3a87ebe14efb138bc4772c8b722c";

	MovieDetailsResponse res = new MovieDetailsResponse();
	HttpHeaders headers = new HttpHeaders();

	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	HttpEntity<String> entity = new HttpEntity<String>(headers);
	MoviesList movielist = new MoviesList();	
	
	JsonNode list = rest.exchange(url, HttpMethod.GET, entity, JsonNode.class).getBody();
	
	JsonNode allData = list.get("results");
	movielist.setPage(list.get("page").asInt());
	movielist.setTotal_pages(list.get("total_pages").asInt());
	movielist.setTotal_results(list.get("total_results").asInt());
	
	List<Results> allresults = new ArrayList<Results>();
	List<MoviesList> movlist = new ArrayList<MoviesList>();

	
	for(JsonNode data : allData)
	{

	Results result = new Results();
	
	result.setAdult(data.get("adult").asBoolean());
	result.setBackdrop_path(data.get("backdrop_path").asText());
	result.setId(data.get("id").asInt()) ;
	result.setOriginal_language(data.get("original_language").asText());
	result.setOriginal_title(data.get("original_title").asText() );
	result.setOverview(data.get("overview").asText());
	result.setPopularity(data.get("popularity").asDouble());
	result.setPoster_path(data.get("poster_path").asText());
	result.setRelease_date(data.get("release_date").asText());
	result.setTitle(data.get("title").asText());
	result.setVideo(data.get("video").asBoolean());
	result.setVote_average(data.get("vote_average").asDouble());
	result.setVote_count(data.get("vote_count").asInt());

	

	allresults.add(result);
	movielist.setResults(allresults);
	}
	
	movlist.add(movielist);
	
	

	
	
	try
		{
	res.setMessage("Data retrieval successful");
	res.setData(movlist);
	res.setStatus(true);
		}
	catch (Exception e) 
		{
		res.setMessage("Data retrieval unsuccessful");
		res.setStatus(true);
		}
	return res;
	
}


@CrossOrigin
@PostMapping("/{id}")
public @ResponseBody MovieDetailsResponse getAllActivity(@PathVariable("id") int id)
{
	FavouritiesList favourities = new FavouritiesList();
	List<FavouritiesList> favlist = new ArrayList<>();
	
	HttpHeaders headers = new HttpHeaders();
	HttpEntity<String> entity = new HttpEntity<String>(headers);
	
	
	String url = "https://api.themoviedb.org/3/movie/"+id+"?api_key=8b5e3a87ebe14efb138bc4772c8b722c";
		JsonNode list = rest.exchange(url, HttpMethod.GET, entity, JsonNode.class).getBody();
		
		favourities.setAdult(list.get("adult").asBoolean());
		favourities.setBackdrop_path(list.get("backdrop_path").asText());
		
		List<Belongs_to_collection> belong = new ArrayList<Belongs_to_collection>();
		JsonNode belongstocol = list.get("belongs_to_collection");
		for(JsonNode data : belongstocol)
		{
			Belongs_to_collection belongs = new Belongs_to_collection();
			belongs.setId(list.get("belongs_to_collection").asInt());
			belongs.setName(list.get("name")!= null ? list.get("name").asText(): "");
			belongs.setBackdrop_path(list.get("backdrop_path")!=null ? list.get("backdrop_path").asText(): "");
			belongs.setPoster_path(list.get("poster_path")!=null ?list.get("poster_path").asText(): "");
			belong.add(belongs);
		}
		favourities.setBelongs_to_collection(belong);
		
		favourities.setBudget(list.get("budget").asInt());
		
		
		List<Genres> generes = new ArrayList<Genres>();
		JsonNode gener = list.get("genres");
		for(JsonNode genere: gener)
		{
			Genres geen = new Genres();
			geen.setId(genere.get("id").asInt());
			geen.setName(genere.get("name").asText());
			generes.add(geen);
		}
		favourities.setGenres(generes);
		
		
		favourities.setHomepage(list.get("homepage").asText());
		favourities.setId(list.get("id").asInt());
		favourities.setImdb(list.get("imdb_id").asText());
		favourities.setOriginal_language(list.get("original_language").asText());
		favourities.setOriginal_title(list.get("original_title").asText());
		favourities.setOverview(list.get("overview").asText());
		favourities.setPopularity(list.get("popularity").asDouble());
		favourities.setPoster_path(list.get("poster_path").asText());
		
		
		JsonNode prodcomp = list.get("production_companies");
		
		List<Production_companies> prodcompanies = new ArrayList<Production_companies>();
		for(JsonNode procomp : prodcomp )
		{
			Production_companies productioncomp = new Production_companies();
			productioncomp.setId(list.get("id").asInt());
			productioncomp.setLogo_path(list.get("logo_path")!= null ? list.get("logo_path").asText() : "");
			productioncomp.setName(list.get("name")!= null ? list.get("name").asText() : "");
			productioncomp.setOrigin_country(list.get("origin_country")!= null ?list.get("origin_country").asText(): "");
			prodcompanies.add(productioncomp);
			}
		favourities.setProduction_companies(prodcompanies);
		
		
		JsonNode prodcountry = list.get("Production_countries");
		

		
		
		favourities.setRelease_date(list.get("release_date").asText());
		favourities.setRevenue(list.get("revenue").asInt());
		favourities.setRuntime(list.get("runtime").asInt());
		
		
		

		
		favourities.setStatus(list.get("status").asText());
		favourities.setTagline(list.get("tagline").asText());
		favourities.setTitle(list.get("title").asText());
		favourities.setVideo(list.get("video").asBoolean());
		favourities.setVote_average(list.get("vote_average").asDouble());
		favourities.setVote_count(list.get("vote_count").asInt());
		favlist.add(favourities);
		
		repo.save(favourities);
		MovieDetailsResponse res = new MovieDetailsResponse();

		try
		{
		res.setMessage("Data successfully posted");
		res.setStatus(true);
		res.setData(favlist);
		}
		catch(Exception e)
		{
			res.setMessage("Data Posting unsuccessfull");
			res.setStatus(false);
			
		}
		return res;



}
@CrossOrigin
@GetMapping("/Getallmovies")
public @ResponseBody MovieDetailsResponse getAllFavourities()
{
	MovieDetailsResponse res = new MovieDetailsResponse();
	try
	{
	List<FavouritiesList> list = service.getAllMovies();	
		res.setMessage("Data successfully retrieved");
		res.setData(list);
		res.setStatus(true);
	}
	catch(Exception e)
	{
		System.out.println(e);
		res.setMessage("Data retrieval unsuccessful");
		res.setStatus(false);
	}
	return res;
}

@CrossOrigin
@DeleteMapping("/{id}")
public @ResponseBody MovieDetailsResponse deleteFavourities(@PathVariable("id") int _id)
{
	MovieDetailsResponse res = new MovieDetailsResponse(); 
	try
	{
	if(repo.getOneById(_id) != null)
		
	{
			repo.deleteById(_id);
			res.setMessage("Deleted successfully");
			res.setStatus(true);
	}	
	else
	{
		res.setMessage("Movie does not exist in database");
		res.setStatus(false);
	}
		
	}
	catch(Exception e)
	{
		System.out.println(e);
		res.setMessage("Data deletion unsuccessful");
		res.setStatus(false);
	}
	return res;
}

}
	
	

