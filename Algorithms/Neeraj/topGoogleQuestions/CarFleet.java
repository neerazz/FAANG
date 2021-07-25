import java.util.*;

/**
 * Created on:  Jul 25, 2021
 * Ref : https://leetcode.com/problems/car-fleet/
 * Ref : https://leetcode.com/problems/car-fleet-ii/
 */
public class CarFleet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getCollisionTimes(new int[][]{{3, 4}, {5, 4}, {6, 3}, {9, 1}})));
    }

    public static double[] getCollisionTimes(int[][] cars) {
        int len = cars.length, target = 1_000_002;
        double[] result = new double[len];
        Arrays.fill(result, -1);
        Stack<Car> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            Car cur = new Car(cars[i][0], cars[i][1], -1d);
            while (!stack.isEmpty()) {
                Car pre = stack.peek();
                if (pre.speed >= cur.speed) {
//                    Collision cant happen, with the pre car. Remove and check if the collision can happen with the car before pre car.
                    stack.pop();
                } else {
//                    Get the time when the collision can happen.
                    double dist = pre.position - cur.position;
                    double rel = cur.speed - pre.speed;
                    cur.time = dist / rel;
//                Previous car was not collided.
                    if (pre.time == -1) break;
                    if (cur.time > pre.time) {
//                    If the current collision is happening after the previous time then you don't need the previous collision.
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
            result[i] = cur.time;
            stack.add(cur);
        }
        return result;
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            cars.add(new Car(position[i], speed[i], target));
        }
        Collections.sort(cars, (c1, c2) -> Integer.compare(c2.position, c1.position));
        // System.out.println(cars);
        Stack<Double> stack = new Stack<>();
        for (Car cur : cars) {
            if (!stack.isEmpty() && stack.peek() >= cur.time) {
//                 I will merge with pre car.
            } else {
                stack.add(cur.time);
            }
        }
        return stack.size();
    }

    static class Car {
        int position, speed;
        double time;

        public Car(int position, int speed, double time) {
            this.position = position;
            this.speed = speed;
            this.time = time;
        }

        Car(int pos, int speed, int tar) {
            position = pos;
            this.speed = speed;
            double dist = tar - pos;
            time = dist / speed;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "position=" + position +
                    ", speed=" + speed +
                    ", time=" + time +
                    '}';
        }
    }
}
