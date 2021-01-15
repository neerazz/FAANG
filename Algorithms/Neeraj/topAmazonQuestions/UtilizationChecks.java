import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 14, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-utilization-checks
 */

public class UtilizationChecks {

    public static void main(String[] args) {
//        System.out.println(finalInstances(2, new int[]{25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80}));
        System.out.println(finalInstances(100000000, new int[]{30, 95, 4, 8, 19, 89}));
    }

    public static int finalInstances(int instances, int[] averageUtil) {
        int skip = 0;
        for (int avg : averageUtil) {
            if (skip > 0) {
                skip--;
            } else {
                int newInstance = instances;
                if (avg < 25) {
                    if (instances == 1) continue;
                    newInstance = (instances / 2) + (instances % 2);
                } else if (avg > 60) {
                    long doubled = instances * 2L;
                    newInstance = doubled > 2_0000_0000 ? instances : 2 * instances;
                }
                if (newInstance != instances) {
                    instances = newInstance;
                    skip = 10;
                }
            }
        }
        return instances;
    }
}
