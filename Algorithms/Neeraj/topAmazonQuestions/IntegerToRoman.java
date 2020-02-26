import java.util.*;

public class IntegerToRoman{
  public static void main(String[] args) {
    System.out.println(intToRoman(3));
    System.out.println(intToRoman(4));
    System.out.println(intToRoman(9));
    System.out.println(intToRoman(58));
    System.out.println(intToRoman(1994));

    System.out.println(romanToInt("III"));
    System.out.println(romanToInt("IV"));
    System.out.println(romanToInt("IX"));
    System.out.println(romanToInt("LVIII"));
    System.out.println(romanToInt("MCMXCIV"));

  }
  public static String intToRoman(int num) {
    String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    int value = num;
    String op = "";
    for(int i = 0; i < romans.length ; i++){
      while(value/values[i] > 0){
        op += romans[i];
        value -= values[i];
      }
    }
    return op;
  }

  public static int romanToInt(String s) {
    List<String> romans = Arrays.asList(new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"});
    List<Integer> values = Arrays.asList(new Integer[]{1000,900,500,400,100,90,50,40,10,9,5,4,1});

    int index = 0, op =0, len = s.length();
    while(index < len){
      // First check of two strings are present.
      if(index + 2 <= len && romans.contains(s.substring(index, index+2))){
        op += values.get(romans.indexOf(s.substring(index, index+2)));
        index +=2;
      }else{
        op += values.get(romans.indexOf(s.substring(index, index+1)));
        index++;
      }
    }
    return op;
  }
}
