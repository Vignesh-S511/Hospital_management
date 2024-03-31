package console_hospital_application.database;

import console_hospital_application.model.User;

public interface AdminDatabase {
	public void adminRegister(User admin);
	public void adminLogin(String loginUserName,String loginPassword);
	

}
