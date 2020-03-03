import java.util.*;

class DroneFlightPlanner{
    static int calcDroneMinEnergy(int[][] route) {
      // your code goes here
      int len = route.length, cost = Integer.MAX_VALUE, current = 0;
      if(len > 0){
        //current = route[0][2];
        for(int i= 1 ; i < len ; i++){
          int pre = route[i-1][2], cur = route[i][2];
          if( pre > cur){
            //I am gaining
            current += pre - cur;
          }else if(cur > pre){
            //I am losing energy
            current -= cur -pre;
          }else{
            continue;
          }
          // Check if the current value goes below zero.
          if(current < 0){
            cost = Math.min(cost,current);
          }
        }
      }
      return cost == Integer.MAX_VALUE ? 0 : cost * -1;
    }

  public static void main(String[] args) {
    System.out.println(calcDroneMinEnergy(new int[][]{{0,2,10},{3,5,0},{9,20,6},{10,12,15},{10,10,8}}));
  }
}
