package console_hospital_application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import console_hospital_application.model.User;

public class PatientDatabaseImpl implements PatientDatabase{
	public String patientRegister(User Patient)
	{
		//User user = new User(registerPassword, registerPassword, registerPassword);
		try {
			String url = "jdbc:mysql://localhost:3306/hospital_management";
			String mysqlUser = "root";
			String password = "Vignesh@2001";
			String sql = "INSERT INTO patient_details VALUES(?,?,?);";
	    	
	    	Connection connection = DriverManager.getConnection(url,mysqlUser,password);
	    	PreparedStatement prepareStatement = connection.prepareStatement(sql);
	    	prepareStatement.setString(1,Patient.getUserName());
	    	prepareStatement.setString(2,Patient.getEmail());
	    	prepareStatement.setString(3,Patient.getPassword());
	    	prepareStatement.executeUpdate();
	    	connection.close();
	    	
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
	
}

		
	
	

