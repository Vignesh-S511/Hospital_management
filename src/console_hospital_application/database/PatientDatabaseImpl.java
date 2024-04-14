package console_hospital_application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import console_hospital_application.model.User;

public class PatientDatabaseImpl implements PatientDatabase {
	Map<String, String> patientMap = new HashMap<String, String>();

	public String patientRegister(User Patient) {
		try {
			String sql = "INSERT INTO patient_details VALUES(?,?,?);";

			Connection conn = GetConnection.getConnectionInstance();
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, Patient.getUserName());
			prepareStatement.setString(2, Patient.getEmail());
			prepareStatement.setString(3, Patient.getPassword());
			int rows = prepareStatement.executeUpdate();
			conn.close();
			patientMap.put(Patient.getUserName(), Patient.getPassword());
			System.out.println(patientMap);

		} catch (SQLException e) {
			System.out.println(e.toString());
			return "Registered unsuccessfully";
		}

		return "Registered successfully";
	}
	
	

	

}
