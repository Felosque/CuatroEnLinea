package cuatroenlinea.interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import cuatroenlinea.mundo.Ficha;
import cuatroenlinea.mundo.VideoJuego;

public class PanelTablero extends JPanel implements ActionListener{

	private JTextField[][] fichas;
	
	private JButton[] botones;
	
	private VentanaPrincipal ven;
	
	public PanelTablero(VentanaPrincipal pInter) {
		
		ven = pInter;
		setLayout( new GridLayout(VideoJuego.MAX_FILAS+1, VideoJuego.MAX_COLUMNAS));
		setBorder(BorderFactory.createLineBorder(new Color(0, 50, 0)));
		fichas = new JTextField[VideoJuego.MAX_FILAS][VideoJuego.MAX_COLUMNAS];
		botones = new JButton[VideoJuego.MAX_COLUMNAS];
		for(int i = 0; i < botones.length; i++)
		{
			botones[i] = new JButton();
			botones[i].addActionListener(this);
			botones[i].setActionCommand(""+i);
			add(botones[i]);
		}
		
		for(int i = 0; i < VideoJuego.MAX_FILAS; i++)
		{
			for(int j = 0; j < VideoJuego.MAX_COLUMNAS; j++)
			{
				fichas[i][j] = new JTextField();
				fichas[i][j].setEditable(false);
				fichas[i][j].setBackground(new Color(0, 68, 95));
				fichas[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
				fichas[i][j].setForeground(new Color(255, 255, 255));
				add(fichas[i][j]);
			}
		}
		
		cambiarImagenJugador(ven.vDarJugadorActual());
		
	}

	public void escribirPanel(int pX, int pY, int pJugador)
	{
		if(pJugador == VideoJuego.JUGADOR_UNO)
		{
			fichas[pX][pY].setText("O");
			fichas[pX][pY].setForeground(new Color(207,66,17));
		}
		else
		{
			fichas[pX][pY].setText("O");
			fichas[pX][pY].setForeground(new Color(241, 191, 37));
		}
		fichas[pX][pY].setFont(new Font("Arial", Font.BOLD,90));
		fichas[pX][pY].setHorizontalAlignment(JTextField.CENTER);
	}
	
	public void colorearFichasGanadoras(Ficha[] pFicha)
	{
		for (int i = 0; i < pFicha.length; i++) {
			fichas[pFicha[i].getPosX()][pFicha[i].getPosY()].setBackground(new Color(116, 144, 21));
		}
	}
	
	public void cambiarImagenJugador(int pJugador)
	{
		ImageIcon icono;
		ImageIcon otroicon = null;
		if(pJugador == 1)
		{
			icono = new ImageIcon("img/P1.png");
			Image img = icono.getImage();
			Image otraimg = img.getScaledInstance(70,70,java.awt.Image.SCALE_SMOOTH);
			otroicon = new ImageIcon(otraimg);
		}else
		{
			icono = new ImageIcon("img/P2.png");
			Image img = icono.getImage();
			Image otraimg = img.getScaledInstance(70,70,java.awt.Image.SCALE_SMOOTH);
			otroicon = new ImageIcon(otraimg);
		}
		
		for(int i = 0; i < botones.length; i++)
		{
			botones[i].setIcon(otroicon);
			botones[i].repaint();
		}
	}
	
	public void ReiniciarJuego(int pJugador)
	{
		cambiarImagenJugador(pJugador);
		for(int i = 0; i < VideoJuego.MAX_FILAS; i++)
		{
			for(int j = 0; j < VideoJuego.MAX_COLUMNAS; j++)
			{
				fichas[i][j].setText("");
				fichas[i][j].setBackground(new Color(0, 68, 95));
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int valor = Integer.parseInt(e.getActionCommand());
		int jugador = ven.vDarJugadorActual();
		int ficha = -1;
		
		switch (valor) {
		
			case 0:
				ficha = ven.vAgregarFicha(valor, jugador);
				if(ficha != -1) escribirPanel(ficha, valor, jugador);
				break;
				
			case 1:
				ficha = ven.vAgregarFicha(valor, jugador);
				if(ficha != -1) escribirPanel(ficha, valor, jugador);
				break;
				
			case 2:
				ficha = ven.vAgregarFicha(valor, jugador);
				if(ficha != -1) escribirPanel(ficha, valor, jugador);
				break;
				
			case 3:
				ficha = ven.vAgregarFicha(valor, jugador);
				if(ficha != -1) escribirPanel(ficha, valor, jugador);
				break;
				
			case 4:
				ficha = ven.vAgregarFicha(valor, jugador);
				if(ficha != -1) escribirPanel(ficha, valor, jugador);
				break;
				
			case 5:
				ficha = ven.vAgregarFicha(valor, jugador);
				if(ficha != -1) escribirPanel(ficha, valor, jugador);
				break;
				
			case 6:
				ficha = ven.vAgregarFicha(valor, jugador);
				if(ficha != -1) escribirPanel(ficha, valor, jugador);
				break;
		}
		
		if(ficha != -1) 
		{
			if(ven.vVerificarJugada(new Ficha(ficha, valor, jugador)))
			{
				colorearFichasGanadoras(ven.vDarFichasGanadoras());
				JOptionPane.showMessageDialog(this, "¡Ha ganado el jugador " + jugador + "!");
			}else {
				ven.vCambiarJugador();
				cambiarImagenJugador(ven.vDarJugadorActual());
			}
		}
		
	}

}
