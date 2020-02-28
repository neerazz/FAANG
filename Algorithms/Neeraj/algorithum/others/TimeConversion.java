package algorithms;

import java.util.IllegalFormatException;

public class TimeConversion {
    public static void main(String[] args) {
        System.out.println(timeConversion("07:05:45PM"));
        System.out.println(timeConversion("12:45:54PM"));
    }
    static String timeConversion(String s) {
        if (s.length() == 10){
            String hour = s.substring(0,2);
            if (s.charAt(8) == 'P'){
                if (hour.equals( "12")){
                    return s.substring(0,8);
                }
                String converted = String.format("%2d", Integer.parseInt(hour) + 12 );
                return converted + s.substring(2,8);
            }else {
                if (hour.equals( "12")){
                    return "00" + s.substring(2,8);
                }
                return s.substring(0,8);
            }
        }
        throw new IllegalArgumentException("Kindly provide input in hh:mm:ssAM/PM format");
    }
}
