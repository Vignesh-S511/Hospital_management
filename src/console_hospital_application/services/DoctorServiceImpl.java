package console_hospital_application.services;

import java.util.Scanner;

import console_hospital_application.database.AdminDatabase;
import console_hospital_application.database.DoctorDatabase;
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
		DoctorDatabase doctorDatabase = new DoctorDatabase();
		Doctor doctor = new Doctor(doctorRegisterUserName,doctorRegisterEmail,doctorRegisterPassword);
		try 
		{
			doctorDatabase.register(doctor);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "unable to register";
		}
		return "registered successfully";
		
	}

}
