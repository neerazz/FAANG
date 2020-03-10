import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MyHashMap{

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        //--------- MAP WRITE METHODS --------------------------------
        map.put(1,"Sachin");             //Add to map
        map.putIfAbsent(1, "No Overwriting");  //Add if does not exist
        map.putAll(new HashMap<>());           //Add map 2 to map 1

        //--------- MAP READ METHODS --------------------------------
        map.get(1);                                 //Get from map
        map.getOrDefault(1,"-1"); //Get or default

        //--------- MAP ITERATE -------------------------------------
        for(Integer i : map.keySet()){ }                                //Iterate over keys
        for(String s : map.values()){ }                                 //Iterate over values
        for(Map.Entry<Integer, String> entries: map.entrySet()){ }      //Iterate over values



    }

}