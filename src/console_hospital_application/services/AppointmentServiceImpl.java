package console_hospital_application.services;

import java.text.SimpleDateFormat;

import console_hospital_application.database.*;
import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import console_hospital_application.model.Appointment;

public class AppointmentServiceImpl implements AppointmentService {
	AppointmentDatabase appointmentDatabase = new AppointmentDatabaseImpl();
	Scanner scanner = new Scanner(System.in);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date date = null;
	PatientDatabase patientDatabase = new PatientDatabaseImpl();
	PatientServiceImpl patientService = new PatientServiceImpl();
			
	public String bookPatientAppointment() {
		
		System.out.println("Enter patient name: ");
		String patientName = scanner.nextLine();
		System.out.println("Enter the disease: ");
		String disease = scanner.nextLine();
		Date currentDate = getCurrentDate();
		while (true) {
			System.out.println("Enter the appoinementDate: ");
			String appointmentDate = scanner.nextLine();
			try {
				date = dateFormat.parse(appointmentDate);
				if (date.after(new Date()) || date.equals(new Date())) {
					break;
				}
				System.out.println("Enter the valid date ");

			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("Enter the valid date");
			}
		}
		System.out.println(date);
		appointmentDatabase.doctorDisplay();
		boolean repeat = true;
		String str = "";
		while (repeat) {
			System.out.println("Enter the doctor's name: ");
			String doctorName = scanner.nextLine();
			if (appointmentDatabase.availableDoctor(doctorName)) {
				Appointment appointment = new Appointment(patientName, disease, date, doctorName);
				repeat = false;
				return appointmentDatabase.bookAppointment(appointment);
			} else {
				repeat = true;
				System.out.println("This doctor will not available inside the hospital, Please enter available doctor");
			}
		}
		return str;
	}

	private Date getCurrentDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String currentDateString = simpleDateFormat.format(new Date()); // format return string format = dd/mm/yyyy+ time
		Date currentDate = null;
		try {
			currentDate = simpleDateFormat.parse(currentDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return currentDate;
	}

	public String patientCancelAppointment() {
		System.out.println("Enter which userId you need to cancel");
		int patientId = scanner.nextInt();
		scanner.nextLine();
		 return appointmentDatabase.cancelAppointment(patientId);
	}
	public void viewPatientAppointment()
	{	
		appointmentDatabase.viewMyAppointment(PatientServiceImpl.patientLoginUserName);
	}
	
}
