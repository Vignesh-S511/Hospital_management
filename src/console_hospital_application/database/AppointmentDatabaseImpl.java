package console_hospital_application.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import console_hospital_application.model.Appointment;

public class AppointmentDatabaseImpl implements AppointmentDatabase 
{

	@Override
	public String bookAppointment(Appointment appointment) {
		//User user = new User(registerPassword, registerPassword, registerPassword);
		try {
			String sql = "INSERT INTO appointment_details (patient_name,patient_disease,appointment_date,doctor_name) VALUES(?,?,?,?);";
	    	
	    	Connection conn = GetConnection.getConnectionInstance();
	    	PreparedStatement prepareStatement = conn.prepareStatement(sql);
	    	prepareStatement.setString(1,appointment. getPatientAppointmentName());
	    	prepareStatement.setString(2,appointment.getPatientDisease());
	    	prepareStatement.setString(3,appointment.getAppointmentDate());
	    	prepareStatement.setString(3,appointment.getDoctorName());
	    	prepareStatement.executeUpdate();
	    	conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			return "Stored unsuccessfully";
		}
		
		return "Stored successfully";

		//return null;
	}
	
}
