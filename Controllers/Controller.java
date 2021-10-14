package Controllers;

import Views.VistaChat;
import Models.NetModel;

public class Controller {

    private static Controller controller;

    private NetModel model; 
    private VistaChat vistaChat; 

    // ==== Initialazers ====
    private Controller(VistaChat vistaChat, NetModel model) {
        this.model = model;
        this.vistaChat = vistaChat;

        addListeners();
    }

    public static Controller createInstance(VistaChat vistaChat, NetModel model) {
        controller = new Controller(vistaChat, model);
        return controller;
    }
    public static Controller getInstance() {
        return controller;
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
