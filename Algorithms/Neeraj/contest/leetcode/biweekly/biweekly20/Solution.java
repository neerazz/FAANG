package biweekly.biweekly20;

import java.util.*;

public class Solution{
  public static void main(String[] args) {
    // System.out.println(Arrays.toString(sortByBits(new int[]{0,1,2,3,4,5,6,7,8})));
    System.out.println(numberOfSubstrings("abcabc"));
//    System.out.println(countOrders(2));
  }

  static long result = 0;
  public static int countOrders(int n) {
    List<String> pickUps = new ArrayList<>();
    List<String> drops = new ArrayList<>();
    for (int i =0; i < n ; i++ ) {
      pickUps.add("P"+i);
      drops.add("D"+i);
    }
    performBackTracking(pickUps,drops);
    return (int)result;
  }

  public static void performBackTracking(List<String> pickUps,List<String> drops) {
    if(pickUps.size() == 0 && drops.size() == 0) {
      result++;
      return;
    }
    for(int i = 0 ; i < pickUps.size(); i++){
      String p = pickUps.get(i);
      pickUps.remove(p);
      if (drops.size() >= pickUps.size()) {
        performBackTracking(pickUps,drops);
      }
      pickUps.add(p);
    }
    for(int i = 0 ; i < drops.size(); i++){
      String d = drops.get(i);
      drops.remove(d);
      performBackTracking(pickUps,drops);
      drops.add(d);
    }
    System.out.println("pickUps = " + pickUps);
    System.out.println("drops = " + drops);
  }

  // Elegent solution: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516955/Java-ELEGANT-No-Sliding-Window-EXPLAINED-(No-of-Sub-Strings-Ending-at-Curr-Index)
  public static int numberOfSubstrings(String s) {
    int count =0, sec = 0;
    int[] var = {0,0,0};
    for(int i =0 ; i< s.length();i++){
      char cur = s.charAt(i);
      ++var[cur - 'a'];
      while (var[0] > 0 && var[1] > 0 && var[2] > 0) {
        // This will reduce the value at starting.
        // And increase the slider value by one.
        --var[s.charAt(sec++) - 'a'];
      }
      // Add the starting slider value to the count.
      // If none of them have all the values in the array. Then we get one more combination just by appending the current char.
      count += sec;
    }
    return count;
  }
  static Map<String,Integer> map = new HashMap<>();
  public static int numberOfSubstrings_Ordered(String s) {
    int count = 0;
    if (s == null || s.length() == 0) {
      return count;
    }
    HashSet<String> set = new HashSet<>();
    int index = 0;
    String cur = "";
    while(index < s.length()){
      cur += s.charAt(index);
      set.add(cur);
      int second = 0;
      String secondString = cur;
      while(second < secondString.length()){
        set.add(secondString.substring(second++));
      }
      index++;
    }
    for(String str : set){
      if(str.contains("a") && str.contains("b") && str.contains("c")){
        count++;
      }
    }
    // if (map.containsKey(s)) {
    //   int value = map.get(s);
    //   return value;
    // }
    // if(s.contains("a") && s.contains("b") && s.contains("c")){
    //   count++;
    // }
    // for(int i =0; i < s.length();i++){
    //   String one = s.substring(i+1);
    //   count += numberOfSubstrings(one);
    //   if (s.length()-i > 0) {
    //     String two = s.substring(i,s.length()-i);
    //     System.out.println("two : " + two);
    //     count += numberOfSubstrings(two);
    //   }
    // }
    // map.put(s,count);
    // System.out.println("S = " + s + " count =" + count + " map =" + map);
    return count;
  }

  public static  int[] sortByBits(int[] arr) {
    // Map<Integer,Integer> map = new HashMap<>();
    // for(Integer val : arr){
    //     byte cur = val.byteValue();
    // }
    // return arr;
    return Arrays.stream(arr).boxed().sorted((a,b) -> Integer.bitCount(a) == Integer.bitCount(b) ? a-b : Integer.bitCount(a) - Integer.bitCount(b)).mapToInt(Integer::intValue).toArray();
  }
  /*
  Input
  ["Cashier","getBill","getBill","getBill","getBill","getBill","getBill","getBill"]
  [[3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100]],[[1,2],[1,2]],[[3,7],[10,10]],[[1,2,3,4,5,6,7],[1,1,1,1,1,1,1]],[[4],[10]],[[7,3],[10,10]],[[7,5,3,1,6,4,2],[10,10,10,9,9,9,7]],[[2,3,5],[5,3,2]]]
  Output
  [null,500.0,4000.0,800.0,4000.0,4000.0,7350.0,2500.0]
  [null,500.00000,4000.00000,1600.00000,4000.00000,4000.00000,14700.00000,2500.00000]
  */
  static class Cashier {

    int counter;
    int n;
    double discount;
    Map<Integer, Integer> map ;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = (double) discount;
        counter = 0;
        map = new HashMap<>();
        for (int i =0; i < products.length ; i++) {
          map.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
      counter++;
      double total = 0.0;
      for(int i = 0; i<product.length;i++){
        total += map.get(product[i]) * amount[i];
      }
      // At teh end check if the customer is eligible for discount or not.
      if(counter == n){
        counter =0;
        total = total * (1-(discount/100));
      }
      return total;
    }
  }
}
