import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class week {
    public static int weekCalc(String date ) throws ParseException {
        String format = "dd/MM/yyyy";
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date dt = df.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int weekNo = cal.get(Calendar.WEEK_OF_YEAR);
        return weekNo;
    }
    
    public static void main(String[] args) throws ParseException {
        int weekOf = weekCalc("01/01/2022");
        System.out.println(weekOf);
    }
}
