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

import controleur.Controleur;
import controleur.Tableau;
import controleur.Vehicule;
import controleur.Controleur;
 
public class PanelVehicule extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel ();
	private JTextField txtMarque = new JTextField();
	private JTextField txtModele = new JTextField();
	private JTextField txtImmatriculation = new JTextField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	private JTable tableVehicule ; //table des classes
	private JScrollPane uneScroll ;
	
	//panel de filtrage
	private JPanel panelFiltre = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltrer = new JButton("Filtrer");
	
	private Tableau unTableau ;
	
	public PanelVehicule()
	{
		super ();
		//construction du formulaire Vehicule.
		this.panelForm.setLayout(new GridLayout(4,2));
		this.panelForm.setBackground(new Color (32, 178, 170));
		this.panelForm.setBounds(10, 10, 300, 300);
		this.panelForm.add(new JLabel("Marque :"));
		this.panelForm.add(this.txtMarque);
		this.panelForm.add(new JLabel("Modele :"));
		this.panelForm.add(this.txtModele);
		this.panelForm.add(new JLabel("Immatriculation :"));
		this.panelForm.add(this.txtImmatriculation);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.panelForm.setVisible(true);
		this.add(this.panelForm);
		
		//construction de la table des vehicules
		String entetes [] = {"ID Vehicule", "Marque", "Modele","Immatricule"};
		this.unTableau = new Tableau (entetes, this.remplirDonnees(""));
		
		this.tableVehicule = new JTable(this.unTableau) ;
		this.tableVehicule.getTableHeader().setReorderingAllowed(false);
		this.uneScroll = new JScrollPane(this.tableVehicule);
		this.uneScroll.setBounds(350, 80, 460, 230);
		this.add(this.uneScroll);
		
		//construction du panel filtre
		this.panelFiltre.setBounds(350, 30, 450, 30);
		this.panelFiltre.setBackground(new Color (32, 178, 170));
		this.panelFiltre.setLayout(new GridLayout(1, 3));
		this.panelFiltre.add(new JLabel("Filtrer les vehicules par :"));
		this.panelFiltre.add(this.txtFiltre);
		this.panelFiltre.add(this.btFiltrer);
		this.add(this.panelFiltre);
		
		//rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btFiltrer.addActionListener(this);
	}
	public Object [] [] remplirDonnees (String filtre){
		//cette méthode permet de convertir l'ArrayList en une matrice de données
		
		ArrayList<Vehicule> lesVehicules = Controleur.selectAllVehicules(filtre);
		Object [] [] matrice = new Object [lesVehicules.size()] [4];
		int i =0;
		for (Vehicule unVehicule : lesVehicules) {
			matrice [i][0] = unVehicule.getIdvehicule();
			matrice [i][1] = unVehicule.getMarque();
			matrice [i][2] = unVehicule.getModele();
			matrice [i][3] = unVehicule.getImmatriculation();
			i++;
		}
		return matrice;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== this.btAnnuler) {
			this.txtMarque.setText("");
			this.txtModele.setText("");
			this.txtImmatriculation.setText("");
		}
		else if (e.getSource()== this.btEnregistrer) {
			String marque = this.txtMarque.getText();
			String modele = this.txtModele.getText();
			String immatriculation = this.txtImmatriculation.getText();
		
			//instanciation d'un vehicule
			Vehicule unVehicule = new Vehicule (marque ,modele, immatriculation);
			
			//insertion dans la base de données
			Controleur.insertVehicule(unVehicule);
			JOptionPane.showMessageDialog(this, "Véhicule ajouté avec succès");
			
			//recuperation de l'id du vehicule de la BDD
			unVehicule = Controleur.selectWhereVehicule(marque, modele);
			
			//mettre à jour l'affichage
			Object ligne[] = {unVehicule.getIdvehicule(), marque, modele, immatriculation};
			this.unTableau.ajouterLigne(ligne);
			
			this.txtMarque.setText("");
			this.txtModele.setText("");
			this.txtImmatriculation.setText("");
		
		}
		else if (e.getSource() == this.btFiltrer) {
			String filtre = this.txtFiltre.getText();
			Object matrice [][] = this.remplirDonnees(filtre);
			this.unTableau.setDonnees(matrice);
					
		}
		
	}
}