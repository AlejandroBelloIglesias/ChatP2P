package Models;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Controllers.Controller;
import Patterns.IObservable;
import Patterns.IObserver;

public class NetModel implements IObservable{

    private ArrayList<IObserver> observers = new ArrayList<>();
    private Map<InetAddress,String> onlineUsers = new HashMap<>();

    public String myIP;
    public String user = "undefined";
 
    //Multicast
    public MulticastSocket ms;
    public NetMulticastSender multicastSender;
    public NetMulticastReceiver multicastReceiver;

    // ==== __INIT__ ====

    public NetModel() {
        
        try {
            ms = new MulticastSocket(Constants.PORT);
            ms.joinGroup(InetAddress.getByName(Constants.IP));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("No se pudo iniciar la conexión al socket multicast");
            System.exit(0);
        }

        // Set ip
        try {
            myIP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("No tienes bien configurado internet!");
            System.exit(0);
        }
    }

    public boolean isOnline (InetAddress ip) {
        return onlineUsers.containsKey(ip);
    }

    public void addOnline (InetAddress ip, String user) {
        onlineUsers.put(ip, user);
    }

    public void removeOnline(InetAddress ip) {
        onlineUsers.remove(ip);
    }


    // ==== GETTERS && SETTERS
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    // ==== MULTICAST ====
    public void login() {

        // RECEIVER
        multicastReceiver = new NetMulticastReceiver(this, ms);
        Thread r = new Thread(multicastReceiver);
        r.start();

        // SENDER
        multicastSender = new NetMulticastSender(this, ms);
        
    }


    // ==== OBSERVABLE ====
    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void delObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {  
        Iterator<IObserver> it = observers.iterator();
        while (it.hasNext()) {
            it.next().update(this);
        }
    }

    @Override
    public synchronized void notifyObservers(Object[] args) {
        Iterator<IObserver> it = observers.iterator();
        while (it.hasNext()) {
            it.next().update(this, args);
        }
    }

    public Map<InetAddress,String> getOnlineUsers() {
        return onlineUsers;
    }

}