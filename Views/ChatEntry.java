package Views;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class ChatEntry {

    private String user;
    Date date;
    String hour;
    String msg;
    DateFormat dateFormat;
  
    public ChatEntry (String msg) {

        date = new Date();
        hour = LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute();
        this.msg = msg;

        dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);

        System.out.println( dateFormat.format(date) + " " +hour+": " + msg);
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