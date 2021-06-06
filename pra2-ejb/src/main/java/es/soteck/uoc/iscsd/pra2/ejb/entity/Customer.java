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

	@Id
	private int id;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "first_name")
	private String first_name;

	@OneToOne
	@JoinColumn(name = "home_address")
	private Address address;


}
