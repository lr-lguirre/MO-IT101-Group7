package Motorphg7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class authentication {
    public static void authuser(String uid, String passwd) {
        String fileName= "users.csv";
        File file= new File(fileName);
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;
        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
            }

            inputStream.close();    
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            
        }

        // the following code lets you iterate through the 2-dimensional array
        int lineNo = 1;
            for(List<String> line: lines) {
                int columnNo = 1;
                String uidAuth = line.toString();
                uidAuth = uidAuth.substring(1,uidAuth.length());
                // uidAuth = uidAuth.replace(" ", "");
                String[] uidArray = uidAuth.split(",");
                String uidRec = uidArray[0];
                // System.out.println(uidRec + uid);
                if ( uidRec.equals(uid)){
                    for (String value: line) {
                        if (value.equals(passwd)) {
                            //System.out.println(value);
                            // hr_portal.hrPortal();
                            continue;
                        }
                        columnNo++;
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
                        }
                        // break;//System.out.print(value);
                    }
                    break;
                }
                lineNo++;
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