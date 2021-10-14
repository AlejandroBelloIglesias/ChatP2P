package Views;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;

public class VistaChat extends JFrame{

    JFrame ventana = new JFrame("Chat de Alecs Beio");
    JPanel panel;
    JPanel norte;
    JPanel centro;
    JPanel sur;
    JButton btn_login, btn_logout, btn_send;
    JTextField txt_nombre;
    JTextArea txt_mensaje;

    Vector vectorMensajes = new Vector();
    JList listaMensajes = new JList(vectorMensajes);
    JScrollPane scroll = new JScrollPane(listaMensajes);

    public VistaChat() {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creación de paneles
        panelPrincipal();
        panelNorte();
        panelCentro();
        panelSur();        

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
        //No hay, lol

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

    public Vector getVectorMensajes() {
        return vectorMensajes;
    }

    public void setVectorMensajes(Vector vectorMensajes) {
        this.vectorMensajes = vectorMensajes;
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

    


}