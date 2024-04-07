package console_hospital_application.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import console_hospital_application.model.Appointment;

public class AppointmentDatabaseImpl implements AppointmentDatabase 
{

	@Override
	public String bookAppointment(Appointment appointment) {
		try {
			String sql = "INSERT INTO appointment_details (patient_name,patient_disease,appointment_date,doctor_details) VALUES(?,?,?,?);";
	    	
	    	Connection conn = GetConnection.getConnectionInstance();
	    	PreparedStatement prepareStatement = conn.prepareStatement(sql);
	    	prepareStatement.setString(1,appointment. getPatientAppointmentName());
	    	prepareStatement.setString(2,appointment.getPatientDisease());
	    	java.sql.Date sqlDate = new java.sql.Date(appointment.getAppointmentDate().getTime());
	    	prepareStatement.setDate(3,sqlDate);
	    	prepareStatement.setString(4,appointment.getDoctorName());
	    	prepareStatement.executeUpdate();
	    	conn.close();
		}	
		catch(Exception e)
		{
			System.out.println(e.toString());
			return "Stored unsuccessfully";
		}
		return "Stored successfully";
	}
	public String doctorDisplay()
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
	           System.out.println(doctorName);
	        }
		}
		catch(Exception e)
		{
			System.out.println("This doctor will not available in our hospital");
		}
		return doctorName;
	}
	 public String availableDoctor(String doctorName) {
	        try {
		        String sql = "SELECT COUNT(*) AS count FROM doctor_details WHERE doctor_name = ?";
		        Connection conn = GetConnection.getConnectionInstance();
	        	PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, doctorName);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                int count = rs.getInt("count");
	                if (count > 0) {
	                    return "Doctor available in the hospital.";
	                } else {
	                    return "This doctor is not available in the hospital.";
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return "An error occurred while checking doctor availability.";
	    }

}
