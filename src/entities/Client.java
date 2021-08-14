package entities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

public class Client {
	private String name;
	private String email;
	private Date birthDate;
		
	public Client() {
	}

	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + name + "\n");
		sb.append("Email: " + email + "\n");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthDate);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = 1 + cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		
		sb.append("Birth Date: " + day + "/");

		if(month < 10) {
			NumberFormat f = new DecimalFormat("00");
			String monthDecimal = String.valueOf(f.format(month));
			sb.append(monthDecimal + "/");
		}
		else {
			sb.append(month +"/");
		}
		
		sb.append(year);

		return sb.toString();
	}
	
	
}
