import java.util.*;

/**
 * Created on:  Jul 25, 2021
 * Ref : https://leetcode.com/problems/car-fleet/
 * Ref : https://leetcode.com/problems/car-fleet-ii/
 */
public class CarFleet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getCollisionTimes(new int[][]{{3, 4}, {5, 4}, {6, 3}, {9, 1}})));
        System.out.println(Arrays.toString(getCollisionTimes_rev1(new int[][]{{3, 4}, {5, 4}, {6, 3}, {9, 1}})));
        System.out.println(carFleet_rev2(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
    }

    public static int carFleet_rev2(int target, int[] position, int[] speed) {
        List<Car> list = new ArrayList<>();
        int len = position.length;
        for (int i = 0; i < len; i++) {
            Car car = new Car(position[i], speed[i], target);
            list.add(car);
        }
        Collections.sort(list, (c1, c2) -> Integer.compare(c1.pos, c2.pos));
        int count = 0, i = len - 1;
        while (i >= 0) {
            count++; // 3
            double time = list.get(i).time;
            while (i >= 0 && list.get(i).time <= time) {
                i--;
            }
        }
        return count;
    }

    public static double[] getCollisionTimes_rev1(int[][] cars) {
        int len = cars.length;
        double[] result = new double[len];
        Arrays.fill(result, -1);
        Stack<Car> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            Car myCar = new Car(cars[i][0], cars[i][1]);
            int myPos = myCar.pos, mySpeed = myCar.speed;
            while (!stack.isEmpty()) {
                Car topCar = stack.peek();
                int topPos = topCar.pos, topSpeed = topCar.speed;
                if (mySpeed <= topSpeed) {
//                    Collision can't happen, with the topCar car. Remove and check if the collision can happen with the car before topCar car.
                    stack.pop();
                } else {
//                    Compute the time when the collision can happen.
                    double dist = topPos - myPos;
                    double rel = mySpeed - topSpeed;
                    double collisionTime = dist / rel;
                    myCar.time = collisionTime;
//                topCar was not collided, then my car will collide.
                    if (topCar.time == -1) break;
//                    If the top car is going to be merged before the current collision,
//                      then the car is not going to exist. So remove the top car and fid the next car which will collide my car.
                    if (collisionTime > topCar.time) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
            result[i] = myCar.time;
            stack.add(myCar);
        }
        return result;
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
//                    Collision can't happen, with the pre car. Remove and check if the collision can happen with the car before pre car.
                    stack.pop();
                } else {
//                    Get the time when the collision can happen.
                    double dist = pre.pos - cur.pos;
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
        Collections.sort(cars, (c1, c2) -> Integer.compare(c2.pos, c1.pos));
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
        int pos, speed;
        double time;
        int idx;

        public Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
            time = -1L;
        }

        public Car(int pos, int speed, double time) {
            this.pos = pos;
            this.speed = speed;
            this.time = time;
        }

        Car(int pos, int speed, int tar, int idx) {
            this.pos = pos;
            this.speed = speed;
            double dist = tar - pos;
            time = dist / speed;
            this.idx = idx;
        }

        Car(int pos, int speed, int tar) {
            this.pos = pos;
            this.speed = speed;
            double dist = tar - pos;
            time = dist / speed;
        }
    }
}
