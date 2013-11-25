package br.com.efraimgentil.utils;

public class Profilador {
	
	private long initialTime;
	
	private long endTime;
	
	public void initiate(){
		initialTime = System.currentTimeMillis();
	}
	
	public void finalize(){
		endTime = System.currentTimeMillis();
	}
	
	public long executionTime(){
		return endTime - initialTime;
	}
	
	
}
