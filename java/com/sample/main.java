package com.sample;
	import java.sql.*;

	import java.util.Scanner;
	public class main {
		
		public Connection getMySQLConnectio()
		{
			Connection con=null;
			try {
			
				
				String url="jdbc:mysql://localhost:3306/todo?autoReconnect=true&useSSL=false";
				String username = "root";
				String password = "Baby32386";
				
			con = DriverManager.getConnection(url,username,password);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return con;
			 
		}
		
		
		
		public String customer_registation() throws SQLException {
			// TODO Auto-generated method stub
			
			 try {
					Connection conn =getMySQLConnectio();
					String createAcount = "insert into customers(username,password,email,address,contact_num,customer_id) values(?,?,?,?,?,?) ";
					
					PreparedStatement ps=  conn.prepareStatement(createAcount);
					
					Scanner sc=new Scanner(System.in);
				
					
					System.out.println("Enter your Username");
					String username = sc.next();
					
					System.out.println("Enter your Password:-");
					String password = sc.next();
					System.out.println("Enter your email:-");
					String email = sc.next();
					System.out.println("Enter your address:-");
					String address = sc.next();
					System.out.println("Enter your number:-");
					int contact_num = sc.nextInt();
					System.out.println("Enter your cus_id:-");
					int customer_id = sc.nextInt();
					//String course = sc.next();
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, address);
					ps.setInt(5, contact_num);
					ps.setInt(6,customer_id);
					
					ps.executeUpdate();
					 System.out.println("***** CUSTOMER REGISTRATION IS SUCCESSFULL *****");
						conn.close();
					
			      }catch(Exception e) {
			    	  System.out.println(e);
			      }
			     return "success";
					
				}
			
				
		
		
		
		
	public void customer_login() {
		// TODO Auto-generated method stub
		Scanner ss=new Scanner(System.in);
		System.out.println("Enter UserName");
		String username = ss.next();
		
		System.out.println("Enter password");
		String password = ss.next();

			Connection connn =getMySQLConnectio();
			String sql=  "select username,password,email,address,contact_num,customer_id from CUSTOMERS where username= ?";
			PreparedStatement stmt;
			try {
				stmt = connn.prepareStatement(sql);
				stmt.setString(1, username);
				ResultSet rs=stmt.executeQuery( );
       			
			
				
				 
				if (rs.next()) {
					
					if (rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
                        System.out.println("press 1 to enter your order details");
						int a=ss.nextInt();
						switch(a) {
						case 1:order_details();
						break;
						default:System.out.println("wrong type again");
						break;
						}
				}
				else{
				
					System.out.println("<<<<<  Wrong Username And Password  >>>>>>" );
					
				}
				}
			}
					
			

				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		
	}



	private void order_details() {
		// TODO Auto-generated method stub
		 try {
				Connection conn =getMySQLConnectio();
				String createAcount = "insert into order_details(item_name,mode_of_payment,order_id,status,customer_id) values(?,?,?,?,?) ";
				
				PreparedStatement ps=  conn.prepareStatement(createAcount);
				
				Scanner sc=new Scanner(System.in);
			
				
				System.out.println("Enter your item name");
				String item_name = sc.next();
				System.out.println("Enter your mode of payment:-");
				String mode_of_payment = sc.next();
				System.out.println("Enter your  order id:-");
				int order_id = sc.nextInt();
				System.out.println("Enter your status:-");
				String status = sc.next();
				System.out.println("Enter your cus_id:-");
				int customer_id = sc.nextInt();
				//System.out.println("Enter your course");
				//String course = sc.next();
				ps.setString(1, item_name);
				ps.setString(2, mode_of_payment);
				ps.setInt(3, order_id);
				ps.setString(4, status);
				ps.setInt(5,customer_id);
				
				ps.executeUpdate();
				 System.out.println("***** thanks for filling order details *****");
					conn.close();
				
		      }catch(Exception e) {
		    	  System.out.println(e);
		      }
		     
	}



	public void delivery_details() {
		// TODO Auto-generated method stub
		try{
			
			Scanner sc1 =new Scanner(System.in);
			 
		Connection conn =getMySQLConnectio();
		 Statement stmt=conn.createStatement();  
		 System.out.println("Enter ur order_id");
		 int id1 = sc1.nextInt();
		 
		 ResultSet rs=stmt.executeQuery("select * from order_details WHERE order_id="+id1);
		 while(rs.next()){    
            
			
			 System.out.println(rs.getString(1)+":     "+rs.getString(2)+":      "+rs.getString(3)+":     "+rs.getString(4)+":  "+rs.getString(5));    
         }  
		 
         // Closing connection  
         conn.close();      
     }catch(Exception e){ System.out.println("error connecting db"+e);}    
 }



	public void view() {
		// TODO Auto-generated method stub
		try{
			Connection conn =getMySQLConnectio();
			 Statement stmt=conn.createStatement();  
			 ResultSet rs=stmt.executeQuery("select * from customer inner join orders on customer.customer_id=orders.customer_id");
			 while(rs.next()){    
	            
			
				 System.out.println(rs.getString(1)+":3"+rs.getString(3)+":     "+rs.getString(4)+":  "+rs.getString(5)+"  :     "+rs.getString(7)+":      "+rs.getString(8)+"  "+ rs.getString(9)+"   :     "+rs.getString(10)+" :     "+rs.getString(11));    
	         }  
			 
	         // Closing connection  
	         conn.close();      
	     }catch(Exception e){ System.out.println("error connecting db"+e);}    
	 }

	}    
	
	
	
	
	

