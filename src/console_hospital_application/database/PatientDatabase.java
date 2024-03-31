package console_hospital_application.database;

import console_hospital_application.model.User;

public interface PatientDatabase {
	public void patientRegister(User admin);
	public void patientLogin(String loginUserName,String loginPassword);

}
