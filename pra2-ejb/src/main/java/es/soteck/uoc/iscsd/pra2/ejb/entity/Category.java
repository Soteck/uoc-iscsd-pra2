package es.soteck.uoc.iscsd.pra2.ejb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category", schema = "pra2")
public class Category {

	@Id
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;
}
