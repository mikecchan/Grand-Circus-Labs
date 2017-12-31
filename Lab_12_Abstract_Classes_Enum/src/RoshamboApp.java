
public class RoshamboApp {
	
	/*
	 * @author: Michael Chan
	 * Lab 12: Rock, Paper, Scissors game.
	 * In this lab exercise, I am primarily demonstrating my competency using abstract classes and enumerations.
	 */
	
	/*My main method goes as follows:
	 * Having the program continuously run over and over again as long as the boolean ('keepGoing') is true.
	 * Create two players of different inheriting classes of which share the same parent abstract class.
	 * In the loop, the player and the computer will pick a roshambo.
	 * Then the 'compare()' function will compare the results of the two picks to determine who wins, losses, or ties.
	 */
	public static void main(String[] args) {
		boolean keepGoing = true;
		System.out.println("Welcome to Rock, Paper, Scissors!");
		Player me = createHuman();
		Player opponent = createOpponent();
			while(keepGoing) {
				me.setPick();
				opponent.setPick();
				compare(me, opponent);
				keepGoing = Validator.doAgain("Would you like to play again? (y/n)");
			}
	}
	
	//Method to create a Player object inheriting the Human class.
	public static Player createHuman() {
		Player player = new Human();
		player.setName(Validator.getString("Please enter your name: "));
		return player;
	}
	
	//Method to create a Player object inheriting either the 'TheJets' or 'TheSharks' class.
	public static Player createOpponent() {
		Player player = null;
		boolean isValid = false;
		while(!isValid) {
			String opponent = Validator.getString("Would you like to play against TheJets or The Sharks (j/s)?");
			if (opponent.equalsIgnoreCase("j")) {
				player = new TheJets();
				player.setName("TheJets");
				isValid = true;
			}
			else if (opponent.equalsIgnoreCase("s")){
				player = new TheSharks();
				player.setName("TheSharks");
				isValid = true;
			}
			else {
				System.out.println("Error, please enter only j or s");
			}
		}
		return player;
	}
	
	//Compare the roshambo of each Player class and determine the outcome.
	public static void compare(Player me, Player opponent) {
		System.out.println("You picked " + me.pick);
		System.out.println(opponent.name +" picked " + opponent.pick);
		if (me.pick.toString().equalsIgnoreCase(opponent.pick.toString())) {
			System.out.println("Tie!");
		}
		else {
			if (me.pick.toString().equalsIgnoreCase("Rock")) {
				switch (opponent.pick.toString()) {
					case "Scissors": 
						System.out.println("You Win!");
						break;
					case "Paper": 
						System.out.println("You Lose!");
						break;
				}
			}
			else if (me.pick.toString().equalsIgnoreCase("Paper")) {
				switch (opponent.pick.toString()) {
					case "Rock": 
						System.out.println("You Win!");
						break;
					case "Scissors": 
						System.out.println("You Lose!");
						break;
				}
			}
			else if (me.pick.toString().equalsIgnoreCase("Scissors")) {
				switch (opponent.pick.toString()) {
					case "Paper": 
						System.out.println("You Win!");
						break;
					case "Rock": 
						System.out.println("You Lose!");
						break;
				}
			}
		}
	}
}
