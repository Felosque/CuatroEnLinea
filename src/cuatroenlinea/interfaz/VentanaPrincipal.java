package cuatroenlinea.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cuatroenlinea.mundo.Ficha;
import cuatroenlinea.mundo.VideoJuego;

public class VentanaPrincipal extends JFrame {

	private PanelTablero panelTablero;
	
	private VideoJuego videoJuego;
	
	private PanelOpciones panelOpciones;
	
	public VentanaPrincipal() {
		
		videoJuego = new VideoJuego();
		
		panelTablero = new PanelTablero(this);
		add(panelTablero, BorderLayout.CENTER);
		
		panelOpciones = new PanelOpciones(this);
		add(panelOpciones, BorderLayout.SOUTH);
		
	}
	
	
	public int vAgregarFicha(int pColumna, int pJugador)
	{
		return videoJuego.agregarFicha(pColumna, pJugador);
	}
	
	public int vDarJugadorActual()
	{
		return videoJuego.darJugadorActual();
	}
	
	public void vPonerJugadaAnterior() {
		try {
			Ficha fichaAnterior = videoJuego.darFichaAnterior();
			videoJuego.cambiarAJugadaAnterior();
			panelTablero.eliminarFichaAnterior(fichaAnterior.getPosX(), fichaAnterior.getPosY());
			vCambiarJugador();
			panelTablero.cambiarImagenJugador(videoJuego.darJugadorActual());
			if(videoJuego.darFichasGanadoras() != null) { 
				panelTablero.descolorearFichasGanadoras(videoJuego.darFichasGanadoras());
				panelTablero.enableBotones();
				videoJuego.setFichasGanadoras(null);
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "No hay jugada anterior");
		}
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
	
	public void vReiniciar()
	{
		if(videoJuego.darFichasGanadoras() != null) {
			panelTablero.descolorearFichasGanadoras(videoJuego.darFichasGanadoras());
			panelTablero.enableBotones();
		}
		videoJuego.ReiniciarJuego();
		panelTablero.ReiniciarJuego(videoJuego.darJugadorActual());
	}
	
	public static void main(String[] args) {
		VentanaPrincipal ven = new VentanaPrincipal();
		ven.setSize(new Dimension(800, 600));
		ven.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ven.setResizable(false);
		ven.setTitle("Cuatro en linea, by RH#0001");
		ven.setVisible(true);
	}

}
