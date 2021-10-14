package Models;

import java.net.DatagramPacket;
import java.net.Socket;


//Recibe mensajes
//Recibe peticiones de conexión al ServerSocket
//Un hilo, un socket por cada participante
public class NetMessageReceiver implements Runnable{
    
    Socket connection;
    //DatagramPacket data = new DatagramPacket(new byte[1024], 1024);

    public NetMessageReceiver (Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        
        while (true) {
            
            //socket.receive()
            //Se coge la conexión y se pasa
            
        }
        
        
    }


}
