package Motorphg7;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class authentication {
    public static void readCSV(String uid, String passwd) {
        try (
            BufferedReader br = new BufferedReader(new FileReader("motorphg7\\users.csv"))) {
            String line;
            HashMap<String, String> userList = new HashMap<String, String>();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                userList.put(values[0],values[1]);
            }
            br.close();
            String entry = userList.get(uid);
            if (entry.equals(passwd)) {
                System.out.println("Authenticated!");
            } else {
                System.out.println("Not authorized!");
            }
        } catch (IOException e) {
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
        readCSV(uid, passwd);
        myObj.close();
    }
    
}