package com.songxu.future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FutureTaskTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		FutureTask<String> futureTask = new FutureTask<String>(
				new Callable<String>() {

					@Override
					public String call() throws Exception {
						System.out.println("任务开始。。。");
						Thread.sleep(3000);
						System.out.println("任务结束");
						return true + "";
					}
				});
		futureTask.cancel(true);
		futureTask.run();
		
		System.out.println(futureTask.get());
		
		ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(15));
		
		threadPoolExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Future<?> future=threadPoolExecutor.submit(futureTask);
		
		Object value=future.get();
		
	}

}
