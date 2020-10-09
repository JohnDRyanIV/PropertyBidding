package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bidder")
public class Bidder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BIDDER_ID")
	private int id;
	
	@Column(name="BIDDER_NAME")
	private String name;
	
	public Bidder() {
		super();
	}
	
	// Implement constructors, getters, & toString

}
