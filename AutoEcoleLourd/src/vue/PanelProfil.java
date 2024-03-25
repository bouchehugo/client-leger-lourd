package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.Controleur;
import controleur.User;

 
public class PanelProfil extends PanelPrincipal implements ActionListener
{
	private JTextArea txtInfos = new JTextArea ();
	private JButton btModifier = new JButton ("Modifier");
	private JPanel panelForm = new JPanel();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtType_user = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JTextField txtNumero_telephone = new JTextField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	private User unUser;
	public PanelProfil(User unUser) {
		super();
		this.unUser = unUser;
		this.txtInfos.setBounds(40, 80, 300, 200);
		this.txtInfos.setBackground(new Color(32, 178, 170));
		this.txtInfos.setText(
				"\n ______Données Utilisateur_____"
				+"\n\nNom User     : "+unUser.getNom()
				+"\n\nPrénom User  : "+unUser.getPrenom()
				+"\n\nEmail User   : "+unUser.getEmail()
				+"\n\nRole User    : "+unUser.getType_user()
				+"\n\nNumero Telephone User    : "+unUser.getNumero_telephone()
				);
		this.add(this.txtInfos);
		this.btModifier.setBounds(100, 300, 100, 30);
		this.add(this.btModifier);
		this.btModifier.addActionListener(this);
		//construction du panel form
		this.panelForm.setBounds(400, 80, 300, 300);
		this.panelForm.setBackground(new Color(32, 178, 170));
		this.panelForm.setLayout(new GridLayout(6,2));
		this.panelForm.add(new JLabel("Nom : "));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Prenom : "));
		this.panelForm.add(this.txtPrenom);
		this.panelForm.add(new JLabel("Email : "));
		this.panelForm.add(this.txtEmail);
		this.panelForm.add(new JLabel("Role : "));
		this.panelForm.add(this.txtType_user);
		this.panelForm.add(new JLabel("Num Tel : "));
		this.panelForm.add(this.txtNumero_telephone);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.add(this.panelForm);
		this.panelForm.setVisible(false);
		//rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.btAnnuler == e.getSource()) {
			this.txtNom.setText("");
			this.txtPrenom.setText("");
			this.txtEmail.setText("");
			this.txtType_user.setText("");
			this.txtNumero_telephone.setText("");
			this.txtMdp.setText("");
			this.panelForm.setVisible(false);
		} 
		else if (this.btModifier == e.getSource())
		{
			this.txtNom.setText(this.unUser.getNom());
			this.txtPrenom.setText(this.unUser.getPrenom());
			this.txtEmail.setText(this.unUser.getEmail());
			this.txtType_user.setText(this.unUser.getType_user());
			this.txtNumero_telephone.setText(this.unUser.getNumero_telephone());
			this.txtMdp.setText(this.unUser.getMdp());
			this.panelForm.setVisible(true);
		} else if (this.btEnregistrer == e.getSource()) {
			//mise à jour dans la base de données
			this.unUser.setNom(this.txtNom.getText());
			this.unUser.setPrenom(this.txtPrenom.getText());
			this.unUser.setEmail(this.txtEmail.getText());
			this.unUser.setType_user(this.txtNumero_telephone.getText());
			this.unUser.setMdp(new String(this.txtMdp.getPassword()));
			Controleur.updateUser(this.unUser);
			JOptionPane.showMessageDialog(this, "Modification effectuee");
			//actualiser l'affichage
			this.txtInfos.setText(
					"\n ______Données Utilisateur_____"
					+"\n\nNom User     : "+unUser.getNom()
					+"\n\nPrénom User  : "+unUser.getPrenom()
					+"\n\nEmail User   : "+unUser.getEmail()
					+"\n\nRole User    : "+unUser.getType_user()
					+"\n\nNumero Telephone User    : "+unUser.getNumero_telephone()
					);
			this.panelForm.setVisible(false);
		}
	}
 
	

	
}
