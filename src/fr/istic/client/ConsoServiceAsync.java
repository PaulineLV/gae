package fr.istic.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.istic.shared.Home;
import fr.istic.shared.Person;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface ConsoServiceAsync {
	/*void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;*/

	void createPerson(String nom, String prenom, String genre, String dateNaissance, String profilFacebook,
			AsyncCallback<Person> asyncCallback);

	void  createHome(Person p, String adresse, float superficie, String adresseIP, AsyncCallback<Home> asyncCallback);
	
	void listAllPerson(AsyncCallback<List<Person>> callback);
	
}
