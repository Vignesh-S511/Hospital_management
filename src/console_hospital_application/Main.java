package console_hospital_application;

import java.text.DateFormat;
import java.util.*;
import console_hospital_application.services.AdminService;
import console_hospital_application.services.DoctorService;
import console_hospital_application.services.PatientService;

import console_hospital_application.database.AdminDatabaseImpl;
import console_hospital_application.model.Doctor;
import console_hospital_application.model.Patient;
import console_hospital_application.services.AdminServiceImpl;
import console_hospital_application.services.AppointmentService;
import console_hospital_application.services.AppointmentServiceImpl;
import console_hospital_application.services.DoctorServiceImpl;
import console_hospital_application.services.PatientServiceImpl;
import console_hospital_application.controller.PatientController;
import console_hospital_application.controller.AdminController;

public class Main {
	public static void main(String[] args) throws Exception
	{
		
		Scanner scanner = new Scanner(System.in);
		AdminService adminService = new AdminServiceImpl();
		DoctorService doctorService = new DoctorServiceImpl();
		PatientService patientService = new PatientServiceImpl();
		
		PatientController patientController = new PatientController();
		AdminController adminController = new AdminController();
		while(true)
		{
			System.out.println("Enter the option");
			int option = scanner.nextInt();
			scanner.nextLine();
			switch(option)
			{
			case 1:
				System.out.print("Enter the userType : ");
				String userType = scanner.nextLine();
				
				if(userType.equals("admin"))
				{
					System.out.println(adminService.adminRegister());
				} 
				else if(userType.equals("doctor"))
				{
					System.out.println(doctorService.doctorRegister());
				}
				else
				{
					System.out.println(patientService.patientRegister());
				}
				break;
			
			case 2:
				System.out.println("LOGIN");
				System.out.println("Enter the userType : ");
				String loginUserType = scanner.nextLine();
				
				if(loginUserType.equals("admin"))
				{
					System.out.println(adminService.adminLogin());
					adminController.adminController();
				}
				else if(loginUserType.equals("doctor"))
				{
					System.out.println(doctorService.doctorLogin());
				}
				else 
				{
					    System.out.println(patientService.patientLogin());
						patientController.patientController();
				}
				break;
			
			
			}
		}

	}

}
