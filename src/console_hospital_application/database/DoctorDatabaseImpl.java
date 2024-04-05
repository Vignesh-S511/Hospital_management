package console_hospital_application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import console_hospital_application.model.User;

public class DoctorDatabaseImpl implements DoctorDatabase {
	
	public String doctorRegister(User doctor)
	{
		//User user = new User(registerPassword, registerPassword, registerPassword);
		try {
			String sql = "INSERT INTO doctor_details VALUES(?,?,?);";
	    	
	    	Connection conn = GetConnection.getConnectionInstance();
	    	PreparedStatement prepareStatement = conn.prepareStatement(sql);
	    	prepareStatement.setString(1,doctor.getUserName());
	    	prepareStatement.setString(2,doctor.getEmail());
	    	prepareStatement.setString(3,doctor.getPassword());
	    	prepareStatement.executeUpdate();
	    	conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			return "Registered unsuccessfully";
		}
		
		return "Registered successfully";

	}
	public String doctorLogin(String loginUserName,String loginPassword)
	{
		String sql;
		try {
			
			sql = "SELECT * FROM  doctor_details WHERE user_name = ? AND Pass_word = ?"; 
	    	Connection conn = GetConnection.getConnectionInstance();
	    	//Statement statement = connection.createStatement();
	    	PreparedStatement prepareStatement = conn.prepareStatement(sql);
	    	prepareStatement.setString(1,loginUserName);
	    	prepareStatement.setString(2,loginPassword);
	    	ResultSet rows = prepareStatement.executeQuery();
	    	
	    	if(rows.next())
	    	{
	    		conn.close();
	    		return "Login successfully";
	    	}
	    		conn.close();	
	    		    		
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return "Invalid username or password";
		
	}
	
	
}

		
	
	

