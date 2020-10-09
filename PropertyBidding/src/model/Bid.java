package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bid")
public class Bid {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BID_ID")
	private int id;
	
	@Column(name="BID_AMOUNT")
	private double amount;
	
	@ManyToOne (cascade=CascadeType.PERSIST) // Might not be many to one, check later
	@JoinColumn(name="PROP_ID")
	private Property property;
	
	@ManyToOne (cascade=CascadeType.PERSIST) // Might not be many to one, check later 
	@JoinColumn(name="BIDR_ID")
	private Bidder bidder;
	
	public Bid() {
		super();
	}
	
	// Implement constructor, getters/setters, and toString
	

}
