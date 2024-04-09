package controller;

import java.util.Scanner;

import console_hospital_application.services.AppointmentService;
import console_hospital_application.services.AppointmentServiceImpl;

public class PatientController {
	AppointmentService appointmentService = new AppointmentServiceImpl();
	public void patientController()
	{
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter 1 for appointment and 2 for cancel appointment and 10 for logout ");
			int patientAppointment = scanner.nextInt();
			switch(patientAppointment)
			{
			case 1 :
			    System.out.println( appointmentService.bookPatientAppointment());
			    break;
			case 2 :
				System.out.println(appointmentService.patientCancelAppointment());
				break;
			case 10 :
				 System.out.println("logout successfully");
			}
				
		}
		
	}

}
