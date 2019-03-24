package com.practise.rxjava;

import io.reactivex.Observable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Observable<String> obs = Observable.just("Hello World");
        obs.subscribe(s -> {
        	System.out.println("Received item = "+s);
        });
    }
}
