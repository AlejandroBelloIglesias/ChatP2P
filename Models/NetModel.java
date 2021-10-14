package Models;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NetModel {

    //Patrón Singleton
    static NetModel netModelSingleton = new NetModel();
    String myIP;

    String user = "undefined";
    Set<Socket> connections = new HashSet<>(); //Es un set porque no queremos que haya repeticiones

    private NetModel () {

        var connectionReceiver = new NetConnectionReceiver(); //???

        //Set ip
        try {
            myIP = InetAddress.getLocalHost().getHostAddress();
            // new NetConnectionSender()?
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("No tienes bien configurado internet!");
            System.exit(0);
        }
    }

    //Patrón Singleton
    public static NetModel getInstance() {
        return netModelSingleton;
    }

    // ==== GETTERS && SETTERS
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    private Set<Socket> getConnections() {
        return connections;
    }

    public synchronized void addConnection(Socket stablishedConnection) {
        connections.add(stablishedConnection);

        //Se crea el hilo que escucha a esta conexión
        new Thread(new NetMessageReceiver(stablishedConnection)).start(); //new Thread
    }

    public void sendMessageToAllConnections(String msg) {

        connections.forEach(
            (socket) -> {
                try {
                    socket.getOutputStream().write(msg.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        );
        
    }


}