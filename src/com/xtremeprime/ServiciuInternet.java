package com.xtremeprime;

public class ServiciuInternet {
	private boolean selected = false;
	private final double cost = 1.4;
	
	public ServiciuInternet(boolean selected){
		this.selected = selected;
	}
	
	public boolean getSelected(){ return this.selected; }
	public void setSelected(boolean b){ this.selected = b; }
	public double getCost(){ return this.cost; }
}
