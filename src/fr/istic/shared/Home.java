package fr.istic.shared;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
public class Home implements Serializable{
	
	private int id;
	private String adresse;
	private float superficie;
	private String adresseIP;
	private Person person;
	
	private Collection<Peripherique> periphs;
	
	public Home(){}

	public Home(String adresse, float superficie, String adresseIP, Person person) {
		this.adresse = adresse;
		this.superficie = superficie;
		this.adresseIP = adresseIP;
		this.periphs=new ArrayList<Peripherique>();
		this.person=person;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public float getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}
	
	public String getAdresseIP() {
		return adresseIP;
	}
	
	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}
	
	@OneToMany(mappedBy="home", cascade = CascadeType.PERSIST)
	public Collection<Peripherique> getPeripherique() {
		return periphs;
	}

	public void setPeripherique(List<Peripherique> periphs) {
		this.periphs = periphs;
	}
	
	public void addPeripherique(Peripherique p){
		periphs.add(p);
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Home [adresse=" + adresse + ", superficie=" + superficie
				+ ", adresseIP=" + adresseIP + "]";
	}
}
