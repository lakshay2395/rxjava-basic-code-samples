package com.reactivex.spring.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.reactivex.spring.dtos.Movie;

import io.reactivex.Observable;

@Component("movieService")
public class MovieService {
	
	public Observable<Movie> getMovies(){
		return Observable.<Movie>create(emitter -> {
			List<Movie> movies = getMoviesList();
			for(Movie movie : movies) {
				emitter.onNext(movie);
			}
			emitter.onComplete();
		});
	}
	
	public Observable<Movie> getMoviesFromAPI(){
		return Observable.<Movie>create(emitter -> {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<String> entity = new HttpEntity<String>(headers);
			List<Movie> movies = restTemplate.exchange("https://input-api.getsandbox.com:443/movies", HttpMethod.GET,entity,  new ParameterizedTypeReference<List<Movie>>(){}).getBody();
			for(Movie movie : movies) {
				emitter.onNext(movie);
			}
			emitter.onComplete();
		});
	}
	
	public static List<Movie> getMoviesList(){
		return List.of(
					new Movie("Chachi 420",4,"Sample Description of Chachi 420"),
					new Movie("Resident Evil",5,"Sample Description of Resident Evil"),
					new Movie("Man Who Knew Infinity",3,"Sample Description of Man Who Knew Infinity"),
					new Movie("Jurrasic Park",5,"Sample Description of Jurassic Park"),
					new Movie("Shree 420",4,"Sample Description of Shree 420"),
					new Movie("Chupke Chupke",3,"Sample Description of Chupke Chupke"),
					new Movie("Raazi",5,"Sample Description of Raazi"),
					new Movie("Uri",3,"Sample Description of Uri"),
					new Movie("36 China Town",1,"Sample Description of 36 China Town"),
					new Movie("Accidental Prime Minister",2,"Sample Description of Accidental Prime Minister"),
					new Movie("Narendra Modi",3,"Sample Description of Narendra Modi"),
					new Movie("Pursuit Of Happiness",5,"Sample Description of Pursuit Of Happiness"),
					new Movie("Shutter Island",4,"Sample Description of Shutter Island"),
					new Movie("Gandhi",5,"Sample Description of Gandhi"),
					new Movie("Slumdog Millionaire",4,"Sample Description of Slumdog Millionaire")
				);
	}
	
}
