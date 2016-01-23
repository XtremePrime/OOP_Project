package com.xtremeprime;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login {
	JFrame frame;
	FlowLayout layout = new FlowLayout();
	
	public Login(){
		init_gui();
	}
	
	private void init_gui(){
		frame = new JFrame("Cost abonament | Popa Madalin & Popescu Andrei");
		frame.setSize(new Dimension(300, 150));

		init_components(frame);
		
		frame.setResizable(false);
		frame.pack();
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
		
		ActionListener listener = new printCost();
		textfield.addActionListener(listener);
	}
	
	private class printCost implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//- Destroy frame
			frame.setVisible(false);
			frame.dispose();
			
			JOptionPane.showMessageDialog(null, "You are winner!");
		}
	}
}
