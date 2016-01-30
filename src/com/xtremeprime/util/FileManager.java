package com.xtremeprime.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import com.xtremeprime.Abonament;
import com.xtremeprime.Pachet;
import com.xtremeprime.Persoana;
import com.xtremeprime.ServiciuInternet;

public class FileManager {
	private FileInputStream in = null;
	private FileOutputStream out = null;
	private File file = null;
	private String mode;
	
	public FileManager(){
		
	}
	
	public boolean exists(String filename){
		File file = new File(filename);
		if(file.exists())
			return true;
		return false;
	}
	
	public void create(String filename) throws IOException{
		file = new File(filename);
		if(file.createNewFile()){
			System.out.println("File is created!");
		}else{
			System.out.println("File already exists!");
		}
	}
	
	//- Opens the file. If the file doesn't exist, it creates it and retries to open it.
	public void open(String filename, String mode){
		this.mode = mode;
		file = new File(filename);
		try {
			if(Objects.equals("r", mode))
				in = new FileInputStream(filename);
			if(Objects.equals("w", mode))
				out = new FileOutputStream(filename, false);
			else if(Objects.equals("w+", mode))
				out = new FileOutputStream(filename, true);
		} catch (FileNotFoundException e) {
			try {
				create(filename);
				open(filename, mode);
			} catch (IOException e1) {
				e1.printStackTrace();
			}			
		}
	}
	
	public void close(){
		try {
			if(Objects.equals("r", mode))
				in.close();
			if(Objects.equals("w", mode) || Objects.equals("w+", mode))
				out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//- Save client data
	public void save(Abonament a){
		Writer writer = null;
		
		try{
		    writer = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
		    
		    writer.write("[" + a.getCode() + ", " + a.getPerson().getLastName() + " " +  a.getPerson().getFirstName() + ", " + a.getPerson().getAddress() + ", " + a.getPerson().getEmail() + ", " + dateFormat.format(date) + "]" + System.lineSeparator());		    
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
		   try {writer.close();}catch (Exception ex){}
		}
	}
	
	//- Load subscriptions
	public void loadSubscriptions(ArrayList<Abonament> list) throws IOException{
		final int CODE = 0, PACKET_NAME = 1, PACKET_COST = 3, NET_STATUS = 2, USER_FIRSTNAME = 4, USER_LASTNAME = 5, USER_EMAIL = 7, USER_ADDRESS = 6;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(in))){
			String line;
			while((line = br.readLine()) != null){
				String[] tokens = line.substring(1, line.length()-1).split("[,]+");
				
				//- Create a new Abonament object and give it all the fetched data then add it to the list
				Abonament a = new Abonament(new Persoana(tokens[USER_FIRSTNAME], tokens[USER_LASTNAME], tokens[USER_EMAIL], tokens[USER_ADDRESS]), new Pachet(tokens[PACKET_NAME], Double.parseDouble(tokens[PACKET_COST])), new ServiciuInternet(Boolean.parseBoolean(tokens[NET_STATUS])));
				a.setCode(tokens[CODE]);
				list.add(a);
				
//				for(String s : tokens){
//					System.out.println(s);
//				}			
				
				//- Delete the file because reading is not appendable
				PrintWriter writer = new PrintWriter(file);
				writer.print("");
				writer.close();
			}
		}
	}

	//- Dump the contents of a list into subscriptions
	public void dumpData(ArrayList<Abonament> list) {
		Writer writer = null;
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(out));
		    for(Abonament a : list){
		    	System.out.println("Saving code: " + a.getCode());
		    	writer.write("[" + a.getCode() + "," + a.getPacket().getName() + "," + a.getInternet().getSelected() + "," + a.getPacket().getCost() + "," + a.getPerson().getFirstName() + "," + a.getPerson().getLastName() + "," + a.getPerson().getEmail() + "," + a.getPerson().getAddress() + "]" + System.lineSeparator());
		    }  	
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally{
		   try {writer.close();}catch (Exception ex){}
		}		
	}
}
