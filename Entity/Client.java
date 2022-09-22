package MyBCE.Entity;

import java.util.ArrayList;

public class Client {

	private String name;
	private String lastName;
	private int code;

	public Client(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
		String n = name + lastName;
		code = n.hashCode();
	}

	public int getCode() {
		return code;
	}

	public String getLastName() {
		return lastName;
	}
}