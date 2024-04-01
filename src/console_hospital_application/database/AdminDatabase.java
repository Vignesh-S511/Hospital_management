package console_hospital_application.database;

import console_hospital_application.model.User;

public interface AdminDatabase {
	public String adminRegister(User admin);
	public String adminLogin(String loginUserName,String loginPassword);
	//public String adminDelete(String deletedUserName);
	

}
