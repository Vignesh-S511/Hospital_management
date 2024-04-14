package console_hospital_application.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import console_hospital_application.database.PatientDatabase;

import console_hospital_application.database.AdminDatabaseImpl;
import console_hospital_application.database.DoctorDatabaseImpl;
import console_hospital_application.database.PatientDatabaseImpl;
import console_hospital_application.database.AppointmentDatabaseImpl;
import console_hospital_application.database.AppointmentDatabase;
import console_hospital_application.model.Appointment;
import console_hospital_application.model.Patient;
import console_hospital_application.model.User;
import console_hospital_application.database.PatientDatabase;
import console_hospital_application.database.PatientDatabaseImpl;

public class PatientServiceImpl implements PatientService {
	Scanner scanner = new Scanner(System.in);
	 PatientDatabase patientDatabase = new PatientDatabaseImpl();
	 User userObject = new User();
	 //Appointment appointment = new Appointment(patientName, disease, date, doctorName);
	AppointmentDatabase appointmentDatabase = new AppointmentDatabaseImpl();
	PatientDatabase patientDatebase = new PatientDatabaseImpl();
	
	public static String patientLoginUserName = "";
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
	    patientLoginUserName = scanner.nextLine();
	    System.out.println("Enter patient loginPassWord");
	    String patientLoginPassword = scanner.nextLine();
	    System.out.println(appointmentDatabase.fetchAppointmentDate(patientLoginUserName));
	    return userObject.userLogin(patientLoginUserName, patientLoginPassword,"patient");
	    
	}
	
	
	


}
