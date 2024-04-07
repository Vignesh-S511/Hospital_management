package console_hospital_application.services;
import java.text.SimpleDateFormat;

import console_hospital_application.database.*;
import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

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
				date=new SimpleDateFormat("dd/MM/yyyy").parse(appointmentDate); 
			} 
	        catch (ParseException e) 
	        {
				e.printStackTrace();
			}  
	        appointmentDatabase.doctorDisplay();
	        System.out.println("Enter the doctor's name: ");
	        String doctorName = scanner.nextLine();
	        appointmentDatabase.availableDoctor(doctorName);
	        Appointment appointment = new Appointment(patientName, disease, date, doctorName);
	        return appointmentDatabase.bookAppointment(appointment);
	    }
	}

