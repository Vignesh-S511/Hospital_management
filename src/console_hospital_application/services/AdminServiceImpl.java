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
			return adminDatabase.adminRegister(admin);
	}
	
	public String adminLogin()
	{
	    System.out.println("Enter admin loginUserName");
	    String adminLoginUserName = scanner.nextLine();
	    System.out.println("Enter admin loginPassWord");
	    String adminLoginPassword = scanner.nextLine();
	    AdminDatabaseImpl adminDatabase = new AdminDatabaseImpl();
	    adminDatabase.adminLogin(adminLoginUserName,adminLoginPassword);
	    //System.out.println("Enter the option : ");
	    //int adminOption = scanner.nextInt();
	    
	    	System.out.println("which user you want to delete : ");
	    	String deleteTable = scanner.nextLine();
	    	System.out.println("which record you want to delete : ");
	    	String deleteRecord = scanner.nextLine();
	    	DoctorDatabaseImpl doctorDataBase = new DoctorDatabaseImpl();
	    	return doctorDataBase.adminDelete(deleteTable,deleteRecord);
	    	
	    
	    
	}
																																																																	
}
//3 claa inside db imp

