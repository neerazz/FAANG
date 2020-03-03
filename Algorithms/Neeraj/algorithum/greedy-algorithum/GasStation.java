
public class GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
        System.out.println(canCompleteCircuit(new int[]{3,3,4},new int[]{3,4,4}));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0; i< gas.length;i++){
            if(gas[i] >= cost[i] && backTracing(gas,cost,i+1,1,gas[i])){
                return i;
            }
        }
        return -1;
    }
    private static boolean backTracing(int[] gas, int[] cost, int index, int totalCovered, int tank){
        if(totalCovered == gas.length) return true;
        if(index >= gas.length) index = 0;
        int prevIndex = index-1 < 0? gas.length-1 : index-1;
        tank = tank - cost[prevIndex] + gas[index];
        if(tank >= cost[index]){
            return backTracing(gas,cost,index+1,totalCovered+1,tank);
        }
        return false;
    }
}
