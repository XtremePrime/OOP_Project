package com.xtremeprime;

public class Persoana {
	String firstname, lastname, address, email;
	
	public Persoana(){}
	public Persoana(String fn, String ln, String ad, String email){
		this.firstname = fn;
		this.lastname = ln;
		this.address = ad;
		this.email = email;
	}
	
	public String getFirstName(){ return this.firstname; }
	public String getLastName(){ return this.lastname; }
	public String getAddress(){ return this.address; }
	public String getEmail(){ return this.email; }
}
