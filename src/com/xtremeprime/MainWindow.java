package com.xtremeprime;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.xtremeprime.util.FileManager;

public class MainWindow {
	JFrame frame;
	FlowLayout layout = new FlowLayout();
	FileManager fm = new FileManager();
	ArrayList<Abonament> list = new ArrayList<Abonament>();
	
	public MainWindow(){
		if(fm.exists("abonamente.txt"))
		init_gui();
	}
	
	private void init_gui(){
		frame = new JFrame("Digital TV Cable | Popa Madalin & Popescu Andrei");
		frame.setSize(new Dimension(300, 150));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init_components(frame);
		
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	private void init_components(JFrame frame){
		frame.setLayout(layout);
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
//		JLabel userLabel = new JLabel("User");
//		userLabel.setBounds(10, 10, 80, 25);
//		frame.add(userLabel);
//
//		JTextField userText = new JTextField(20);
//		userText.setBounds(100, 10, 160, 25);
//		frame.add(userText);
//
//		JLabel passwordLabel = new JLabel("Password");
//		passwordLabel.setBounds(10, 40, 80, 25);
//		frame.add(passwordLabel);
//
//		JPasswordField passwordText = new JPasswordField(20);
//		passwordText.setBounds(100, 40, 160, 25);
//		frame.add(passwordText);

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
			Register register = new Register();
		}
	}
	
	private class printAccountBtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			Login login = new Login();
		}
	}
}
