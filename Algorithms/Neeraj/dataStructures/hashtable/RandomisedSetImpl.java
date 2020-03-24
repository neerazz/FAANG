import java.util.*;

class RandomisedSetImpl{
  public static void main(String[] args) {

  }
}
class RandomizedSet {

    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        int idx = list.size();
        map.put(val,idx);
        list.add(idx,val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
//         Get the last item index.
        int idx = map.get(val);
        int size = list.size();

//         Get the last item value
        int lastItem = list.get(size-1);

//         Set the last item at the index.
        list.set(idx,lastItem);

//         Update the map with index value
        map.put(lastItem,idx);

//         remove the last item from list and the val from map.
        list.remove(size-1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
