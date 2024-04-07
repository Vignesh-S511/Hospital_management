package console_hospital_application.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import console_hospital_application.database.PatientDatabase;

import console_hospital_application.database.AdminDatabaseImpl;
import console_hospital_application.database.DoctorDatabaseImpl;
import console_hospital_application.database.PatientDatabaseImpl;
import console_hospital_application.model.Appointment;
import console_hospital_application.model.Patient;

public class PatientServiceImpl implements PatientService {
	private static final String Appointment = null;
	Scanner scanner = new Scanner(System.in);
	 PatientDatabase patientDatabase = new PatientDatabaseImpl();
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
		//PatientDatabaseImpl patientDatabase = new PatientDatabaseImpl();
		Patient patient = new Patient(patientRegisterUserName,patientRegisterEmail,patientRegisterPassword);
		return patientDatabase.patientRegister(patient);
		
	}
	public String patientLogin()
	{
	    System.out.println("Enter patient loginUserName");
	    String patientLoginUserName = scanner.nextLine();
	    System.out.println("Enter patient loginPassWord");
	    String patientLoginPassword = scanner.nextLine();
	    return patientDatabase.patientLogin(patientLoginUserName,patientLoginPassword);
	    
	}
	


}
