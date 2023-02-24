package Motorphg7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class workweek_empsearch {
    public static boolean employeeDetails(String id) throws NumberFormatException, ParseException, IOException {
        int ID = Integer.valueOf(id);
        File f = new File("employeedetails.txt");
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
         String line = "";
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                if (empid == ID) {
                    return true;
                }
            }   
        }
        return false;
    }

    public static void workweekSearch (String id) throws NumberFormatException, IOException, ParseException {
        int ID = Integer.valueOf(id);
        File f = new File("attendance.txt");
        FileReader fr = new FileReader(f);
        Map<Integer, String> weeks = new HashMap<Integer, String>();
        try (BufferedReader br = new BufferedReader(fr)) {
            String line = "";
            while ((line = br.readLine()) != null) {
                // boolean found = false;
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                String work_date = einfo[3];
                
                if ( empid == ID ) {
                    int weekNum = workweek_calculator.weekCalc(work_date);
                    Integer weekNo = Integer.valueOf(weekNum);
                    weeks.put(weekNo,work_date);
                    // System.out.println(weekNo);
                        // System.out.println(work_date);         
                } 
            }
        }
        TreeMap<Integer, String> sorted = new TreeMap<>(weeks); 
        Set<Entry<Integer, String>> mappings = sorted.entrySet();
        for (Entry<Integer, String> mapping: mappings ) {
           // System.out.println("Week Number: "+mapping.getKey() +" Start of Week: "+ mapping.getValue()); 
        }
    }
}
