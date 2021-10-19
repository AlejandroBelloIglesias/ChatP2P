/*package Models;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetConnectionReceiver {
    
    NetModel netModel = NetModel.getInstance();
    ServerSocket ss;

    public NetConnectionReceiver () { //Se podría pasar netModel por aquí

        try {
            ss = new ServerSocket(55555);

            while (true) {
                Socket aClientConnection = ss.accept();
                netModel.addConnection(aClientConnection);

                //Detalles de la conexión XD
                System.out.println("Ip:" + aClientConnection.getInetAddress());
                System.out.println(" Puerto:" + aClientConnection.getPort());
            }

        } catch (IOException e) {

            e.printStackTrace();
            System.exit(0);
        }

    }

}
*/