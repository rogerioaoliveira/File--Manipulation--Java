package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Products;

public class Program2 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Products> list = new ArrayList<>();

		System.out.print("Enter a path: ");
		String path = sc.nextLine();
		
		File folder = new File(path);
		String newFolder = folder.getParent();
		
		boolean nF = new File(newFolder + "\\out").mkdir();
					
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] str = line.split(",");
				String name = str[0];
				double price = Double.parseDouble(str[1]);
				int quantity = Integer.parseInt(str[2]);
				
				Products product = new Products(name, price, quantity);
				list.add(product);
				line = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFolder + "\\out\\Summary.csv"))) {
				for (Products l : list) {
					bw.write(l.getName() + ", " + l.totalPrice());
					bw.newLine();
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
	