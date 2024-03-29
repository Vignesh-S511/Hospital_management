package console_hospital_application;

import java.util.*;

import console_hospital_application.database.AdminDatabase;
import console_hospital_application.model.Doctor;
import console_hospital_application.model.Patient;
import console_hospital_application.services.AdminDetails;

public class Main {
	public static void main(String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
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
				System.out.println(AdminDetails.adminRegister());
			}
			else if(userType.equals("doctor"))
			{
				Doctor.doctorRegister();
			}
			else
			{
				Patient.patientRegister();
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
