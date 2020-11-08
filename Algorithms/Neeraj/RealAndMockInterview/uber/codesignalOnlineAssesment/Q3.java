package codesignalOnlineAssesment;

import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 08, 2020
 * Questions:
 *  Given an two dimensional array with black and white boxes (like chess) starting with black, and array of queries:
 *      Queries: Will have [x,y,w], Means starting from left top (x,y) position till the sub-array of w size.
 *          Sort all the black numbers, and white number independently.
 *          And replace the actual array with that number in an order.
 *
 *    1 2 3 4 5
 *    5 4 3 2 1
 *    4 3 2 1 5
 *    9 6 4 1 6
 *
 *    query: [1,1,3]:
 *      Means for the below sub-array:
 *              4 3 2
 *              3 2 1
 *              6 4 1
 *              black = 4,2,2,6,1,  sorted = [1,2,2,4,6]
 *              white = 3,3,1,4,    sorted = [1,3,3,4]
 *              take teh first value
 */

public class Q3 {

    public static void main(String[] args) {

    }
}
