package com.xtremeprime.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.xtremeprime.Abonament;

public class FileManager {
	FileInputStream in = null;
	FileOutputStream out = null;
	File file = null;
	
	public FileManager(){
		
	}
	
	public boolean exists(String filename){
		File file = new File(filename);
		if(file.exists())
			return true;
		return false;
	}
	
	private void create(String filename) throws IOException{
		file = new File(filename);
		if(file.createNewFile()){
			System.out.println("File is created!");
		}else{
			System.out.println("File already exists!");
		}
	}
	
	public void open(String filename){
		try {
			in = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			try {
				create(filename);
			} catch (IOException e1) {
				e1.printStackTrace();
			}			
		}
	}
	
	public void save(Abonament a){
		
	}
	
	public void load(Abonament a){
		
	}
}
