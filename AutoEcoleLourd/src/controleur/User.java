package controleur;

public class User {
private int iduser;
private String nom, prenom, email, mdp, type_user, numero_telephone;
public User(int iduser, String nom, String prenom, String email, String mdp, String type_user, String numero_telephone) {
	super();
	this.iduser = iduser;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.mdp = mdp;
	this.type_user = type_user;
	this.numero_telephone= numero_telephone;
}
  public User(String nom, String prenom, String email, String mdp, String type_user, String numero_telephone) {
	super();
	this.iduser = 0;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.mdp = mdp;
	this.type_user = type_user;
	this.numero_telephone = numero_telephone;
}
public int getIduser() {
	return iduser;
}
public void setIduser(int iduser) {
	this.iduser = iduser;
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
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
public String getType_user() {
	return type_user;
}
public void setType_user(String type_user) {
	this.type_user = type_user;
}
public String getNumero_telephone() {
	return numero_telephone;
}
public void setNumero_telephone(String numero_telephone) {
	this.numero_telephone = numero_telephone;
}
  
  
}
 
  
