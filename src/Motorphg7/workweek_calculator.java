package Motorphg7;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.Set;

public class workweek_calculator {
    public static void entry() throws ParseException, NumberFormatException, IOException {
        System.out.println("Enter Employee Number");
        Scanner sc = new Scanner(System.in);
        String empid = sc.nextLine();
        if (!workweek_empsearch.employeeDetails(empid)) {
            entry();
        } else {
            workweek_empsearch.workweekSearch(empid);
        }
        workweek_empsearch.workweekSearch(empid);
        System.out.println("");
        System.out.println("Enter Workweek Number: ");
        System.out.println("");
        String weekNo = sc.nextLine();        
        sc.close();
    }

    public static long hoursCalc(String timeIn, String timeOut) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date in = format.parse(timeIn);
        Date out = format.parse(timeOut);
        long worksec = out.getTime() - in.getTime();
        long workhours = TimeUnit.MILLISECONDS.toHours(worksec);
        return workhours;
    }

    public static int weekCalc(String date ) throws ParseException {
        String format = "dd/MM/yyyy";
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date dt = df.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int weekNo = cal.get(Calendar.WEEK_OF_YEAR);
        return weekNo;
    }
}
