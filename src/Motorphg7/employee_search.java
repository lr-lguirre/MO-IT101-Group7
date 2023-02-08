package Motorphg7;

import java.util.Scanner;

public class employee_search {
    public static void employeeSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        employee_details.employeeDetails(id);
        // try (BufferedReader br = new BufferedReader(new FileReader("employeedetails.csv"))) {
        
        scanner.close(); 
   }
}
