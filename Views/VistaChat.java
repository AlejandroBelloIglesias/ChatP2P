package Views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;
import java.net.InetAddress;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class VistaChat extends JFrame{

    private JFrame ventana = new JFrame("er cha v1.1");
    private JPanel panel;
    private JPanel norte, centro, sur, este, oeste;
    private JButton btn_login, btn_logout, btn_send;
    private JTextField txt_nombre;
    private JTextArea txt_mensaje;
    private JList<String> txt_onlineUsers;

    //Mensajes
    private ArrayList<ChatEntry> entriesArrayList;
    private JList<ChatEntry> listaMensajes;
    private JScrollPane scroll;
    
    private JTextPane chatTextPane = new JTextPane();

    // ==== __INIT __ ====

    public VistaChat() {
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        chatTextPane.setEditable(false);

        //Creación de paneles
        panelPrincipal();
        panelNorte();
        panelCentro();
        panelSur();
        panelEste();

        logout();

        ventana.pack();
        ventana.setSize(600, 600);

        ventana.setVisible(true);
    }

    // ==== PANELES ====

    public void panelPrincipal(){
        // Panel principal
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        ventana.add(panel);
    }

    public void panelNorte() {

        // Panel del Norte
        norte = new JPanel();
        norte.setLayout(new BoxLayout(norte, BoxLayout.X_AXIS));
        norte.setBorder(BorderFactory.createTitledBorder("Login"));

        // Contenido del panel Norte
        txt_nombre = new JTextField();
        btn_login = new JButton("Login");
        btn_logout = new JButton("Logout");
        
        norte.add(txt_nombre);
        norte.add(btn_login);
        norte.add(btn_logout);

        panel.add(norte, BorderLayout.NORTH);
    }

    public void panelCentro(){
        // Panel del Centro
        centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.X_AXIS));
        centro.setBorder(BorderFactory.createTitledBorder("Chat"));

        // Contenido del panel Centro
/*
        entriesArrayList = new ArrayList<>();
        listaMensajes = new JList<ChatEntry>( new Vector(entriesArrayList) ); //
        */
        scroll = new JScrollPane(chatTextPane);
        chatTextPane.setEnabled(false);

        //centro.add(scroll); //Voy a usar simplemente un textfield
        centro.add(scroll);
        

        panel.add(centro, BorderLayout.CENTER);
    }

    public void panelSur () {
        
        // Panel del Sur
        sur = new JPanel();
        sur.setLayout(new BoxLayout(sur, BoxLayout.X_AXIS));
        sur.setBorder(BorderFactory.createTitledBorder("Enviar"));

        // Contenido del panel Sur
        txt_mensaje = new JTextArea();
        txt_mensaje.setRows(3);
        txt_mensaje.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        sur.add(txt_mensaje);

        btn_send = new JButton("Enviar");
        sur.add(btn_send);

        panel.add(sur, BorderLayout.SOUTH);
    }

    public void panelEste () {
        
        // Panel del Este
        este = new JPanel();
        este.setLayout(new BoxLayout(este, BoxLayout.Y_AXIS));
        este.setBorder(BorderFactory.createTitledBorder("Online"));
        este.setMaximumSize( new Dimension(400, 9999) );

        // Contenido del panel este
        txt_onlineUsers = new JList<String>();


        este.add(txt_onlineUsers);        

        panel.add(este, BorderLayout.EAST);
    }

    public void addMessageToGUI(String msg) {

        centro.add(scroll);
        chatTextPane.setText( chatTextPane.getText() + "\n" + msg);


        //vistaChat.getEntries().add( new ChatEntry(msg) );
        //SwingUtilities.updateComponentTreeUI(vistaChat.getListaMensajes());
        
        //SIMPLIFICAR: SI SE CAMBIA ALGO DE LA VISTA ESTO DEBERÍA QUEDARSE IGUAL
    }

    public void login () {
        btn_logout.setEnabled(true);
        chatTextPane.setEnabled(true);
        txt_mensaje.setEnabled(true);
        btn_send.setEnabled(true);

        ventana.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        btn_login.setEnabled(false);

    }

    public void logout() {
        btn_logout.setEnabled(false);
        chatTextPane.setEnabled(false);
        txt_mensaje.setEnabled(false);
        btn_send.setEnabled(false);

        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

        btn_login.setEnabled(true);
    }

    // ==== Getters && Setters ====

    public JFrame getVentana() {
        return ventana;
    }

    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getNorte() {
        return norte;
    }

    public void setNorte(JPanel norte) {
        this.norte = norte;
    }

    public JPanel getCentro() {
        return centro;
    }

    public void setCentro(JPanel centro) {
        this.centro = centro;
    }

    public JPanel getSur() {
        return sur;
    }

    public void setSur(JPanel sur) {
        this.sur = sur;
    }

    public JButton getBtn_login() {
        return btn_login;
    }

    public void setBtn_login(JButton btn_login) {
        this.btn_login = btn_login;
    }

    public JButton getBtn_logout() {
        return btn_logout;
    }

    public void setBtn_logout(JButton btn_logout) {
        this.btn_logout = btn_logout;
    }

    public JButton getBtn_send() {
        return btn_send;
    }

    public void setBtn_send(JButton btn_send) {
        this.btn_send = btn_send;
    }

    public JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public void setTxt_nombre(JTextField txt_nombre) {
        this.txt_nombre = txt_nombre;
    }

    public JTextArea getTxt_mensaje() {
        return txt_mensaje;
    }

    public void setTxt_mensaje(JTextArea txt_mensaje) {
        this.txt_mensaje = txt_mensaje;
    }

    /*
    public Vector getVectorMensajes() {
        return vectorMensajes;
    }

    public void setVectorMensajes(Vector vectorMensajes) {
        this.vectorMensajes = vectorMensajes;
    }
*/
    public ArrayList<ChatEntry> getEntries() {
        return entriesArrayList;
    }

    public JList getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(JList listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public void updateOnlineUsers(Map<InetAddress,String> onlineUsers) {

        este.remove(txt_onlineUsers);

        //onlineUsers.keySet().toArray();
        String[] ips = new String[onlineUsers.size()];

        Object[] ips_raw = onlineUsers.keySet().toArray();

        for (int i=0; i<onlineUsers.size(); i++) {
            ips[i] = ips_raw[i].toString();
        }

        txt_onlineUsers = new JList<String>( ips );
        
        este.add(txt_onlineUsers);
        
        System.out.println("Usuarios online: " + onlineUsers); 
    }

    


}