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

public class main extends Applet{
	public static void main (String[] args) {

		// Random
		Random rand = new Random();

		// Inputs
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter Failstack: ");
		int fs = myObj.nextInt();
		while ((fs > 500) || (fs < -1)) {
			System.out.println("Invalid input, please type it again. (Valid fs: 0-500)");
			System.out.print("Enter Failstack: ");
			fs = myObj.nextInt();
		} 

		Scanner myObj2 = new Scanner(System.in);
		System.out.print("Enter Equipment Type (Accessory/Armor/Weapon): ");
		String equipType = myObj2.nextLine();
		while (!((equipType.equalsIgnoreCase("Accessory")) || (equipType.equalsIgnoreCase("Armor")) || (equipType.equalsIgnoreCase("Weapon")))) {
			System.out.println("Invalid input, please type it again.");
			System.out.print("Enter Equipment Type (Accessory/Armor/Weapon): ");
			equipType = myObj2.nextLine();
		}

		Scanner myObj3 = new Scanner(System.in);
		System.out.print("Enter Enhance Level (1-20): ");
		int enhanceLvl = myObj3.nextInt();
		while ((enhanceLvl > 21) || (enhanceLvl < 0)) {
			System.out.println("Invalid input, please type it again. (Valid fs: 1-20)");
			System.out.print("Enter Failstack: ");
			enhanceLvl = myObj3.nextInt();
		} 

		// Results
		System.out.println();

		double armor = 0;
		double weapon = 0;
		double accessory = 0;

		if (equipType.equalsIgnoreCase("Armor")) {
			armor = armorCalc(fs, equipType, enhanceLvl);
			System.out.println("Success Rate: " + armor +"%");
		} else if (equipType.equalsIgnoreCase("Weapon")) {
			weapon = weaponCalc(fs, equipType, enhanceLvl);
			System.out.println("Success Rate: " + weapon +"%");
		} else if (equipType.equalsIgnoreCase("Accessory")) {
			accessory = accsCalc(fs, equipType, enhanceLvl);
			System.out.println("Success Rate: " + accessory +"%");
		} else {
			// Do nothing
		}

		double combined = armor + weapon + accessory;


		// Random Number and Min & Max.
		int rng = rand.nextInt(1001);
		int dmax = 1000;
		int dmin = 0;
		System.out.println("RNG: " + rng + ", FS: " + fs);

		int fsrng = rng + fs;
		if (fsrng >= 1000) {
			fsrng = 1000;
		}		
		double k = combined * 10;
		double k2 = (dmax - k);
		System.out.println(dmax + " - " + k + " = " + k2 + " (Pass to succeed)");

		if (fsrng > k2) {
			System.out.println("(Enhancement Succeed)");
			System.out.println("FS + RNG: " + fsrng);
		} else {
			System.out.println("(Enhancement Failed)");
			System.out.println("FS + RNG: " + fsrng);
		}
	}

	public static double armorCalc (int fs, String equipType, int enhanceLvl) {

		// Carried values
		String equip = equipType;
		int lvl = enhanceLvl;
		int fail = fs;

		double softcap = 0;
		double base = 0;
		double increment = 0;
		double increment2 = 0;
		double fin = 0;

		if(lvl == 6) {
			base = 70;
			fin = base;
			if (fail >= 0) {
				softcap = 0;
				increment2 = 1.4;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 7) {
			base = 25.64;
			increment = 2.564;
			fin = base + (increment * fail);
			if (fail >= 18) {
				softcap = 18;
				increment2 = 0.520;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 8) {
			base = 17.24;
			increment = 1.724;
			fin = base + (increment * fail);
			if (fail >= 31) {
				softcap = 31;
				increment2 = 0.34;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 9) {
			base = 11.76;
			increment = 1.177;
			fin = base + (increment * fail);
			if (fail >= 50) {
				softcap = 50;
				increment2 = 0.23;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 10) {
			base = 7.69;
			increment = 0.769;
			fin = base + (increment * fail);
			if (fail >= 82) {
				softcap = 82;
				increment2 = 0.15;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 11) {
			base = 6.25;
			increment = 0.625;
			fin = base + (increment * fail);
			if (fail >= 102) {
				softcap = 102;
				increment2 = 0.12;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 12) {
			base = 5.00;
			increment = 0.500;
			fin = base + (increment * fail);
		} else if (lvl == 13) {
			base = 4.00;
			increment = 0.400;
			fin = base + (increment * fail);
		} else if (lvl == 14) {
			base = 2.86;
			increment = 0.286;
			fin = base + (increment * fail);
		} else if (lvl == 15) {
			base = 2.00;
			increment = 0.200;
			fin = base + (increment * fail);
		} else if (lvl == 16) {
			base = 11.76;
			increment = 1.176;
			fin = base + (increment * fail);
			if (fail >= 50) {
				softcap = 50;
				increment2 = 0.23;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 17) {
			base = 7.69;
			increment = 0.769;
			fin = base + (increment * fail);
			if (fail >= 82) {
				softcap = 82;
				increment2 = 0.16;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 18) {
			base = 6.25;
			increment = 0.625;
			fin = base + (increment * fail);
			if (fail >= 102) {
				softcap = 102;
				increment2 = 0.12;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 19) {
			base = 2.00;
			increment = 0.200;
			fin = base + (increment * fail);
		} else if (lvl == 20) {
			base = 0.30;
			increment = 0.030;
			fin = base + (increment * fail);
		} else {
			fin = 90;
		}

		// If % is over 90%, it displays 90% success rate.
		if (fin > 91) {
			fin = 90;
		}

		return fin;
	}

	public static double weaponCalc (int fs, String equipType, int enhanceLvl) {

		// Carried values
		String equip = equipType;
		int lvl = enhanceLvl;
		int fail = fs;

		double softcap = 0;
		double base = 0;
		double increment = 0;
		double increment2 = 0;
		double fin = 0;

		if(lvl == 8) {
			base = 70;
			fin = base;
			if (fail >= 0) {
				softcap = 0;
				increment2 = 1.4;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 9) {
			base = 20.41;
			increment = 2.041;
			fin = base + (increment * fail);
			if (fail >= 25) {
				softcap = 25;
				increment2 = 0.410;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 10) {
			base = 14.29;
			increment = 1.429;
			fin = base + (increment * fail);
			if (fail >= 43) {
				softcap = 43;
				increment2 = 0.290;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 11) {
			base = 10.00;
			increment = 1.000;
			fin = base + (increment * fail);
			if (fail >= 60) {
				softcap = 60;
				increment2 = 0.200;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 12) {
			base = 6.67;
			increment = 0.670;
			fin = base + (increment * fail);
			if (fail >= 95) {
				softcap = 95;
				increment2 = 0.130;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 13) {
			base = 4.0;
			increment = 0.400;
			fin = base + (increment * fail);
		} else if (lvl == 14) {
			base = 2.5;
			increment = 0.250;
			fin = base + (increment * fail);
		} else if (lvl == 15) {
			base = 2.0;
			increment = 0.200;
			fin = base + (increment * fail);
		} else if (lvl == 16) {
			base = 11.76;
			increment = 1.176;
			fin = base + (increment * fail);
			if (fail >= 52) {
				softcap = 52;
				increment2 = 0.230;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 17) {
			base = 7.69;
			increment = 0.769;
			fin = base + (increment * fail);
			if (fail >= 82) {
				softcap = 82;
				increment2 = 0.160;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 18) {
			base = 6.25;
			increment = 0.625;
			fin = base + (increment * fail);
			if (fail >= 102) {
				softcap = 102;
				increment2 = 0.120;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if (lvl == 19) {
			base = 2.00;
			increment = 0.200;
			fin = base + (increment * fail);
		} else if (lvl == 20) {
			base = 0.30;
			increment = 0.030;
			fin = base + (increment * fail);
		} else {
			fin = 90;
		}

		// If % is over 90%, it displays 90% success rate.
		if (fin > 91) {
			fin = 90;
		}

		return fin;
	}

	public static double accsCalc (int fs, String equipType, int enhanceLvl) {

		// Carried values
		String equip = equipType;
		int lvl = enhanceLvl;
		int fail = fs;

		double softcap = 0;
		double base = 0;
		double increment = 0;
		double increment2 = 0;
		double fin = 0;

		if(lvl == 1) {
			base = 25.00;
			increment = 2.500;
			fin = base + (increment * fail);
			if (fail >= 18) {
				softcap = 18;
				increment2 = 0.500;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if(lvl == 2) {
			base = 10.00;
			increment = 1.250;
			fin = base + (increment * fail);
			if (fail >= 40) {
				softcap = 40;
				increment2 = 0.200;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if(lvl == 3) {
			base = 7.5;
			increment = 0.750;
			fin = base + (increment * fail);
			if (fail >= 44) {
				softcap = 44;
				increment2 = 0.150;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if(lvl == 4) {
			base = 2.5;
			increment = 0.250;
			fin = base + (increment * fail);
			if (fail >= 110) {
				softcap = 110;
				increment2 = 0.050;
				fin = base + (softcap * increment) + ((fail - softcap) * increment2);
			}
		} else if(lvl == 5) {
			base = 0.5;
			increment = 0.050;
			fin = base + (increment * fail);
		} else {
			fin = 90;
		}

		// If % is over 90%, it displays 90% success rate.
		if (fin > 91) {
			fin = 90;
		}


		return fin;
	}
}
