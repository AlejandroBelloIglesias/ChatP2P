/*package Models;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Socket;

import Controllers.Controller;


//Recibe mensajes
//Recibe peticiones de conexión al ServerSocket
//Un hilo, un socket por cada participante
public class NetMessageReceiver implements Runnable{
    
    Socket connection;

    public NetMessageReceiver (Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        
        while (true) {
            
            try {

                String msg = connection.getInputStream().readAllBytes().toString();
                Controller.getInstance().unMetodoParaPasarElMensaje(msg);

            } catch (IOException e) {

                System.out.println("Se perdió un mensaje del host " + connection.getInetAddress());
                e.printStackTrace();

            }
            
        }
        
        
    }


}
*/