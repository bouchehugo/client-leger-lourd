package controleur;

public class Lecons {
	private int idlecon; 
	private String type_de_lecon, description, titre;
	public Lecons(int idlecon, String type_de_lecon,String description, String titre) {
		super();
		this.idlecon = idlecon;
		this.type_de_lecon = type_de_lecon;
		this.description = description;
		this.titre = titre;
	}
	
	public Lecons( String type_de_lecon, String description, String titre) {
		super();
		this.idlecon = 0;
		this.type_de_lecon = type_de_lecon;
		this.description = description;
		this.titre = titre;
	}

	public int getIdlecon() {
		return idlecon;
	}

	public void setIdlecon(int idlecon) {
		this.idlecon = idlecon;
	}

	public String gettype_de_lecon() {
		return type_de_lecon;
	}

	public void settype_de_lecon(String type_de_lecon) {
		this.type_de_lecon = type_de_lecon;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public String gettitre() {
		return titre;
	}

	public void settitre(String titre) {
		this.titre = titre;
	}
	
	
}