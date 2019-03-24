package com.reactivex.spring.controllers;

import java.util.concurrent.ForkJoinPool;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@Component("deferredTestController")
public class DeferredTestController {

	@GetMapping("/async")
	public DeferredResult<ResponseEntity<?>> handleRequest(){
		DeferredResult<ResponseEntity<?>> result = new DeferredResult<>();
		ForkJoinPool.commonPool().submit(() -> {
	        try {
	            Thread.sleep(6000);
	        } catch (InterruptedException e) {
	        }
	        result.setResult(ResponseEntity.ok("ok"));
	    });
		return result;
	}
	
}
