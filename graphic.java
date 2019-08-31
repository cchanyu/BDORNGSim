import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.Random;
import java.util.Scanner;

public class graphic extends Applet{

	Random rand = new Random();

	int fs = 0;
	String equipType = null;
	int enhanceLvl = 0;

	double armor = 0;
	double weapon = 0;
	double accessory = 0;

	// Random Number and Min & Max.
	int rng = rand.nextInt(1001);
	int dmax = 1000;
	int dmin = 0;

	//empty label which will show event after button clicked
	JLabel label1 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	JLabel label7 = new JLabel();
	JLabel label8 = new JLabel();
	
	public graphic(){    
		JFrame f=new JFrame("BDO Enhancement Calculator"); 

		//submit button
		JButton button = new JButton("Enhance");    
		button.setBounds(100, 170, 140, 40);    

		//enter name label
		JLabel label = new JLabel();		
		label.setText("Failstack :");
		label.setBounds(10, 10, 100, 100);

		JLabel label2 = new JLabel();		
		label2.setText("Enhance Type :");
		label2.setBounds(10, 50, 100, 100);

		JLabel label3 = new JLabel();		
		label3.setText("Enhance Level :");
		label3.setBounds(10, 90, 100, 100);

		label1.setBounds(10, 200, 300, 100);
		label4.setBounds(10, 220, 300, 100);
		label5.setBounds(10, 240, 300, 100);
		label6.setBounds(10, 260, 300, 100);
		label7.setBounds(10, 280, 300, 100);
		label8.setBounds(10, 300, 300, 100);

		//text field to enter name
		JTextField textfield = new JTextField();
		textfield.setBounds(110, 45, 130, 30);

		JTextField textfield2 = new JTextField();
		textfield2.setBounds(110, 85, 130, 30);

		JTextField textfield3 = new JTextField();
		textfield3.setBounds(110, 125, 130, 30);

		//add to frame
		f.add(label);
		f.add(label1);
		f.add(label2);
		f.add(label3);
		f.add(label4);
		f.add(label5);
		f.add(label6);
		f.add(label7);
		f.add(label8);

		f.add(textfield);
		f.add(textfield2);
		f.add(textfield3);
		f.add(button);

		f.setSize(300,400);
		f.setLayout(null);
		f.setVisible(true);


		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

		//action listener
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				label1.setText("The Result:");
				fs = Integer.parseInt(textfield.getText());
				equipType = textfield2.getText();
				enhanceLvl = Integer.parseInt(textfield3.getText());
				
				if (equipType.equalsIgnoreCase("Armor")) {
					armor = main.armorCalc(fs, equipType, enhanceLvl);
					int temp = (int)(armor*100.0);
				    double shortDouble = ((double)temp)/100.0;
					label4.setText("Success Rate: " + shortDouble +"%");
				} else if (equipType.equalsIgnoreCase("Weapon")) {
					weapon = main.weaponCalc(fs, equipType, enhanceLvl);
					int temp3 = (int)(weapon*100.0);
				    double shortDouble3 = ((double)temp3)/100.0;
					label4.setText("Success Rate: " + shortDouble3 +"%");
				} else if (equipType.equalsIgnoreCase("Accessory")) {
					accessory = main.accsCalc(fs, equipType, enhanceLvl);
					int temp4 = (int)(accessory*100.0);
				    double shortDouble4 = ((double)temp4)/100.0;
					label4.setText("Success Rate: " + shortDouble4 +"%");
				} else {
					// Do nothing
				}
				
				double combined = armor + weapon + accessory;
				
				
				label5.setText("RNG: " + rng + ", FS: " + fs);
				
				int fsrng = rng + fs;
				if (fsrng >= 1000) {
					fsrng = 1000;
				}		
				double k = combined * 10;
				int temp2 = (int)(k*100.0);
			    double shortDouble2 = ((double)temp2)/100.0;
				double k2 = (dmax - k);
				label6.setText(dmax + " - " + shortDouble2 + " = " + k2 + " (Pass to succeed)");

				if (fsrng > k2) {
					label7.setText("(Enhancement Succeed)");
					label8.setText("FS + RNG: " + fsrng);
				} else {
					label7.setText("(Enhancement Failed)");
					label8.setText("FS + RNG: " + fsrng);
				}
			}          
		});

	}

}
