package console_hospital_application.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import console_hospital_application.model.Appointment;

public class AppointmentDatabaseImpl implements AppointmentDatabase 
{
	List <String> doctorList = new ArrayList<>();

	@Override
	public String bookAppointment(Appointment appointment) {
		int id;
		try {
			String sql = "INSERT INTO appointment_details (patient_name,patient_disease,appointment_date,doctor_details) VALUES(?,?,?,?);";
	    	
	    	Connection conn = GetConnection.getConnectionInstance();
	    	PreparedStatement prepareStatement = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS ); /// to fetch id from database
	    	prepareStatement.setString(1,appointment. getPatientAppointmentName());
	    	prepareStatement.setString(2,appointment.getPatientDisease());
	        java.sql.Date sqlDate = new java.sql.Date(appointment.getAppointmentDate().getTime());
	    	prepareStatement.setDate(3,sqlDate);
	    	prepareStatement.setString(4,appointment.getDoctorName());
	    	int row = prepareStatement.executeUpdate();
	    	if(row>0)
	    	{
	    		ResultSet generatedKey = prepareStatement.getGeneratedKeys();
	    		if(generatedKey.next())
	    		{
	    			int insertId = generatedKey.getInt(1);
	    			System.out.println("Appointment details stored successfully with id of "+ insertId);
	    		}
	    	}
	    	conn.close();
		}	
		catch(Exception e)
		{
			System.out.println(e.toString());
			return "Stored unsuccessfully";
		}
		return "Stored successfully";
	}
	public void doctorDisplay()
	{
		String doctorName="";
		try 
		{
			String sql ="SELECT * FROM doctor_details";
			Connection conn = GetConnection.getConnectionInstance();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("These doctors are available inside the hospital:");
			System.out.println("Which doctor you want to put appointment : ");
	        while (resultSet.next()) {
	           doctorName = resultSet.getString("User_name");
	           doctorList.add(doctorName);
	           System.out.println(doctorName);
	        }
		}
		catch(Exception e)
		{
			System.out.println("This doctor will not available in our hospital");
		}
	}
	public boolean availableDoctor(String doctorName) 
	{
	        return doctorList.contains(doctorName);
	}
	public String cancelAppointment(int id)
	{
		try
		{
			//int patientId = Integer.parseInt(id);
			String sql = "DELETE FROM appointment_details WHERE id = ?";
			Connection conn = GetConnection.getConnectionInstance();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.toString());
			return "cancelled unSuccessfully";
		}
		return "Canceled Successfully";
	}

}
