package fr.istic.client;


import java.util.List;

import fr.istic.shared.Home;
import fr.istic.shared.Peripherique;
import fr.istic.shared.Person;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gae implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final ConsoServiceAsync consoService = GWT.create(ConsoService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		VerticalPanel v1 = new VerticalPanel();
		HorizontalPanel p1 = new HorizontalPanel();
		HorizontalPanel p2 = new HorizontalPanel();
		HorizontalPanel p3 = new HorizontalPanel();
		HorizontalPanel p4 = new HorizontalPanel();
		HorizontalPanel p5 = new HorizontalPanel();
		
		HorizontalPanel p6 = new HorizontalPanel();
		

		VerticalPanel v2 = new VerticalPanel();
		VerticalPanel v3 = new VerticalPanel();
		VerticalPanel v4 = new VerticalPanel();
		VerticalPanel v5 = new VerticalPanel();

		Label labelNom = new Label("Nom : ");
		final TextBox textBoxNom = new TextBox();
		p1.add(labelNom);
		p1.add(textBoxNom);
		v1.add(p1);

		Label labelPrenom = new Label("Prenom :");
		final TextBox textBoxPrenom = new TextBox();

		Label labelGenre = new Label("Genre :");
		final TextBox textBoxGenre = new TextBox();

		Label labelDateN = new Label("date de naissance : ");
		final TextBox textBoxDateN = new TextBox();

		Label labelProfilFB = new Label ("Profil facebook :");
		final TextBox textBoxProfilFB = new TextBox();

		Button b = new Button("create");
		Button addHome = new Button ("add home");
		final Button createHome = new Button ("create home");
		createHome.setVisible(false);

		final Label labelAdresse = new Label("Adresse :");
		labelAdresse.setVisible(false);
		final TextBox textBoxAdresse = new TextBox();
		textBoxAdresse.setVisible(false);
		final Label labelSuperficie = new Label("Superficie :");
		labelSuperficie.setVisible(false);
		final TextBox textBoxSuperficie = new TextBox();
		textBoxSuperficie.setVisible(false);

		final Label labelAdresseIP = new Label("Adresse IP :");
		labelAdresseIP.setVisible(false);
		final TextBox textBoxAdresseIp = new TextBox();
		textBoxAdresseIp.setVisible(false);
		
		
		final Label labelConso = new Label("Conso :");
		labelConso.setVisible(false);
		
		final TextBox textBoxConso = new TextBox();
		textBoxConso.setVisible(false);
		
		Button addPeripherique = new Button(" Ajouter un peripherique");
		
		final Button createPeripherique = new Button ("create");
		createPeripherique.setVisible(false);
		
		

		p2.add(labelPrenom);
		p2.add(textBoxPrenom);
		p3.add( labelGenre);
		p3.add(textBoxGenre);
		p4.add(labelDateN);
		p4.add(textBoxDateN);
		p4.add(labelProfilFB);
		p4.add(textBoxProfilFB);
		p4.add(b);
		p5.add(labelAdresse);
		p5.add(textBoxAdresse);
		p5.add(labelSuperficie);
		p5.add(textBoxSuperficie);
		p5.add(labelAdresseIP);
		p5.add(textBoxAdresseIp);
		p5.add(createHome);
		
		p6.add(addPeripherique);
		p6.add(labelConso);
		p6.add(textBoxConso);
		p6.add(createPeripherique);
		
		v2.add(p2);
		v2.add(p3);
		v2.add(p4);
		v4.add(addHome);
		v4.add(p5);
		v5.add(p6);


		Button listAllPerson = new Button("listAllPerson");
		v3.add(listAllPerson);


		RootPanel.get().add(v1);
		RootPanel.get().add(v2);
		RootPanel.get().add(v3);
		RootPanel.get().add(v4);
		RootPanel.get().add(v5);

		b.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

					consoService.createPerson(textBoxNom.getText(), textBoxPrenom.getText(),textBoxGenre.getText(), textBoxDateN.getText(), textBoxProfilFB.getText(), new AsyncCallback<Person>() {

						@Override
						public void onSuccess(Person result) {
							Window.alert("Ok " + result.getNom() + " " +result.getPrenom() + "est cree");
							textBoxNom.setText("");
							textBoxPrenom.setText("");
							textBoxGenre.setText("");
							textBoxDateN.setText("");
							textBoxProfilFB.setText("");
						}

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("erreur!");

						}
					});
			}
		});

		addHome.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				textBoxAdresse.setVisible(true);
				textBoxSuperficie.setVisible(true);
				textBoxAdresseIp.setVisible(true);
				labelAdresse.setVisible(true);
				labelAdresseIP.setVisible(true);
				labelSuperficie.setVisible(true);
				createHome.setVisible(true);

				consoService.createHome(null, textBoxAdresse.getText(), Float.valueOf(textBoxSuperficie.getText()), textBoxAdresseIp.getText(), new AsyncCallback<Home>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("erreur!");

					}

					@Override
					public void onSuccess(Home result) {
						// TODO Auto-generated method stub

						Window.alert("ok maison cree "+result.getAdresse() + " ");

					}

				});
			}
		});

		listAllPerson.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				consoService.listAllPerson(new AsyncCallback<List<Person>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(List<Person> result) {
						StringBuffer buf = new StringBuffer();
						for (Person p : result){
							buf.append("person " + p.getId() + " "+ p.getPrenom() + " " + p.getNom());
						}
						Window.alert(buf.toString());
					}
				});
			}
		});
		
		
		
		addPeripherique.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				labelConso.setVisible(true);
				textBoxConso.setVisible(true);
				createPeripherique.setVisible(true);
			}
			
		});
		
		
		createPeripherique. addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				consoService.createAppareil(home, Long.valueOf(textBoxConso.getText()), new AsyncCallback<Peripherique>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("erreur impossible de creer un peripherique");
						
					}

					@Override
					public void onSuccess(Peripherique result) {
						// TODO Auto-generated method stub
						
						Window.alert("ok peripherique cree");
						
					}
					
				});
				
			}
		});
	}

	
}
