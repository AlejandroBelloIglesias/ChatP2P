package Controllers;

import Views.ChatEntry;
import Views.VistaChat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import Models.NetModel;
import Patterns.IObservable;
import Patterns.IObserver;

public class Controller implements IObserver{

    private NetModel model;
    private VistaChat vistaChat;

    // ==== Initialazers ====
    public Controller(VistaChat vistaChat, NetModel model) {
        this.model = model;
        this.vistaChat = vistaChat;

        addListeners();
    }

    // ==== View Listeners ===
    public void addListeners() {

        vistaChat.getBtn_login().addActionListener((e) -> {

            //System.out.println("login");
            //System.out.println(vistaChat.getTxt_nombre().getText());
            // TCP (TODO): Solicita conexión con ServerSocket() de cada participante 

            model.login();
            model.setUser(vistaChat.getTxt_nombre().getText());
            model.multicastSender.send(vistaChat.getTxt_nombre().getText() + " ha hecho login.");
        });

        vistaChat.getBtn_logout().addActionListener((e) -> {
            
            model.multicastSender.send(vistaChat.getTxt_nombre().getText() + " ha abandonado el chat.");
            System.exit(0);

            // Send "X Ha salido del Chat"
            // Borrar al participante de la lista de participantes para que no se envíen
            // paquetes sin destino
            // La "X" del frame DEBERÁ EJECUTAR ESTE MÉTODO
            // System.exit(0);
        });

        vistaChat.getBtn_send().addActionListener( (e) -> sendMessage() );
        vistaChat.getTxt_mensaje().addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    e.consume();
                    sendMessage();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}

        });


    }

    public void sendMessage() {
        
        model.multicastSender.send(model.getUser() + ": " +  vistaChat.getTxt_mensaje().getText());

        vistaChat.getTxt_mensaje().setText("");    
    }



    //Se ejecuta cuando en Net llega un mensaje
    @Override
    public void update(IObservable observable) {
        //System.out.println("Controller NOTIFIED! without ARGS");        
    }

    @Override
    public void update(IObservable observable, Object args) {
        //System.out.println("Controller NOTIFIED! with ARGS");
        String msg = (String) args;    
        addMessageToGUI(msg);
    }

    //Método delegator
    public void addMessageToGUI(String msg ) {
        vistaChat.addMessageToGUI(msg);
    }

}
