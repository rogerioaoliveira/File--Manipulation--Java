package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Products;

public class Program1 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Products> list = new ArrayList<>();

		System.out.print("Enter a folder: ");
		String strFolder = sc.nextLine();

		File folder = new File(strFolder);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(folder + "\\Products.csv"))) {

			char newProduct = 'Y';

			while (newProduct != 'N') {
				System.out.print("What is the product name? ");
				String name = sc.nextLine();
				System.out.print("What is the product price? ");
				double price = sc.nextDouble();
				System.out.print("What is the product quantity? ");
				int quantity = sc.nextInt();
				System.out.print("Do you want to continue entering products? Y/N ");
				newProduct = sc.next().charAt(0);
				sc.nextLine();

				Products product = new Products(name, price, quantity);
				list.add(product);
				bw.write(product.getName() + ", " + String.format("%.2f", product.getPrice()) + ", "
						+ product.getQuantity());
				bw.newLine();
			}

			try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(folder + "\\out\\Summary.csv"))) {
				for (Products l : list) {
					bw2.write(l.getName() + ", " + l.totalPrice());
					bw2.newLine();
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
