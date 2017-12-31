import java.util.Random;

public enum Roshambo {
	Rock, Paper, Scissors;
	
	
	
	public static Roshambo getRandomRoshambo() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
}
