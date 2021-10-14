package Models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NetConnectionFinder {

    //Singleton
    static NetConnectionFinder connectionFinder = new NetConnectionFinder();
    ArrayList<Socket> l = new ArrayList<>();
    boolean ready = false;

    private NetConnectionFinder() {}

    //Singleton
    public static NetConnectionFinder getInstance() {
        return connectionFinder;
    }

    public void findLocalConnections(String ownIp, String mask, int port) {

        // Recorrer toda la red excepto la red en sí (0) router (1?) y el broadcast
        // (255)
        // Doy por hecho de que la máscara es 255.255.255.0 (/24)
        for (int i = 2; i < 255; i++) {
            new Thread(new FinderThread(ownIp, i, port)).start();
            //timeout más corto
        }

    }
}

class FinderThread implements Runnable {

    int ipDigit, port;
    String ownIp;

    public FinderThread(String ownIp, int ipDigit, int port) {
        this.ipDigit = ipDigit;
        this.ownIp = ownIp;
        this.port = port;
    }

    @Override
    public void run() {
        
        //EVITAR CONEXIÓN CONMIGO MISMO

        String[] arr = ownIp.split("\\."); 
        String ip = arr[0] + "." + arr[1] + "." + arr[2] + "." + ipDigit;
        
        System.out.println("FINDING: " + ip);

        try {

            Socket possibleConnection = new Socket();
            possibleConnection.connect(new InetSocketAddress(ip, port), 1000);

            System.out.println("Se aceptó la conexión con " + ip);

            NetModel.getInstance().addConnection(possibleConnection);

        } catch (IOException e) {
            //System.out.println("No se aceptó la conexión con " + ip);
            //e.printStackTrace();
        }
    }

}
