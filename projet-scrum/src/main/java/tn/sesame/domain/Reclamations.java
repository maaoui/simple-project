package tn.sesame.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="reclamations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reclamations {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idrec;
	private String nom;
	private String description;
	
	private String etat;
@ManyToOne
private Collaborateur coll;

@ManyToOne
private Service service;

}
