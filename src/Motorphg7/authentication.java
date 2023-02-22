package Motorphg7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class authentication {
   // private static final String Lang = null;
    // Method to return an array of the users file
    private List<List<String>> authuser() throws Exception {
        String fileName= "users.csv";
        File file= new File(fileName);
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;
        try{
            // deepcode ignore DontCloseInTry: <please specify a reason of ignoring this>
            inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
        return lines;     
    }
    // the following code lets you iterate through the 2-dimensional array
     private static String authorize(String uid, String passwd) throws Exception{   
        // int lineNo = 1;
        authentication auth = new authentication();
        List<List<String>> lines = auth.authuser();
        // int columnNo = 1;
            for(List<String> line: lines) {
                String uidAuth = line.toString();
                uidAuth = uidAuth.substring(1,uidAuth.length());
                String[] uidArray = uidAuth.split(",");
                String uidRec = uidArray[0];
                if ( uidRec.equals(uid)){
                    for (String value: line) {
                        if (value.equals(passwd)) {
                            return value;
                        } else {
                            value = "unauth";
                            return value;
                        }
                    }
                } else {
                    String value = "unauth";
                    return value;
                }
                // lineNo++;
            }
            String value = "unauth";
            return value;
    }


    public static void authenticate() throws Exception {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String uid = myObj.nextLine();
        System.out.println("Input Password: ");
        String passwd = myObj.nextLine();
        String value = authorize(uid, passwd);
        switch(value){
            case ("hr"):
                hr_portal.hrPortal();
                break;
            case ("employee"):
                employee_portal.employeePortal();
                break;
            case ("admin"):
                admin_portal.adminPortal();
                break;
            case ("unauth"):
                authorize(uid,passwd);
                break;
        }
        myObj.close();
    }
    
}