package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="property")
public class Property {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROPERTY_ID")
	private int id;
	
	@Column(name="PROPERTY_ADDRESS")
	private String address;
	
	@Column(name="PROPERTY_CITY")
	private String city;
	
	@Column(name="PROPERTY_STATE")
	private String state;
	
	@Column(name="PROPERTY_ZIP")
	private String zip;
	
	@Column(name="DATE_SOLD")
	private LocalDate dateSold;
	
	public Property() {
		super();
	}
	
	public Property(String address, String city, String state, String zip) {
		super();
		setAddress(address);
		setCity(city);
		setState(state);
		setZip(zip);
	}
	
	// Function assigns current date dateSold
	public void sellProperty() {
		LocalDate sold = LocalDate.now(); // date object created
		setDateSold(sold);
	}
	
	// Getters-Setters & toString

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public LocalDate getDateSold() {
		return dateSold;
	}

	public void setDateSold(LocalDate dateSold) {
		this.dateSold = dateSold;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", dateSold=" + dateSold + "]";
	}

}
