package console_hospital_application;

import java.util.*;
import console_hospital_application.services.AdminService;

import console_hospital_application.database.AdminDatabase;
import console_hospital_application.model.Doctor;
import console_hospital_application.model.Patient;
import console_hospital_application.services.AdminServiceImpl;
import console_hospital_application.services.DoctorServiceImpl;
import console_hospital_application.services.PatientDetails;

public class Main {
	public static void main(String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the option");
		AdminService adminService = new AdminServiceImpl();
		DoctorService doctorService = new DoctorServiceImpl();
		while(true)
		{
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
					System.out.println(DoctorService.doctorRegister());
				}
				else
				{
					System.out.println(PatientDetails.patientRegister());
				}
				break;
			
			case 2:
				System.out.println("ADMIN LOGIN");
				System.out.println("Enter admin userName");
				String loginUserName = scanner.nextLine();
				System.out.println("Enter admin password");
				String loginPassword = scanner.nextLine();
				System.out.println("Enter the user details");
				String userLoginDetails = scanner.nextLine();
				AdminDatabase.login(loginUserName,loginPassword);
				break;
			
			
			}
		}

	}

}
