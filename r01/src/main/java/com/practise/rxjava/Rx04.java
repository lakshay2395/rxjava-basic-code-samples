package com.practise.rxjava;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class Rx04 {
	
	public static void main(String...s)throws Exception {
		Observable<Movie> obs = getMovieObservable();
		obs
		.map(movie -> {
			movie.setSynopsis(movie.getSynopsis().toUpperCase());
			return movie.getSynopsis();
		})
		.subscribeOn(Schedulers.io())
		.subscribe(new DisposableObserver<String>() {

			@Override
			public void onNext(String t) {
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
		
		Thread.sleep(10000);
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
