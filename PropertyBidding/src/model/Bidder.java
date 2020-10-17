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
	
	public Bidder(String name) {
		super();
		setName(name);
	}

	// Getters-Setters & toString
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bidder [id=" + id + ", name=" + name + "]";
	}

}
