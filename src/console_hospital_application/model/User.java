package console_hospital_application.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import console_hospital_application.database.GetConnection;

public class User {
	private String userName;
	private String email;
	private String password;
	
	
	public User(String userName,String email,String password)
	{
		this.setUserName(userName);
		this.setEmail(email);
		this.setPassword(password);
	}
	public User()
	{
		
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getEmail() 
	{
		return email;
	}	
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String userLogin(String loginUserName, String loginPassword,String tableName) {
		try {
			String sql;
			if(tableName.equals("admin"))
			{
				sql = "SELECT * FROM admin_details where user_name = ?";
			}
			else if(tableName.equals("doctor"))
			{
				sql = "SELECT * FROM doctor_details where user_name = ?";
			}
			else 
			{
				sql = "SELECT * FROM patient_details where user_name = ?";
			}
			Connection connection = GetConnection.getConnectionInstance();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, loginUserName);
			ResultSet rs = prepareStatement.executeQuery();
			if (!rs.next()) {
				return "No such user";
			}
			String storedPassword = rs.getString("password");
			if (storedPassword.equals(loginPassword)) {
				return "login successfully";
			}
			return "Enter valid userName and password";
		} catch (SQLException e) {
			System.out.println(e.toString());
			return "Enter valid userName and Password";

		}

	}
	
	}