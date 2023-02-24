package Motorphg7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class workhours_calculator {
    public static void entry() throws ParseException, NumberFormatException, IOException {
        System.out.println("Enter Employee Number");
        Scanner sc = new Scanner(System.in);
        String empid = sc.nextLine();
        if (!workhoursCalculator(empid)) {
            entry();
        } else {
            hr_portal.hrPortal();
        }
        sc.close();
    }
    public static boolean workhoursCalculator(String id) throws NumberFormatException, ParseException, IOException {
        int ID = Integer.valueOf(id);
        File f = new File("attendance.txt");
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
            boolean found = false;
            String line = "";
            Map<String, Long> workweek = new HashMap<String, Long>();
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                String work_date = einfo[3];
                String timeIn = einfo[4];
                String timeOut = einfo[5];
                if (empid == ID) {
                    long worked_hours = worktime_calculator.hoursCalc(timeIn, timeOut);
                    workweek.put(work_date, worked_hours);
                    found = true;
                }
            } if (found) {
                System.out.println(workweek);
                return true;
            } else {
                return false;
            }
        }
    }
}

