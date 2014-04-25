package fr.istic.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.istic.shared.Home;
import fr.istic.shared.Person;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface ConsoService extends RemoteService {
	//String greetServer(String name) throws IllegalArgumentException;
	
	Person createPerson(String nom, String prenom, String genre, String dateNaissance, String profilFacebook) ;

	Home createHome(Person p, String adresse, float superficie, String adresseIP);

	List<Person> listAllPerson();
	
}
