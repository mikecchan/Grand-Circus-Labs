
public class ThreadApp {

	private static ThreadRunner Tortoise;
	private static ThreadRunner Hare;

	public static void main(String[] args) {
		
		ThreadApp threadapp = new ThreadApp();
		 Tortoise = new ThreadRunner("Tortoise", 0, 1, threadapp);
		 Hare = new ThreadRunner("Hare", 90, 10, threadapp);
		
		System.out.println("Starting..");
		
		Tortoise.start();
		Hare.start();
	}
	
	public static void finished(String winnerName) {
		
		if (winnerName.equalsIgnoreCase("Tortoise")) {
			Hare.interrupt();
			System.out.println("Tortoise is the winner!");
		}
		else {
			System.out.println("Hare is the winner!");
			Tortoise.interrupt();
		}
		
	}

}
