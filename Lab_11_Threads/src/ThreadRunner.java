
public class ThreadRunner extends Thread{
	private String name;
	private int restProb;
	private int speed;
	private ThreadApp threadapp;
	
	public ThreadRunner(String name, int restProb, int speed, ThreadApp threadapp) {
		this.name = name;
		this.restProb = restProb;
		this.speed = speed;
		this.threadapp = threadapp;
	}
	
	@Override
	public void run() {
		System.out.println(this.name + " started!");
		int meters = 0;
		try {
			while(meters < 1000) {
				double prob = Math.random() * 100;
				if (this.restProb >= prob) {	
					System.out.println("prob is " +prob);
					System.out.println(this.name + " is resting");
					Thread.sleep(100);
				}
				else {		
					meters = meters + this.speed;
					System.out.println(this.name + ": " + meters);
				}
			}
			threadapp.finished(this.name);
		}
		catch(InterruptedException e) {
			System.out.println("Thread " +  name + " interrupted.");
		}
	}
	
}
