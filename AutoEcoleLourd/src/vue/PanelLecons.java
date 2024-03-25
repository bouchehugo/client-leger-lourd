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
import controleur.Lecons;
import controleur.Tableau;
import controleur.Vehicule;

public class PanelLecons extends PanelPrincipal implements ActionListener {
	private JPanel panelForm = new JPanel ();
	private JTextField txtTYPE_DE_LECON = new JTextField ();
	private JTextField txtDESCRIPTION = new JTextField ();
	private JTextField txtTITRE = new JTextField ();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	private JTable tableLecons ; //table des lecons
	private JScrollPane uneScroll ;
	

	//panel de filtrage
	private JPanel panelFiltre = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltrer = new JButton("filtrer");
	
	private Tableau unTableau;
	
	
	public PanelLecons() {
		super();
		
		//construction du formulaire leçon.
			this.panelForm.setLayout(new GridLayout(4,2));
			this.panelForm.setBackground(new Color(32, 178, 170));
			this.panelForm.setBounds(10, 10, 300, 300);
			this.panelForm.add(new JLabel("TYPE_DE_LECON"));
			this.panelForm.add(this.txtTYPE_DE_LECON);
			this.panelForm.add(new JLabel("DESCRIPTION"));
			this.panelForm.add(this.txtDESCRIPTION);
			this.panelForm.add(new JLabel("TITRE"));
			this.panelForm.add(this.txtTITRE);
			this.panelForm.add(this.btAnnuler);
			this.panelForm.add(this.btEnregistrer);
			this.panelForm.setVisible(true);
			this.add(this.panelForm);
			
			//construction de la table des lecons
			String entetes [] = {"ID Lecons", "TYPE_DE_LECON", "DESCRIPTION","TITRE"};
			this.unTableau = new Tableau (entetes, this.remplirDonnees(""));
			
			this.tableLecons = new JTable(this.unTableau) ;
			this.tableLecons.getTableHeader().setReorderingAllowed(false);
			this.uneScroll = new JScrollPane(this.tableLecons);
			this.uneScroll.setBounds(350, 80, 460, 230);
			this.add(this.uneScroll);
			
			//construction du panel filtre
			this.panelFiltre.setBounds(350, 30, 450, 30);
			this.panelFiltre.setBackground(new Color (32, 178, 170));
			this.panelFiltre.setLayout(new GridLayout(1, 3));
			this.panelFiltre.add(new JLabel("Filtrer les Leçons par :"));
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
			
			ArrayList<Lecons> lesLecons = Controleur.selectAllLecons(filtre);
			Object [] [] matrice = new Object [lesLecons.size()] [4];
			int i =0;
			for (Lecons uneLecon : lesLecons) {
				matrice [i][0] = uneLecon.getIdlecon();
				matrice [i][1] = uneLecon.gettype_de_lecon();
				matrice [i][2] = uneLecon.getdescription();
				matrice [i][3] = uneLecon.gettitre();
				i++;
			}
			return matrice;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()== this.btAnnuler) {
				this.txtTYPE_DE_LECON.setText("");
				this.txtDESCRIPTION.setText("");
				this.txtTITRE.setText("");
			}
			else if (e.getSource()== this.btEnregistrer) {
				String TYPE_DE_LECON = this.txtTYPE_DE_LECON.getText();
				String DESCRIPTION = this.txtDESCRIPTION.getText();
				String TITRE = this.txtTITRE.getText();
			
				//instanciation d'une Leçon
				Lecons uneLecon = new Lecons (TYPE_DE_LECON ,DESCRIPTION, TITRE);
				
				//insertion dans la base de données
				Controleur.insertLecons(uneLecon);
				JOptionPane.showMessageDialog(this, "Leçon ajoutée avec succès");
				
				//recuperation de l'id de la leçon de la BDD
				uneLecon = Controleur.selectWhereLecons(TYPE_DE_LECON, DESCRIPTION, TITRE);
				
				//mettre à jour l'affichage
				Object ligne[] = {uneLecon.getIdlecon(),TYPE_DE_LECON, DESCRIPTION, TITRE};
				this.unTableau.ajouterLigne(ligne);
				
				this.txtTYPE_DE_LECON.setText("");
				this.txtDESCRIPTION.setText("");
				this.txtTITRE.setText("");
			
			}
			else if (e.getSource() == this.btFiltrer) {
				String filtre = this.txtFiltre.getText();
				Object matrice [][] = this.remplirDonnees(filtre);
				this.unTableau.setDonnees(matrice);
						
			}
			
		}
	
	}

