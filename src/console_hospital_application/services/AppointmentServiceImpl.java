package console_hospital_application.services;
import java.text.SimpleDateFormat;

import console_hospital_application.database.*;
import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import console_hospital_application.model.Appointment;

public class AppointmentServiceImpl implements AppointmentService
{
	AppointmentDatabase appointmentDatabase = new AppointmentDatabaseImpl();
     Scanner scanner = new Scanner(System.in);
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  public String bookPatientAppointment()
	  {
		  Date date = null;
	        System.out.println("Enter patient name: ");
	        String patientName = scanner.nextLine();

	        System.out.println("Enter the disease: ");
	        String disease = scanner.nextLine();
	          System.out.println("Enter the appoinementDate: ");
		        String appointmentDate = scanner.nextLine();
		        try 
		        {
//		        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		        	LocalDate inputDate = LocalDate.parse(appointmentDate,formatter);
//		        	LocalDate currentDate = LocalDate.now();
//		        	if(!(inputDate.isAfter(currentDate)))
//		        	{
//		        		System.out.println("Enter the valid date ");
//		        		appDate = true;
//		        	}
//		        	else
//		        	{
//		        		appDate = false;
//		        	}
		        	date = new SimpleDateFormat("dd/MM/yyyy").parse(appointmentDate);
				} 
		        catch (Exception e) 
		        {
					e.printStackTrace();
				}  
	        appointmentDatabase.doctorDisplay();
	        boolean repeat = true;
	        String str = "";
	        while(repeat)
	        {
		        System.out.println("Enter the doctor's name: ");
		        String doctorName = scanner.nextLine();
		        if(appointmentDatabase.availableDoctor(doctorName))
		        {
		        	 Appointment appointment = new Appointment(patientName, disease, date, doctorName);
		        	 repeat = false;
		 	        return appointmentDatabase.bookAppointment(appointment);
		        }
		        else
		        {
		        	repeat = true;
		        	System.out.println("This doctor will not available inside the hospital, Please enter available doctor");
		        }
	        }
	        return str;
	    }
	  public String patientCancelAppointment()
	  {
		  System.out.println("Enter which userId you need to cancel");
		  int patientId = scanner.nextInt();
		  scanner.nextLine();
		  //String id = Integer.toString(patientId);
		  return appointmentDatabase. cancelAppointment(patientId); 
	  }
	}

