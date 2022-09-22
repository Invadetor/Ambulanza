package MyBCE.Controller;

import MyBCE.Entity.Ambulatory;
import MyBCE.Entity.Client;
import MyBCE.Entity.Doctor;
import MyBCE.Entity.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Controller {


	public static ArrayList<Reservation> showReservationsOfDoctor(String number, String date) throws ParseException {
		ArrayList<Reservation> completo = new ArrayList<>();
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		Date d = s.parse(date);
		Date today = new Date();
		if(d.before(today)) {
			throw new RuntimeException("The Date has to be after today.");
		}
		int iD = Ambulatory.getAmbulatorio().findNumber(number);
		if(Ambulatory.getAmbulatorio().findNumber(number) > 0){
			for(Reservation r : Ambulatory.getAmbulatorio().getReservations()) {
				if(r.getDate().equals(d) && r.getDoctor().getNumber().equals(number)) {
					completo.add(r);
				}
			}
		} else {
			throw new RuntimeException("The Doctor with that Number doesn't exist.");
		}
		return completo;

		/*for(Doctor d : Ambulatory.getAmbulatorio().getDoctors()) {
			if(d.getNumber().equals(doctor.getNumber())) {
				for(Reservation r : d.getReservations()) {
					if(r.getDate().equals(date)) {
						completo.add(r);
					}
				}
				return completo;
			}
		}
		return null;*/
	}

	public static void addReservation(String name, String lastName, Date date, String hour, String numberD) {
		int iD = Ambulatory.getAmbulatorio().findNumber(numberD);
		String n = name + lastName;
		int iC = Ambulatory.getAmbulatorio().findCode(n.hashCode());
		if(iD < 0) {
			throw new RuntimeException("Doctor Doesn't exist");
		}
		if(iC < 0) {
			Client c = new Client(name, lastName);
			Ambulatory.getAmbulatorio().getClients().add(c);
		}
		Doctor d = Ambulatory.getAmbulatorio().getDoctors().get(iD);
		Client c = Ambulatory.getAmbulatorio().getClients().get(iC);
		String codice = d.getNumber() + c.getLastName() + date.toString();
		Reservation r = new Reservation(date, hour, codice.hashCode(), d, c);
		Ambulatory.getAmbulatorio().assignReservation(r, d, c);
	}

	public static void removeReservation(int code) throws ParseException {
		int c = Ambulatory.getAmbulatorio().findCode(code);
		if(c < 0) {
			throw new RuntimeException("Reservation doesn't exist");
		}
		Ambulatory.getAmbulatorio().removeReservation(c);
	}

}