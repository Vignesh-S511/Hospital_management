package console_hospital_application.services;
import java.util.Scanner;
																																																																
import console_hospital_application.database.AdminDatabaseImpl;
import console_hospital_application.database.DoctorDatabaseImpl;
import console_hospital_application.model.Admin;
import console_hospital_application.model.Doctor;
import console_hospital_application.model.User;
import console_hospital_application.database.AdminDatabase;
public class AdminServiceImpl implements AdminService
{
	Scanner scanner = new Scanner(System.in);
	AdminDatabase adminDatabase = new AdminDatabaseImpl();
	User userObject = new User();
	
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
			Admin admin = new Admin(adminRegisterUserName,adminRegisterEmail,adminRegisterPassword);
			return adminDatabase.adminRegister(admin);
	}
	
	public String adminLogin()
	{
	    System.out.println("Enter admin loginUserName");
	    String adminLoginUserName = scanner.nextLine();
	    System.out.println("Enter admin loginPassWord");
	    String adminLoginPassword = scanner.nextLine();
	    return userObject.userLogin(adminLoginUserName, adminLoginPassword,"admin");
	}
	public String adminServiceDelete()
	{
        System.out.println("which user you want to delete : ");
	    String deleteTable = scanner.nextLine();
	    System.out.println("which record you want to delete : ");
	    String deleteRecord = scanner.nextLine();
	    return adminDatabase.adminDelete(deleteTable,deleteRecord);
	}
																																																																	
}

