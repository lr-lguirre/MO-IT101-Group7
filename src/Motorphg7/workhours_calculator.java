package Motorphg7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class workhours_calculator {
    public static void workhoursCalculator() {
        
        System.out.println("Please enter the work hours per day.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Sunday:");
        int sun = sc.nextInt();
        System.out.println("Monday:");
        int mon = sc.nextInt();
        System.out.println("Tuesday:");
        int tue = sc.nextInt();
        System.out.println("Wednesday:");
        int wed = sc.nextInt();
        System.out.println("Thursday:");
        int thu = sc.nextInt();
        System.out.println("Friday:");
        int fri = sc.nextInt();
        System.out.println("Saturday:");
        int sat = sc.nextInt();
        int work_hours = sun + mon + tue + wed + thu + fri + sat;
        System.out.println("The total working hours this week is:" +work_hours);
        sc.close();

        try {
            File f = new File("attendance.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            ArrayList<String> workweek = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                if (einfo[0].equals(id)) {

                }
            } 
            
            br.close();
        } 
        catch(IOException e) {

        }
    }
}
