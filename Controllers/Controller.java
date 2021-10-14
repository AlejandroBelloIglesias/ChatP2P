package Controllers;

import Views.VistaChat;
import Models.NetModel;

public class Controller {

    private NetModel model; 
    private VistaChat vistaChat; 

    public Controller(VistaChat vistaChat, NetModel model) {
        this.model = model;
        this.vistaChat = vistaChat;

        addListeners();
    }


    // ==== View Listeners ===
    public void addListeners () {

        vistaChat.getBtn_login().addActionListener(
            (e) -> {
                System.out.println("login");
                System.out.println(vistaChat.getTxt_nombre().getText());
                //Solicita conexión con ServerSocket() de cada participante
            }
        );

        vistaChat.getBtn_logout().addActionListener(
            (e) -> {
                System.out.println("logout"); 
                System.out.println(vistaChat.getTxt_nombre().getText());

                //Send "X Ha salido del Chat"
                //Borrar al participante de la lista de participantes para que no se envíen paquetes sin destino
                //La "X" del frame DEBERÁ EJECUTAR ESTE MÉTODO
                //System.exit(0);
            }
        );

        vistaChat.getBtn_send().addActionListener(
            (e) -> {
                System.out.println("send"); 
                System.out.println(vistaChat.getTxt_mensaje().getText());
            }
        );

    }


}
