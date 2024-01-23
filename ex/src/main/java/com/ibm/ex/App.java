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
		Customer customer=new Customer();
		Orders order=new Orders();
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
	        boolean or_conf1=Boolean.valueOf(br.readLine());
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
			System.out.println("==============================");
			System.out.println("Enter Customer Id:");
			String id2=br.readLine();
			customer=customerService.getCustomerByCustomerId(id2);
			if(customer==null)
			{
				System.out.println("no such customer available..");
			}
			else
			{
				System.out.println(customer);
			}
			System.out.println("==============================");
			System.out.println("Enter Order Id:");
			String id1=br.readLine();
			order=ordersService.getOrderById(id1);
			if(order==null)
			{
				System.out.println("no such order available..");
			}
			else
			{
				System.out.println(order);
			}
			System.out.println("==============================");
			System.out.println("To update customer,enter customer id: ");
			customer=customerService.getCustomerByCustomerId(br.readLine());
			if(customer==null)
			{
				System.out.println("no such customer available..");
			}
			else
			{
				System.out.println("Enter new customer Name: ");
			    String cn = br.readLine();
				System.out.println("Customer updated: "+customerService.updateById(customer.getCustomerId(),cn));
			}
			System.out.println("==============================");
			System.out.println("To update order,enter order id: ");
			order=ordersService.getOrderById(br.readLine());
			if(order==null)
			{
				System.out.println("no such order available..");
			}
			else
			{
				System.out.println("Enter new order type: ");
			    String ot = br.readLine();
		        System.out.println("enter new order price: ");
			    double op = br.read();
				System.out.println("is order confirmed? ");
			    boolean con = sc.nextBoolean();
				System.out.println("Order updated: "+ordersService.updateById(order.getId(),ot,con,op));
			}
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}