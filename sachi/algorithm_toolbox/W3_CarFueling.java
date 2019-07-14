import java.util.Scanner;

/*
You are going to travel to another city that is located 𝑑 miles away from your home city. 
Your can can travel at most 𝑚 miles on a full tank and you start with a full tank. 
Along your way, there are gas stations at distances stop1, stop2, . . . , stop𝑛 from your home city. 
What is the minimum number of refills needed?

Input Format. The first line contains an integer 𝑑. The second line contains an integer 𝑚. 
The third line specifies an integer 𝑛. Finally, the last line contains integers stop1, stop2, . . . , stop𝑛.
Input Format. Assuming that the distance between the cities is 𝑑 miles, a car can travel at most 𝑚 miles on a full tank, 
and there are gas stations at distances stop1 , stop2 , . . . , stop𝑛 along the way, output the minimum number of refills needed. 
Assume that the car starts with a full tank. If it is not possible to reach the destination, output −1.
*/

public class W3_CarFueling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
        System.out.println(computeMinRefills(dist, tank, stops));
        scanner.close();
    }

    private static int computeMinRefills(int dist, int tank, int[] stops) {

        int refills = 0, previousStopIndex = 0, distanceTravelled = 0;
        boolean gasFound;

        //Cannot reach first stop
        if (tank < stops[0]) {
            return -1;
        }

        //No need to refill
        if(tank >= dist){
            return 0;
        }

        while (distanceTravelled < dist && previousStopIndex < stops.length) {
            gasFound = false;
            for (int i = previousStopIndex; i < stops.length; i++) {
                if (stops[i] <= tank + distanceTravelled) {
                    previousStopIndex = i;
                    gasFound = true;
                } else {
                    break;
                }
            }
            if (gasFound) {
                refills++;
                distanceTravelled = stops[previousStopIndex++];
                if (dist - distanceTravelled <= tank) {
                    return refills;
                }
            } else {
                return -1;
            }
        }
        return -1;
    }
}