package com.practise.rxjava;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Rx05 {
	
	public static void main(String...s) throws Exception {
		Observable<String> obs = Observable
		.just("A","B","C","D","E","F");
		
		obs
		.flatMap(e -> performLongOperation(e).observeOn(Schedulers.newThread()))
		.subscribe(e -> {
			System.out.println("1 = "+e+" , Thread = "+Thread.currentThread().getName());
		});
		
		Thread.sleep(10000);
	}

	public static Observable<String> performLongOperation(String v) {
	    Random random = new Random();
	    try {
	        Thread.sleep(random.nextInt(3) * 1000);
	        return Observable.just(v);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
}
