package console_hospital_application.model;

import java.sql.Date;

public class Appointment {
	private String patientAppointmentName;
	private String patientDisease;
	private String appointmentDate;
	private String doctorName;
	
	public Appointment(String patientAppointmentName,String patientDisease,String appointmentDate,String doctorName) 
	{
		this.setPatientAppointmentName(patientAppointmentName);
		this.setPatientDisease(patientDisease);
		this.setAppointmentDate(appointmentDate);
		this.setDoctorName(doctorName);
	}

	public String getPatientAppointmentName()
	{
		return patientAppointmentName;
	}
	public void setPatientAppointmentName(String patientAppointmentName)
	{
		this.patientAppointmentName = patientAppointmentName;
	}
	
	public String getPatientDisease()
	{
		return patientDisease;
	}
	public void setPatientDisease(String patientDisease)
	{
		this.patientDisease = patientDisease;
	}
	
	public String getAppointmentDate()
	{
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate)
	{
		this.appointmentDate = appointmentDate;
	}
	
	public String getDoctorName()
	{
		return doctorName;
	}
	public void setDoctorName(String doctorName)
	{
		this.doctorName = doctorName;
	}
}
