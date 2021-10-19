package Models;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class NetMulticast{
    
    private MulticastSocket multicastSocket;
    private NetMulticastReceiver multicastReceiver;

    public NetMulticast (NetModel owner) {

        try {
            multicastSocket = new MulticastSocket(Constants.PORT);
            multicastSocket.joinGroup(InetAddress.getByName(Constants.IP));


            Thread r = new Thread(new NetMulticastReceiver(owner, multicastSocket));
            r.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    public void send(String msg) {

        DatagramPacket dp;
        try {
            dp = new DatagramPacket(
                    msg.getBytes(), 
                    msg.getBytes().length,
                    InetAddress.getByName(Constants.IP),
                    Constants.PORT
                );

                try {
                    multicastSocket.send(dp);
                } catch (IOException e) {
                    e.printStackTrace();
                }

        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        }        

    }

}
