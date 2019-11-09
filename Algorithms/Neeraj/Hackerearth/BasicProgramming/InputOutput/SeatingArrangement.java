package BasicProgramming.InputOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/
Akash and Vishal are quite fond of travelling. They mostly travel by railways. They were travelling in a train one day and they got interested in the seating arrangement of their compartment. The compartment looked something like
So they got interested to know the seat number facing them and the seat type facing them. The seats are denoted as follows :
Window Seat : WS
Middle Seat : MS
Aisle Seat : AS
You will be given a seat number, find out the seat number facing you and the seat type, i.e. WS, MS or AS.
INPUT: First line of input will consist of a single integer T denoting number of test-cases. Each test-case consists of a single integer N denoting the seat-number.
OUTPUT: For each test case, print the facing seat-number and the seat-type, separated by a single space in a new line.
CONSTRAINTS
1<=T<=105
1<=N<=108
SAMPLE INPUT
2
18
40
SAMPLE OUTPUT
19 WS
45 AS
 */
public class SeatingArrangement {
    static Map<Integer, OppositeFacingObject> seatMapping = new HashMap<>();

    public static void main(String[] args) {
        populateSeats();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        printOppositeSeat(nums);
        for (int i = 0; i < n; i++) {
            System.out.println(facingSeat_elegent(scanner.nextInt()));
        }
    }

    private static void printOppositeSeat(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int remainder = cur % 12;
            int divedent = cur / 12;
            OppositeFacingObject oppositeFacingObject = seatMapping.get(remainder);
            int oppositeSeat = remainder == 0 ? oppositeFacingObject.oppositeSeatNumber + (divedent - 1) * 12 : oppositeFacingObject.oppositeSeatNumber + divedent * 12;
            System.out.println(oppositeSeat + " " + oppositeFacingObject.currentSeatDenotion);
        }
    }

    private static String facingSeat_elegent(int seatNumber) {
        int originalNumber = seatNumber;
        String result = "";
        seatNumber = seatNumber % 12;

        switch (seatNumber) {
            case 1:
                result += (originalNumber + 11) + " WS";
                break;
            case 2:
                result += (originalNumber + 9) + " MS";
                break;
            case 3:
                result += (originalNumber + 7) + " AS";
                break;
            case 4:
                result += (originalNumber + 5) + " AS";
                break;
            case 5:
                result += (originalNumber + 3) + " MS";
                break;
            case 6:
                result += (originalNumber + 1) + " WS";
                break;
            case 7:
                result += (originalNumber - 1) + " WS";
                break;
            case 8:
                result += (originalNumber - 3) + " MS";
                break;
            case 9:
                result += (originalNumber - 5) + " AS";
                break;
            case 10:
                result += (originalNumber - 7) + " AS";
                break;
            case 11:
                result += (originalNumber - 9) + " MS";
                break;
            case 0:
            case 12:
                result += (originalNumber - 11) + " WS";
                break;
        }
        return result;
    }

    private static void populateSeats() {
        seatMapping.put(1, new OppositeFacingObject("WS", 12));
        seatMapping.put(2, new OppositeFacingObject("MS", 11));
        seatMapping.put(3, new OppositeFacingObject("AS", 10));
        seatMapping.put(4, new OppositeFacingObject("AS", 9));
        seatMapping.put(5, new OppositeFacingObject("MS", 8));
        seatMapping.put(6, new OppositeFacingObject("WS", 7));
        seatMapping.put(7, new OppositeFacingObject("WS", 6));
        seatMapping.put(8, new OppositeFacingObject("MS", 5));
        seatMapping.put(9, new OppositeFacingObject("AS", 4));
        seatMapping.put(10, new OppositeFacingObject("AS", 3));
        seatMapping.put(11, new OppositeFacingObject("MS", 2));
        seatMapping.put(0, new OppositeFacingObject("WS", 1));
    }

    static class OppositeFacingObject {
        String currentSeatDenotion;
        Integer oppositeSeatNumber;

        public OppositeFacingObject(String currentSeatDenotion, Integer oppositeSeatNumber) {
            this.currentSeatDenotion = currentSeatDenotion;
            this.oppositeSeatNumber = oppositeSeatNumber;
        }
    }
}
