package com.dbms_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeTable {
	
	static Connection con = null;
	static Statement st = null;
	
	// A. Inserting 5 Records
       public void CreationAndInsertion() throws SQLException {
    	   try {
   			
   			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl?useSSL=false","root","1234"); 
   			st = con.createStatement();		
   				// Creating Employee Table	
   			String query = "create table Employee (Id int primary key ,Name varchar(50) NOT NULL,"
   					+ " Email_Id varchar(50) NOT NULL, Phone_Number varchar(50) NOT NULL)";		
   			// Inserting the values into Employee Table		
   			String query1 = "insert into Employee values(1, \"Kunal Maan\", \"kunalmaan@gamil.com\", \"9468321657\") ";
   			String query2 = "insert into Employee values(2, \"Pranjal Dahiya\", \"pranjaldahiya@gamil.com\", \"9864641568\")";
   			String query3 = "insert into Employee values(3, \"Ram Pal\", \"rampal@gamil.com\", \"9586058719\")";
   			String query4 = "insert into Employee values(4, \"Harbansh Malik\", \"harbanshmalik@gmail.com\", \"9715245660\")";
   			String query5 = "insert into Employee values(5, \"Prince Kant\", \"princekant@gmail.com\", \"9048245555\")";		
   					

   			try {
   				st.execute(query);
   				st.executeUpdate(query1);
   				st.executeUpdate(query2);
   				st.executeUpdate(query3);
   				st.executeUpdate(query4);
   				st.executeUpdate(query5);
   				
   				System.out.println("Table Created Successfully.");
   				System.out.println("Insertion Successful");
   			}catch (SQLException e) {
   				System.out.println(e.getMessage());
   				
   			}	

   		}
   		catch (SQLException e) {
   			System.out.println(e.getMessage());
   			e.printStackTrace();

   		}finally {
   			
   			st.close();
   			con.close();
   		}
       }
       //B. Modify Email_Id column to varchar(30) NOT NULL
       public void ModifyEmail_Id() throws SQLException {
    	   try {
      			
      			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl?useSSL=false","root","1234"); 
      			st = con.createStatement();		
      				// Creating Employee Table	
      			String query ="alter table Employee modify Email_Id varchar(30) not null";
      			try {
      				st.executeUpdate(query);
      				System.out.println("Modify Statement Updated!");
      			
    	   }catch (SQLException e) {
      			System.out.println(e.getMessage());
       			e.printStackTrace();
    	   }	
       }catch (SQLException e) {
 			System.out.println(e.getMessage());
   			e.printStackTrace();
       }finally {

  			st.close();
  			con.close();
       }
    	   
       }
       
       //C.Inserting Two Records
       public void InsertingTwoRecords() throws SQLException{
    	   try {
    		   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gl?useSSL=false","root","1234"); 
    		   st=con.createStatement();
    		   ResultSet res = null;
    		   String query1="insert into Employee values(6,\"Rina\",\"rina@gmail.com\",\"9354567880\")";
    		   String query2="insert into Employee values(7,\"Samarth\",\"samarth@gmail.com\",\"9234567876\")";
    		   String query = "select * from employee";
    		   try {
    			   st.executeUpdate(query1);
    			   st.executeUpdate(query2);
    			   res = st.executeQuery(query);
    			   System.out.println("Two records are Inserted Successfully!");
    			   
    			   while (res.next()) {
    					// Retrieving data from each row
    					int id = res.getInt("Id");

    					String name = res.getString("Name");
    					String eMail = res.getString("Email_Id");
    					String phoneNumber=res.getString("Phone_Number");

    					System.out.println("Employee ID: " + id+", Employee Name: " + name+", Email_Id: "+eMail+", Phone_Number: "+phoneNumber);
    				//	System.out.println("Employee Name: " + name + " " + lname);
    			   }
    		   }catch(Exception e) {
    			   e.printStackTrace();
    		   }
    	   }catch(Exception e) {
    		   e.printStackTrace();
    	   }finally {

     			st.close();
     			con.close();
          }
       }
       
       //D.Update the name of Employee Id 3 to Karthik and Phone Number to 1234567890
       public void UpdateName() throws SQLException{
    	   try {
    		   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gl?useSSL=false","root","1234"); 
    		   st=con.createStatement();
    		   
    		   String query="update Employee set Name=\"Karthik\",Phone_Number=\"1234567890\" where Id=3";
    	      
    			try {
    				st.executeUpdate(query);
    				System.out.println("Id=3 Name Updated!");
    			}catch(Exception e ) {
    				e.printStackTrace();
    			}
    	   }catch(Exception e) {
    		   e.printStackTrace();
    	   }
    	   finally {

     			st.close();
     			con.close();
          }
       }
       //E.Delete Employee records 3 and 4
       public void DeleteRecords() throws SQLException{
    	   try {
    		   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gl?useSSL=false","root","1234"); 
    		   st=con.createStatement();
    		   
    		   String query="delete from Employee where Id IN(3,4)";
    	      
    			try {
    				st.executeUpdate(query);
    				System.out.println("Records of Id in(3 and 4 ) are deleted!");
    			}catch(Exception e ) {
    				e.printStackTrace();
    			}
    	   }catch(Exception e) {
    		   e.printStackTrace();
    	   }
    	   finally {

     			st.close();
     			con.close();
          }
       }
       
       //F.Remove all records from the table Employee
       public void RemovingAllTheRecords() throws SQLException{
    	   try {
    		   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gl?useSSL=false","root","1234"); 
    		   st=con.createStatement();
    		   
    		   String query="truncate table Employee";
    	      
    			try {
    				st.executeUpdate(query);
    				System.out.println("All Records are removed from the table!");
    			}catch(Exception e ) {
    				e.printStackTrace();
    			}
    	   }catch(Exception e) {
    		   e.printStackTrace();
    	   }
    	   finally {

     			st.close();
     			con.close();
          }
       }
	public static void main(String[] args) throws SQLException  {

		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			
			Class.forName(driver);
		}catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		EmployeeTable tb=new EmployeeTable();
		// 1. Inserting 5 records to the Table Employee
		tb.CreationAndInsertion();
		// 2.Modifying Email_Id dataType
        tb.ModifyEmail_Id();
        // 3.Inserting two records 
		tb.InsertingTwoRecords();
		tb.UpdateName();
		tb.DeleteRecords();
		tb.RemovingAllTheRecords();

	}	
		
}
