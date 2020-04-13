public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int p1 = 0, p2 = height.length - 1, water = 0;
        water = Math.min(height[p1], height[p2]) * (p2 - p1);
        while (p1 > p2) {
            if (height[p1] < height[p2]) {
                p1++;
            } else {
                p2--;
            }
            int curr = Math.min(height[p1], height[p2]) * (p2 - p1);
            water = Math.max(curr, water);
        }
        return water;
    }
}
