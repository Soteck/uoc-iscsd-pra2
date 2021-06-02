package es.soteck.uoc.iscsd.pra2.ejb.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="uoccsd.customer")
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String last_name;
	private String first_name;
	private Address address;
	

	public Customer() {
		super();
	}

	public Customer(int id, String last_name, String first_name) {
		
		this.id = id;
		this.last_name = last_name;
		this.first_name = first_name;
	}

	@Id

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "last_name")
	public String getLastName() {
		return last_name;
	}
	public  void setLastName(String last_name) {
		this.last_name = last_name;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return first_name;
	}	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	// persistent relationships
	@OneToOne
	@JoinColumn(name = "home_address")
	public Address getHomeAddress() {
		return address;
	}	
	public void setHomeAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {

		return "Customer: " + getId() + " Name " + getLastName() + ", "
				+ getFirstName();
	}
}
