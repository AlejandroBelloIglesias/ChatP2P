import java.net.InetAddress;

import Controllers.Controller;
import Models.NetConnectionFinder;
import Models.NetModel;
import Views.VistaChat;

public class Main {
    public static void main(String[] args) throws Exception{

        var model = NetModel.getInstance();
        var frame = new VistaChat();

        /**
         * QUIERO COMUNICACIÓN BIDIRECCIONAL ENTRE M-V-C
         * A referencia a B 
         * B referencia a A
         * 
         * B referencia a C
         * C referencia a B
         * 
         * A NO referencia a C
         * C NO referencia a A
         * 
         * repasar:
         * Composición-agregación (herencia)?
         *  
         */


/*
        var netFinder = NetConnectionFinder.getInstance();
        netFinder.findLocalConnections(InetAddress.getLocalHost().getHostAddress(), "69lmao", 55555);
*/


        //TESTTTTTTTT
        Controller.createInstance(frame, model);
        
        System.out.println("Test cambios");

    }   
}
