package controleur;

public class Examens {
	private int idExamen; 
	private String DATE_ET_HEURE_D_EXAMEN;
	private String Vehicule;
	private String TYPE_DE_PERMIS;
	public Examens(int idExamen, String DATE_ET_HEURE_D_EXAMEN, String Vehicule, String TYPE_DE_PERMIS) {
		super();
		this.idExamen = idExamen;
		this.DATE_ET_HEURE_D_EXAMEN = DATE_ET_HEURE_D_EXAMEN;
		this.Vehicule = Vehicule;
		this.TYPE_DE_PERMIS = TYPE_DE_PERMIS;
	}
	public Examens( String DATE_ET_HEURE_D_EXAMEN, String Vehicule, String TYPE_DE_PERMIS) {
		super();
		this.idExamen = 0 ;
		this.DATE_ET_HEURE_D_EXAMEN = DATE_ET_HEURE_D_EXAMEN;
		this.Vehicule = Vehicule;
		this.TYPE_DE_PERMIS = TYPE_DE_PERMIS;
	}
	public int getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}
	public String getDATE_ET_HEURE_D_EXAMEN() {
		return DATE_ET_HEURE_D_EXAMEN;
	}
	public void setDATE_ET_HEURE_D_EXAMEN(String DATE_ET_HEURE_D_EXAMEN) {
		this.DATE_ET_HEURE_D_EXAMEN = DATE_ET_HEURE_D_EXAMEN;
	}
	public String getVehicule() {
		return Vehicule;
	}
	public void setVehicule(String Vehicule) {
		this.Vehicule = Vehicule;
	}
	public String getTYPE_DE_PERMIS() {
		return TYPE_DE_PERMIS;
	}
	public void setType_de_permis(String type_de_permis) {
		this.TYPE_DE_PERMIS = TYPE_DE_PERMIS;
	}
	
	
	
}
 