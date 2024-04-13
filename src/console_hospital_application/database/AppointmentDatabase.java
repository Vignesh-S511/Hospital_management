package console_hospital_application.database;

import console_hospital_application.model.Appointment;

public interface AppointmentDatabase 
{
	public String bookAppointment(Appointment appointment );
	public void doctorDisplay();
	public boolean availableDoctor(String availableDoctor);
	public String cancelAppointment(int cancelAppointment);
	public String fetchAppointmentDate(String patientLoginUserName);
}
