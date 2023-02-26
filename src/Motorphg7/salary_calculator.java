package Motorphg7;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class salary_calculator {
    public static void entry() throws ParseException, NumberFormatException, IOException {
        System.out.println("Enter Employee Number or [0] to exit");
        Scanner sc = new Scanner(System.in);
        String empid = sc.nextLine();
        
        if (empid.equals("0")) {
            hr_portal.hrPortal();
        } else if (!workweek_empsearch.employeeDetails(empid)) {
                entry();
        } else {
            workweek_empsearch.workweekSearch(empid);
        }
        // workweek_empsearch.workweekSearch(empid);
        System.out.println("");
        System.out.println("Enter Payroll Month: ");
        System.out.println("[1] January");
        System.out.println("[2] February");
        System.out.println("[3] March");
        System.out.println("[4] April");
        System.out.println("[5] May");
        System.out.println("[6] June");
        System.out.println("[7] July");
        System.out.println("[8] August");
        System.out.println("[9] September");
        System.out.println("[10] October");
        System.out.println("[11] November");
        System.out.println("[12] December");
        String monthEntry = sc.nextLine();
        switch (monthEntry) {
            case "1" -> paymonth(empid, 1);
            case "2" -> paymonth(empid, 2);
            case "3" -> paymonth(empid, 3);
            case "4" -> paymonth(empid, 4);
            case "5" -> paymonth(empid, 5);
            case "6" -> paymonth(empid, 6);
            case "7" -> paymonth(empid, 7);
            case "8" -> paymonth(empid, 8);
            case "9" -> paymonth(empid, 9);
            case "10" -> paymonth(empid, 10);
            case "11" -> paymonth(empid, 11);
            case "12" -> paymonth(empid, 12);
            default -> {
                System.out.println("Please select a correct Input.");
                entry();
            }
        }
        sc.close();
    }

    public static void paymonth(String id, int month) throws ParseException, NumberFormatException, IOException {
        float rate = salary_helpers.rate(id);
        float pay = salary_helpers.payMonth(id, month);
        float pagibig = salary_helpers.pagibig();
        float philhealth = 100f;
        float annual = salary_helpers.salary(id) * 13;
        float sss = salary_helpers.sss(pay);
        float clothing = salary_helpers.clothing(id);
        float phone = salary_helpers.phone(id);
        float rice = salary_helpers.rice(id);
        float govDeductions = (pagibig + sss + philhealth) * 13;
        float benefits = clothing + phone + rice;
        float taxbase = annual  - govDeductions;
        float tax = salary_helpers.tax(taxbase);
        float deductions = tax + govDeductions;
        float total = pay + benefits - deductions;

        Double result = Double.valueOf(String.valueOf(total));
        System.out.println("Employee ID "+id);
        salary_helpers.employeeName(id);
        System.out.println("Rate: "+rate);
        System.out.println("Pay: "+pay);
        System.out.println("Annual: "+annual);
        System.out.println("Total Deductions: "+deductions+" SSS: "+sss+" HDMF: "+pagibig+" PhilHealth: "+philhealth+" Tax: "+tax);
        System.out.println("Total Benefits: "+benefits+" Clothing: "+clothing+" Phone: "+phone+" Rice: "+rice);
        System.out.println("Salary for Month " +month+" is: " + result);
        entry();
    }
}
