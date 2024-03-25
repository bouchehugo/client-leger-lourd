package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class PanelPrincipal extends JPanel
{
	public PanelPrincipal() {
		//touttes les propriétés communes à tous les panels.
		this.setBounds(20, 80, 950, 540);
		this.setLayout(null);
		this.setBackground(new Color(32, 178, 170));
		
		this.setVisible(false);
	}

	
}
