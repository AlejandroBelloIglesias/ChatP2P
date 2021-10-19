package Models;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Controllers.Controller;
import Patterns.IObservable;
import Patterns.IObserver;

public class NetModel implements IObservable{

    private ArrayList<IObserver> observers = new ArrayList<>();

    public String myIP;
    public String user = "undefined";

    //Multicast
    public NetMulticast multicastSender;

    // ==== __INIT__ ====

    public NetModel() {

        // Set ip
        try {
            myIP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("No tienes bien configurado internet!");
            System.exit(0);
        }
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

        //Solo al hacer login se inicializa la red multicast
        multicastSender = new NetMulticast(this);

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
    public synchronized void notifyObservers(Object args) {
        Iterator<IObserver> it = observers.iterator();
        while (it.hasNext()) {
            it.next().update(this, args);
        }
    }

}