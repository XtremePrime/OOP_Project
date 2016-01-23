package com.xtremeprime;

public class Pachet {
	private String name;
	private double cost;
	
	public Pachet(){}
	public Pachet(String name, double cost){
		this.name = name;
		this.cost = cost;
	}
	
	public String getName(){ return this.name; }
	public double getCost(){ return this.cost; }
}
