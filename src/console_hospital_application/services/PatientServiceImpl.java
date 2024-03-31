package console_hospital_application.services;

import java.util.Scanner;
import console_hospital_application.database.PatientDatabase;

import console_hospital_application.database.AdminDatabaseImpl;
import console_hospital_application.database.DoctorDatabaseImpl;
import console_hospital_application.database.PatientDatabaseImpl;
import console_hospital_application.model.Patient;

public class PatientServiceImpl implements PatientService {
	Scanner scanner = new Scanner(System.in);
	@Override
	public  String patientRegister() 
	{
		//Scanner scanner = new Scanner(System.in);
		System.out.println("Patient Registration");
		System.out.println("Enter patient userName : ");
		String patientRegisterUserName = scanner.nextLine();
		System.out.println("Enter patient Email : ");
		String patientRegisterEmail = scanner.nextLine();
		System.out.print("Enter registration password : ");
		String patientRegisterPassword = scanner.nextLine();
		PatientDatabaseImpl patientDatabase = new PatientDatabaseImpl();
		Patient patient = new Patient(patientRegisterUserName,patientRegisterEmail,patientRegisterPassword);
		try {
			patientDatabase.patientRegister(patient);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unable to register";
		}
		return "registered successfully";
	}
	public String patientLogin()
	{
	    System.out.println("Enter patient loginUserName");
	    String patientLoginUserName = scanner.nextLine();
	    System.out.println("Enter admin loginPassWord");
	    String patientLoginPassword = scanner.nextLine();
	    PatientDatabase patientDatabase = new PatientDatabaseImpl();
	    patientDatabase.patientLogin(patientLoginUserName,patientLoginPassword);
		
	    return "login successfully";
	}


}
