package vue;
 
import java.awt.Color;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.JTextField;
import controleur.Moniteur;
import controleur.Controleur;
import controleur.Tableau;
 
public class PanelMoniteur extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel (); 
	private JTextField txtNomMoniteur = new JTextField(); 
	private JTextField txtPrenomMoniteur = new JTextField();  
	private JTextField txtEmailMoniteur = new JTextField(); 
	private JPasswordField txtMdpMoniteur = new JPasswordField();	
	private JTextField txtType_user = new JTextField("moniteur"); 
	private JTextField txtNumero_telephone = new JTextField();	 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JTable tableMoniteur ; //table des candidats 
	private JScrollPane uneScroll ;

	//panel de filtrage 

	private JPanel panelFiltre = new JPanel(); 
	private JTextField txtFiltre = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer"); 
	private Tableau unTableau ;
	private int nbMoniteur;
	private JLabel lbTitre = new JLabel("Nombre de moniteurs : ");
	public PanelMoniteur()

	{

		super ();

		//construction du formulaire Moniteur. 
		this.txtType_user.setEditable(false);
		this.panelForm.setLayout(new GridLayout(10,2));
		this.panelForm.setBackground(new Color (32, 178, 170));
		this.panelForm.setBounds(10, 50, 250, 350);
		this.panelForm.add(new JLabel("Nom  :")); 
		this.panelForm.add(this.txtNomMoniteur); 
		this.panelForm.add(new JLabel("Prenom :")); 
		this.panelForm.add(this.txtPrenomMoniteur);
		this.panelForm.add(new JLabel("Email :")); 
		this.panelForm.add(this.txtEmailMoniteur);
		this.panelForm.add(new JLabel("Mdp  :")); 
		this.panelForm.add(this.txtMdpMoniteur);
		this.panelForm.add(new JLabel("Num tel :")); 
		this.panelForm.add(this.txtNumero_telephone);
		this.panelForm.add(new JLabel("Type d'user :")); 
		this.panelForm.add(this.txtType_user); 
		
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer); 
		this.panelForm.setVisible(true);
		this.add(this.panelForm);

		//construction de la table des Moniteurs 

		String entetes [] = {"ID USER", "Nom Moniteur", "Prenom Moniteur","Email","Type_user","Numero telephone"};

		this.unTableau = new Tableau (entetes, this.remplirDonnees("")); 
		this.tableMoniteur = new JTable(this.unTableau) ; 
		this.tableMoniteur.getTableHeader().setReorderingAllowed(false);
		this.uneScroll = new JScrollPane(this.tableMoniteur); 
		this.uneScroll.setBounds(350, 80, 550, 230);
		this.add(this.uneScroll);

		//construction du panel filtre 

		this.panelFiltre.setBounds(350, 30, 550, 30);
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
		
		//ajout label titre 
		this.lbTitre.setBounds(300, 380, 300, 20);
		this.nbMoniteur = this.unTableau.getRowCount();
		this.lbTitre.setText("Nombre de moniteurs : " + this.nbMoniteur);
		this.add(this.lbTitre);
		
		//suppression d'un moniteur
		this.tableMoniteur.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			int numLigne = 0;
			int IDUSER = 0;
			if(e.getClickCount() >=2) {
				numLigne = tableMoniteur.getSelectedRow();
				IDUSER = Integer.parseInt(tableMoniteur.getValueAt(numLigne, 0).toString());
				int reponse = JOptionPane.showConfirmDialog(null,
						"Voulez vous confirmer suppression?" ,"Suppression du Moniteur", JOptionPane.YES_NO_OPTION);
				if(reponse == 0) {
					Controleur.deleteMoniteur(IDUSER);
					unTableau.supprimerLigne(numLigne);
					nbMoniteur = unTableau.getRowCount();
					lbTitre.setText("Nombre de Moniteurs : " + nbMoniteur);
				}
			}else if (e.getClickCount() == 1) {
				numLigne = tableMoniteur.getSelectedRow();
				txtNomMoniteur.setText(tableMoniteur.getValueAt(numLigne, 1).toString());
				txtPrenomMoniteur.setText(tableMoniteur.getValueAt(numLigne, 2).toString());
				txtEmailMoniteur.setText(tableMoniteur.getValueAt(numLigne, 3).toString());
				txtMdpMoniteur.setText("");
				txtType_user.setText(tableMoniteur.getValueAt(numLigne, 4).toString());
				txtNumero_telephone.setText(tableMoniteur.getValueAt(numLigne, 5).toString());
				btEnregistrer.setText("Modifier");

			}
		}
	});
}
	
	public Object [][] remplirDonnees (String filtre){

		//cette méthode permet de convertir l'ArrayList en une matrice de données.

		ArrayList<Moniteur> lesMoniteurs = Controleur.selectAllMoniteurs(filtre) ; 
		Object [][] matrice = new Object [lesMoniteurs.size()][6];
		int i =0; 
		for (Moniteur unMoniteur : lesMoniteurs) {
			matrice [i][0] = unMoniteur.getIDUSER(); 
			matrice [i][1] = unMoniteur.getNOM(); 
			matrice [i][2] = unMoniteur.getPRENOM(); 			
			matrice [i][3] = unMoniteur.getEMAIL();
			 			
			matrice [i][4] = unMoniteur.getType_user();
			matrice [i][5] = unMoniteur.getNUMERO_TELEPHONE();
			i++;

		}

		return matrice;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		 if (e.getSource() == this.btAnnuler) {

			 this.txtNomMoniteur.setText("");
			 this.txtPrenomMoniteur.setText("");
			 this.txtEmailMoniteur.setText("");
			 this.txtMdpMoniteur.setText("");
			 
			 this.txtNumero_telephone.setText("");
			 btEnregistrer.setText("Enregistrer");
		 }
		 else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {

			 String nom = this.txtNomMoniteur.getText();
			 String prenom = this.txtPrenomMoniteur.getText();
			 String email = this.txtEmailMoniteur.getText();
			 String mdp = new String (this.txtMdpMoniteur.getPassword());
			 String type_user = this.txtType_user.getText();
			 String numero_telephone = this.txtNumero_telephone.getText();

			 //instanciation d'une Moniteur 
			 Moniteur unMoniteur = new Moniteur (nom,prenom, email, mdp,type_user, numero_telephone); 
			 //insertion dans la base de données 
			 Controleur.insertMoniteur(unMoniteur);
			 JOptionPane.showMessageDialog(this, "Moniteur ajouté avec succès");

			 //recuperation de l'id du Moniteur de la BDD 
			 unMoniteur = Controleur.selectWhereMoniteur(nom,prenom, email, mdp, type_user, numero_telephone); 

			 //mettre à jour l'afffichage 
			 Object ligne[]= {unMoniteur.getIDUSER(),nom,prenom, email, mdp, type_user,numero_telephone};
			 

			 this.unTableau.ajouterLigne(ligne);
			 this.nbMoniteur = unTableau.getRowCount();
			 this.lbTitre.setText("Nombre de Moniteurs : " + nbMoniteur);
			 this.txtNomMoniteur.setText("");
			 this.txtPrenomMoniteur.setText("");
			 this.txtEmailMoniteur.setText("");
			 this.txtMdpMoniteur.setText("");
			  
			 this.txtNumero_telephone.setText("");
		 }

		 else if (e.getSource() == this.btFiltrer) {

			 String filtre = this.txtFiltre.getText(); 

			 Object matrice [][] = this.remplirDonnees(filtre); 

			 this.unTableau.setDonnees(matrice);

		 }else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")) {
			 String Nom = this.txtNomMoniteur.getText();
			 String Prenom = this.txtPrenomMoniteur.getText();
			 String Email = this.txtEmailMoniteur.getText();
			 String mdp = new String (this.txtMdpMoniteur.getPassword());
			 String Type_user = this.txtType_user.getText();
			 String Numero_telephone = this.txtNumero_telephone.getText();
			 int numLigne = this.tableMoniteur.getSelectedRow();
			 int idLigne = Integer.parseInt(tableMoniteur.getValueAt(numLigne, 0).toString());
			 Moniteur unMoniteur = new Moniteur(idLigne, Nom, Prenom, Email, mdp, Type_user, Numero_telephone);
			 Controleur.updateMoniteur(unMoniteur);
			 Object ligne[] = {idLigne, Nom, Prenom, Email, mdp, Type_user, Numero_telephone};
			 this.unTableau.modifierLIGNE(numLigne, ligne);
			 this.txtNomMoniteur.setText("");
			 this.txtPrenomMoniteur.setText("");
			 this.txtEmailMoniteur.setText("");
			 this.txtMdpMoniteur.setText("");
			 
			 this.txtNumero_telephone.setText("");
			 this.btEnregistrer.setText("Enregistrer");
			 
					 
			 }
		 }
	

}
 