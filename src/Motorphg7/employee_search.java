package Motorphg7;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class employee_search {
    public static void entry() throws NumberFormatException, ParseException, IOException {
        System.out.println("Enter Employee Number");
        Scanner sc = new Scanner(System.in);
        String empid = sc.nextLine();
        if (!employee_details.employeeDetails(empid)) {
            entry();
        } else {
            hr_portal.hrPortal();
        }
        sc.close();
    }
    /* public static void employeeSearch() throws NumberFormatException, ParseException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        if (!employee_details.employeeDetails(id)) {


        };        
        scanner.close(); 
   } */
}
