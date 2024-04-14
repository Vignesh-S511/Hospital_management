package console_hospital_application.controller;

import java.util.Scanner;

import console_hospital_application.services.AppointmentService;
import console_hospital_application.services.AppointmentServiceImpl;
import console_hospital_application.services.PatientService;
import console_hospital_application.services.PatientServiceImpl;
import console_hospital_application.database.AppointmentDatabase;
import console_hospital_application.database.AppointmentDatabaseImpl;

public class PatientController {
	AppointmentService appointmentService = new AppointmentServiceImpl();
	PatientService patientService = new PatientServiceImpl();
	AppointmentDatabase appointmentDatabase = new AppointmentDatabaseImpl();
	public void patientController()
	{
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter 1 for appointment and 2 for cancel appointment 3 to view my booking appointment and 10 for logout ");
			int patientAppointment = scanner.nextInt();
			switch(patientAppointment)
			{
			case 1 :
			    System.out.println( appointmentService.bookPatientAppointment());
			    break;
			case 2 :
				System.out.println(appointmentService.patientCancelAppointment());
				break;
			case 3 :
				appointmentService.viewPatientAppointment();
				break;
			case 10 :
				 System.out.println("logout successfully");
			}
				
		}
		
	}

}

