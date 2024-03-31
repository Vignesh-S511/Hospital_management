package console_hospital_application.services;
import java.util.Scanner;
																																																																
import console_hospital_application.database.AdminDatabaseImpl;
import console_hospital_application.database.DoctorDatabaseImpl;
import console_hospital_application.model.Admin;
import console_hospital_application.model.Doctor;
public class AdminServiceImpl implements AdminService
{
	Scanner scanner = new Scanner(System.in);
	@Override
	public String adminRegister()
	{
			
		    System.out.println("Admin Registration");
			System.out.println("Enter admin userName : ");
			String adminRegisterUserName = scanner.nextLine();
			System.out.println("Enter admin Email : ");
			String adminRegisterEmail = scanner.nextLine();
		    System.out.print("Enter registration password : ");
			String adminRegisterPassword = scanner.nextLine();
			//scanner.close();
			AdminDatabaseImpl adminDatabase = new AdminDatabaseImpl();
			Admin admin = new Admin(adminRegisterUserName,adminRegisterEmail,adminRegisterPassword);
			try 
			{
				adminDatabase.adminRegister(admin);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return "unable to register";
		     }
				return "registered successfully";
	}
	public String adminLogin()
	{
		String loginUserName = scanner.nextLine();
	    System.out.println("Enter admin loginUserName");
	    String adminLoginUserName = scanner.nextLine();
	    System.out.println("Enter admin loginPassWord");
	    String adminLoginPassword = scanner.nextLine();
	    AdminDatabaseImpl adminDatabase = new AdminDatabaseImpl();
	    adminDatabase.adminLogin(adminLoginUserName,adminLoginPassword);
	    return "login successfully";
	}
																																																																	
}
//3 claa inside db imp