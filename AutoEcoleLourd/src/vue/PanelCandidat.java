package vue;
 
import java.awt.Color;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.JTextField;
import controleur.Candidat;
import controleur.Controleur;
import controleur.Tableau;
 
public class PanelCandidat extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel (); 
	private JTextField txtNomCandidat = new JTextField(); 
	private JTextField txtPrenomCandidat = new JTextField();  
	private JTextField txtEmailCandidat = new JTextField(); 
	private JTextField txtMdpCandidat = new JTextField();	
	private JTextField txtType_user = new JTextField("candidat"); 
	private JTextField txtNumero_telephone = new JTextField();	
	private JTextField txtnb_lecon = new JTextField(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JTable tableCandidat ; //table des candidats 
	private JScrollPane uneScroll ;

	//panel de filtrage 

	private JPanel panelFiltre = new JPanel(); 
	private JTextField txtFiltre = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer"); 
	private Tableau unTableau ; 
	public PanelCandidat()

	{

		super ();

		//construction du formulaire candidat. 
		this.txtType_user.setEditable(false);
		this.panelForm.setLayout(new GridLayout(10,2));
		this.panelForm.setBackground(new Color (32, 178, 170));
		this.panelForm.setBounds(10, 50, 250, 350);
		this.panelForm.add(new JLabel("Nom  :")); 
		this.panelForm.add(this.txtNomCandidat); 
		this.panelForm.add(new JLabel("Prenom :")); 
		this.panelForm.add(this.txtPrenomCandidat);
		this.panelForm.add(new JLabel("Email :")); 
		this.panelForm.add(this.txtEmailCandidat);
		this.panelForm.add(new JLabel("Mdp  :")); 
		this.panelForm.add(this.txtMdpCandidat);
		this.panelForm.add(new JLabel("Type d'user :")); 
		this.panelForm.add(this.txtType_user); 
		this.panelForm.add(new JLabel("Num tel :")); 
		this.panelForm.add(this.txtNumero_telephone);
		this.panelForm.add(new JLabel("Nombre de leçons :")); 
		this.panelForm.add(this.txtnb_lecon); 
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer); 
		this.panelForm.setVisible(true);
		this.add(this.panelForm);

		//construction de la table des Candidats 

		String entetes [] = {"ID USER", "Nom Candidat", "Prenom Candidat","Email","Mdp","Type_user","Numero telephone","nb_lecon"};

		this.unTableau = new Tableau (entetes, this.remplirDonnees("")); 
		this.tableCandidat = new JTable(this.unTableau) ; 
		this.tableCandidat.getTableHeader().setReorderingAllowed(false);
		this.uneScroll = new JScrollPane(this.tableCandidat); 
		this.uneScroll.setBounds(350, 80, 460, 230);
		this.add(this.uneScroll);

		//construction du panel filtre 

		this.panelFiltre.setBounds(350, 30, 450, 30);
		this.panelFiltre.setBackground(new Color (32, 178, 170));
		this.panelFiltre.setLayout(new GridLayout(1, 3));
		this.panelFiltre.add(new JLabel("Filtrer les Candidat par :")); 
		this.panelFiltre.add(this.txtFiltre); 
		this.panelFiltre.add(this.btFiltrer); 
		this.add(this.panelFiltre); 

		//rendre les boutons ecoutables 

		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btFiltrer.addActionListener(this);
	}

	public Object [][] remplirDonnees (String filtre){

		//cette méthode permet de convertir l'ArrayList en une matrice de données.

		ArrayList<Candidat> lesCandidats = Controleur.selectAllCandidats(filtre) ; 
		Object [][] matrice = new Object [lesCandidats.size()][8];
		int i =0; 
		for (Candidat unCandidat : lesCandidats) {
			matrice [i][0] = unCandidat.getIDUSER(); 
			matrice [i][1] = unCandidat.getNOM(); 
			matrice [i][2] = unCandidat.getPRENOM(); 			
			matrice [i][3] = unCandidat.getEMAIL();
			matrice [i][4] = unCandidat.getMDP();			
			matrice [i][5] = unCandidat.getType_user();
			matrice [i][6] = unCandidat.getNUMERO_TELEPHONE();
			matrice [i][7] = unCandidat.getnb_lecon();

			i++;

		}

		return matrice;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		 if (e.getSource() == this.btAnnuler) {

			 this.txtNomCandidat.setText("");
			 this.txtPrenomCandidat.setText("");
			 this.txtEmailCandidat.setText("");
			 this.txtMdpCandidat.setText("");
			 this.txtType_user.setText("");
			 this.txtNumero_telephone.setText("");
			 this.txtnb_lecon.setText("");

		 }
		 else if (e.getSource() == this.btEnregistrer) {

			 String nom = this.txtNomCandidat.getText();
			 String prenom = this.txtPrenomCandidat.getText();
			 String email = this.txtEmailCandidat.getText();
			 String mdp = this.txtMdpCandidat.getText();
			 String type_user = this.txtType_user.getText();
			 String numero_telephone = this.txtNumero_telephone.getText();
			 String nb_lecon = this.txtnb_lecon.getText();

			 //instanciation d'une Candidat 
			 Candidat unCandidat = new Candidat (nom,prenom, email, mdp,type_user, numero_telephone,nb_lecon); 
			 //insertion dans la base de données 
			 Controleur.insertCandidat(unCandidat);
			 JOptionPane.showMessageDialog(this, "Candidat ajouté avec succès");

			 //recuperation de l'id du Candidat de la BDD 
			 unCandidat = Controleur.selectWhereCandidat(nom,prenom, email, mdp, type_user, numero_telephone, nb_lecon); 

			 //mettre à jour l'afffichage 
			 Object ligne[]= {unCandidat.getIDUSER(),nom,prenom, email, mdp, type_user,numero_telephone,nb_lecon };
			 this.unTableau.ajouterLigne(ligne);
			 
			 this.txtNomCandidat.setText("");
			 this.txtPrenomCandidat.setText("");
			 this.txtEmailCandidat.setText("");
			 this.txtMdpCandidat.setText("");
			 this.txtType_user.setText("");
			 this.txtNumero_telephone.setText("");
			 this.txtnb_lecon.setText("");
		 }
		 else if (e.getSource() == this.btFiltrer) {

			 String filtre = this.txtFiltre.getText(); 

			 Object matrice [][] = this.remplirDonnees(filtre); 

			 this.unTableau.setDonnees(matrice);

		 }

	}

}
 