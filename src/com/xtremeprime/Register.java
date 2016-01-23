package com.xtremeprime;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register {
	JFrame frame;
	FlowLayout layout = new FlowLayout();
	
	public Register(){
		init_gui();
	}
	
	private void init_gui(){
		frame = new JFrame("Abonament nou | Popa Madalin & Popescu Andrei");
		frame.setSize(new Dimension(300, 300));

		init_components(frame);
		
		frame.setResizable(false);	
//		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	private void init_components(JFrame frame){
		frame.setLayout(null);

		//- Nume
		JLabel lastNameLabel = new JLabel("Nume");
		lastNameLabel.setBounds(0, 0, 160, 25);
		frame.add(lastNameLabel);
		
		JTextField lastNameText = new JTextField(20);
		lastNameText.setBounds(100, 0, 160, 25);
		frame.add(lastNameText);
		//- Prenume
		JLabel firstNameLabel = new JLabel("User");
		firstNameLabel.setBounds(10, 10, 80, 25);
		frame.add(firstNameLabel);
		
		JTextField firstNameText = new JTextField(20);
		firstNameText.setBounds(100, 10, 160, 25);
		frame.add(firstNameText);
		//- Adresa
		//- Adresa e-mail
		//- Programs Package
		//- Buttons
		JButton confirmBtn = new JButton("OK");
		confirmBtn.setBounds(10, 80, 80, 25);
		frame.add(confirmBtn);		
	}	
}
