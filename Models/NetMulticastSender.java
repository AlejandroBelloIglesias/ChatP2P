package Models;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class NetMulticastSender{
    
    private MulticastSocket multicastSocket;
    private NetModel owner;

    public NetMulticastSender (NetModel owner, MulticastSocket multicastSocket) {
        this.owner = owner;
        this.multicastSocket = multicastSocket;
    }

    public void send(String msg) {

        System.out.println("LLEGÓ AL SEND");
     
        try {
            byte [] buffer = msg.getBytes();
 
            //Paquete para EMITIR
            DatagramPacket dp = new DatagramPacket(
                buffer, 
                buffer.length,
                InetAddress.getByName(Constants.IP),
                Constants.PORT
            );
/*
            System.out.println("ip origen: "+ dp.getAddress());
            System.out.println("puerto origen: "+ dp.getPort());
            System.out.println(new String(buffer));
            */
            multicastSocket.send(dp);

        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        

    }

}
