package Motorphg7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class worktime_calculator {
    public static long hoursCalc(String timeIn, String timeOut ) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date in = format.parse(timeIn);
        Date out = format.parse(timeOut);
        long worksec = out.getTime() - in.getTime();
        long workhours = TimeUnit.MILLISECONDS.toHours(worksec);
        return workhours;
    }
}
