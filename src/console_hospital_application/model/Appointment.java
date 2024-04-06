package console_hospital_application.model;

import java.util.Date;
public class Appointment {
	private String patientAppointmentName;
	private String patientDisease;
	private Date appointmentDate;
	private String doctorName;
	
	public Appointment(String patientName, String disease, Date date, String doctorName) 
	{
		setPatientAppointmentName(patientName);
		setPatientDisease(disease);
		setAppointmentDate(date);
		setDoctorName(doctorName);
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
	
	public Date getAppointmentDate()
	{
		return appointmentDate;
	}
	public void setAppointmentDate(Date date)
	{
		this.appointmentDate = date;
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
