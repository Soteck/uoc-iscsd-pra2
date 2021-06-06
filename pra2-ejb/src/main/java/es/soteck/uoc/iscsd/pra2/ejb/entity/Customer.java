package es.soteck.uoc.iscsd.pra2.ejb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer", schema = "uoccsd")
public class Customer implements Serializable {

	private static final long serialVersionUID = -1344945732500875806L;

	@Id
	private int id;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@OneToOne
	@JoinColumn(name = "home_address")
	private Address address;

	public Customer (int id, String lastName, String firstName){
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}

}
