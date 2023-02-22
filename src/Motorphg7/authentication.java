package Motorphg7;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class authentication {
    public static String login(String username, String pass, String file) throws Exception {
        if (validaLogin(username, pass, file)) {
            System.out.println("Login successfully");
            switch(validAccess(username, pass, file)){
            case ("hr"):
                hr_portal.hrPortal();
                break;
            case ("employee"):
                employee_portal.employeePortal();
                break;
            case ("admin"):
                admin_portal.adminPortal();
                break;
            case ("Unauthorized"):
                authentication.authenticate();
                break;
        } 
        } else {
            System.out.println("Invalid Credentials");
        }
        return file;

    }
    public static boolean validaLogin(String user, String pass, String file) {
        boolean sucess = false;
        Map<String, String> mapUser = new HashMap();
        getLines(file).forEach(l -> {
            String[] strs = l.split(",");
           // System.out.println(mapUser);
            mapUser.put(strs[0], strs[1]);
        });
        if (mapUser.containsKey(user)) {
            return mapUser.get(user).equals(pass);
        }
        return sucess;
    }

    public static String validAccess(String user, String pass, String file) {
        Map<String, String> mapUser = new HashMap();
        getLines(file).forEach(l -> {
            String[] strs = l.split(",");
            //System.out.println(mapUser);
            mapUser.put(strs[0], strs[2]);
        });
        if (mapUser.containsKey(user)) {
            String authkey = mapUser.getOrDefault(user, pass);
            System.out.println(authkey);
            return authkey;
        }
        return "Unauthorized";
    }
    
    public static List<String> getLines(String path) {
        List<String> lines = new ArrayList();
        try {
            lines = Files.readAllLines(new File(path).toPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lines;
    }

    public static void authenticate() throws Exception {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String uid = myObj.nextLine();
        System.out.println("Input Password: ");
        String passwd = myObj.nextLine();
        login(uid, passwd, "users.csv");
        myObj.close();
    }
}
