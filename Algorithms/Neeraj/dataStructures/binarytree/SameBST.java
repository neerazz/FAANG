import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SameBST{
  public static void main(String[] args) {
    System.out.println(sameBsts(Arrays.asList(1,2,3,4,5,6,7),Arrays.asList(1,2,3,4,5,6,7)));
    System.out.println(sameBsts(Arrays.asList(5,2,-1,100,45,12,8,-1,8,10,15,8,12,94,81,2,-34),
                                Arrays.asList(5,8,10,15,2,8,12,45,100,2,12,94,81,-1,-1,-34,8)));
  }
  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
    if(arrayOne.size() != arrayTwo.size()) return false;
    Map<Integer,Integer> mapOne = new HashMap<>();
    for(int i : arrayOne){
      mapOne.put(i,mapOne.getOrDefault(i,0)+1);
    }
    Map<Integer,Integer> maptwo = new HashMap<>();
    for(int i : arrayTwo){
      maptwo.put(i,maptwo.getOrDefault(i,0)+1);
    }
    System.out.println("mapOne = " + mapOne);
    System.out.println("maptwo = " + maptwo);
    for(int i : mapOne.keySet()){
      if(maptwo.containsKey(i) && maptwo.get(i) == mapOne.get(i)){
        continue;
      }else{
        return false;
      }
    }
    return true;
  }
}
