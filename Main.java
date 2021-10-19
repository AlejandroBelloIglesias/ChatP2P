import java.net.InetAddress;

import Controllers.Controller;
import Models.*;
import Views.ChatEntry;
import Views.VistaChat;

public class Main {
    public static void main(String[] args) throws Exception{

        var model = new NetModel();
        var frame = new VistaChat();

        var c = new Controller(frame, model);
        model.addObserver(c);

    }   
}
