package com.xtremeprime;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.xtremeprime.util.FileManager;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Register {
	private JFrame frame;
	private FlowLayout layout = new FlowLayout();
	private Persoana person = null;
	private HashMap<String, Pachet> packets = new HashMap<String, Pachet>();
	private ArrayList<Abonament> subscriptions;
	private FileManager fm;
	
	public Register(ArrayList<Abonament> ab){
		this.subscriptions = ab;
		this.fm = new FileManager();
		
		//- Init list used in detecting what package the user picked
		packets.put("Base", 			new Pachet("Base", 0.70));
		packets.put("Base +HBO", 		new Pachet("Base +HBO", 0.75));
		packets.put("Base +Cinemax", 	new Pachet("Base +Cinemax", 0.8));
		packets.put("Base+", 			new Pachet("Base+", 1.12));
		packets.put("Extra", 			new Pachet("Extra", 0.8));
		packets.put("Extra +HBO", 		new Pachet("Extra +HBO", 1.0));
		packets.put("Extra +Cinemax", 	new Pachet("Extra +Cinemax", 0.94));
		packets.put("Extra+", 			new Pachet("Extra+", 1.25));
		
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
		JLabel addressLabel = new JLabel("Adresa");
		addressLabel.setBounds(0, 70, 80, 25);
		frame.add(addressLabel);
		
		JTextField addressText = new JTextField(20);
		addressText.setBounds(185, 70, 160, 25);
		frame.add(addressText);
		//- Adresa e-mail
		JLabel mailLabel = new JLabel("Adresa e-mail");
		mailLabel.setBounds(0, 105, 80, 25);
		frame.add(mailLabel);
		
		JTextField mailText = new JTextField(20);
		mailText.setBounds(185, 105, 160, 25);
		frame.add(mailText);
		//- Programs Package
		JLabel packageProgLabel = new JLabel("Programs Package");
		packageProgLabel.setBounds(35, 140, 160, 25);
		frame.add(packageProgLabel);
		
		//- Combo Bar
		JComboBox<String> comboPackage = new JComboBox<String>();
		comboPackage.addItem("Base");
		comboPackage.addItem("Extra");
		comboPackage.setBounds(155,140,80,25);
		frame.add(comboPackage);
		
		//- Checkbox
		JCheckBox HBOLabel;
		HBOLabel = new JCheckBox("HBO");
		HBOLabel.setSelected(false);
		HBOLabel.setBounds(240,140,80,25);
		frame.add(HBOLabel);
		
		JCheckBox CinemaxLabel;
		CinemaxLabel = new JCheckBox("Cinemax");
		CinemaxLabel.setSelected(false);
		CinemaxLabel.setBounds(75,175,80,25);
		frame.add(CinemaxLabel);
		
		JCheckBox ISLabel;
		ISLabel = new JCheckBox("Internet service");
		ISLabel.setSelected(false);
		ISLabel.setBounds(160,175,160,25);
		frame.add(ISLabel);
		
		//- Buttons
		JButton confirmBtn = new JButton("OK");
		confirmBtn.setBounds(135, 225, 80, 25);
		frame.add(confirmBtn);

		confirmBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//- Empty field check
				if(lastNameText.getText().isEmpty() || firstNameText.getText().isEmpty() || addressText.getText().isEmpty() || mailText.getText().isEmpty())
					return;
				
				
				//- Add things to list
				Persoana p = new Persoana(lastNameText.getText().trim(), firstNameText.getText().trim(), addressText.getText().trim(), mailText.getText().trim());
				Pachet pk = packPacket(comboPackage.getItemAt(comboPackage.getSelectedIndex()), HBOLabel.isSelected(), CinemaxLabel.isSelected());
				ServiciuInternet si = new ServiciuInternet(ISLabel.isSelected());
				Abonament ab = new Abonament(p, pk, si);
				System.out.println("Price: " + ab.getCostEuro() + "€ / " + ab.getCostRon() + "RON");
				subscriptions.add(ab);
				
				//- Save file
				fm.open("clienti.txt", "w+");
				fm.save(ab);
				fm.close();
				
				//- Printing (FML)
				// NOOOOOOOOOOOOOOOO
				JOptionPane.showMessageDialog(null, "Abonament creat!\nCod: "+ab.getCode()+
													"\n\nPachet: " + pk.getName() + "(" + ab.getCostEuro() + "€/luna)\n" +
													"Internet: " + (si.getSelected() ? "Da" : "Nu") + "\n");
				System.out.println("Code: " + ab.getCode());
				
				//- Destroy frame
				frame.setVisible(false);
				frame.dispose();
			}
		});
	}	
	
	//- Packs all the info gathered and returns the appropraite package
	private Pachet packPacket(String name, boolean hbo, boolean cinemax){
		if(name == "Base"){
			if(hbo && cinemax)
				return packets.get("Base+");
			else if(hbo && !cinemax)
				return packets.get("Base +HBO");
			else if(!hbo && cinemax)
				return packets.get("Base +Cinemax");
			else
				return packets.get("Base");
		}else if(name == "Extra"){
			if(hbo && cinemax)
				return packets.get("Extra+");
			else if(hbo && !cinemax)
				return packets.get("Extra +HBO");
			else if(!hbo && cinemax)
				return packets.get("Extra +Cinemax");
			else
				return packets.get("Extra");			
		}
		return null;
	}
}
