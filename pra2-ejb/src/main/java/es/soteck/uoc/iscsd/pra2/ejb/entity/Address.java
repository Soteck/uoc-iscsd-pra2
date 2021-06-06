package es.soteck.uoc.iscsd.pra2.ejb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address", schema = "uoccsd")
public class Address implements Serializable {

	private static final long serialVersionUID = -7432439993674121023L;

	@Id
	private int id;
	private String street;
	private String city;
	private String state;
	private String zip;


	@Override
	public String toString() {

		return "Address: " + getId() + " Street " + getStreet() + " City "
				+ getCity() + " State " + getState() + " Zip " + getZip();
	}
}
