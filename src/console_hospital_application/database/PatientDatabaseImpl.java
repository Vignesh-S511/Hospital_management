package console_hospital_application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import console_hospital_application.model.User;

public class PatientDatabaseImpl implements PatientDatabase
{
	public String patientRegister(User Patient)
	{
		try {
			String sql = "INSERT INTO patient_details VALUES(?,?,?);";
	    	
	    	Connection conn = GetConnection.getConnectionInstance();
	    	PreparedStatement prepareStatement = conn.prepareStatement(sql);
	    	prepareStatement.setString(1,Patient.getUserName());
	    	prepareStatement.setString(2,Patient.getEmail());
	    	prepareStatement.setString(3,Patient.getPassword());
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
	public String patientLogin(String loginUserName,String loginPassword)
	{
		String sql;
		try 
		{
			sql = "SELECT * FROM  patient_details WHERE user_name = ? AND password = ?"; 
	    	Connection conn = GetConnection.getConnectionInstance();
	    	PreparedStatement prepareStatement = conn.prepareStatement(sql);
	    	prepareStatement.setString(1,loginUserName);
	    	prepareStatement.setString(2,loginPassword);
	    	ResultSet rows = prepareStatement.executeQuery();
	    	if(rows.next()){
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

		
	
	

