//Michael Chan
//Lab 3
/* In this assignment, I am building an application that allows users to input a numerical value of
 * and calculate each integer from 1 to the numerical value, the square and cube of each value.
 */

import java.util.Scanner;

public class Power {
	
	public static int squared(int i) {
		i = i * i;
		return i;
	}
	
	public static int cubed(int i) {
		i = i * i * i;
		return i;
	}
	
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		int input = 0;
		int input_sqrd;
		int input_cubd;
		String cont = "y";
		boolean goodinput = false;
		
		while (cont.equalsIgnoreCase("y")) {
			System.out.println("Please enter an integer...");
		
			while(!scnr.hasNextInt()) {
				scnr.next();
				System.out.println("Error.  Please enter a valid integer only");
			}
			input = scnr.nextInt();
		
			System.out.println(" Number" + "  " + "Squared"  + " " + " Cubed");
			System.out.println("=======" + "  " + "======="  + " " + "=======");
		
			for (int i = 1; i <= input; i++) {
				input_sqrd = squared(i);
				input_cubd = cubed(i);
				System.out.println(i + "        " + input_sqrd + "        " + input_cubd);
			}
			
			while (goodinput == false) {
				System.out.println("Would you like to try again?");
				cont = scnr.next();
				if (cont.equalsIgnoreCase("n") || cont.equalsIgnoreCase("no")) {
					cont = "n";
					goodinput = true;
				}
				else if (cont.equalsIgnoreCase("y") || cont.equalsIgnoreCase("yes")) {
					System.out.println("You would like to continue...");
					goodinput = true;
					break;
				}
				else {
					System.out.println("Please enter either 'n', 'no', 'y', or 'yes' ");
				}
			}
			goodinput = false;
		}
		
		scnr.close();
	}
}
