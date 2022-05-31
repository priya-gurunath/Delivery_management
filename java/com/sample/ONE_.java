package com.sample;
import java.sql.SQLException;
import java.util.Scanner;
public class ONE_ {
	public static void main(String[] args) throws SQLException 
	{
			Scanner sc= new Scanner(System.in);
			String loop="y";
			while(loop.equals("y")) 
			{
				
				System.out.println("1. customer_registation");
				System.out.println("2. customer_login");
				System.out.println("3. view order deatils");
				System.out.println("4.view all data with their order details");
				System.out.println("\n Enter your choice: ");
			
				main m=new main();
				
				int a = sc.nextInt();
				switch(a) {
				case 1:m.customer_registation();
					break;
				case 2:m.customer_login();
					
					break;
				case 3:m.delivery_details();
				break;
				case 4:m.view();
			         break;
				default:
					System.out.println("Enter valid choice: ");
				}
				System.out.println("Do you wish to continue: y/n");
				loop = sc.next();
			}
			
			sc.close();
		
		
	
}
}