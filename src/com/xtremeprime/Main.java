package com.xtremeprime;

/**
* A simple subscription management program
*
* @author  Popa Madalin-Iulian
* @author  Popescu Andrei-Sabin
* @version 1.0
* @since   02-02-2016 
*/

public class Main {
	public Main(){}
	public void start(){
		MainWindow mw = new MainWindow();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.start();
		
//		String str = "[hello, there, my name, is, john wick]";
//		String[] tokens = str.substring(1, str.length()-1).split("[, ]+");
//		
//		for(String s : tokens){
//			System.out.println(s);
//		}
	}
}
