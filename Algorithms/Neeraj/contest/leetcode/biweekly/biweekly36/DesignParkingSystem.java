package biweekly.biweekly36;

/**
 * Created on:  Oct 03, 2020
 * Questions: https://leetcode.com/problems/design-parking-system
 */
public class DesignParkingSystem {
    public static void main(String[] args) {

    }
}

class ParkingSystem {
    int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return slots[carType - 1]-- > 0;
    }
}