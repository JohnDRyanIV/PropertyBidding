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
	private Double amount;
	
	@ManyToOne (cascade=CascadeType.PERSIST) // Might not be many to one, check later
	@JoinColumn(name="PROP_ID")
	private Property property;
	
	@ManyToOne (cascade=CascadeType.PERSIST) // Might not be many to one, check later 
	@JoinColumn(name="BIDR_ID")
	private Bidder bidder;
	
	public Bid() {
		super();
	}
	
	public Bid(Double amount, Property property, Bidder bidder) {
		super();
		setAmount(amount);
		setProperty(property);
		setBidder(bidder);
	}
	
	// Getters-Setters & toString
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

	@Override
	public String toString() {
		return "Bid [id=" + id + ", amount=" + amount + ", property=" + property.toString() + 
				", bidder=" + bidder.toString() + "]";
	}
	

}
