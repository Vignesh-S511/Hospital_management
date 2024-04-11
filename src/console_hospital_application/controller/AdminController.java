package console_hospital_application.controller;

import java.util.Scanner;

import console_hospital_application.services.AdminService;
import console_hospital_application.services.AdminServiceImpl;
import console_hospital_application.database.AdminDatabase;
import console_hospital_application.database.AdminDatabaseImpl;

public class AdminController {
	AdminService adminService = new AdminServiceImpl();
	AdminDatabase  adminDatabase = new AdminDatabaseImpl();
	public void adminController()
	{
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter 1 for adminDelete 2 for display all the patient and Doctor");
			int adminOption;
			adminOption = scanner.nextInt();
			switch(adminOption)
			{
			case 1:
				System.out.println(adminService.adminServiceDelete());
				break;
			case 2:
				adminDatabase.adminDoctorDisplay();
				adminDatabase.adminPatientDisplay();
				break;
			}
		}
	}

}



