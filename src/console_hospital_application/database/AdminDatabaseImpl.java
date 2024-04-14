package console_hospital_application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import console_hospital_application.model.Admin;
import console_hospital_application.model.User;

public class AdminDatabaseImpl implements AdminDatabase {
	List <String> doctorList = new ArrayList<>();
	List <String> patientList = new ArrayList<>();
	@Override
	public String adminRegister(User admin) {
		try {
			String sql = "INSERT INTO admin_details (user_name,email,password) VALUES(?,?,?);";
			Connection conn = GetConnection.getConnectionInstance();
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, admin.getUserName());
			prepareStatement.setString(2, admin.getEmail());
			prepareStatement.setString(3, admin.getPassword());
			prepareStatement.executeUpdate();
			conn.close();

		} catch (Exception e) {
			System.out.println(e.toString());
			return "Registered unsuccessfully";
		}

		return "Registered successfully";
	}
	public String adminDelete(String deleteTable, String deleteRecord) {
		String sql = " ";
		try {
			if (deleteTable.equals("doctor")) {
				sql = "DELETE FROM doctor_details WHERE user_name = ?";
			} else if (deleteTable.equals("patient")) {
				sql = "DELETE FROM patient_details WHERE user_name = ?";
			} else {
				return "Invalid Input";
			}
			Connection conn = GetConnection.getConnectionInstance();
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, deleteRecord);
			int rowsAffected = prepareStatement.executeUpdate();

			if (rowsAffected == 1) {
				return "User deleted successfully.";
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "No user found with the specified ID.";
	}

	public void adminDoctorDisplay() {
		String doctorName="";
		try 
		{
			String sql ="SELECT * FROM doctor_details";
			Connection conn = GetConnection.getConnectionInstance();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("These doctors are available inside the hospital:");
			while (resultSet.next()) {
		           doctorName = resultSet.getString("User_name");
		           doctorList.add(doctorName);
		           System.out.println(doctorName);
		        }
			conn.close();
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	public void adminPatientDisplay() {
		String patientName="";
		try 
		{
			String sql ="SELECT * FROM patient_details";
			Connection conn = GetConnection.getConnectionInstance();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("These patient are booking appointment:");
	        while (resultSet.next()) 
	        {
	        	patientName = resultSet.getString("User_name");
		           patientList.add(patientName);
		           System.out.println(patientName);
	        }
	        conn.close();
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	
}
