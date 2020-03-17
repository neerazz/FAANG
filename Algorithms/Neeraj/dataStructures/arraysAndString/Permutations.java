import java.util.*;

class Permutations {
  public static void main(String[] args) {
    System.out.println(getPermutations(Arrays.asList(1,2,3)));
    System.out.println(getPermutations(Arrays.asList(1,2)));
    System.out.println(powerset(Arrays.asList(1,2,3)));
  }
	static Set<List<Integer>> set;
  public static List<List<Integer>> getPermutations(List<Integer> array) {
    set = new HashSet<>();
    if(array.size() >0) {
			helper(array, new ArrayList<>());
		}
    return new ArrayList<>(set);
  }
	private static void helper(List<Integer> input, List<Integer> preVal){
		if(input.size() == 0){
			set.add(preVal);
		}
		for(int val: input){
			List<Integer> temp = new ArrayList<>(preVal);
			List<Integer> temp1 = new ArrayList<>(input);
			temp.add(val);
			temp1.remove((Integer) val);
			helper(temp1, temp);
		}
	}
  static Set<List<Integer>> set2;
  public static List<List<Integer>> powerset(List<Integer> array) {
    set2 = new HashSet<>();
    if(array.size() >0) {
			helper2(array, new ArrayList<>());
		}
    set2.add(array);
    return new ArrayList<>(set2);
  }
  private static void helper2(List<Integer> input, List<Integer> preVal){
    if(input.size() != 0){
      Collections.sort(preVal);
      set2.add(preVal);
    }
    for(int val: input){
      List<Integer> temp = new ArrayList<>(preVal);
      List<Integer> temp1 = new ArrayList<>(input);
      temp.add(val);
      temp1.remove((Integer) val);
      helper2(temp1, temp);
    }
  }
}
