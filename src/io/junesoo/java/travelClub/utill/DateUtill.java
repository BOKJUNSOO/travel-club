package io.junesoo.java.travelClub.utill;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtill {
    public static String today(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format((Calendar.getInstance().getTime()));
    }

    public static String today(){
        return today("yyyy.MM.dd");
    }
}
