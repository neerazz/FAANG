import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Car Fueling - Implementation and Analysis

Given a number N which represents the total distance in km to be covered by a car on a single road.
There are N petrol pumps at a distance of 1 km each(1, 2, 3, ..N).
The capacity of the fuel tank of the car is such that at full tank it goes till a distance of K km.
The car has to compulsorily stop at M petrol tanks whose distance from the starting position is given as M integers.

The task is to find the number of times, the car has to refill its tank including the compulsory stops to complete its journey of N km.

Sample 1:
Input: N = 5, K = 2, M = 1
arr[] = {3}
Output: 2

Sample 2:
Input: N = 10, K = 2, M = 3
arr[] = { 6, 7, 8 }
Output: 5

Sample 3: (950 400 4 200 375 550 750)
Input: N=950
K=400
M=4
array[] = 200 375 550 750
Output: 2
Explanation
Steps:
Start from 0
loop from start to the total distance.
Again loop through all the fuel stations from current point, to the maximum point that can be travelled.

Sample 4: (700 200 4 100 200 300 400)
Input:
700
200
4
100 200 300 400
Output: -1
 */
public class Week3CarFueling {

    public static void main(String[] args) {
        int totalDistance = FastScan.nextInt();
        int capacityOfFuelTank = FastScan.nextInt();
        int numberOfPumps = FastScan.nextInt();
        int[] pumpsDistanceArray = new int[numberOfPumps];
        for (int i = 0; i < numberOfPumps; i++) {
            pumpsDistanceArray[i] = FastScan.nextInt();
        }
        System.out.println(minimumRefills(pumpsDistanceArray, capacityOfFuelTank, totalDistance));
//        System.out.println(minimumRefills2(pumpsDistanceArray, capacityOfFuelTank, totalDistance));
    }

    private static int minimumRefills2(int[] pumpsDistanceArray, int capacityOfFuelTank, int totalDistance) {
        int numberOfRefills = 0;
        int currentRefill = 0;
        int lastRefill = 0;
        int numberOfPumps = pumpsDistanceArray.length;

        while (currentRefill <= numberOfPumps) {
            lastRefill = currentRefill;
            while (currentRefill <= numberOfPumps && pumpsDistanceArray[currentRefill + 1] - pumpsDistanceArray[lastRefill] <= capacityOfFuelTank) {
                currentRefill++;
            }
            if (currentRefill == lastRefill) return -1;
            if (currentRefill <= numberOfPumps) numberOfRefills++;
        }
        return numberOfRefills;
    }

    private static int minimumRefills(int[] pumpsDistanceArray, int capacityOfFuelTank, int totalDistance) {
        int numberOfRefills = 0;
        int currentRefill = 0;
        int lastRefill = 0;
        int distanceCovered = 0;

//        Loop the total distance is covered.
        while (distanceCovered < totalDistance) {
            lastRefill = currentRefill;
            for (int j = currentRefill; j < pumpsDistanceArray.length; j++) {
                int currentDistance = pumpsDistanceArray[currentRefill];
                if ((currentDistance - distanceCovered) < capacityOfFuelTank) {
//                    If the difference between current point and distance covered is less than fuel capacity. Go to find the next best.
                    if (currentRefill == pumpsDistanceArray.length - 1) {
//                        You have reached to the end of fuel pump.
                        distanceCovered = currentDistance;
                        numberOfRefills++;
                        break;
                    }
                    currentRefill++;
                } else if ((currentDistance - distanceCovered) == capacityOfFuelTank) {
//                    If the difference is same then add a refill.
                    distanceCovered = currentDistance;
                    numberOfRefills++;
                    break;
                } else {
                    currentRefill--;
                    distanceCovered = pumpsDistanceArray[currentRefill];
                    numberOfRefills++;
                    break;
                }
            }
            if (lastRefill == currentRefill) return -1;
            if ((pumpsDistanceArray[currentRefill] + capacityOfFuelTank) >= totalDistance) break;
        }
        return numberOfRefills;
    }

    static class FastScan {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}