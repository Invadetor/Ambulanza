package MyBCE.Entity;

import java.util.Date;


public class Reservation {

	private Date date;
	private String hour;
	private int code;
	private Doctor doctor;
	private Client client;


	public Reservation(Date date, String hour, int code, Doctor doctor, Client client) {
		this.date = date;
		this.hour = hour;
		this.code = code;
		this.doctor = doctor;
		this.client = client;
	}

	public Date getDate() {return date;}

	public int getCode() {return code;}

	public Doctor getDoctor() {
		return doctor;
	}

	public Client getClient() {
		return client;
	}
}