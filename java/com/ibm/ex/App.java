package com.ibm.ex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.UUID;

import com.ibm.ex.model.Customer;
import com.ibm.ex.model.Orders;
import com.ibm.ex.service.CustomerService;
import com.ibm.ex.service.CustomerServiceImpl;
import com.ibm.ex.service.OrdersService;
import com.ibm.ex.service.OrdersServiceImpl;


public class App {
private static CustomerService customerService;
private static OrdersService ordersService;

	static
	{
		customerService=new CustomerServiceImpl();
		ordersService=new OrdersServiceImpl();

	}
	public static void main(String[] args) {
		// create session factory

		// create session
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);

		try {

			UUID uniqueId = UUID.randomUUID();
	        String cusId = uniqueId.toString();
	        System.out.println("Enter name of the customer:");
	        String cus_nm=br.readLine();
			Customer tempCustomer = new Customer(cusId,cus_nm);
			UUID uniqueId1 = UUID.randomUUID();
	        String orId = uniqueId1.toString();
	        System.out.println("Enter type of order:");
	        String or_type=br.readLine();
	        System.out.println("Enter price of order:");
	        double or_pr=br.read();
	        System.out.println("Is order confirmed?");
	        boolean or_conf1=sc.nextBoolean();
			Orders tempOrders = new Orders(orId,or_type, or_pr,or_conf1);
			tempCustomer.setOrders(tempOrders);
			System.out.println("Saving customer and order: " + customerService.createCustomer(tempCustomer));
			System.out.println("==============================");
			System.out.println("List of all customers:");
			for(Customer c:customerService.getAllCustomers())
			{
				System.out.println(c);
			}
			System.out.println("==============================");
			System.out.println("List of all orders:");
			for(Orders o:ordersService.getAllOrders())
			{
				System.out.println(o);
			}

			System.out.println("Done!");
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}