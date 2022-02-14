package entities;

public class Products {

	private String name;
	private double price;
	private int quantity;
	
	public Products(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String totalPrice () {
		double result = price * (double) quantity;
		return String.format("%.2f", result);
	}
}
