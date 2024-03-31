package console_hospital_application.database;

import console_hospital_application.model.User;

public interface DoctorDatabase {
	public String doctorRegister(User admin);
	public String doctorLogin(String loginUserName,String loginPassword);

}
