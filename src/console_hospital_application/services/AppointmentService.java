package console_hospital_application.services;

import java.text.ParseException;

public interface AppointmentService 
{
	public String bookPatientAppointment();
	public String patientCancelAppointment();
	public void viewPatientAppointment();
}
