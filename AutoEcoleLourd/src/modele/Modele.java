package modele;

import com.mysql.jdbc.Statement;

import controleur.Vehicule;
import controleur.Candidat;
import controleur.Examens;
import controleur.Lecons;
import controleur.Moniteur;
import controleur.User;
import controleur.Vehicule;

	 
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	 
	import controleur.User;
	 
	public class Modele {
		private static Bdd uneBdd = new Bdd("localhost","auto_ecole_24","root","");
		public static User selectWhereUser (String email, String mdp) {
			String requete = "select * from user where email='"+email+"' and "+" mdp ='"+mdp+"';";
			User unUser = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unUser = new User (
							unRes.getInt("iduser"), unRes.getString("nom"),
							unRes.getString("prenom"),unRes.getString("email"),
							unRes.getString("mdp"), unRes.getString("type_user"),
							unRes.getString("numero_telephone")
							);
				}
				unStat.close();
				uneBdd.seDeConnecter();
			}
			catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
			return unUser;
		}
		public static void updateUser(User unUser) {
			String requete = "update user set nom='"
					+unUser.getNom()+"' , prenom='"
					+unUser.getPrenom()+"' , email ='"
					+unUser.getEmail()+"' , role ='"
					+unUser.getType_user()+"' , mdp ='"
					+unUser.getMdp()+"' where iduser ='"
					+unUser.getIduser()+"' where numero_telephone ="
					+unUser.getNumero_telephone()+";";
			try{
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
		}
		
		/******************************Gestion des vehicule***************************/
		public static void insertVehicule(Vehicule unVehicule) {
			String requete ="insert into vehicule values (null, '"+unVehicule.getMarque()+"','"
															+unVehicule.getModele()+"','"
															+unVehicule.getImmatriculation()+"');";
			try {
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close();
				uneBdd.seDeConnecter();
				}
			catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
		}
		public static void deleteVehicule (int idVehicule) {
			String requete = "delete from vehicule where idVehicule ="+idVehicule+";";
					 try{
							uneBdd.seConnecter();
							Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
							unStat.execute(requete);
							unStat.close();
							uneBdd.seDeConnecter();
							}
					 catch (SQLException exp) {
							System.out.println("Erreur de requete : " + requete);
						}
		}
		public static void updateVehicule (Vehicule unVehicule) {
			String requete ="update vehicule set marque='"
					+unVehicule.getMarque()+"',modele='"
					+unVehicule.getModele()+"',immatriculation='"
					+unVehicule.getImmatriculation()+"'where idVehicule="
					+unVehicule.getIdvehicule()+";";
			try {
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
		}
		public static ArrayList<Vehicule> selectAllVehicules (String filtre){
			ArrayList<Vehicule> lesVehicules = new ArrayList<Vehicule>();
			String requete ="";
			if (filtre.contentEquals("")) {
				requete = "select * from vehicule ; ";
			}else {
				requete = "select * from vehicule where marque like '%" + filtre
						+ "%' or modele like '%"+filtre
						+"%' or immatriculation like '%"+filtre +"%' ;";
			}
			 try{
					uneBdd.seConnecter();
					Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
					ResultSet desRes = unStat.executeQuery(requete);	
					while (desRes.next()) {
						Vehicule unVehicule = new Vehicule(desRes.getInt("idvehicule"),
								desRes.getString("marque"),
								desRes.getString("modele"),desRes.getString("immatriculation"));
						lesVehicules.add(unVehicule);
					}
					unStat.close();
					uneBdd.seDeConnecter();
					}
			 catch (SQLException exp) {
					System.out.println("Erreur de requete : " + requete);
				}
			return lesVehicules;
		}
		public static Vehicule selectwhereVehicule (int idVehicule) {
			Vehicule unVehicule = null;
			String requete = "select * from vehicule where idvehicule =" +idVehicule+";";
			 try{
					uneBdd.seConnecter();
					Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
					ResultSet desRes = unStat.executeQuery(requete);
					if (desRes.next()) {
						 unVehicule = new Vehicule(desRes.getInt("idvehicule"),
								desRes.getString("marque"),
								desRes.getString("modele"),desRes.getString("immatriculation"));
					}
					unStat.close();
					uneBdd.seDeConnecter();
					}
			 catch (SQLException exp) {
					System.out.println("Erreur de requete : " + requete);
				}
				return unVehicule;
		}
		public static Vehicule selectwhereVehicule (String marque, String modele) {
			Vehicule unVehicule = null;
			String requete = "select * from Vehicule where marque='"+marque+"' and modele ='"+modele+"';";
			 try{
					uneBdd.seConnecter();
					Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
					ResultSet desRes = unStat.executeQuery(requete);
					if (desRes.next()) {
						 unVehicule = new Vehicule(desRes.getInt("idvehicule"),
								desRes.getString("marque"),
								desRes.getString("modele"),desRes.getString("immatriculation"));
					}
					unStat.close();
					uneBdd.seDeConnecter();
					}
			 catch (SQLException exp) {
					System.out.println("Erreur de requete : " + requete);
				}
				return unVehicule;
		}
		
		/******************************Gestion des leçons***************************/
		public static void insertLecons(Lecons uneLecon) {
			String requete ="insert into lecons values (null, '"+uneLecon.gettype_de_lecon()+"','"
															+uneLecon.getdescription()+"','"
															+uneLecon.gettitre()+"');";
			try {
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close();
				uneBdd.seDeConnecter();
				}
			catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
		}
		public static void deleteLecons (int idLecon) {
			String requete = "delete from lecons where idLecon ="+idLecon+";";
					 try{
							uneBdd.seConnecter();
							Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
							unStat.execute(requete);
							unStat.close();
							uneBdd.seDeConnecter();
							}
					 catch (SQLException exp) {
							System.out.println("Erreur de requete : " + requete);
						}
		}
		public static void updateLecons (Lecons uneLecon) {
			String requete ="update Lecons set type_de_lecon='"
					+uneLecon.getIdlecon()+"',description='"
					+uneLecon.getdescription()+"',titre='"
					+uneLecon.gettitre()+"'where idlecon="
					+uneLecon.getIdlecon()+";";
			try {
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
		}
		public static ArrayList<Lecons> selectAllLecons (String filtre){
			ArrayList<Lecons> lesLecons = new ArrayList<Lecons>();
			String requete ="";
			if (filtre.contentEquals("")) {
				requete = "select * from lecons ; ";
			}else {
				requete = "select * from lecons where type_de_lecon like '%" + filtre
						+ "%' or description like '%"+filtre
						+"%' or titre like '%"+filtre +"%' ;";
			}
			 try{
					uneBdd.seConnecter();
					Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
					ResultSet desRes = unStat.executeQuery(requete);				
					while (desRes.next()) {						
						Lecons uneLecon = new Lecons(desRes.getInt("idlecon"),
								desRes.getString("type_de_lecon"),
								desRes.getString("description"),desRes.getString("titre"));					
						lesLecons.add(uneLecon);
					}
					unStat.close();
					uneBdd.seDeConnecter();
					}
			 catch (SQLException exp) {
					System.out.println("Erreurdedededede de requete : " + requete);
				}
			return lesLecons;
		}
		public static Lecons selectwhereLecons (int idlecon) {
			Lecons uneLecon = null;
			String requete = "select * from lecons where idlecons =" +idlecon+";";
			 try{
					uneBdd.seConnecter();
					Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
					ResultSet desRes = unStat.executeQuery(requete);
					if (desRes.next()) {
						uneLecon = new Lecons(desRes.getInt("idlecon"),
								desRes.getString("type_de_lecon"),
								desRes.getString("description"),desRes.getString("titre"));
					}
					unStat.close();
					uneBdd.seDeConnecter();
					}
			 catch (SQLException exp) {
					System.out.println("Erreur de requete : " + requete);
				}
				return uneLecon;
		}
		public static Lecons selectwhereLecons (String type_de_lecon, String description, String titre) {
			Lecons uneLecon = null;
			String requete = "select * from lecons where type_de_lecon='"+type_de_lecon+"' and description ='"+description+"'and titre ='"+titre+"';";
			 try{
					uneBdd.seConnecter();
					Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
					ResultSet desRes = unStat.executeQuery(requete);
					if (desRes.next()) {
						uneLecon = new Lecons(desRes.getInt("idlecon"),
								desRes.getString("type_de_lecon"),
								desRes.getString("description"),desRes.getString("titre"));
					}
					unStat.close();
					uneBdd.seDeConnecter();
					}
			 catch (SQLException exp) {
					System.out.println("Erreur de requete : " + requete);
				}
				return uneLecon;
		}
		

	/******************************Gestion des examens***************************/
	public static void insertExamens(Examens unExamen) {
		String requete ="insert into examens values (null, '"+unExamen.getDATE_ET_HEURE_D_EXAMEN()+"','"
														+unExamen.getVehicule()+"','"
														+unExamen.getTYPE_DE_PERMIS()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
			}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}
	public static void deleteExamens (int idExamen) {
		String requete = "delete from Examens where idExamen ="+idExamen+";";
				 try{
						uneBdd.seConnecter();
						Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
						unStat.execute(requete);
						unStat.close();
						uneBdd.seDeConnecter();
						}
				 catch (SQLException exp) {
						System.out.println("Erreur de requete : " + requete);
					}
	}
	public static void updateExamens (Examens unExamen) {
		String requete ="update Examens set DATE_ET_HEURE_D_EXAMEN='"
				+unExamen.getDATE_ET_HEURE_D_EXAMEN()+"',Vehicule='"
				+unExamen.getVehicule()+"',TYPE_DE_PERMIS='"
				+unExamen.getTYPE_DE_PERMIS()+"'where idExamen="
				+unExamen.getIdExamen()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
			}
	 catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}
	public static ArrayList<Examens> selectAllExamens (String filtre){
		ArrayList<Examens> lesExamens = new ArrayList<Examens>();
		String requete ="";
		if (filtre.contentEquals("")) {
			requete = "select * from Examens ; ";
		}else {
			requete = "select * from lecons where type_de_lecon like '%" + filtre
					+ "%' or description like '%"+filtre
					+"%' or titre like '%"+filtre +"%' ;";
		}
		 try{
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);	
				while (desRes.next()) {
					Examens unExamen = new Examens(desRes.getInt("idExamen"),
							desRes.getString("DATE_ET_HEURE_D_EXAMEN"),
							desRes.getString("Vehicule"),desRes.getString("TYPE_DE_PERMIS"));
					lesExamens.add(unExamen);
				}
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
		return lesExamens;
	}
	public static Examens selectwhereExamens (int idExamen) {
		Examens unExamen =null;
		String requete = "select * from Examens where idExamen =" +unExamen+";";
		 try{
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				if (desRes.next()) {
					unExamen = new Examens(desRes.getInt("idExamen"),
							desRes.getString("DATE_ET_HEURE_D_EXAMEN"),
							desRes.getString("Vehicule"),desRes.getString("TYPE_DE_PERMIS"));
				}
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
			return unExamen;
	}
	public static Examens selectwhereExamens (String DATE_ET_HEURE_D_EXAMEN, String Vehicule, String TYPE_DE_PERMIS) {
		Examens unExamen = null;
		String requete = "select * from Examens where DATE_ET_HEURE_D_EXAMEN='"+DATE_ET_HEURE_D_EXAMEN+"' and Vehicule ='"+Vehicule+"' and TYPE_DE_PERMIS ='"+TYPE_DE_PERMIS+"';";
		 try{
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				if (desRes.next()) {
					unExamen = new Examens(desRes.getInt("idExamen"),
							desRes.getString("DATE_ET_HEURE_D_EXAMEN"),
							desRes.getString("Vehicule"),desRes.getString("TYPE_DE_PERMIS"));
				}
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
			return unExamen;
	}

	/******************************Gestion des candidats***************************/
	public static void insertCandidat(Candidat unCandidat) {
		String requete ="insert into candidat values (null, '"+unCandidat.getNOM()+"','"
														+unCandidat.getPRENOM()+"','"
														+unCandidat.getEMAIL()+"','"
														+unCandidat.getMDP()+"','"
														+unCandidat.getType_user()+"','"
														+unCandidat.getNUMERO_TELEPHONE()+"','"
														+unCandidat.getnb_lecon()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
			}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}
	public static void deleteCandidat (int IDUSER) {
		String requete = "delete from candidat where IDUSER ="+IDUSER+";";
				 try{
						uneBdd.seConnecter();
						Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
						unStat.execute(requete);
						unStat.close();
						uneBdd.seDeConnecter();
						}
				 catch (SQLException exp) {
						System.out.println("Erreur de requete : " + requete);
					}
	}
	public static void updateCandidat (Candidat unCandidat) {
		String requete ="update candidat set nom='"
				+unCandidat.getNOM()+"',prenom='"
				+unCandidat.getPRENOM()+"',email='"
				+unCandidat.getEMAIL()+"',Type_user='"
				+unCandidat.gettype_user()+"',numero_telephone='"
				+unCandidat.getNUMERO_TELEPHONE()+"'nb_lecon="
				+unCandidat.getnb_lecon()+"'where IDUSER="
				+unCandidat.getIDUSER()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
			}
	 catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}
	public static ArrayList<Candidat> selectAllCandidats (String filtre){
		ArrayList<Candidat> lesCandidats = new ArrayList<Candidat>();
		String requete ="";	
		if (filtre.contentEquals("")) {
			requete = "select * from candidat ; ";
		}else {
			requete = "select * from candidat where nom like '%" + filtre
					+ "%' or prenom like '%"+filtre
					+ "%' or email like '%"+filtre
					+ "%' or mdp like '%"+filtre
					+ "%' or type_user like '%"+filtre
					+"%' or numero_telephone like '%"+filtre 
					+"%' or nb_lecon like '%"+filtre +"%' ;";
		}
		 try{
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				while (desRes.next()) {
					Candidat unCandidat = new Candidat(desRes.getInt("IDUSER"),
							desRes.getString("NOM"),
							desRes.getString("PRENOM"),
							desRes.getString("EMAIL"),
							desRes.getString("MDP"),
							desRes.getString("type_user"),
							desRes.getString("NUMERO_TELEPHONE"),
							desRes.getString("nb_lecon"));
					lesCandidats.add(unCandidat);
				}
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
		return lesCandidats;
	}
	public static Candidat selectwhereCandidat (int IDUSER) {
		Candidat unCandidat = null;
		String requete = "select * from candidat where IDUSER =" +IDUSER+";";
		 try{
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				if (desRes.next()) {
					 unCandidat = new Candidat(desRes.getInt("IDUSER"),
							 desRes.getString("NOM"),
								desRes.getString("PRENOM"),
								desRes.getString("EMAIL"),
								desRes.getString("MDP"),
								desRes.getString("type_user"),
								desRes.getString("NUMERO_TELEPHONE"),
								desRes.getString("nb_lecon"));
							
				}
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
			return unCandidat;
	}
	public static Candidat selectwhereCandidat (String nom, String prenom, String email, String mdp ,String type_user, String numero_telephone, String nb_lecon) {
		Candidat unCandidat = null;
		String requete = "select * from candidat where nom='"+nom+"' and prenom ='"+prenom+"' and email ='"+email+"' and mdp ='"+mdp+"' and type_user ='"+type_user+"' and numero_telephone ='"+numero_telephone+"' and nb_lecon ='"+nb_lecon+"';";
		System.out.println(requete);
		try{
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				if (desRes.next()) {
					 unCandidat = new Candidat(desRes.getInt("IDUSER"),
							 desRes.getString("NOM"),
								desRes.getString("PRENOM"),
								desRes.getString("EMAIL"),
								desRes.getString("MDP"),
								desRes.getString("type_user"),
								desRes.getString("NUMERO_TELEPHONE"),
								desRes.getString("nb_lecon"));
				}
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
			return unCandidat;
	}


	/******************************Gestion des Moniteurs***************************/
	public static void insertMoniteur(Moniteur unMoniteur) {
		String requete ="insert into Moniteur values (null, '"+unMoniteur.getNOM()+"','"
														+unMoniteur.getPRENOM()+"','"
														+unMoniteur.getEMAIL()+"','"
														+unMoniteur.getMDP()+"','"
														+unMoniteur.getType_user()+"','"
														+unMoniteur.getNUMERO_TELEPHONE()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
			}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}
	public static void deleteMoniteur (int IDUSER) {
		String requete = "delete from Moniteur where IDUSER ="+IDUSER+";";
				 try{
						uneBdd.seConnecter();
						Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
						unStat.execute(requete);
						unStat.close();
						uneBdd.seDeConnecter();
						}
				 catch (SQLException exp) {
						System.out.println("Erreur de requete : " + requete);
					}
	}
	public static void updateMoniteur (Moniteur unMoniteur) {
		String requete ="update Moniteur set nom='"
				+unMoniteur.getNOM()+"',prenom='"
				+unMoniteur.getPRENOM()+"',email='"
				+unMoniteur.getEMAIL()+"',Type_user='"
				+unMoniteur.gettype_user()+"',numero_telephone='"
				+unMoniteur.getNUMERO_TELEPHONE()+"'where IDUSER="
				+unMoniteur.getIDUSER()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
			}
	 catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}
	public static ArrayList<Moniteur> selectAllMoniteurs (String filtre){
		ArrayList<Moniteur> lesMoniteurs = new ArrayList<Moniteur>();
		String requete ="";	
		if (filtre.contentEquals("")) {
			requete = "select * from Moniteur ; ";
		}else {
			requete = "select * from Moniteur where nom like '%" + filtre
					+ "%' or prenom like '%"+filtre
					+ "%' or email like '%"+filtre
					+ "%' or mdp like '%"+filtre
					+ "%' or type_user like '%"+filtre
					+"%' or numero_telephone like '%"+filtre +"%' ;";
		}
		 try{
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				while (desRes.next()) {
					Moniteur unMoniteur = new Moniteur(desRes.getInt("IDUSER"),
							desRes.getString("nom"),
							desRes.getString("prenom"),
							desRes.getString("email"),
							desRes.getString("mdp"),
							desRes.getString("type_user"),
							desRes.getString("Numero_telephone"));
					lesMoniteurs.add(unMoniteur);
				}
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
		return lesMoniteurs;
	}
	public static Moniteur selectwhereMoniteur (int IDUSER) {
		Moniteur unMoniteur = null;
		String requete = "select * from Moniteur where IDUSER =" +IDUSER+";";
		 try{
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				if (desRes.next()) {
					 unMoniteur = new Moniteur(desRes.getInt("IDUSER"),
							 desRes.getString("nom"),
								desRes.getString("prenom"),
								desRes.getString("email"),
								desRes.getString("mdp"),
								desRes.getString("type_user"),
								desRes.getString("Numero_telephone"));
							
				}
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
			return unMoniteur;
	}
	public static Moniteur selectwhereMoniteur (String nom, String prenom, String email, String mdp ,String type_user, String numero_telephone) {
		Moniteur unMoniteur = null;
		String requete = "select * from Moniteur where nom='"+nom+"' and prenom ='"+prenom+"' and email ='"+email+"' and mdp ='"+mdp+"' and type_user ='"+type_user+"' and numero_telephone ='"+numero_telephone+"';";
		 try{
				uneBdd.seConnecter();
				Statement unStat = (Statement) uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				if (desRes.next()) {
					 unMoniteur = new Moniteur(desRes.getInt("IDUSER"),
							    desRes.getString("nom"),
								desRes.getString("prenom"),
								desRes.getString("email"),
								desRes.getString("mdp"),
								desRes.getString("type_user"),
								desRes.getString("Numero_telephone"));
				}
				unStat.close();
				uneBdd.seDeConnecter();
				}
		 catch (SQLException exp) {
				System.out.println("Erreur de requete : " + requete);
			}
			return unMoniteur;
	}

}
	
	