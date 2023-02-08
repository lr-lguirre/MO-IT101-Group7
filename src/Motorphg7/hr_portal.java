package Motorphg7;

import java.util.Scanner;

public class hr_portal {
    public static void hrPortal() {
        System.out.println("Welcome Lizette to Human Resource Portal!");
        System.out.println("Select HR function you wanted proceed");
        Scanner sc = new Scanner(System.in);
        System.out.println("[1] Employee Search");
        System.out.println("[2] Work Hours Calculator");
        String hr_function = sc.nextLine();
        switch (hr_function) {
            case "1" -> employee_search.employeeSearch();
            case "2" -> workhours_calculator.workhoursCalculator();
            default -> {
                System.out.println("Please select a correct HR function.");
                hrPortal();
            }
        }
        sc.close();
    }
}
