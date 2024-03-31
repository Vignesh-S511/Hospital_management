package console_hospital_application.services;

import java.util.Scanner;

import console_hospital_application.database.AdminDatabase;
import console_hospital_application.database.PatientDatabase;
import console_hospital_application.model.Patient;

public class PatientServiceImpl implements PatientService {
	@Override
	public  String patientRegister() 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Patient Registration");
		System.out.println("Enter patient userName : ");
		String patientRegisterUserName = scanner.nextLine();
		System.out.println("Enter patient Email : ");
		String patientRegisterEmail = scanner.nextLine();
		System.out.print("Enter registration password : ");
		String patientRegisterPassword = scanner.nextLine();
		PatientDatabase patientDatabase = new PatientDatabase();
		Patient patient = new Patient(patientRegisterUserName,patientRegisterEmail,patientRegisterPassword);
		try {
			patientDatabase.register(patient);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unable to register";
		}
		return "registered successfully";
		
	}


}
