package console_hospital_application.services;

import java.util.Scanner;

import console_hospital_application.database.AdminDatabaseImpl;
import console_hospital_application.database.DoctorDatabaseImpl;
import console_hospital_application.model.Doctor;

public abstract class DoctorServiceImpl implements DoctorService {
	Scanner scanner = new Scanner(System.in);
	@Override
	public String doctorRegister()
	{
		
		System.out.println("Doctor Registration");
		System.out.println("Enter doctor userName : ");
		String doctorRegisterUserName = scanner.nextLine();
		System.out.println("Enter doctor Email : ");
		String doctorRegisterEmail = scanner.nextLine();
		System.out.print("Enter registration password : ");
		String doctorRegisterPassword = scanner.nextLine();
		DoctorDatabaseImpl doctorDatabase = new DoctorDatabaseImpl();
		Doctor doctor = new Doctor(doctorRegisterUserName,doctorRegisterEmail,doctorRegisterPassword);
		try 
		{
			doctorDatabase.doctorRegister(doctor);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "unable to register";
		}
		return "registered successfully";
		
	}
	public String doctorLogin()
	{
		String loginUserName = scanner.nextLine();
	    System.out.println("Enter doctor loginUserName");
	    String doctorLoginUserName = scanner.nextLine();
	    System.out.println("Enter admin loginPassWord");
	    String doctorLoginPassword = scanner.nextLine();
	    DoctorDatabaseImpl doctorDatabase = new DoctorDatabaseImpl();
	    doctorDatabase.doctorLogin(doctorLoginUserName,doctorLoginPassword);
	    return "login successfully";
	}

}
