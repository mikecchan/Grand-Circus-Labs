import java.util.Scanner;
import java.util.Random;

/* Michael Chan
 * Lab 5 Dice Rolling
 * In this lab, I let users enter the number of sides a die to have.
 * Then the die will be rolled twice, and each time a random number appears between 1 and the number
 * the user inputted.
 */
public class DiceRolling {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		//'howMany prompts user to enter how many sides.
		howMany(scnr);
		
		scnr.close();
	}
	
	public static void howMany(Scanner scnr) {
		int sides = 0;
		
		while(sides <= 1 ) {
			System.out.println("How many sides do you want a die to have?");
			sides = scnr.nextInt();
			
			if (sides <= 1) {
				System.out.println("Error.  Please enter a valid integer at 2 or greater");
			}
		}
		
		rolling(sides, scnr);
	}
	
	public static void rolling(int sides, Scanner scnr) {
		
		System.out.println("Rolling...");
		System.out.println((int)(Math.random() * sides) + 1);
		
		Random randGen = new Random();
		
		System.out.println("Rolling Again..");
		System.out.println(randGen.nextInt(sides) + 1);
		
		doAgain(scnr);
	}
	
	public static void doAgain(Scanner scnr) {
		System.out.println("Roll Again? (y/n)");
		
		scnr.nextLine();
		
		String rollAgain = scnr.next();
		
		if (rollAgain.equalsIgnoreCase("y") || rollAgain.equalsIgnoreCase("yes")) {
			System.out.println("Rolling Again...");
			howMany(scnr);
		}
		else if (rollAgain.equalsIgnoreCase("n") || rollAgain.equalsIgnoreCase("no")) {
			System.out.println("Bye!");
			System.exit(0);
		}
		else {
			System.out.println("Please enter either 'y', 'yes', 'n', or 'no' ");
			doAgain(scnr);
		}
	}

}
