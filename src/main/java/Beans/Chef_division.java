package Beans;

import java.io.Serializable;

public class Chef_division implements Serializable {
	
	private String cin;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String telephone;
	
	public Chef_division() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Chef_division(String cin, String nom, String prenom, String email, String adresse, String telephone) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "Chef_division [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse="
				+ adresse + ", telephone=" + telephone + "]";
	}
	
	

}
