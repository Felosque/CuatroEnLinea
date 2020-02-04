package cuatroenlinea.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import cuatroenlinea.mundo.Ficha;
import cuatroenlinea.mundo.VideoJuego;

public class VentanaPrincipal extends JFrame {

	private PanelTablero panelTablero;
	
	private VideoJuego videoJuego;
	
	public VentanaPrincipal() {
		panelTablero = new PanelTablero(this);
		add(panelTablero, BorderLayout.CENTER);
		
		videoJuego = new VideoJuego();
	}
	
	
	public int vAgregarFicha(int pColumna, int pJugador)
	{
		return videoJuego.agregarFicha(pColumna, pJugador);
	}
	
	public int vDarJugadorActual()
	{
		return videoJuego.darJugadorActual();
	}
	
	public void vCambiarJugador()
	{
		videoJuego.cambiarJugador();
	}
	
	public boolean vVerificarJugada(Ficha pFicha)
	{
		return videoJuego.verificarJugadaJugador(pFicha);
	}
	
	public Ficha[] vDarFichasGanadoras() {
		return videoJuego.darFichasGanadoras();
	}
	
	public static void main(String[] args) {
		VentanaPrincipal ven = new VentanaPrincipal();
		ven.setSize(new Dimension(1000, 600));
		ven.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ven.setResizable(false);
		ven.setTitle("Cuatro en linea, by RH#0001");
		ven.setVisible(true);
	}

}
