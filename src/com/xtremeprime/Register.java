package com.xtremeprime;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Register {
	JFrame frame;
	FlowLayout layout = new FlowLayout();
	
	public Register(){
		init_gui();
	}
	
	private void init_gui(){
		frame = new JFrame("Abonament nou | Popa Madalin & Popescu Andrei");
		frame.setSize(new Dimension(350, 280));

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
		lastNameText.setBounds(185, 0, 160, 25);
		frame.add(lastNameText);
		//- Prenume
		JLabel firstNameLabel = new JLabel("Prenume");
		firstNameLabel.setBounds(0, 35, 80, 25);
		frame.add(firstNameLabel);
		
		JTextField firstNameText = new JTextField(20);
		firstNameText.setBounds(185, 35, 160, 25);
		frame.add(firstNameText);
		//- Adresa
		JLabel AddressLabel = new JLabel("Adresa");
		AddressLabel.setBounds(0, 70, 80, 25);
		frame.add(AddressLabel);
		
		JTextField AddressText = new JTextField(20);
		AddressText.setBounds(185, 70, 160, 25);
		frame.add(AddressText);
		//- Adresa e-mail
		JLabel MailLabel = new JLabel("Adresa e-mail");
		MailLabel.setBounds(0, 105, 80, 25);
		frame.add(MailLabel);
		
		JTextField MailText = new JTextField(20);
		MailText.setBounds(185, 105, 160, 25);
		frame.add(MailText);
		//- Programs Package
		JLabel PackageProgLabel = new JLabel("Programs Package");
		PackageProgLabel.setBounds(35, 140, 160, 25);
		frame.add(PackageProgLabel);
		
		//- Combo Bar
		JComboBox<String> myTitles = new JComboBox<String>();
		 
		JComboBox<Integer> myNumbers = new JComboBox<Integer>();
		
		JComboBox<String> comboPackage = new JComboBox<String>();
		
		comboPackage.addItem("Te");
		comboPackage.addItem("drecu");
		comboPackage.addItem("de");
		comboPackage.addItem("lista");
		comboPackage.addItem("Desene Chineze");
		
		comboPackage.setBounds(155,140,80,25);
		frame.add(comboPackage);
		
		//- Checkbox
		JCheckBox HBOLabel;
		HBOLabel = new JCheckBox("HBO");
		HBOLabel.setSelected(true);
		HBOLabel.setBounds(240,140,80,25);
		frame.add(HBOLabel);
		
		JCheckBox CinemaxLabel;
		CinemaxLabel = new JCheckBox("Cinemax");
		CinemaxLabel.setSelected(true);
		CinemaxLabel.setBounds(75,175,80,25);
		frame.add(CinemaxLabel);
		
		JCheckBox ISLabel;
		ISLabel = new JCheckBox("Internet service");
		ISLabel.setSelected(true);
		ISLabel.setBounds(160,175,160,25);
		frame.add(ISLabel);
		
		//- Buttons
		JButton confirmBtn = new JButton("OK");
		confirmBtn.setBounds(135, 225, 80, 25);
		frame.add(confirmBtn);		
	}	
}
