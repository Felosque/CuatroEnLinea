package cuatroenlinea.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import cuatroenlinea.mundo.Cliente;
import cuatroenlinea.mundo.Ficha;
import cuatroenlinea.mundo.VideoJuego;

public class VentanaPrincipal extends JFrame {

	private PanelTablero panelTablero;
	
	private VideoJuego videoJuego;
	
	private PanelOpciones panelOpciones;
	
	private Cliente cliente;
	
	public VentanaPrincipal() {
		
		videoJuego = new VideoJuego();
		
		cliente = new Cliente(videoJuego, this);
		
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
