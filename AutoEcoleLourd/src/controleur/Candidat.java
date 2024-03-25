package controleur;

public class Candidat {
	private int IDUSER ; 
	private String NOM, PRENOM, EMAIL, MDP, type_user, NUMERO_TELEPHONE, nb_lecon; 
	public Candidat(int IDUSER, String NOM, String PRENOM, String EMAIL, String MDP ,String type_user, String NUMERO_TELEPHONE,String nb_lecon) {
		super();
		
		this.IDUSER = IDUSER;
		this.NOM = NOM;
		this.PRENOM = PRENOM;
		this.EMAIL = EMAIL;
		this.MDP = MDP;
		this.type_user = type_user;
		this.NUMERO_TELEPHONE = NUMERO_TELEPHONE;
		this.nb_lecon = nb_lecon;
	} 
	public Candidat(String NOM, String PRENOM, String EMAIL, String MDP, String type_user, String NUMERO_TELEPHONE, String nb_lecon) {
		 
		this.IDUSER = 0;
		this.NOM = NOM;
		this.PRENOM = PRENOM;
		this.EMAIL = EMAIL;
		this.MDP = MDP;
		this.type_user = type_user;
		this.NUMERO_TELEPHONE = NUMERO_TELEPHONE;
		this.nb_lecon = nb_lecon;
	} 
	public int getIDUSER() {
		return IDUSER;
	}
	public void setIDUSER(int IDUSER) {
		this.IDUSER = IDUSER;
	}
	public String getNOM() {
		return NOM;
	}
	public void setNOM(String NOM) {
		this.NOM = NOM;
	}
	public String getPRENOM() {
		return PRENOM;
	}
	public void setPRENOM(String PRENOM) {
		this.PRENOM = PRENOM;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public String getMDP() {
		return MDP;
	}
	public String gettype_user() {
		return type_user;
	}
	public String getType_user() {
			return type_user;
	}
	public void setNUMERO_TELEPHONE(String NUMERO_TELEPHONE) {
		this.NUMERO_TELEPHONE = NUMERO_TELEPHONE;
	}
	public String getNUMERO_TELEPHONE() {
		return NUMERO_TELEPHONE;
	}
	public String getnb_lecon() {
		return nb_lecon;
	
	}


	
	

}
