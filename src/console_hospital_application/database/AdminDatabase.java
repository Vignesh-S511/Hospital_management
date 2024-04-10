package console_hospital_application.database;

import console_hospital_application.model.User;

public interface AdminDatabase {
	public String adminRegister(User admin);
	public String adminDelete(String deleteTableName,String deleteRecord);
	public void adminDoctorDisplay();
	public void adminPatientDisplay();
	

}
