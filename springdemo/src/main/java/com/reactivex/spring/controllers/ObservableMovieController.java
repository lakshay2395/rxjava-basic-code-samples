package com.reactivex.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.reactivex.spring.dtos.Movie;
import com.reactivex.spring.services.MovieService;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

@RestController
@Component("observableMovieController")
public class ObservableMovieController {
	
	@Autowired
	MovieService service;
	
	@GetMapping("/stored-movies")
	public DeferredResult<ResponseEntity<List<Movie>>> getStoredMovies(){
		DeferredResult<ResponseEntity<List<Movie>>> result = new DeferredResult<>();
		List<Movie> movies = new ArrayList<>();
		service.getMovies()
		.doOnComplete(() -> {
			result.setResult(ResponseEntity.ok(movies));
		})
		.flatMap(e -> Observable.just(e).subscribeOn(Schedulers.newThread()))
		.subscribe(movie -> {
			System.out.println(Thread.currentThread().getName());
			movies.add(movie);
		});
		return result;
	}
	
	@GetMapping("/api-movies")
	public DeferredResult<ResponseEntity<List<Movie>>> getMoviesFromAPI(){
		DeferredResult<ResponseEntity<List<Movie>>> result = new DeferredResult<>();
		List<Movie> movies = new ArrayList<>();
		service.getMoviesFromAPI()
		.subscribeOn(Schedulers.newThread())
		.doOnComplete(() -> {
			result.setResult(ResponseEntity.ok(movies));
		})
		.flatMap(e -> Observable.just(e).subscribeOn(Schedulers.newThread()))
		.subscribe(movie -> {
			System.out.println(Thread.currentThread().getName());
			movies.add(movie);
		});
		return result;
	} 

}
