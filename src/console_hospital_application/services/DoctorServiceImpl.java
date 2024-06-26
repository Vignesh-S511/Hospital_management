package console_hospital_application.services;

import java.util.Scanner;

import console_hospital_application.database.AdminDatabaseImpl;
import console_hospital_application.database.DoctorDatabaseImpl;
import console_hospital_application.model.Doctor;
import console_hospital_application.model.User;

public class DoctorServiceImpl implements DoctorService {
	Scanner scanner = new Scanner(System.in);
	User userObject = new User();
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
		return doctorDatabase.doctorRegister(doctor);
	}
	public String doctorLogin()
	{
	    System.out.println("Enter doctor loginUserName");
	    String doctorLoginUserName = scanner.nextLine();
	    System.out.println("Enter doctor loginPassWord");
	    String doctorLoginPassword = scanner.nextLine();
	    return userObject.userLogin(doctorLoginUserName, doctorLoginPassword,"doctor");
	}

}
