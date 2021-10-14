import java.net.InetAddress;

import Controllers.Controller;
import Models.NetConnectionFinder;
import Models.NetModel;
import Views.VistaChat;

public class Main {
    public static void main(String[] args) throws Exception{

        var model = NetModel.getInstance();
        var frame = new VistaChat();

/*
        var netFinder = NetConnectionFinder.getInstance();
        netFinder.findLocalConnections(InetAddress.getLocalHost().getHostAddress(), "69lmao", 55555);
*/

        new Controller(frame, model);
        
        System.out.println("Test cambios");

    }   
}
