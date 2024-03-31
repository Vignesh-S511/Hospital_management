package console_hospital_application.database;

import console_hospital_application.model.User;

public interface DoctorDatabase {
	public void doctorRegister(User admin);
	public void doctorLogin(String loginUserName,String loginPassword);

}
