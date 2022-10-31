package Beans;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity 
@Table(name= "Demande") 
public class Demande implements Serializable{
	@Id   
	@GeneratedValue
	private int id;
	@Column(name="description")
	private String description;
	@Column(name="etat")
	private String etat;
	@Column(name="url_document")
	private  String url_document;
	@Column(name="nom_procedure")
	private String nom_procedure;
	@Column(name="jeton")
	private String jeton;
	@ManyToOne
	private Citoyen citoyen;
	@ManyToOne
	private Employe employe;
	@ManyToOne
	private Chef_division chef;
	
	
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Demande(String description, String url_document, String nom_procedure, Citoyen citoyen) {
		super();
		this.description = description;
		this.url_document = url_document;
		this.nom_procedure = nom_procedure;
		this.citoyen = citoyen;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public String getUrl_document() {
		return url_document;
	}


	public void setUrl_document(String url_document) {
		this.url_document = url_document;
	}


	public String getNom_procedure() {
		return nom_procedure;
	}


	public void setNom_procedure(String nom_procedure) {
		this.nom_procedure = nom_procedure;
	}


	public String getJeton() {
		return jeton;
	}


	public void setJeton(String jeton) {
		this.jeton = jeton;
	}


	public Citoyen getCitoyen() {
		return citoyen;
	}


	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}


	public Employe getEmploye() {
		return employe;
	}


	public void setEmploye(Employe employe) {
		this.employe = employe;
	}


	public Chef_division getChef() {
		return chef;
	}


	public void setChef(Chef_division chef) {
		this.chef = chef;
	}


	@Override
	public String toString() {
		return "Demande [id=" + id + ", description=" + description + ", etat=" + etat + ", url_document="
				+ url_document + ", nom_procedure=" + nom_procedure + ", jeton=" + jeton + ", citoyen=" + citoyen
				+ ", employe=" + employe + ", chef=" + chef + "]";
	}
	
	

	



	
}
