package com.songxu.observer;

public class Test {
	public static void main(String[] args) {
		
		
		Alarm alarm=new Alarm();
		
		Monitor monitor1=new Monitor("1��");
		Monitor monitor2=new Monitor("2��");
		
		alarm.regist(monitor1);
		alarm.regist(monitor2);
		
		alarm.doSomething();
		
	}

}
