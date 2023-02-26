package Motorphg7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class salary_helpers {

    public static void employeeName(String id) throws NumberFormatException, ParseException, IOException {
        int ID = Integer.valueOf(id);
        File f = new File("employeedetails.txt");
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                String empName = (einfo[2] + " " + einfo[1]);
                String status = einfo[10];
                String position = einfo[11];
                if (empid == ID) {
                    System.out.println("Salary details for: "+empName);
                    System.out.println("Status: "+status);
                    System.out.println("Position: "+position);
                }
            }
        }
    }
    public static float rate(String id) throws NumberFormatException, ParseException, IOException {
        int ID = Integer.valueOf(id);
        float rate = 0f;
        File f = new File("employeedetails.txt");
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                if (empid == ID) {
                    rate = Float.parseFloat(einfo[18]);
                }
            }
        }
        return rate;
    }

    public static float payMonth(String id, int month) throws NumberFormatException, IOException, ParseException {
        int ID = Integer.valueOf(id);
        float pay = 0f;
        int Month = month;
        File f = new File("attendance.txt");
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line = "";
            while ((line = br.readLine()) != null) {
                // boolean found = false;
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                String work_date = einfo[3];
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                cal.setTime(sdf.parse(work_date));
                int mth = cal.get(Calendar.MONTH);
                String in = einfo[4];
                String out = einfo[5];
                if (empid == ID && mth == Month) {
                    long dayPay = workweek_calculator.hoursCalc(in, out);
                    pay = pay + dayPay;
                }
            }
        }
        // add paid weekends - 8 weekend days x 9 hours per day 
        pay = pay + 72;
        System.out.println("Total Monthly Hours: " +pay);
        float monthpay = (rate(id) * pay);
        return monthpay;
    }

    public static boolean isBetween(Float x, Float lower, Float upper) {
        return lower <= x && x <= upper;
    }

    public static float sss(Float monthly) {
        // based on SSS Schedule of deductions
        float deduction = 160f;
        if (monthly < 2250) {
            deduction = 160;
        } else if (isBetween(monthly, 2250f, 2749.99f)) {
            deduction = 200;
        } else if (isBetween(monthly, 2750f, 3249.99f)) {
            deduction = 240;
        } else if (isBetween(monthly, 3250f, 3749.99f)) {
            deduction = 280;
        } else if (isBetween(monthly, 3750f, 4249.99f)) {
            deduction = 320;
        } else if (isBetween(monthly, 4250f, 4749.99f)) {
            deduction = 360;
        } else if (isBetween(monthly, 4750f, 5249.99f)) {
            deduction = 400;
        } else if (isBetween(monthly, 5250f, 5749.99f)) {
            deduction = 440;
        } else if (isBetween(monthly, 5750f, 6249.99f)) {
            deduction = 480;
        } else if (isBetween(monthly, 6250f, 6749.99f)) {
            deduction = 520;
        } else if (isBetween(monthly, 6750f, 7249.99f)) {
            deduction = 560;
        } else if (isBetween(monthly, 7250f, 7749.99f)) {
            deduction = 600;
        } else if (isBetween(monthly, 7750f, 8249.99f)) {
            deduction = 640;
        } else if (isBetween(monthly, 8250f, 8749.99f)) {
            deduction = 680;
        } else if (isBetween(monthly, 8750f, 9249.99f)) {
            deduction = 720;
        } else if (isBetween(monthly, 9250f, 9749.99f)) {
            deduction = 760;
        } else if (isBetween(monthly, 9750f, 10249.99f)) {
            deduction = 800;
        } else if (isBetween(monthly, 10250f, 10749.99f)) {
            deduction = 840;
        } else if (isBetween(monthly, 10750f, 11249.99f)) {
            deduction = 880;
        } else if (isBetween(monthly, 11250f, 11749.99f)) {
            deduction = 920;
        } else if (isBetween(monthly, 11750f, 12249.99f)) {
            deduction = 960;
        } else if (isBetween(monthly, 12250f, 12749.99f)) {
            deduction = 1000;
        } else if (isBetween(monthly, 12750f, 13249.99f)) {
            deduction = 1040;
        } else if (isBetween(monthly, 13250f, 13749.99f)) {
            deduction = 1080;
        } else if (isBetween(monthly, 13750f, 14249.99f)) {
            deduction = 1120;
        } else if (isBetween(monthly, 14250f, 14749.99f)) {
            deduction = 1160;
        } else if (isBetween(monthly, 14750f, 15249.99f)) {
            deduction = 1200;
        } else if (isBetween(monthly, 15250f, 15749.99f)) {
            deduction = 1240;
        } else if (isBetween(monthly, 15750f, 16249.99f)) {
            deduction = 1280;
        } else if (isBetween(monthly, 16250f, 16749.99f)) {
            deduction = 1320;
        } else if (isBetween(monthly, 16750f, 17249.99f)) {
            deduction = 1360;
        } else if (isBetween(monthly, 17250f, 17749.99f)) {
            deduction = 1400;
        } else if (isBetween(monthly, 17750f, 18249.99f)) {
            deduction = 1440;
        } else if (isBetween(monthly, 18250f, 18749.99f)) {
            deduction = 1480;
        } else if (isBetween(monthly, 18750f, 19249.99f)) {
            deduction = 1520;
        } else if (isBetween(monthly, 19250f, 19749.99f)) {
            deduction = 1560;
        } else {
            deduction = 1600;
        }
        return deduction;
    }

    public static float pagibig() {
        float deduction = 100;
        return deduction;
    }

    public static float tax(Float annual) {
        // Annual based on basic salary x 13
        float deduction = 0f;
        float lower = 250000f;
        float excess = 0f;
        if (isBetween(annual, lower, 399999.99f)) {
            lower = 250000;
            excess = annual - lower;
            deduction = excess * .2f;
        } else if (isBetween(annual, 400000f, 799999.99f)) {
            lower = 400000;
            excess = annual - lower;
            deduction = ((excess * .25f) + 30000) / 13;
        } else if (isBetween(annual, 800000f, 1999999.99f)) {
            lower = 800000;
            excess = annual - lower;
            deduction = ((excess * .30f) + 130000) / 13;
        } else if (isBetween(annual, 2000000f, 7999999.99f)) {
            lower = 2000000;
            excess = annual - lower;
            deduction = ((excess * .32f) + 490000) / 13;
        } else {
            lower = 8000000;
            excess = annual - lower;
            deduction = ((excess * .32f) + 490000) / 13;
        }
        return deduction;
    }

    public static float rice(String id) throws NumberFormatException, ParseException, IOException {
        int ID = Integer.valueOf(id);
        float rate = 0;
        File f = new File("employeedetails.txt");
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                String salary = einfo[14];
                String result = null;
                result = salary.replace(",","");
                if (empid == ID) {
                    rate = Float.parseFloat(result);
                }
            }
        }
        return rate;
    }

    public static float salary(String id) throws NumberFormatException, ParseException, IOException {
        int ID = Integer.valueOf(id);
        float rate = 0;
        File f = new File("employeedetails.txt");
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                String salary = einfo[13];
                String result = null;
                result = salary.replace(",","");
                if (empid == ID) {
                    rate = Float.parseFloat(result);
                }
            }
        }
        return rate;
    }

    public static float phone(String id) throws NumberFormatException, ParseException, IOException {
        int ID = Integer.valueOf(id);
        float rate = 0;
        File f = new File("employeedetails.txt");
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                String salary = einfo[15];
                String result = null;
                result = salary.replace(",","");
                if (empid == ID) {
                    rate = Float.parseFloat(result);
                }
            }
        }
        return rate;
    }

    public static float clothing(String id) throws NumberFormatException, ParseException, IOException {
        int ID = Integer.valueOf(id);
        float rate = 0;
        File f = new File("employeedetails.txt");
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                String salary = einfo[16];
                String result = null;
                result = salary.replace(",","");
                if (empid == ID) {
                    rate = Float.parseFloat(result);
                }
            }
        }
        return rate;
    }
}
