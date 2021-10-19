package Models;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.Iterator;

class NetMulticastReceiver implements Runnable{

    MulticastSocket ms;
    NetModel owner;
 
    public NetMulticastReceiver (NetModel owner, MulticastSocket ms) {
        this.ms = ms;
        this.owner = owner;
    }
 
    @Override
    public void run() {
        
        //NO SE POR QUÉ NO HACE FALTA EL WHILE XD

        //Paquete para RECIBIR
        DatagramPacket dp = new DatagramPacket(
            new byte [Constants.BUFFER_SIZE], 
            Constants.BUFFER_SIZE
        );

        try {
            ms.receive(dp);
            System.out.println("SE HA RECIBIDO ALGO!!!");
            owner.notifyObservers( (Object) new String (dp.getData()) );

        } catch (IOException e) {
            e.printStackTrace();
        }       
        
    }
    
}
