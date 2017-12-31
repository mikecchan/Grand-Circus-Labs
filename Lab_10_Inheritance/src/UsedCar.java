
public class UsedCar extends Car{
	
	private double mileage;
	
	public UsedCar() {
		
	}
	
	public UsedCar(int index, double mileage, String make, String model, int year, double price, String type) {
		super(index, make, model, year, price, type);
		this.mileage = mileage;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	@Override 
	public String toString() {
		return String.format("%-5s | %-5s", super.toString(), mileage);
	}
	
}
