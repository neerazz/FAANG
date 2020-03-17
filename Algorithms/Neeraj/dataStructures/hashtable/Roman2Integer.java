import java.util.*;

class Roman2Integer{
  public static void main(String[] args) {

  }
  public int romanToInt(String s) {
      Map<String,Integer> map = new HashMap<>();
      map.put("I",1);
      map.put("IV",4);
      map.put("V",5);
      map.put("IX",9);
      map.put("X",10);
      map.put("XL",40);
      map.put("L",50);
      map.put("XC",90);
      map.put("C",100);
      map.put("CD",400);
      map.put("D",500);
      map.put("CM",900);
      map.put("M",1000);
      int sum =0;
      while(s.length() > 0){
          if(s.length() > 1 && map.containsKey(s.substring(0,2))){
              sum += map.get(s.substring(0,2));
              s = s.substring(2);
          }else{
              sum += map.get(s.substring(0,1));
              s = s.substring(1);
          }
      }
      return sum;
  }
}
