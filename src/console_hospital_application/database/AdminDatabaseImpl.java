package console_hospital_application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import console_hospital_application.model.Admin;
import console_hospital_application.model.User;

public class AdminDatabaseImpl implements AdminDatabase 
{
	@Override
	public String adminRegister(User admin)
	{
		try 
		{
			String url = "jdbc:mysql://localhost:3306/hospital_management";
			String mysqlUser = "root";
			String password = "Vignesh@2001";
			String sql = "INSERT INTO admin_details (userName,email,password) VALUES(?,?,?);";
	    	
	    	Connection connection = DriverManager.getConnection(url,mysqlUser,password);
	    	//Statement statement = connection.createStatement();
	    	PreparedStatement prepareStatement = connection.prepareStatement(sql);
	    	prepareStatement.setString(1,admin.getUserName());
	    	prepareStatement.setString(2,admin.getEmail());
	    	prepareStatement.setString(3,admin.getPassword());
	    	prepareStatement.executeUpdate();
	    	
	    	//System.out.println(PreparedStatement);
	    	
	    	connection.close();
	    	
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			return "Registered unsuccessfully";
		}
		
		return "Registered successfully";		
	}
	@Override
	public String adminLogin(String loginUserName,String loginPassword)
	{
		String sql;
		try {
			String url = "jdbc:mysql://localhost:3306/hospital_management";
			String user = "root";
			String password = "Vignesh@2001";
			sql = "SELECT * FROM admin_details WHERE user_name = ? AND Pass_word = ?"; 
	    	Connection connection = DriverManager.getConnection(url,user,password);
	    	//Statement statement = connection.createStatement();
	    	PreparedStatement prepareStatement = connection.prepareStatement(sql);
	    	prepareStatement.setString(1,loginUserName);
	    	prepareStatement.setString(2,loginPassword);
	    	ResultSet rows = prepareStatement.executeQuery();
	    	if(rows.next())
	    	{
	    		connection.close();
	    		return "Login successfully";
	    	}
	    		connection.close();	
	    		    		
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return "Invalid username or password";
		
	}
    public String adminDelete(String deleteTable,String deleteRecord)
	{
		try 
		{
			String url = "jdbc:mysql://localhost:3306/hospital_management";
			String mysqlUser = "root";
			String password = "Vignesh@2001";
			String sql = "DELETE FROM ? WHERE userName = ?";
			 Connection conn = DriverManager.getConnection(url, mysqlUser, password);
	         PreparedStatement prepareStatement = conn.prepareStatement(sql);
	         prepareStatement.setString(1,deleteTable);
	         prepareStatement.setString(2,deleteRecord);
	         ResultSet rowsAffected = prepareStatement.executeQuery();
            
	            if (rowsAffected.next())
	            {
	                System.out.println("User deleted successfully.");
	            } 
	        } 
			catch (SQLException e) 
			{
	            e.printStackTrace();
	        }
		 return "No user found with the specified ID.";
         
	}
}

		
	
	

