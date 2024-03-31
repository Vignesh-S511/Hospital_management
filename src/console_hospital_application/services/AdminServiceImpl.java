package console_hospital_application.services;
import java.util.Scanner;
																																																																
import console_hospital_application.database.AdminDatabase;
import console_hospital_application.model.Admin;
public class AdminServiceImpl implements AdminService
{
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
			//scanner.close();
			Admin admin = new Admin(adminRegisterUserName,adminRegisterEmail,adminRegisterPassword);// Admin admin = new Admin() anonymous object
			System.out.println(admin.getUserName() );
			System.out.println(admin.getEmail());
			System.out.println(admin.getPassword());

			try 
			{
				AdminDatabase.register(admin);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return "unable to register";
		     }
				return "registered successfully";
	}
																																																																	
}
