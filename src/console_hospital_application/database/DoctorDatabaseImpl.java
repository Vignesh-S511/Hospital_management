package console_hospital_application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import console_hospital_application.model.User;

public class DoctorDatabaseImpl {
	
	public void doctorRegister(User Doctor)
	{
		//User user = new User(registerPassword, registerPassword, registerPassword);
		try {
			String url = "jdbc:mysql://localhost:3306/hospital_management";
			String mysqlUser = "root";
			String password = "Vignesh@2001";
			String sql = "INSERT INTO doctor_details VALUES(?,?,?);";
	    	
	    	Connection connection = DriverManager.getConnection(url,mysqlUser,password);
	    	//Statement statement = connection.createStatement();
	    	PreparedStatement prepareStatement = connection.prepareStatement(sql);
	    	prepareStatement.setString(1,Doctor.getUserName());
	    	prepareStatement.setString(2,Doctor.getEmail());
	    	prepareStatement.setString(3,Doctor.getPassword());
	    	prepareStatement.executeUpdate();
	    	
	    	//System.out.println(PreparedStatement);
	    	
	    	connection.close();
	    	
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public void doctorLogin(String loginUserName,String loginPassword)
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

		
	
	

