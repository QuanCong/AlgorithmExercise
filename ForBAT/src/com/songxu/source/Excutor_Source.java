package com.songxu.source;

import java.util.concurrent.Executors;

public class Excutor_Source {
	public static void main(String[] args) {
		
		Executors.newCachedThreadPool();
		Executors.newSingleThreadExecutor();
		Executors.newFixedThreadPool(10);
		
		
	}

}
