package Views;

import java.awt.Color;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.colorchooser.*;
import javax.swing.plaf.ColorUIResource;

public class ChatEntry extends JPanel {

    private String user;
    Date date;
    String hour;
    String msg;
    DateFormat dateFormat;
    //color de fondo
    
  
    public ChatEntry (String msg) {

        super();

        this.add(new JLabel(msg));

        date = new Date();
        hour = LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute();
        this.msg = msg;

        dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);

        //Componentes
        this.setBackground(Color.CYAN);
    }


    // ==== GETTERS && SETTERS ====

    public String getFullMessage() {
        return dateFormat.format(date) + " " +hour+": " + msg;
    }
    
    public String getHour() {
        return hour;
    }

    public String getMessage() {
        return msg;
    }

    public String getDate() {
        return dateFormat.format(date);
    }

    public String getUser() {
        return user;
    }

    
  }