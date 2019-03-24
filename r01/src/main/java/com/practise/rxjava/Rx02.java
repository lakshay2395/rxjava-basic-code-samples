package com.practise.rxjava;

import java.util.List;

import io.reactivex.Observable;

public class Rx02 {
	
	public static void main(String...s) {
		Observable<Movie> obs = getMovieObservable();
		obs
		.filter(movie -> movie.getRatings() == 5)
		.subscribe(System.out::println);
	}
	
	
	public static Observable<Movie> getMovieObservable(){
		return Observable.create(emitter -> {
			List<Movie> movies = Utils.getMoviesList();
			for(Movie m : movies) {
				emitter.onNext(m);
			}
			emitter.onComplete();
		});
	}

}
