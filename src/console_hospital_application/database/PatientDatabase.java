package console_hospital_application.database;

import console_hospital_application.model.User;

public interface PatientDatabase {
	public String patientRegister(User admin);
	public String patientLogin(String loginUserName,String loginPassword);

}
