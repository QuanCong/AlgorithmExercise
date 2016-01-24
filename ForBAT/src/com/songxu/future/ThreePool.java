package com.songxu.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreePool {
	public static void main(String[] args) {
		
		ExecutorService fix=Executors.newFixedThreadPool(10);
		ExecutorService single=Executors.newSingleThreadExecutor();
		ExecutorService cache=Executors.newCachedThreadPool();
		
	}

}
