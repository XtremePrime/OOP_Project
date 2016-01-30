package com.xtremeprime;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login {
	private JFrame frame;
	private FlowLayout layout = new FlowLayout();
	private ArrayList<Abonament> subscriptions;
	
	public Login(ArrayList<Abonament> ab){
		this.subscriptions = ab;
		init_gui();
	}
	
	private void init_gui(){
		frame = new JFrame("Cost abonament | Popa Madalin & Popescu Andrei");
		frame.setSize(new Dimension(250, 75));

		init_components(frame);
		
		frame.setResizable(false);
//		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	private void init_components(JFrame frame){
		frame.setLayout(layout);
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JLabel label = new JLabel("Cod abonament");
		frame.add(label);
		JTextField textfield = new JTextField(10);
		frame.add(textfield);
		
//		ActionListener listener = new printCost();
		textfield.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//- Destroy frame
				frame.setVisible(false);
				frame.dispose();
				
				//- Show price and name of client
				for(Abonament a : subscriptions){
					if(Objects.equals(a.getCode(), textfield.getText().trim())){
						JOptionPane.showMessageDialog(null, "Client: " + a.getPerson().getLastName() + " " + a.getPerson().getFirstName() + "\n" + "Costul abonamentului este: " + a.getCostEuro() + "€/luna (" + String.format("%.2f", a.getCostRon()) + "RON/luna)");
						break;
					}
				}
			}
		});
	}
	
//	private class printCost implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//
//		}
//	}
}
