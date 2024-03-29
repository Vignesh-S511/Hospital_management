package console_hospital_application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import console_hospital_application.model.User;

public class AdminDatabase {
	public static void register(String registerUserName,String registerEmail,String registerPassword)throws Exception
	{
		User user = new User(registerPassword, registerPassword, registerPassword);
		try {
			String url = "jdbc:mysql://localhost:3306/hospital_management";
			String mysqlUser = "root";
			String password = "Vignesh@2001";
			String sql = "INSERT INTO admin_details VALUES(?,?,?);";
	    	
	    	Connection connection = DriverManager.getConnection(url,mysqlUser,password);
	    	//Statement statement = connection.createStatement();
	    	PreparedStatement prepareStatement = connection.prepareStatement(sql);
	    	prepareStatement.setString(1,user.getUserName());
	    	prepareStatement.setString(2,user.getEmail());
	    	prepareStatement.setString(3,user.getPassword());
	    	prepareStatement.executeUpdate();
	    	
	    	//System.out.println(PreparedStatement);
	    	
	    	connection.close();
	    	
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public static void login(String loginUserName,String loginPassword)throws Exception
	{
		String sql;
		try {
			String url = "jdbc:mysql://localhost:3306/hospital_management";
			String user = "root";
			String password = "Vignesh@2001";
			sql = "SELECT * FROM  doctor_details WHERE user_name = ? AND Pass_word = ?"; 
	    	Connection connection = DriverManager.getConnection(url,user,password);
	    	//Statement statement = connection.createStatement();
	    	PreparedStatement prepareStatement = connection.prepareStatement(sql);
	    	prepareStatement.setString(1,loginUserName);
	    	prepareStatement.setString(2,loginPassword);
	    	ResultSet rows = prepareStatement.executeQuery();
	    	if(rows.next())
	    	{
	    		System.out.println("Login successfully");
	    	}
	    	else
	    	{
	    		System.out.println("Invalid username or password");
	    	}
	    		    	
	    	connection.close();
	    	
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	
}

		
	
	

