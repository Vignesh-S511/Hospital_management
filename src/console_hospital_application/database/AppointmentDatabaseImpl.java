package console_hospital_application.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import console_hospital_application.model.Appointment;
import console_hospital_application.services.AppointmentService;
import console_hospital_application.services.AppointmentServiceImpl;

public class AppointmentDatabaseImpl implements AppointmentDatabase 
{
	List <String> doctorList = new ArrayList<>();
	List <String> patientList = new ArrayList<>();


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
	        conn.close();
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
	public String fetchAppointmentDate(String patientLoginUserName)
	{
		String patientName = " ";
		try {
			String sql = "SELECT appointment_date FROM appointment_details WHERE patient_name = ?";
			Connection conn = GetConnection.getConnectionInstance();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,patientLoginUserName);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			
			Date currentDate = new Date(); //13-04-2024   8.56
			long millisecondInDay = 24*60*60*1000; // 24hr in millisecond
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date tomorrowDate = null;
			try 
			{
				tomorrowDate = simpleDateFormat.parse(simpleDateFormat.format(new Date(currentDate.getTime()+millisecondInDay))); // 2024/04/14 00:00:00
				                                                                       //           1970 12.oclock gmt jan1 - 2024 8.56 ist april 13 diff millisec                          
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			while(resultSet.next())
			{
				java.sql.Date appointmentDate = resultSet.getDate("appointment_date");
				java.util.Date utilAppointmentDate = new java.util.Date(appointmentDate.getTime());
			    if(utilAppointmentDate.equals(tomorrowDate))
				{
					return "you have an appointment tomorrow";
				}
			}
			conn.close();

		}
		catch(SQLException e){
			System.out.println(e.toString());
			
		}
		return " ";
	}
	public void viewMyAppointment(String patientLoginUserName)
	{
		try {
			String sql = "SELECT appointment_date,doctor_details FROM appointment_details WHERE patient_name = ? ";
			Connection conn = GetConnection.getConnectionInstance();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,patientLoginUserName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				java.sql.Date appointmentDate = resultSet.getDate("appointment_date");
				String doctorDetails = resultSet.getString("doctor_details");
				java.util.Date utilAppointmentDate = new java.util.Date(appointmentDate.getTime());
				System.out.println(utilAppointmentDate);
				System.out.println(doctorDetails);
				
			}
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.toString());
		}
	}
	
}
