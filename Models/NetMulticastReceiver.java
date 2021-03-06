package Models;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
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
        
        while (true) {

            byte[] datos = new byte[Constants.BUFFER_SIZE];

            //Paquete para RECIBIR
            DatagramPacket dp;
            try {
                
                dp = new DatagramPacket(
                    datos, 
                    datos.length,
                    InetAddress.getByName(Constants.IP),
                    Constants.PORT
                );

                ms.receive(dp);
                datos = dp.getData();

                System.out.println("ip origen: "+ dp.getAddress());
                System.out.println("puerto origen: "+ dp.getPort());
                System.out.println(new String(datos));

                if ( !owner.isOnline(dp.getAddress()) ) {
                    owner.addOnline(dp.getAddress(), "");
                }
             
                Object[] args = {
                    (Object) new String (datos), 
                    (Object) owner.getOnlineUsers() //Debería poder ser null
                };

                owner.notifyObservers( args );


            } catch (UnknownHostException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }        
        }    
    }

    /*
    public String getUserFromLoginMessage () {

        return "";
    }*/
    
}
