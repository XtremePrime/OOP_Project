package com.xtremeprime;

import java.util.Random;

public class Abonament {
	private Persoana person;
	private Pachet packet;
	private ServiciuInternet internet;
	private String code;
	private double price;
	
	public Abonament(Persoana p, Pachet pk, ServiciuInternet is){
		this.person = p;
		this.packet = pk;
		this.internet = is;
		
		code = randInt(100,999) + "-" + randInt(100,999) + "-" + randInt(100,999);
		
		//- Calculate cost
		this.price = calculatePrice();
	}
	
	private int randInt(int min, int max){
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}
	
	public double calculatePrice(){
		double price = packet.getCost();
		if(internet.getSelected())
			price += internet.getCost();
		
		return price;
	}
	public double getCostEuro(){ return this.price; }
	public double getCostRon(){return getCostEuro()*4.54;}
	public void setPrice(double price){ this.price = price; }
	public Persoana getPerson(){ return this.person; }
	public Pachet getPacket(){ return this.packet; }
	public ServiciuInternet getInternet(){ return this.internet; }
	public String getCode(){ return this.code; }
	public void setCode(String code){ this.code = code; }
}
