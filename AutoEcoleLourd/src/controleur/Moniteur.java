package controleur;

public class Moniteur {
	private int IDUSER ; 
	private String NOM, PRENOM, EMAIL, MDP, type_user, NUMERO_TELEPHONE; 
	public Moniteur(int IDUSER, String NOM, String PRENOM, String EMAIL, String MDP ,String type_user, String NUMERO_TELEPHONE) {
		super();
		
		this.IDUSER = IDUSER;
		this.NOM = NOM;
		this.PRENOM = PRENOM;
		this.EMAIL = EMAIL;
		this.MDP = MDP;
		this.type_user = type_user;
		this.NUMERO_TELEPHONE = NUMERO_TELEPHONE;
	} 
	public Moniteur(String PRENOM, String EMAIL, String NOM, String MDP, String type_user, String NUMERO_TELEPHONE) {
		 
		this.IDUSER = 0;
		this.NOM = NOM;
		this.PRENOM = PRENOM;
		this.EMAIL = EMAIL;
		this.MDP = MDP;
		this.type_user = type_user;
		this.NUMERO_TELEPHONE = NUMERO_TELEPHONE;
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

}
