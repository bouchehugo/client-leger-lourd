package vue;

import java.awt.Color;
import java.awt.Component;
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
import controleur.Examens;
import controleur.Lecons;
import controleur.Tableau;
import controleur.Vehicule;

public class PanelExamens extends PanelPrincipal implements ActionListener {
	private JPanel panelForm = new JPanel ();
	private JTextField txtDATE_ET_HEURE_D_EXAMEN = new JTextField ();
	private JTextField txtVehicule = new JTextField ();
	private JTextField txtTYPE_DE_PERMIS = new JTextField ();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	private JTable tableExamens ; //table des lecons
	private JScrollPane uneScroll ;
	

	//panel de filtrage
	private JPanel panelFiltre = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltrer = new JButton("filtrer");
	
	private Tableau unTableau;
	
	
	public PanelExamens() {
		super();
		
		//construction du formulaire examen.
			this.panelForm.setLayout(new GridLayout(4,2));
			this.panelForm.setBackground(new Color(32, 178, 170));
			this.panelForm.setBounds(10, 10, 300, 300);
			this.panelForm.add(new JLabel("DATE_ET_HEURE_D_EXAMEN"));
			this.panelForm.add(this.txtDATE_ET_HEURE_D_EXAMEN);
			this.panelForm.add(new JLabel("Vehicule"));
			this.panelForm.add(this.txtVehicule);
			this.panelForm.add(new JLabel("TITRE"));
			this.panelForm.add(this.txtTYPE_DE_PERMIS);
			this.panelForm.add(this.btAnnuler);
			this.panelForm.add(this.btEnregistrer);
			this.panelForm.setVisible(true);
			this.add(this.panelForm);
			
			//construction de la table des examens
			String entetes [] = {"ID Examens", "DATE_ET_HEURE_D_EXAMEN", "Vehicule","TYPE_DE_PERMIS"};
			this.unTableau = new Tableau (entetes, this.remplirDonnees(""));
			
			this.tableExamens = new JTable(this.unTableau) ;
			this.tableExamens.getTableHeader().setReorderingAllowed(false);
			this.uneScroll = new JScrollPane(this.tableExamens);
			this.uneScroll.setBounds(350, 80, 460, 230);
			this.add(this.uneScroll);
			
			//construction du panel filtre
			this.panelFiltre.setBounds(350, 30, 450, 30);
			this.panelFiltre.setBackground(new Color (32, 178, 170));
			this.panelFiltre.setLayout(new GridLayout(1, 3));
			this.panelFiltre.add(new JLabel("Filtrer les examens par :"));
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
			
			ArrayList<Examens> lesExamens = Controleur.selectAllExamens(filtre);
			Object [] [] matrice = new Object [lesExamens.size()] [4];
			int i =0;
			for (Examens unExamen : lesExamens) {
				matrice [i][0] = unExamen.getIdExamen();
				matrice [i][1] = unExamen.getDATE_ET_HEURE_D_EXAMEN();
				matrice [i][2] = unExamen.getVehicule();
				matrice [i][3] = unExamen.getTYPE_DE_PERMIS();
				i++;
			}
			return matrice;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()== this.btAnnuler) {
				this.txtDATE_ET_HEURE_D_EXAMEN.setText("");
				this.txtVehicule.setText("");
				this.txtTYPE_DE_PERMIS.setText("");
			}
			else if (e.getSource()== this.btEnregistrer) {
				String DATE_ET_HEURE_D_EXAMEN = this.txtDATE_ET_HEURE_D_EXAMEN.getText();
				String Vehicule = this.txtVehicule.getText();
				String TYPE_DE_PERMIS = this.txtTYPE_DE_PERMIS.getText();
			
				//instanciation d'une Leçon
				Examens unExamen = new Examens (DATE_ET_HEURE_D_EXAMEN ,Vehicule, TYPE_DE_PERMIS);
				
				//insertion dans la base de données
				Controleur.insertExamens(unExamen);
				JOptionPane.showMessageDialog(this, "Examen ajoutée avec succès");
				
				//recuperation de l'id de l'examen de la BDD
				unExamen = Controleur.selectWhereExamens(DATE_ET_HEURE_D_EXAMEN, Vehicule, TYPE_DE_PERMIS);
				
				//mettre à jour l'affichage
				Object ligne[] = {unExamen.getIdExamen(),DATE_ET_HEURE_D_EXAMEN, Vehicule, TYPE_DE_PERMIS};
				this.unTableau.ajouterLigne(ligne);
				
				this.txtDATE_ET_HEURE_D_EXAMEN.setText("");
				this.txtVehicule.setText("");
				this.txtTYPE_DE_PERMIS.setText("");
			
			}
			else if (e.getSource() == this.btFiltrer) {
				String filtre = this.txtFiltre.getText();
				Object matrice [][] = this.remplirDonnees(filtre);
				this.unTableau.setDonnees(matrice);
						
			}
			
		}
	
	}


