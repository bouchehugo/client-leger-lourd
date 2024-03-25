package controleur;

public class Vehicule {
	private int idvehicule; 
	private String marque, modele, immatriculation;
	public Vehicule(int idvehicule, String marque, String modele, String immatriculation) {
		super();
		this.idvehicule = idvehicule;
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
	}
	
	public Vehicule( String marque, String modele, String immatriculation) {
		super();
		this.idvehicule = 0;
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
	}

	public int getIdvehicule() {
		return idvehicule;
	}

	public void setIdvehicule(int idvehicule) {
		this.idvehicule = idvehicule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	
	
}

 