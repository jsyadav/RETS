package com.irets.bl.util;


public class Timer {

	long startTime;
	long stopTime;
	
	public void startTimer(){
		startTime = System.currentTimeMillis();				
	}
	public void stopTimer(){
		stopTime = System.currentTimeMillis();
	}
	public long elapsedTimer(){
		return (stopTime - startTime);
	}
}
