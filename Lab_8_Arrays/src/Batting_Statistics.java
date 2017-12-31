import java.util.Scanner;

/*
 * @author: Michael Chan
 * Lab 8
 * In this lab, I am creating a batting statistics calculator to calculate user input's batting and slugging average.
 * This is what the application will do step by step...
 * 1) Calculate the batting average and slugging percentage for one or more baseball/softball players.
 * 2) Ask for number of at bats.
 * 3) After all of the at-bats are entered, it will output the batting average and slugging percentage of the batter.
 */

public class Batting_Statistics {
	
	static Scanner scnr = new Scanner(System.in);
	
	/*
	 * The main method to initialze and run this project.  This application will continuously
	 * run under a while loop until the user wants to stop continuing.
	 */
	public static void main(String[] args) {
		boolean keepGoing = true;
		
		while(keepGoing) {
			int bats = Validator.getInt(scnr, "Please enter number of bats: ");
		
			int[] atBatArray = createArray(bats);
		
			System.out.println("The batting average is: " + calcBatAvg(atBatArray));
		
			System.out.println("The slugging percentage is: " + calcSlugAvg(atBatArray) + "%");
		
			keepGoing = doAgain();
		}
	}
	
	/*
	 * This method will create the array of how many at bats a user inputs.
	 * Once array is created, it will iterate through each index of the array and prompt users to
	 * enter the number of bases a batter runs after hitting the ball
	 */
	public static int[] createArray(int bats) {
		int[] atBatArray = new int[bats];
		
		for (int i=0 ; i < atBatArray.length ; i++) {
			atBatArray[i] = Validator.getInt(scnr, "Please enter number (between 0 and 4) of bases earned at bat: " + (i + 1), 0, 4);
		}
		return atBatArray;
	}
	
	/*
	 * This method will calculate the batting average.
	 * The batting average is the total number of at-bats or which the player earned at least one base
	 * divided by the total number of at-bats.
	 */
	public static double calcBatAvg(int[] atBatArray) {
		int count = 0;
		for (int i = 0; i < atBatArray.length ; i++) {
			if (atBatArray[i] > 0) {
				count++;
			}
		}
		double count_d = count;
		double atBatArray_d = atBatArray.length;
		
		return count_d/atBatArray_d;
	}
	
	/*
	 * This method will calculate the slugging percentage.  The slugging percentage is the total number of
	 * bases earned divided by the total number of at-bats.
	 */
	public static double calcSlugAvg(int[] atBatArray) {
		int sum = 0;
		for (int i = 0; i < atBatArray.length ; i++) {
			sum = sum + atBatArray[i];
		}
		
		double sum_d = sum;
		double atBatArray_d = atBatArray.length;
		return sum_d/atBatArray_d;
	}
	
	/*
	 * Once the application outputs the batting average and slugging percentage, this method will
	 * prompt users if he/she would like to rerun this application again.
	 */
	public static boolean doAgain() {
		System.out.println("Would you like to try again?  Please type only 'yes' or 'no'");
		String tryAgain = scnr.nextLine();
		boolean response = true;
		if (tryAgain.equalsIgnoreCase("no")) {
			response = false;
			System.out.println("Bye!");
		}
		else if (tryAgain.equalsIgnoreCase("yes")) {
			response = true;
			System.out.println("Going at it again!");
		}
		else {
			System.out.println("In valid response.  Please try again.");
			doAgain();
		}
		return response;
	}
}
