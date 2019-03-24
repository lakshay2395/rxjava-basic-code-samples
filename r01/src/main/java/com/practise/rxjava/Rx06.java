package com.practise.rxjava;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Rx06 {
	
	public static void main(String...s) throws Exception {
		Observable
		.just("A","B","C")
		.flatMap(item -> 
		performLongOperation(item)
		.subscribeOn(Schedulers.newThread()))
		.subscribe(v -> {
				System.out.println("Thread = "+Thread.currentThread().getName());
				System.out.println("Item = "+v);
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
