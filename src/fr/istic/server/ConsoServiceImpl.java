package fr.istic.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;

import fr.istic.client.ConsoService;
import fr.istic.shared.ElectronicDevice;
import fr.istic.shared.Heater;
import fr.istic.shared.Home;
import fr.istic.shared.Peripherique;
import fr.istic.shared.Person;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ConsoServiceImpl extends RemoteServiceServlet implements ConsoService {

	//private EntityManagerFactory factory;

	EntityManager manager;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		manager = EMF.get().createEntityManager();
		//manager = Persistence.createEntityManagerFactory("transactions-optional");
	}

	public Person createPerson(String nom, String prenom, String genre, String dateNaissance, String profilFacebook) {
		// TODO Auto-generated method stub
		Person p = new Person(nom, prenom, genre, dateNaissance, profilFacebook);
		EntityTransaction t =  manager.getTransaction();
		if (!t.isActive())
			t.begin();
		manager.persist(p);
		t.commit();

		return p;
	}

	public Home createHome(Person p, String adresse, float superficie, String adresseIP) {
		// TODO Auto-generated method stub
		List<Home> homes = new ArrayList<Home>();
		Home h= new Home(adresse,superficie, adresseIP, p);
		EntityTransaction t =  manager.getTransaction();
		if (!t.isActive())
			t.begin();
		manager.persist(h);
		homes.add(h);
		p.setHomes(homes);
		return h;
	}
	
	public List<Person> listAllPerson(){
		List<Person> res = new ArrayList<>();
		res.addAll(manager.createQuery("select p from Person as p",Person.class).getResultList());
		return res;
		
	}

	public Peripherique createAppareil(Home h, Long conso) {
		// TODO Auto-generated method stub
		
		Peripherique a = new Peripherique(conso);
		EntityTransaction trans =  manager.getTransaction();
		
		if(a.getClass().toString().equals("Heater")){			
			Heater heat = (Heater) a;
			h.getPeripherique().add(heat);
			heat.setHome(h);
			if (!trans.isActive())
				trans.begin();
			manager.persist(a);	
		}else if(a.getClass().toString().equals("ElectronicDevice")){
			ElectronicDevice e = (ElectronicDevice) a;
			
			h.getPeripherique().add(e);
			e.setHome(h);
			manager.persist(e);	
		}
		return a;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		manager.close();
		//factory.close();
	}	
}
