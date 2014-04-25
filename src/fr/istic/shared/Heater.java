package fr.istic.shared;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Heater")
public class Heater extends Peripherique{
	
	private Long conso;
	private Home home;
	
	public Heater(){}

	public Heater(Long conso, Home h) {
		super(conso);
		this.home=h;
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
		return "Heater";
	}
}

