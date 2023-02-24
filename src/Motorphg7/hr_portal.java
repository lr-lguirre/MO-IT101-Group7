package Motorphg7;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class hr_portal {
    public static void hrPortal() throws ParseException, NumberFormatException, IOException {
        System.out.println("Welcome Lizette to Human Resource Portal!");
        System.out.println("Select HR function you wanted proceed");
        Scanner sc = new Scanner(System.in);
        System.out.println("[1] Employee Search");
        System.out.println("[2] Work Hours Calculator");
        System.out.println("[3] Work Week Calculator");
        System.out.println("[4] Exit");
        String hr_function = sc.nextLine();
        switch (hr_function) {
            case "1" -> employee_search.entry();
            case "2" -> workhours_calculator.entry();
            case "3" -> workweek_calculator.entry();
            case "4" -> exit.Exit();
            default -> {
                System.out.println("Please select a correct HR function.");
                hrPortal();
            }
        }
        sc.close();
    }
}
