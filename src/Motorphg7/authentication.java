package Motorphg7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class authentication {
    public static void authuser(String uid, String passwd) {
        Scanner sc;
        try {
            sc = new Scanner(new File("users.csv"));
            sc.useDelimiter(",");   //sets the delimiter pattern  
            while (sc.hasNext()) {
            System.out.print(sc.next());
        } 
        sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        
    }

    public static void authenticate() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String uid = myObj.nextLine();
        System.out.println("Input Password: ");
        String passwd = myObj.nextLine();
        authuser(uid, passwd);
        myObj.close();
    }
    
}