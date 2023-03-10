package Motorphg7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class employee_details {
    
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
                    String empName = (einfo[2] + " " + einfo[1]);
                    String empBdate = einfo[3];
                    String empAddress = einfo[4];
                    String empPhone = einfo[5];
                    String empSSS = einfo[6];
                    String empPhilhealth = einfo[7];
                    String empTIN = einfo[8];
                    String empPagibig = einfo[9];
                    String empStatus = einfo[10];
                    String empPosition = einfo[11];
                    String empSupervisor = einfo[12];
                    String empSalary = einfo[13];
                    String empRice = einfo[14];
                    String empPhoneAllowance = einfo[15];
                    String empClothing = einfo[16];
                    String empSemi = einfo[17];
                    String empRate = einfo[18];
                    System.out.println("EID: " + id);
                    System.out.println("Employee Name: " + empName);
                    System.out.println("Birthdate: " + empBdate);
                    System.out.println("Address: " + empAddress);
                    System.out.println("Phone Number: " + empPhone);
                    System.out.println("SSS ID: " + empSSS);
                    System.out.println("PhilHealth: " + empPhilhealth);
                    System.out.println("TIN ID: " + empTIN);
                    System.out.println("Pag Ibig ID: " + empPagibig);
                    System.out.println("Status: " + empStatus);
                    System.out.println("Position: " + empPosition);
                    System.out.println("Immediate Supervisor: " + empSupervisor);
                    System.out.println("Basic Salary: " + empSalary);
                    System.out.println("Rice Subsidy: " + empRice);
                    System.out.println("Phone Allowance: " + empPhoneAllowance);
                    System.out.println("Clothing Allowance: " + empClothing);
                    System.out.println("Gross Semi-monthly Rate: " + empSemi);
                    System.out.println("Hourly Rate: " + empRate);
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
    
}
