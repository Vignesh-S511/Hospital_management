package console_hospital_application.database;

import java.util.Date;

import console_hospital_application.model.User;

public interface PatientDatabase {
	public String patientRegister(User admin);
	public String patientLogin(String loginUserName,String loginPassword);
	//public String patientAppointmentDetails(String patientAppointmentName,String patientDisease,Date date);

}
