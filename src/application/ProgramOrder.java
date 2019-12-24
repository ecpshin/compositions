package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class ProgramOrder {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter Client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth date: ");
		Date birthDate = sdf.parse(sc.next());
		
		Client cli = new Client(name, email, birthDate);
       
		System.out.print("Enter Order data: ");
		
		System.out.print("Status: ");
		String orderStatus = sc.next();
		
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		sc.nextLine();
		
		Order order = new Order();
		OrderItem orderItem = new OrderItem();
				
		for(int i=1;i<=items;i++) {
			
			System.out.println("Enter #" + i + " item data: ");
			
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
						
			orderItem = new OrderItem(quantity, price);
			
			order = new Order(new Date(), OrderStatus.valueOf(orderStatus), cli);
			
			orderItem.addProduct(new Product(productName, price));
			
			order.addItem(orderItem);
			
		}
		
		System.out.print(order);
		sc.close();
	}

}
