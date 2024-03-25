package controleur;

import java.util.ArrayList;

import modele.Modele;

public class Controleur {
	public static User selectWhereUser (String email, String mdp) {
		//tester email et la complexite mdp.
		return Modele.selectWhereUser(email,mdp);
	}
	public static void updateUser(User unUser) {
        Modele.updateUser(unUser);
	}
	/************************Gestion vehicules dans le controleur******************/
	public static void insertVehicule( Vehicule unVehicule) {
        Modele.insertVehicule(unVehicule);
    }
    
    public static void deleteVehicule( int idVehicule) {
        Modele.deleteVehicule(idVehicule);
    }
    
    public static void updateVehicule( Vehicule unVehicule) {
        Modele.updateVehicule(unVehicule);
    }
    
    public static ArrayList<Vehicule> selectAllVehicules( String filtre) {
        return Modele.selectAllVehicules(filtre);
    }
    public static Vehicule selectWhereVehicule(int idVehicule) {
        return Modele.selectwhereVehicule(idVehicule);
    }
    
    public static Vehicule selectWhereVehicule (String marque, String modele) {
        return Modele.selectwhereVehicule(marque, modele);
    }
    public static Vehicule selectWhereVehicule(String marque, String modele, String immatriculation) {
        // TODO Auto-generated method stub
        return null;
    }
    /************************Gestion Leçons dans le controleur******************/
	public static void insertLecons( Lecons uneLecon) {
        Modele.insertLecons(uneLecon);
    }
    
    public static void deleteLecons( int idLecons) {
        Modele.deleteVehicule(idLecons);
    }
    
    public static void updateLecons( Lecons uneLecon) {
        Modele.updateLecons(uneLecon);
    }
    
    public static ArrayList<Lecons> selectAllLecons( String filtre) {
        return Modele.selectAllLecons(filtre);
    }
    public static Lecons selectWhereLecons(int idLecon) {
        return Modele.selectwhereLecons(idLecon);
    }
    
    public static Lecons selectWhereLecons (String TYPE_DE_LECON, String DESCRIPTION,String TITRE) {
        return Modele.selectwhereLecons(TYPE_DE_LECON, DESCRIPTION, TITRE);
    }
    /************************Gestion examens dans le controleur******************/
	public static void insertExamens( Examens unExamen) {
        Modele.insertExamens(unExamen);
    }
    
    public static void deleteExamens( int idExamen) {
        Modele.deleteExamens(idExamen);
    }
    
    public static void updateExamens( Examens unExamen) {
        Modele.updateExamens(unExamen);
    }
    
    public static ArrayList<Examens> selectAllExamens( String filtre) {
        return Modele.selectAllExamens(filtre);
    }
    public static Vehicule selectWhereExamens(int idExamen) {
        return Modele.selectwhereVehicule(idExamen);
    }
    
    public static Examens selectWhereExamens (String DATE_ET_HEURE_D_EXAMEN, String Vehicule, String TYPE_DE_PERMIS) {
        return Modele.selectwhereExamens(DATE_ET_HEURE_D_EXAMEN, Vehicule, TYPE_DE_PERMIS);
    }
    /************************Gestion Candidats dans le controleur******************/
    public static void insertCandidat( Candidat unCandidat) {
        Modele.insertCandidat(unCandidat);
    }
     
    public static void deleteCandidat( int IDUSER) {
        Modele.deleteCandidat(IDUSER);
    }
     
    public static void updateCandidat( Candidat unCandidat) {
        Modele.updateCandidat(unCandidat);
    }
     
    public static ArrayList<Candidat> selectAllCandidats( String filtre) {
        return Modele.selectAllCandidats(filtre);
    }
    public static Candidat selectWhereCandidat(int IDUSER) {
        return Modele.selectwhereCandidat(IDUSER);
        }
    
    public static Candidat selectWhereCandidat (String NOM, String PRENOM, String EMAIL, String MDP, String type_user, String NUMERO_TELEPHONE, String nb_lecon){
        return Modele.selectwhereCandidat(NOM, PRENOM, EMAIL,  MDP ,type_user, NUMERO_TELEPHONE, nb_lecon);
    }

/************************Gestion Moniteurs dans le controleur******************/
public static void insertMoniteur( Moniteur unMoniteur) {
    Modele.insertMoniteur(unMoniteur);
}
 
public static void deleteMoniteur( int IDUSER) {
    Modele.deleteCandidat(IDUSER);
}
 
public static void updateMoniteur( Moniteur unMoniteur) {
    Modele.updateMoniteur(unMoniteur);
}
 
public static ArrayList<Moniteur> selectAllMoniteurs( String filtre) {
    return Modele.selectAllMoniteurs(filtre);
}
public static Moniteur selectWhereMoniteur(int IDUSER) {
    return Modele.selectwhereMoniteur(IDUSER);
    }

public static Moniteur selectWhereMoniteur (String NOM, String PRENOM, String EMAIL, String MDP, String type_user, String NUMERO_TELEPHONE){
    return Modele.selectwhereMoniteur(NOM, PRENOM, EMAIL,  MDP ,type_user, NUMERO_TELEPHONE);
}
}


