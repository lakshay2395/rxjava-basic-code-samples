package com.practise.rxjava;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

public class Rx03 {
	
	public static void main(String...s) {
		Observable<Movie> obs = getMovieObservable();
		obs
		.filter(movie -> movie.getRatings() >= 4)
		.subscribe(new DisposableObserver<Movie>() {

			@Override
			public void onNext(Movie t) {
				System.out.println("Received Movie = "+t);
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("Received Error = "+e.getMessage());
			}

			@Override
			public void onComplete() {
				System.out.println("Subcription Complete");
				this.dispose();
			}

			
		});
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
