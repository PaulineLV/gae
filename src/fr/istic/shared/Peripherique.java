package fr.istic.shared;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="peripheriquetype",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Peripherique")
public class Peripherique implements Serializable{
	
	private int id;
	private Long conso;
	
	public Peripherique(){}

	public Peripherique(Long conso) {
		this.conso=conso;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Long getConso() {
		return conso;
	}

	public void setConso(Long conso) {
		this.conso = conso;
	}
}

