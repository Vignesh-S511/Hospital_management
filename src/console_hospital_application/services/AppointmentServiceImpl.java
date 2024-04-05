package console_hospital_application.services;

import java.text.SimpleDateFormat;
import console_hospital_application.database.*;
import java.util.Date;
import java.util.Scanner;

import console_hospital_application.model.Appointment;

public class AppointmentServiceImpl implements AppointmentService
{
	AppointmentDatabase appointmentDatabase = new AppointmentDatabaseImpl();
	public String patientAppointment() 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter patient name : ");
		String patientAppointmentName = scanner.nextLine();
		System.out.println("Enter what kind of disease : ");
		String patientDisease = scanner.nextLine();
		System.out.println("Enter the appointment date : ");
		String appointmentDate = scanner.nextLine();
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		//Date date = formatter.parse(appointmentDate);
		System.out.println("Enter the name of doctor : ");
		String doctorName = scanner.nextLine();
		 Appointment appointment = new Appointment(patientAppointmentName,patientDisease,appointmentDate,doctorName);
		 return appointmentDatabase.bookAppointment(appointment);
	}

}
