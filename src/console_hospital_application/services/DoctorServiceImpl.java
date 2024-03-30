package console_hospital_application.services;

import java.util.Scanner;

import console_hospital_application.database.AdminDatabase;
import console_hospital_application.model.Doctor;

public class DoctorServiceImpl implements DoctorService {
	@Override
	public String doctorRegister()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Doctor Registration");
		System.out.println("Enter doctor userName : ");
		String doctorRegisterUserName = scanner.nextLine();
		System.out.println("Enter doctor Email : ");
		String doctorRegisterEmail = scanner.nextLine();
		System.out.print("Enter registration password : ");
		String doctorRegisterPassword = scanner.nextLine();
		Doctor doctor = new Doctor(doctorRegisterUserName,doctorRegisterEmail,doctorRegisterPassword);
		try {
			AdminDatabase.register(doctorRegisterUserName,doctorRegisterEmail,doctorRegisterPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unable to register";
		}
		return "registered successfully";
		
	}

}
