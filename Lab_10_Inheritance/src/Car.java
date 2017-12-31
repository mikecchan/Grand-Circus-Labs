
public class Car {
	
	private int index;
	private String make;
	private String model;
	private int year;
	private double price;
	private String type;
	
	public Car() {
	}
	
	public Car(int index, String make, String model, int year, double price, String type) {
		this.index = index;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override 
	public String toString() {
		return String.format("%-5s | %-5s | %-5s | %-5s | %-5s | %-5s", index, make , model , year , price, type);
	}
	
}
