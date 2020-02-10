package cuatroenlinea.mundo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JEditorPane;

import cuatroenlinea.interfaz.VentanaPrincipal;

/**
 *
 * @author netosolis
 */
public class Cliente implements Runnable{
	
	
    private Socket cliente;
    private DataInputStream in;
    private DataOutputStream out;
   
    private int puerto = 2027;
    private String host = "localhost";
    
    private String jugada = "";
    private VideoJuego videoJuego;
    private VentanaPrincipal ventanaPrincipal;

   
    public Cliente(VideoJuego pVideoJuego, VentanaPrincipal pVentanaPrincipal){
    	videoJuego = pVideoJuego;
    	ventanaPrincipal = pVentanaPrincipal;
    	
        try {
            cliente = new Socket(host,puerto);
            in = new DataInputStream(cliente.getInputStream());
            out = new DataOutputStream(cliente.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void run() {
        try{
            //Ciclo infinito que escucha por mensajes del servidor y los muestra en el panel
            while(true){
                jugada = in.readUTF();
                //Aquí se actualiza las jugadas
                System.out.println(jugada + "Hola xd");
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Funcion sirve para enviar mensajes al servidor
    public void enviarMsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
