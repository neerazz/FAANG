import java.util.LinkedHashMap;
import java.util.Map;

class IntegerToString {
    static Map<Integer, String> map = new LinkedHashMap<>();

    static {
        map.put(1000000000, "Billion ");
        map.put(1000000, "Million ");
        map.put(1000, "Thousand ");
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(1234567));
        System.out.println(numberToWords(1234567891));
        System.out.println(numberToWords(0));
        System.out.println(numberToWords(101));
        System.out.println(numberToWords(1000));
    }

    public static String getBelowTen(int num) {
        switch (num) {
            case 0:
                return "Zero ";
            case 1:
                return "One ";
            case 2:
                return "Two ";
            case 3:
                return "Three ";
            case 4:
                return "Four ";
            case 5:
                return "Five ";
            case 6:
                return "Six ";
            case 7:
                return "Seven ";
            case 8:
                return "Eight ";
            case 9:
                return "Nine ";
        }
        return "";
    }

    public static String getBelowTwenty(int num) {
        switch (num) {
            case 10:
                return "Ten ";
            case 11:
                return "Eleven ";
            case 12:
                return "Twelve ";
            case 13:
                return "Thirteen ";
            case 14:
                return "Fourteen ";
            case 15:
                return "Fifteen ";
            case 16:
                return "Sixteen ";
            case 17:
                return "Seventeen ";
            case 18:
                return "Eighteen ";
            case 19:
                return "Nineteen ";
        }
        return "";
    }

    public static String getBelowHundred(int num) {
        switch (num) {
            case 2:
                return "Twenty ";
            case 3:
                return "Thirty ";
            case 4:
                return "Forty ";
            case 5:
                return "Fifty ";
            case 6:
                return "Sixty ";
            case 7:
                return "Seventy ";
            case 8:
                return "Eighty ";
            case 9:
                return "Ninety ";
        }
        return "";
    }

    public static String getThreeDigit(int num) {
        int div = num / 100;
        int rem = num % 100;
        if (rem == 0) {
            return getWord(div) + "Hundred ";
        } else {
            return getWord(div) + "Hundred " + getWord(rem);
        }
    }

    private static String getTwoDigit(int num) {
        if (num < 20) {
            return getBelowTwenty(num);
        }
        int div = num / 10;
        int rem = num % 10;
        if (rem == 0) {
            return getBelowHundred(div);
        } else {
            return getBelowHundred(div) + getWord(rem);
        }
    }

    public static String numberToWords(int num) {
        StringBuilder output = new StringBuilder();
//        Map<Integer,String> map = getInitialMap();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (num >= entry.getKey()) {
                int div = num / entry.getKey();
                output.append(getWord(div)).append(entry.getValue());
                num %= entry.getKey();
            }
        }
        if (num != 0 || output.length() == 0) {
            output.append(getWord(num));
        }
        return output.toString().trim();
    }

    private static String getWord(int num) {
        if (num < 1000 && num >= 100) {
            return getThreeDigit(num);
        } else if (num < 100 && num >= 10) {
            return getTwoDigit(num);
        } else {
            return getBelowTen(num);
        }
    }
}
