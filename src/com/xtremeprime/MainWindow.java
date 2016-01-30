package com.xtremeprime;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import com.xtremeprime.util.FileManager;

public class MainWindow {
	private JFrame frame;
	private FlowLayout layout = new FlowLayout();
	private FileManager fm = new FileManager();
	private ArrayList<Abonament> subscriptions = new ArrayList<Abonament>();
	
	public MainWindow(){
		init_gui();
		loadSubscriptions();
		for(Abonament a : subscriptions)
			System.out.println(a.getCode());
		System.out.println(subscriptions.size());
	}
	
	private void init_gui(){
		frame = new JFrame("Digital TV Cable | Popa Madalin & Popescu Andrei");
		frame.setSize(new Dimension(300, 150));
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    frame.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent event) {
	            quit();
	        }
	    });
	    
		init_components(frame);
		
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	private void init_components(JFrame frame){
		frame.setLayout(layout);
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		JButton newAccountBtn = new JButton("Creare abonament nou");
//		newAccountBtn.setBounds(10, 80, 80, 25);
		frame.add(newAccountBtn);

		JButton printAccountBtn = new JButton("Afisare cost abonament");
//		printAccountBtn.setBounds(180, 80, 80, 25);
		frame.add(printAccountBtn);

		ActionListener nabl = new newAccountBtnListener();
		ActionListener pabl = new printAccountBtnListener();
		newAccountBtn.addActionListener(nabl);
		printAccountBtn.addActionListener(pabl);		
	}
	
	private class newAccountBtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			Register register = new Register(subscriptions);
		}
	}
	
	private class printAccountBtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			Login login = new Login(subscriptions);
		}
	}
	
	private void loadSubscriptions(){
		fm.open("abonamente.txt", "r");
		try {
			fm.loadSubscriptions(subscriptions);
		} catch (IOException e) {
			e.printStackTrace();
		}
		fm.close();
	}
	
	private void quit(){
		if(subscriptions.size() > 0){
			fm.open("abonamente.txt", "w+");
			fm.dumpData(subscriptions);
			fm.close();	
			System.out.println("Dumped content to abonamente.txt!");
		}
		
		frame.dispose();
	    System.exit(0);
	}
}
