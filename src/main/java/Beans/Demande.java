package Beans;

import java.io.Serializable;

public class Demande implements Serializable{

	private int id;
	private String description;
	private String etat;
	private  String url_document;
	private String procedure;
	private String cin_chef;
	private String cin_employe;
	private String cin_citoyen;
	private String jeton;
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	



	public Demande(String description, String url_document, String procedure, String cin_citoyen) {
		super();
		this.description = description;
		this.url_document = url_document;
		this.procedure = procedure;
		this.cin_citoyen = cin_citoyen;
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







	public String getProcedure() {
		return procedure;
	}







	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}







	public String getCin_chef() {
		return cin_chef;
	}







	public void setCin_chef(String cin_chef) {
		this.cin_chef = cin_chef;
	}







	public String getCin_employe() {
		return cin_employe;
	}







	public void setCin_employe(String cin_employe) {
		this.cin_employe = cin_employe;
	}







	public String getCin_citoyen() {
		return cin_citoyen;
	}







	public void setCin_citoyen(String cin_citoyen) {
		this.cin_citoyen = cin_citoyen;
	}







	public String getJeton() {
		return jeton;
	}







	public void setJeton(String jeton) {
		this.jeton = jeton;
	}







	@Override
	public String toString() {
		return "Demande [id=" + id + ", description=" + description + ", etat=" + etat + ", url_document="
				+ url_document + ", procedure=" + procedure + ", cin_chef=" + cin_chef + ", cin_employe=" + cin_employe
				+ ", cin_citoyen=" + cin_citoyen + ", jeton=" + jeton + "]";
	}
	
	
	
}
