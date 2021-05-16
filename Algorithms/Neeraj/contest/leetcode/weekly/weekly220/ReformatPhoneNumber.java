package weekly.weekly220;

/**
 * Created on:  Dec 19, 2020
 * Questions:
 */

public class ReformatPhoneNumber {

    public static void main(String[] args) {

    }

    public static String reformatNumber(String number) {
        String trimmed = number.replaceAll(" ", "").replaceAll("-", "");
        StringBuilder sb = new StringBuilder();
        int i = 0, len = trimmed.length();
        while (i < len - 4) {
            sb.append(trimmed.charAt(i++))
                    .append(trimmed.charAt(i++))
                    .append(trimmed.charAt(i++))
                    .append("-");
        }
        if (i + 4 == len) {
            sb.append(trimmed.charAt(i++)).append(trimmed.charAt(i++)).append("-").append(trimmed.charAt(i++)).append(trimmed.charAt(i++));
        }else if(i == len){
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.append(trimmed.substring(i));
        }
        return sb.toString();
    }
}
