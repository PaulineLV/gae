package fr.istic.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Person implements Serializable {
	private int id;

    private String nom;
    
    private String prenom;
    
    private String genre;
    
    private String dateNaissance;

    private String profilFacebook;
    
    private Collection<Home> homes;
    
    //private Collection<Person> friends;
    
    //private Collection<ElectronicDevice> elDevs;

	public Person() {
    }

   public Person(String nom, String prenom, String genre, String dateNaissance, String profilFacebook) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre=genre;
        this.dateNaissance=dateNaissance;
        this.profilFacebook=profilFacebook;
        //this.friends=new ArrayList<Person>();
        //this.homes=new ArrayList<Home>();
        //this.elDevs=new ArrayList<ElectronicDevice>();
    }
	
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getProfilFacebook() {
		return profilFacebook;
	}

	public void setProfilFacebook(String profilFacebook) {
		this.profilFacebook = profilFacebook;
	}
	
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	/*
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
	
	/*@OneToMany(mappedBy="person", cascade = CascadeType.PERSIST)
	public Collection<ElectronicDevice> getElDevs() {
		return elDevs;
	}

	public void setElDevs(List<ElectronicDevice> elDevs) {
		this.elDevs = elDevs;
	}*/

	public void addHome(Home h){
		homes.add(h);
	}
	/*
	public void addFriend(Person p){
		friends.add(p);
	}*/
	
	/*public void addElectronicDevice(ElectronicDevice elDev){
		elDevs.add(elDev);
	}*/
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    public Collection<Home> getHomes() {
        return homes;
    }
	
	/*
	@ManyToMany
    public Collection<Person> getFriends(){
        return friends;
    }*/
	
	@Override
    public String toString() {
        return "Person [id=" + id + ", name=" + nom + ", prenom=" + prenom + " ]";
    }
}