package Motorphg7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class totalhours_calculator {

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

    private static String padTime(String timeString) {
        String[] parts = timeString.split(":");
        String paddedHour = String.format("%02d", Integer.parseInt(parts[0]));
        return paddedHour + ":" + parts[1];
    }

    public static boolean workhoursCalculator(String id) throws NumberFormatException, ParseException, IOException {
        int ID = Integer.valueOf(id);
        File f = new File("attendance.txt");
        FileReader fr = new FileReader(f);
        int totalHours = 0; // Marvin starts changing here.
        try (BufferedReader br = new BufferedReader(fr)) {
            boolean found = false;
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                LocalTime timeIn = LocalTime.parse(padTime(einfo[4]), DateTimeFormatter.ofPattern("HH:mm")); // LocalTime Parse to change into time format. Unfortunately yong time is nag is hindi nag start sa 0 (zero) kaya need gumawa ng padding para malagyan ng zero sa harapan at ma parse ng maayos ng localtime parser
                LocalTime timeOut = LocalTime.parse(padTime(einfo[5]),DateTimeFormatter.ofPattern("HH:mm"));
                if (empid == ID) {
                    Duration duration = Duration.between(timeIn, timeOut);
                    int hours = (int) duration.toHours();
                    totalHours += hours; 
                    found = true;
                }

                
            } if (found) {
                System.out.println(totalHours); // Marvin ends changing here
                return true;
            } else {
                return false;
            }  
        }
    }
}
