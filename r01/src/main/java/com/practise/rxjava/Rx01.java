package com.practise.rxjava;

import java.util.List;

import io.reactivex.Observable;

public class Rx01 {

	public static void main(String[] args) {
		List<Movie> movies = Utils.getMoviesList();
		Movie []movieArray = new Movie[movies.size()];
		for(int i = 0; i <movies.size() ; i++){
			movieArray[i] = movies.get(i);
		}
		Observable<Movie> obs = Observable.fromArray(movieArray);
		obs.subscribe(System.out::println);
	}

}
