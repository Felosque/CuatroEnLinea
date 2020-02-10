package cuatroenlinea.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener {

	
	private JButton btReiniciar;
	
	private JButton btMenuPrincipal;
	
	private VentanaPrincipal ven;
	
	
	public PanelOpciones(VentanaPrincipal pVen) {
		
		setLayout(new GridLayout(1, 2));
		this.ven = pVen;
		
		btMenuPrincipal = new JButton("Menu principal");
		btMenuPrincipal.setActionCommand("MENU_PRINCIPAL");
		btMenuPrincipal.addActionListener(this);
		add(btMenuPrincipal);
		
		btReiniciar = new JButton("Reiniciar");
		btReiniciar.setActionCommand("REINICIAR");
		btReiniciar.addActionListener(this);
		add(btReiniciar);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String commando = e.getActionCommand();
		
		if(commando.equals("MENU_PRINCIPAL"))
		{
			
		}
		else if(commando.equals("REINICIAR"))
		{
			ven.vReiniciar();
		}
		
		
	}
	
	
}
