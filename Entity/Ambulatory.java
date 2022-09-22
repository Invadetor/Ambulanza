package MyBCE.Entity;

import MyBCE.Entity.Doctor;
import java.util.ArrayList;
import java.util.Date;

public class Ambulatory {

	private static Ambulatory ambulatory = null;

	private ArrayList<Doctor> doctors = new ArrayList<>();

	private ArrayList<Reservation> reservations = new ArrayList<>();

	private ArrayList<Client> clients = new ArrayList<>();



	public static Ambulatory getAmbulatorio() {
		if(ambulatory == null) {
			ambulatory = new Ambulatory();
		}
		return ambulatory;
	}

	public void removeReservation(int position){
		reservations.remove(position);
	}

	public void assignReservation(Reservation r, Doctor d, Client c){
		reservations.add(r);
	}

	public Boolean verifyDoctor(String number) {
		for(Doctor d : doctors) {
			if(d.getNumber().equals(number)) {
				return true;
			}
		}
		return false;
	}

	public int findNumber(String number) {
		for(Doctor d : doctors) {
			if(number.equals(d.getNumber())) {
				return doctors.indexOf(d);
			}
		}
		return -1;
	}

	public int findCode(int code) {
		for(Client c : clients) {
			if(code == c.getCode()) {
				return doctors.indexOf(c);
			}
		}
		return -1;
	}

	public ArrayList<Doctor> getDoctors() {return doctors;}

	public ArrayList<Reservation> getReservations() {return reservations;}

	public ArrayList<Client> getClients() {
		return clients;
	}
}