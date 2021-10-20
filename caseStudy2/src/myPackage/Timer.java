package myPackage;
import java.util.Date; //importing all the packages required for Timer
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Timer {
    public static String Date_Time() // to get instantaneous system date as string
    {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy/HH:mm:ss");  
    Date date=new Date();
    return formatter.format(date).trim();//date as string
    }
    public static long tottime(String d1,String d2) throws ParseException // to give output in seconds
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy/HH:mm:ss");
            Date startDate = formatter.parse(d1);
            Date endDate = formatter.parse(d2);
            long diffInMilliSec = endDate.getTime() - startDate.getTime();
           long seconds = (diffInMilliSec / 1000) % 60;  
            long minutes = (diffInMilliSec / (1000 * 60)) % 60;
            long hours = (diffInMilliSec / (1000 * 60 * 60)) % 24;
            long days = (diffInMilliSec / (1000 * 60 * 60 * 24)) % 365;
            long years =  (diffInMilliSec / (1000l * 60 * 60 * 24 * 365));
           
            long Total_Time_hr=hours+days*24+years*365*24;
            long Total_Time_mins=Total_Time_hr*60+minutes;
            long Total_Sec=seconds+Total_Time_mins*60;
            
            return Total_Sec; //returns time in secs as long data type
        
    }
}
