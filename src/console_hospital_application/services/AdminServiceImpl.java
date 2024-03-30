package console_hospital_application.services;

import java.util.Scanner;

import console_hospital_application.database.AdminDatabase;
import console_hospital_application.model.Admin;

public class AdminServiceImpl implements AdminService{
	@Override
	public String adminRegister() 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Admin Registration");
		System.out.println("Enter admin userName : ");
		String adminRegisterUserName = scanner.nextLine();
		System.out.println("Enter admin Email : ");
		String adminRegisterEmail = scanner.nextLine();
		System.out.print("Enter registration password : ");
		String adminRegisterPassword = scanner.nextLine();
		scanner.close();
		new Admin(adminRegisterUserName,adminRegisterEmail,adminRegisterPassword);// Admin admin = new Admin() anonymous object
		try {
			AdminDatabase.register(adminRegisterUserName,adminRegisterEmail,adminRegisterPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unable to register";
		}
		return "registered successfully";
		
	}

}
