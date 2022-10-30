package com.frontoffice.fontoffice;
  

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;  
import jakarta.persistence.Table;  
  
@Entity 
@Table(name= "Citoyan")   
public class Citoyan {    
  
@Id   
@GeneratedValue
private int id;    
@Column(name="nom")
private String nom;
@Column(name="prenom")
private String prenom;
@Column(name="cin")
private String cin;
@Column(name="email")
private String email;  
@Column(name="adresse")
private String adress;
@Column(name="phone")
private String phone;
@Column(name="password")
private String password;

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
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Citoyan [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", email=" + email
			+ ", adress=" + adress + ", phone=" + phone + ", password=" + password + "]";
}


      
}