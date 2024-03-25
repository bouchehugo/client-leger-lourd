package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.AutoEcole;

import controleur.User;

public class VueGenerale extends JFrame implements ActionListener{

	private JPanel panelMenu = new JPanel();
    private JButton btProfil= new JButton("Profil");
	private JButton btCandidat= new JButton("Candidat");
	private JButton btMoniteur= new JButton("Moniteur");
	private JButton btLecons= new JButton("Lecons");
    private JButton btVehicule= new JButton("Vehicule");
    private JButton btExamens= new JButton("Examens");
    private JButton btPlannings= new JButton("Plannings");
	private JButton btQuitter= new JButton("Quitter");
	
	
	
	private PanelProfil unPanelProfil ;
	private PanelCandidat unPanelCandidat = new PanelCandidat();
	private PanelMoniteur unPanelMoniteur = new PanelMoniteur();
	private PanelLecons unPanelLecons = new PanelLecons();
	private PanelVehicule unPanelVéhicule = new PanelVehicule();
    private PanelExamens unPanelExamen = new PanelExamens();
    private PanelPlannings unPanelPlanning = new PanelPlannings();
	


	
	
	public VueGenerale(User unUser){
		this.setTitle("Auto-Ecole Castelanne");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(32, 178, 170));
		this.setLayout(null);
		this.setBounds(200, 200,1000, 600);
		this.setResizable(false);
		
		// instanciation du panel profil 
		this.unPanelProfil = new PanelProfil(unUser);
		
		//placement du menu
		this.panelMenu.setBounds(30,10,900,30);
		this.panelMenu.setBackground(new Color (32, 178, 170));
		this.panelMenu.setLayout(new GridLayout(1, 6));
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btCandidat);
		this.panelMenu.add(this.btMoniteur);
		this.panelMenu.add(this.btLecons);
		this.panelMenu.add(this.btVehicule);
        this.panelMenu.add(this.btExamens);
        this.panelMenu.add(this.btPlannings);
		this.panelMenu.add(this.btQuitter);
		this.panelMenu.setVisible(true);
		this.add(this.panelMenu);
		
	
        this.btProfil.addActionListener(this);
		this.btCandidat.addActionListener(this);
		this.btMoniteur.addActionListener(this);
		this.btLecons.addActionListener(this);
		this.btVehicule.addActionListener(this);
        this.btExamens.addActionListener(this);
        this.btPlannings.addActionListener(this);
		this.btQuitter.addActionListener(this);
		
		
		this.add(this.unPanelProfil);
		this.add(this.unPanelCandidat);
		this.add(this.unPanelMoniteur);
		this.add(this.unPanelLecons);
		this.add(this.unPanelVéhicule);
        this.add(this.unPanelExamen);
		this.add(this.unPanelPlanning);
		
		this.setVisible(true);
	}
	
	public void afficherPanel(int choix) {
		this.unPanelProfil.setVisible(false);
		this.unPanelCandidat.setVisible(false);
		this.unPanelMoniteur.setVisible(false);
		this.unPanelLecons.setVisible(false);
		this.unPanelVéhicule.setVisible(false);
        this.unPanelExamen.setVisible(false);
		this.unPanelPlanning.setVisible(false);
		switch(choix) {
		case 1 : unPanelProfil.setVisible(true); break;
		case 2 : unPanelCandidat.setVisible(true); break;
		case 3 : unPanelMoniteur.setVisible(true); break;
		case 4 : unPanelLecons.setVisible(true); break;
		case 5 : unPanelVéhicule.setVisible(true); break;
		case 6 : unPanelExamen.setVisible(true); break;
        case 7 : unPanelPlanning.setVisible(true); break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btQuitter) {
			AutoEcole.rendreVisibleGenerale(false,null);
			AutoEcole.rendreVisibleConnexion(true);
		
		}else if(e.getSource() == this.btProfil) {
			this.afficherPanel(1);
		}else if(e.getSource() == this.btCandidat) {
			this.afficherPanel(2);
		}else if(e.getSource() == this.btMoniteur) {
			this.afficherPanel(3);
		}else if(e.getSource() == this.btLecons) {
			this.afficherPanel(4);
		}else if(e.getSource() == this.btVehicule) {
			this.afficherPanel(5);
		}else if(e.getSource() == this.btExamens) {
			this.afficherPanel(6);
		}else if(e.getSource() == this.btPlannings) {
			this.afficherPanel(7);
		}
	}
}
