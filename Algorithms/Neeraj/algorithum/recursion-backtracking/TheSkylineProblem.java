import java.util.*;

/*
https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/3006/
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
Buildings Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
Notes:
The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the output as such: [...[2 3], [4 5], [12 7], ...]
 */
public class TheSkylineProblem {
    public static void main(String[] args) {
        System.out.println("**********************************************************************");
        System.out.println(getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
        System.out.println(getSkyline_elegant(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
        System.out.println(getSkyline_rev(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
//        System.out.println(getSkyline_rev2(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));

        System.out.println("**********************************************************************");
        System.out.println(getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}}));
        System.out.println(getSkyline_elegant(new int[][]{{0, 2, 3}, {2, 5, 3}}));
        System.out.println(getSkyline_rev(new int[][]{{0, 2, 3}, {2, 5, 3}}));
//        System.out.println(getSkyline_rev2(new int[][]{{0, 2, 3}, {2, 5, 3}}));

        System.out.println("**********************************************************************");
        System.out.println(getSkyline(new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}}));
        System.out.println(getSkyline_elegant(new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}}));
        System.out.println(getSkyline_rev(new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}}));
        System.out.println(getSkyline_rev2(new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}}));

        System.out.println("**********************************************************************");
        System.out.println(getSkyline(new int[][]{{2, 4, 7}, {2, 4, 5}, {2, 4, 6}}));
        System.out.println(getSkyline_elegant(new int[][]{{2, 4, 7}, {2, 4, 5}, {2, 4, 6}}));
        System.out.println(getSkyline_rev(new int[][]{{2, 4, 7}, {2, 4, 5}, {2, 4, 6}}));
        System.out.println(getSkyline_rev2(new int[][]{{2, 4, 7}, {2, 4, 5}, {2, 4, 6}}));

        System.out.println("**********************************************************************");
        System.out.println(getSkyline(new int[][]{{4, 10, 10}, {5, 10, 9}, {6, 10, 8}, {7, 10, 7}, {8, 10, 6}, {9, 10, 5}}));
        System.out.println(getSkyline_elegant(new int[][]{{4, 10, 10}, {5, 10, 9}, {6, 10, 8}, {7, 10, 7}, {8, 10, 6}, {9, 10, 5}}));
        System.out.println(getSkyline_rev(new int[][]{{4, 10, 10}, {5, 10, 9}, {6, 10, 8}, {7, 10, 7}, {8, 10, 6}, {9, 10, 5}}));
        System.out.println(getSkyline_rev2(new int[][]{{4, 10, 10}, {5, 10, 9}, {6, 10, 8}, {7, 10, 7}, {8, 10, 6}, {9, 10, 5}}));
    }

    public static List<List<Integer>> getSkyline_rev2(int[][] buildings) {
        List<Building> list = new ArrayList<>();
        for (int[] building : buildings) {
            int left = building[0], right = building[1], height = building[2];
            list.add(new Building(height, left, true));
            list.add(new Building(height, right, false));
        }
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v2, v1));
        int preMax = 0;
        pq.add(preMax);
        List<List<Integer>> result = new ArrayList<>();
        for (Building building : list) {
            if (building.isStart) {
                pq.add(building.height);
            } else {
                pq.remove(building.height);
            }
            int curMax = pq.peek();
            if (curMax != preMax) {
                preMax = curMax;
                result.add(Arrays.asList(building.point, preMax));
            }
        }
        return result;
    }

    static class Building implements Comparable<Building> {
        int height, point;
        boolean isStart;

        Building(int height, int point, boolean isStart) {
            this.height = height;
            this.point = point;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Building that) {
            if (this.point == that.point) {
//                 If both of that are starting, then the one with more height comes first
                if (this.isStart && that.isStart) {
                    return Integer.compare(that.height, this.height);
                } else if (!this.isStart && !that.isStart) {
//                     If both are ending then that one with more height comes first
                    return Integer.compare(this.height, that.height);
                } else {
//                     if one is starting and other is ending, then the one with starting comes first
                    return this.isStart ? -1 : 1;
                }
            }
            return Integer.compare(this.point, that.point);
        }
    }

    public static List<List<Integer>> getSkyline_rev(int[][] buildings) {
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            Point start = new Point(i, buildings[i][0], buildings[i][2], 0);
            Point end = new Point(i, buildings[i][1], buildings[i][2], 1);
            list.add(start);
            list.add(end);
        }
        Collections.sort(list);
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int height = 0;
        pq.add(height);
        for (Point cur : list) {
            if (cur.start == 0) {
                pq.add(cur.height);
            } else {
                pq.remove(cur.height);
            }
            int curHeight = pq.peek();
            if (curHeight != height) {
                height = curHeight;
                result.add(Arrays.asList(cur.point, height));
            }
        }
        return result;
    }

    static class Point implements Comparable<Point> {
        int id, point, height, start;

        //         start: 0 for start, 1 for end
        public Point(int id, int point, int height, int start) {
            this.id = id;
            this.point = point;
            this.height = height;
            this.start = start;
        }

        public int compareTo(Point that) {
            if (point == that.point) {
                if (start == that.start) {
                    if (start == 0) {
                        return Integer.compare(that.height, height);
                    } else {
                        return Integer.compare(height, that.height);
                    }
                } else {
                    return Integer.compare(start, that.start);
                }
            }
            return Integer.compare(point, that.point);
        }
//        Sorting: Current point, if same then:
//          if both are starting then bigger height should be first,
//          if both are ending then smaller height should be first,
//          if one start and one end is compared then the starting should be taken

        @Override
        public String toString() {
            return "Point{" +
                    "id=" + id +
                    ", point=" + point +
                    ", height=" + height +
                    ", start=" + start +
                    '}';
        }
    }

    public static List<List<Integer>> getSkyline_elegant(int[][] buildings) {
        List<List<Integer>> output = new ArrayList<>();
        if (buildings.length == 0) return output;
        List<HeightAndSide> heightAndSides = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            heightAndSides.add(new HeightAndSide(buildings[i][0], buildings[i][2], 's'));
            heightAndSides.add(new HeightAndSide(buildings[i][1], buildings[i][2], 'e'));
        }
        Collections.sort(heightAndSides);
        int maxHeight = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(maxHeight);
        for (HeightAndSide heightAndSide : heightAndSides) {
            if (heightAndSide.side == 's') {
                queue.add(heightAndSide.height);
            } else {
                queue.remove(heightAndSide.height);
            }
            Integer currentMax = queue.peek();
            if (currentMax != maxHeight) {
                maxHeight = currentMax;
                output.add(Arrays.asList(heightAndSide.point, maxHeight));
            }
        }
        return output;
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> output = new ArrayList<>();
        if (buildings.length == 0) return output;
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            points.add(buildings[i][0]);
            points.add(buildings[i][1]);
        }
        Map<Integer, Integer> pointHeight = new HashMap<>();
        for (Integer p : points) {
            pointHeight.put(p, getDistanceAtPoint(p, buildings));
        }
//        Sort the map based on key
        TreeMap<Integer, Integer> sorted = new TreeMap<>(pointHeight);

//        Loop through all the map entry and findout point and which the height changes.
        int preHeight = 0;
        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
            int currentHeight = entry.getValue();
            if (currentHeight != preHeight) {
                output.add(Arrays.asList(entry.getKey(), currentHeight));
            }
            preHeight = currentHeight;
        }
        return output;
    }

    private static int getDistanceAtPoint(int point, int[][] buildings) {
        int maxHeight = 0;
        for (int i = 0; i < buildings.length; i++) {
            int curStart = buildings[i][0], curEnd = buildings[i][1];
            if (point >= curStart && point < curEnd) {
                maxHeight = Math.max(maxHeight, buildings[i][2]);
            } else if (point < curStart) {
                break;
            }
        }
        return maxHeight;
    }
}

class HeightAndSide implements Comparable {
    Integer point;
    Integer height;
    char side;

    public HeightAndSide(int point, int height, char side) {
        this.point = point;
        this.height = height;
        this.side = side;
    }

    @Override
    public int compareTo(Object o) {
        //first compare by x.
        //If they are same then use this logic
        //if two starts are compared then higher height building should be picked first
        //if two ends are compared then lower height building should be picked first
        //if one start and end is compared then start should appear before end
        HeightAndSide that = (HeightAndSide) o;
        if (this.point.compareTo(that.point) == 0) {
            return (this.side == 's' ? -this.height : this.height) - (that.side == 's' ? -that.height : that.height);
        }
        return this.point.compareTo(that.point);
    }
}