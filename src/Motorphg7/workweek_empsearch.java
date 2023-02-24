package Motorphg7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class workweek_empsearch {
    public static boolean employeeDetails(String id) throws NumberFormatException, ParseException, IOException {
        int ID = Integer.valueOf(id);
        File f = new File("employeedetails.txt");
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
         boolean found = false;
         String line = "";
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                if (empid == ID) {
                    found = true;
                }
                if (found) {
                    return true;
                } else {
                    return false;
                }
            }   
        }
        return false;
    }

    public static void workweekNo (String id, String[] dates) {


    }

    public static void workweekSearch (String id) throws NumberFormatException, IOException, ParseException {
        int ID = Integer.valueOf(id);
        File f = new File("attendance.txt");
        FileReader fr = new FileReader(f);
        List<Set<Integer>> weekdays = new ArrayList<Set<Integer>>();
        Set<Integer> weeks = new HashSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        try (BufferedReader br = new BufferedReader(fr)) {
            String line = "";
            while ((line = br.readLine()) != null) {
                // boolean found = false;
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                String work_date = einfo[3];
                Date dt = sdf.parse(work_date);
                if ( empid == ID) {
                    // LocalDate weekYr = LocalDate.parse(work_date);
                    // int year = weekYr.getYear();
                    int weekNum = workweek_calculator.weekCalc(work_date);
                    weekdays.add(weekNum);
                    cal.setTime(dt);
                    cal.set(Calendar.WEEK_OF_YEAR, weekNum);
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    /* 
                    
                    
                    
                    System.out.println(weekStream[0]);
                    // System.out.println("Week Number: "+weekNum+" Monday: "+work_date+" ");
                    */
                } 
            }
          
        }
        System.out.println(weeks);  
    }
}
