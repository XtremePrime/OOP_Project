package com.xtremeprime;

public class Main {
	private boolean running = false;
	
	public Main(){
		
	}
	
	public void start(){
		running = true;
		MainWindow mw = new MainWindow();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.start();
	}

}
