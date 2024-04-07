package console_hospital_application.database;

import console_hospital_application.model.Appointment;

public interface AppointmentDatabase 
{
	public String bookAppointment(Appointment appointment );
	public String doctorDisplay();
	public String availableDoctor(String availableDoctor);
}
