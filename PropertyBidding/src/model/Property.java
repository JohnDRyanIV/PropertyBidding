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
	
	// Implement constructors, getters/setters, and toString

}
