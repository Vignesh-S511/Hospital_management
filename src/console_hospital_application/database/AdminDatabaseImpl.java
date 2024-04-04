package console_hospital_application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import console_hospital_application.model.Admin;
import console_hospital_application.model.User;

public class AdminDatabaseImpl implements AdminDatabase {
	@Override
	public String adminRegister(User admin) {
		try {
			String sql = "INSERT INTO admin_details (userName,email,password) VALUES(?,?,?);";
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

	@Override
	public String adminLogin(String loginUserName, String loginPassword) {
		String sql;
		try {
			sql = "SELECT * FROM admin_details WHERE userName = ? AND Password = ?";
			Connection conn = GetConnection.getConnectionInstance();
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, loginUserName);
			prepareStatement.setString(2, loginPassword);
			ResultSet rows = prepareStatement.executeQuery();
			if (rows.next()) {
				conn.close();
				return "Login successfully";
			}
			conn.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return "Invalid username or password";

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
}
