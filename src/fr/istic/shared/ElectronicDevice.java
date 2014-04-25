package fr.istic.shared;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("ElectronicDevice")
public class ElectronicDevice extends Peripherique{
	private Long conso;
	private Home home;
	
	public ElectronicDevice(){}

	public ElectronicDevice(Long conso, Home home) {
		super(conso);
		this.home=home;
	}

	public Long getConso() {
		return conso;
	}

	public void setConso(Long conso) {
		this.conso = conso;
	}
	
	@ManyToOne
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
	
	@Override
	public String toString() {
		return "ElectronicDevice";
	}
}
